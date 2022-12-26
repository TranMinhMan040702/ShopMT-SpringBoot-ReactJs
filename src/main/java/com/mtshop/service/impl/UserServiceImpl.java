package com.mtshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtshop.dto.input.UserReq;
import com.mtshop.dto.output.UserResp;
import com.mtshop.entity.User;
import com.mtshop.exception.ResourceNotFoundException;
import com.mtshop.repository.UserRepository;
import com.mtshop.service.UserService;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	ModelMapper mapper;
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public List<UserResp> findAll() {
		List<UserResp> results = new ArrayList<>();
		List<User> usersEntity = userRepository.findAll();
		for (User user : usersEntity) {
			UserResp userDto = mapper.map(user, UserResp.class);
			results.add(userDto);
		}
		return results;
	}
	
	@Override
	public UserResp findUserById(long id) throws ResourceNotFoundException {
		Optional<User> entity = userRepository.findById(id);
		if (entity.isPresent()) {
			UserResp result = mapper.map(entity, UserResp.class);
			return result;
		} else {
			throw new ResourceNotFoundException("User not found with id: "+id);
		}
		
	}
	
	@Override
	public UserResp saveUser(UserReq userReq) {
		User user = mapper.map(userReq, User.class);
		return mapper.map(userRepository.save(user), UserResp.class);
	}
}
