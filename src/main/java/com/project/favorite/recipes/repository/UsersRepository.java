package com.project.favorite.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.favorite.recipes.entity.Users;

/**
 * {@link UsersRepository}
 * 
 * User repository created to use for JPA functionality and use to perform CRUD operations on the table
 * 
 * @author Sumit.Vaidya
 *
 */
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	@Query(value="select  count(*) from  users  where  user_name=?  and  user_password=?", nativeQuery=true)
	Integer  checkLogin(String userName, String password);
}
