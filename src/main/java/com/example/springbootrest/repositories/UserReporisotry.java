package com.example.springbootrest.repositories;

import com.example.springbootrest.enitities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReporisotry extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Modifying
    @Query("update User u set u.username = :username where u.id = :id")
    int updateUsername(@Param("username") String username, @Param("id") Long id);

    List<User> findByIdIn(List<Long> ids);

}
