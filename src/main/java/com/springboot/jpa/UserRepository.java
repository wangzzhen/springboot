package com.springboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//通过JpaRepository接口源码可以看到，
//里面已经封装了创建（save）、更新（save）、删除（delete）、查询（findAll、findOne）等基本操作
public interface UserRepository extends JpaRepository<UserJpa, Long>{
	
	//自定义sql查询，可以用Hql，也可以用原生sql，nativeQuery可以设置，true则表示为原生sql
	@Query(value = "select * from user_info where id=:id",nativeQuery = true)
	public UserJpa findById(@Param("id") long id);
}
