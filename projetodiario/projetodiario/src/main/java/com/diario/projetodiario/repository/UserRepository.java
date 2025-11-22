package com.diario.projetodiario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diario.projetodiario.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
