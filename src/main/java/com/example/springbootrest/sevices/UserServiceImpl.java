package com.example.springbootrest.sevices;

import com.example.springbootrest.enitities.User;
import com.example.springbootrest.exceptions.UserExistException;
import com.example.springbootrest.exceptions.UserNotFoundException;
import com.example.springbootrest.repositories.UserReporisotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService{

    final private UserReporisotry userReporisotry;

    @Autowired
    public UserServiceImpl(UserReporisotry userReporisotry) {
        this.userReporisotry = userReporisotry;
    }

    @Override
    public User findByUsername(String username) {
        return userReporisotry.findByUsername(username);
    }

    @Override
    public User createUser(User user) throws UserExistException {

        User existUser = userReporisotry.findByUsername(user.getUsername());

        if (existUser != null){
            throw new UserExistException("User with username "+user.getUsername()+" already exist!");
        }

        return userReporisotry.save(user);
    }

    @Override
    public Optional<User> findByUserId(Long id) throws UserNotFoundException {
        Optional<User> usr = userReporisotry.findById(id);
        if (!usr.isPresent()){
            throw new UserNotFoundException("User not found in user repo");
        }

        return usr;
    }

    @Override
    public void deleteUserById(Long id){
        if (!userReporisotry.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found in user repo");
        }
        userReporisotry.deleteById(id);
    }

    @Override
    public User updateUserById(Long id, User user) throws UserNotFoundException {
        Optional<User> usr = userReporisotry.findById(id);
        if (!usr.isPresent()){
            throw new UserNotFoundException("User not found in user repo, provide the correct user id");
        }
        user.setId(id);
        return userReporisotry.save(user);
    }

    @Override
    @Transactional
    public User updateUsernameById(long id, String username) {

        int result = userReporisotry.updateUsername(username, id);
        if (result > 0){
            Optional<User> userOp = userReporisotry.findById(id);
            return userOp.get();
        }
        return null;
    }

    @Override
    public List<User> findByIdIn(List<Long> ids) {
        return userReporisotry.findByIdIn(ids);
    }

    @Override
    public List<User> findAllUsers() {
        return userReporisotry.findAll();
    }
}
