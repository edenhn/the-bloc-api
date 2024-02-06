package com.negusse.eden.the.bloc.api.domain.user.service;

import com.negusse.eden.the.bloc.api.domain.user.exceptions.UserNameNotFoundException;
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
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User createUser(User user) throws UserNameTakenException {
        Optional<User> optional = userRepo.findByEmail(user.getUserName());
        if(optional.isPresent())
            throw new UserNameTakenException("Username unavailable:" + user.getUserName());
        user = userRepo.save(user);
        return user;
    }

    @Override
    public User getUserByUserName(String userName) throws UserNameNotFoundException {
        return null;
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        User user = userRepo.findById(id)
                .orElseThrow(()->new UserNotFoundException("No User with id" + id));
        return user;
    }

    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        User user = userRepo.findByEmail(email)
                .orElseThrow(()->new UserNotFoundException("No User with email"));
        return user;
    }

    @Override
    public User updateUser(Long id, User userDetail) throws UserNotFoundException {
        User user = getUserById(id);
        user.setUserName(userDetail.getUserName());
        user.setFirstName(userDetail.getFirstName());
        user.setLastName(userDetail.getLastName());
        user.setEmail(userDetail.getEmail());
        user.setPhoneNumber(userDetail.getPhoneNumber());
        user.setAddress(userDetail.getAddress());
        user = userRepo.save(user);
        return user;
    }

    @Override
    public void deleteUser(String email) throws UserNameNotFoundException{
       Optional<User> userAccountExistsOption = userRepo.findByEmail(email);
       if(userAccountExistsOption.isEmpty())
           throw new UserNotFoundException("User with email" + email + "not found");
       User userAccountToRemove = userAccountExistsOption.get();
       userRepo.delete(userAccountToRemove);
    }
}
