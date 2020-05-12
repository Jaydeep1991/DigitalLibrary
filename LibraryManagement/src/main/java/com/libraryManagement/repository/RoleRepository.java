package com.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.libraryManagement.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	@Query(value="SELECT role_id FROM user_roles WHERE user_id=?1",nativeQuery = true)
	public Integer findRole(int userId);

}
