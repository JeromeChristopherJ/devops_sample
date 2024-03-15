package com.jerome.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jerome.log.domain.login;

@Repository
public interface loginrepo extends JpaRepository<login,String>
{
    login findByUsernameAndPassword(String username, String password);
}
