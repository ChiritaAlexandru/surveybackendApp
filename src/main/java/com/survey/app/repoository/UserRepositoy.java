package com.survey.app.repoository;

import com.survey.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoy  extends JpaRepository<User,Integer> {

    User findByUserName(String username);
}
