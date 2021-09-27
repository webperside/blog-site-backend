package com.webperside.blogsite.repository;

import com.webperside.blogsite.entity.user.UserSecurityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSecurityRepository extends JpaRepository<UserSecurityEntity, Integer> {
}
