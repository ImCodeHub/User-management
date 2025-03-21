package com.example.User_management.Exception;

public class CustomException {
//    customer exception handling
     public static class UserNotFoundException extends RuntimeException{
        public UserNotFoundException(String message){
            super(message);
        }
    }
    public static class emailNotExistException extends RuntimeException{
         public emailNotExistException(String message){
             super(message);
         }
    }
}
