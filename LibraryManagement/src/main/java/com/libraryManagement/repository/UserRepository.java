package com.libraryManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libraryManagement.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	public Optional<Users> findByemail(String email);
}
