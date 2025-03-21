package com.example.User_management.Service;

import com.example.User_management.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
//    abstract method for save user
    public String saveUser(User user);
    public List<User> getAllUser();
    public Optional<User> getUser(Long userId);
    public Boolean deleteUser(Long userId);
}
