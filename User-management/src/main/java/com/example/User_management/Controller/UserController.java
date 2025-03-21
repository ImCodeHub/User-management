package com.example.User_management.Controller;


import com.example.User_management.Entity.User;
import com.example.User_management.Service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/user")
public class UserController {
    //    this is user service dependency
    @Autowired
    private UserServiceImpl userServiceimpl;

    //handler method
    @GetMapping("greet-user")
    public String getUserName() {
        return "welcome to Spring boot"; //plain text return.
    }

    @PutMapping("update-user-details")
    public String updateUser() {
        return "user has been updated";
    }


    @PostMapping("save-user")
    public ResponseEntity<String> saveUserDetails(@RequestBody User user) {
        String response = userServiceimpl.saveUser(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("get-users-details")
    public ResponseEntity<List<User>> getAllUserDetails() {
        List<User> useList = userServiceimpl.getAllUser();
        return new ResponseEntity<>(useList, HttpStatus.FOUND);
    }

    @GetMapping("get-user-by-id/{id}")
    public ResponseEntity<Optional<User>> getUserDetailsById(@PathVariable Long id) {
        Optional<User> user = userServiceimpl.getUser(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        Boolean response = userServiceimpl.deleteUser(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }





}
