package com.example.springbootrest.sevices;

import com.example.springbootrest.enitities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findByUsername(String username);
    User createUser(User user);
    Optional<User> findByUserId(Long id);
    void deleteUserById(Long id);
    User updateUserById(Long id, User user);
    User updateUsernameById(long id, String username);
    List<User> findByIdIn(List<Long> ids);

}
