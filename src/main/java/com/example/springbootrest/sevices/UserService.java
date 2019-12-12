package com.example.springbootrest.sevices;

import com.example.springbootrest.enitities.User;
import com.example.springbootrest.exceptions.UserExistException;
import com.example.springbootrest.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findByUsername(String username);
    User createUser(User user) throws UserExistException;
    Optional<User> findByUserId(Long id) throws UserNotFoundException;
    void deleteUserById(Long id);
    User updateUserById(Long id, User user) throws UserNotFoundException ;
    User updateUsernameById(long id, String username);
    List<User> findByIdIn(List<Long> ids);

}
