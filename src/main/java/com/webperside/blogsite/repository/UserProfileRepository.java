package com.webperside.blogsite.repository;

import com.webperside.blogsite.entity.user.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Integer> {
}
