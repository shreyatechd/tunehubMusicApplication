package com.tunehub.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.project.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
              public Users findByEmail(String email);
}
