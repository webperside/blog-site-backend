package com.webperside.blogsite.repository;

import com.webperside.blogsite.entity.user.UserAuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthorizationRepository extends JpaRepository<UserAuthorizationEntity, Integer> {
}
