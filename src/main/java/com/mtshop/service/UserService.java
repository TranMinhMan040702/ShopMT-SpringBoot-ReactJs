package com.mtshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mtshop.dto.input.UserReq;
import com.mtshop.dto.output.UserResp;
import com.mtshop.exception.ResourceNotFoundException;

@Service
public interface UserService {

	List<UserResp> findAll();

	UserResp findUserById(long id) throws ResourceNotFoundException;

	UserResp saveUser(UserReq userReq);

}
