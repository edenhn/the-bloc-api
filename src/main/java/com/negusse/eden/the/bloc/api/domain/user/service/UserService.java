package com.negusse.eden.the.bloc.api.domain.user.service;

import com.negusse.eden.the.bloc.api.domain.user.exceptions.UserNameNotFoundException;
import com.negusse.eden.the.bloc.api.domain.user.exceptions.UserNameTakenException;
import com.negusse.eden.the.bloc.api.domain.user.exceptions.UserNotFoundException;
import com.negusse.eden.the.bloc.api.domain.user.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user) throws UserNameTakenException;
    User getUserByUserName(String userName) throws UserNameNotFoundException;
    User getUserByEmail(String email) throws UserNotFoundException;
    User getUserById(Long id) throws UserNotFoundException;
    List<User> getAll();
    User updateUser(Long id, User userDetail) throws UserNotFoundException;
    void deleteUser(String email) throws UserNotFoundException;

}
