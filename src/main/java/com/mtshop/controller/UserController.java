package com.mtshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtshop.dto.input.UserReq;
import com.mtshop.dto.output.UserResp;
import com.mtshop.exception.ResourceNotFoundException;
import com.mtshop.service.UserService;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<UserResp> saveUser(@RequestBody @Valid UserReq userReq) {
		return new ResponseEntity<>(userService.saveUser(userReq), HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserResp>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UserResp> findUserById(@PathVariable long id) throws ResourceNotFoundException {
		return ResponseEntity.ok(userService.findUserById(id));
	}
	

}
