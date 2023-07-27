package com.leetcode.ranking.services;

import com.leetcode.ranking.dao.UserRepository;
import com.leetcode.ranking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
 
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public enum ServiceResult {
        SUCCESS,
        FAILURE_USER_NOT_FOUND,
        FAILURE_SAVE,
        FAILURE_UPDATE,
        FAILURE_DELETE
    }

    //Add new user into database
    public ServiceResult addUser(User user) {
        try {
            userRepository.save(user);
            return ServiceResult.SUCCESS;
        } catch (Exception e) {
            return ServiceResult.FAILURE_SAVE;
        }
    }

    //Update user in database
    public ServiceResult updateUser(User user, int id) {
        try {
            user.setId(id);
            userRepository.save(user);
            return ServiceResult.SUCCESS;
        } catch (Exception e) {
            return ServiceResult.FAILURE_UPDATE;
        }
    }

    public ServiceResult deleteUser(int id) {
        try {
            userRepository.deleteById(id);
            return ServiceResult.SUCCESS;
        } catch (Exception e) {
            return ServiceResult.FAILURE_DELETE;
        }
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserWithId(int id) {
        return userRepository.findById(id);
    }
}
