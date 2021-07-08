package com.springmvc.app.services;

import com.springmvc.app.domain.Item;
import com.springmvc.app.domain.User;
import com.springmvc.app.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public static User userRecords;
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsersRecords() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public void saveUserIntoDB(User user) {
        this.userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("order with id" + userId + "does not exist");
        }
        userRepository.deleteById(userId);
    }


    public User getUserById(Long id) {
        Optional<User> userOtherDetails = userRepository.findById(id);
        User user = null;
        if (userOtherDetails.isPresent()) {
            user = userOtherDetails.get();
        } else {
            throw new RuntimeException("Order not found for id::" + id);
        }
        return user;
    }
}
