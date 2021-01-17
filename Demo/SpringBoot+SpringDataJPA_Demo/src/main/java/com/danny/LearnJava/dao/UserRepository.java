package com.danny.LearnJava.dao;

import com.danny.LearnJava.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
