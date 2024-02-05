package com.negusse.eden.the.bloc.api.domain.user.repo;

import com.negusse.eden.the.bloc.api.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}
