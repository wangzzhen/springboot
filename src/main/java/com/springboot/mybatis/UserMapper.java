package com.springboot.mybatis;

import com.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
//这里因为只有一个mapper，为了方便是用@mapper注解，如果有多个mapper,则
//可以扫描包，写一个mybatis的配置bean或者直接在启动类中加上@MapperScan（“包路径”）注解。
public interface UserMapper {
	public void save(User user);
	public void update(User user);
	public void delete(long id);
	public User getById(long id);
}
