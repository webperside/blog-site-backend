package com.webperside.blogsite.repository;

import com.webperside.blogsite.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
