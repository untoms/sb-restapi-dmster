package com.example.springbootrest.sevices;

import com.example.springbootrest.enitities.User;
import com.example.springbootrest.repositories.UserReporisotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public User createUser(User user) {
        return userReporisotry.save(user);
    }

    @Override
    public Optional<User> findByUserId(Long id){
        return userReporisotry.findById(id);
    }

    @Override
    public void deleteUserById(Long id){
        if (userReporisotry.findById(id).isPresent()){
            userReporisotry.deleteById(id);
        }
    }

    @Override
    public User updateUserById(Long id, User user){
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
}
