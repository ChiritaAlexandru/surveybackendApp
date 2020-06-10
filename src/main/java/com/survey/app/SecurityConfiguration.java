package com.survey.app;


import com.survey.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{



    private UserService userService;

    @Autowired
    public SecurityConfiguration( UserService userService){
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
  /*  auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("1234")).roles("Respondes")
                .and()
                .withUser("admin").password("{noop}password").roles("Coordinators"); */
    }

    @Override
    protected  void configure( HttpSecurity http) throws  Exception{
        http.cors().and().csrf().disable();
        http
                .authorizeRequests().antMatchers("/survey/**").hasRole("COORDINATORS").and()
                .authorizeRequests().antMatchers("//question/**").hasRole("COORDINATORS").and()
                .authorizeRequests().antMatchers("/answer/**").hasRole("COORDINATORS").and()
                .authorizeRequests().antMatchers("/respondents/survey/**").hasRole("COORDINATORS")
                .and()
                .httpBasic();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2_console/**");
        web.ignoring().antMatchers("/user/addUser/**");
    }


    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userService);
        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
