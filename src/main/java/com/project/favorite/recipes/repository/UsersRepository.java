package com.project.favorite.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.favorite.recipes.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	@Query(value="select  count(*) from  users  where  user_name=?  and  user_password=?", nativeQuery=true)
	Integer  checkLogin(String userName, String password);
}
