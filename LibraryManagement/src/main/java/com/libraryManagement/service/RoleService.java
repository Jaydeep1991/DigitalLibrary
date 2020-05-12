package com.libraryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libraryManagement.model.Role;
import com.libraryManagement.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepo;

	public Role getRole(int userId) {
		Integer rObj=roleRepo.findRole(userId);
		Role role =roleRepo.findById(rObj).get();
		return role;
	}
}
