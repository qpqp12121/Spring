package com.example.demo.users.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.users.UsersVO;

@Mapper
public interface UsersMapper {

	//단건조회
	public UsersVO getUsersInfo(String userid);
}
