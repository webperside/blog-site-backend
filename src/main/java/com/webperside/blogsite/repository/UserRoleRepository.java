package com.webperside.blogsite.repository;

import com.webperside.blogsite.entity.user.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {
}
