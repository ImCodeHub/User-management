package com.example.User_management.Service;

import com.example.User_management.Entity.User;
import com.example.User_management.Exception.CustomException;
import com.example.User_management.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
//    Adding the User Respository dependency
    @Autowired
    private UserRepository userRepository;

    @Override
    public String saveUser(User user) {
         userRepository.save(user);
         return "User has successfully saved";

    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public Optional<User> getUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            logger.debug("we are debugging");
            logger.info("user is present by this id:"+userId);
            return optionalUser;
        }else{
            logger.error("This user not found in db by this id: "+userId);
            throw new CustomException.UserNotFoundException("user not found int the DB");
        }
    }

    @Override
    public Boolean deleteUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
