package com.negusse.eden.the.bloc.api.domain.user.service;

import com.negusse.eden.the.bloc.api.domain.user.exceptions.UserNameTakenException;
import com.negusse.eden.the.bloc.api.domain.user.exceptions.UserNotFoundException;
import com.negusse.eden.the.bloc.api.domain.user.model.User;
import com.negusse.eden.the.bloc.api.domain.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) throws UserNameTakenException {
        Optional<User> optional = userRepo.findById(user.getId());
        if(optional.isPresent())
            throw new UserNameTakenException("Username unavailable:" + user.getUserName());
        user = userRepo.save(user);
        return user;
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        return null;
    }

    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        return null;
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User update(Long id, User userDetail) throws UserNotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
