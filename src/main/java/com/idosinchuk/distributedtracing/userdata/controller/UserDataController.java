package com.idosinchuk.distributedtracing.userdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.idosinchuk.distributedtracing.userdata.dto.UserData;
import com.idosinchuk.distributedtracing.userdata.service.UserDataService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserDataController {

	@Autowired
	private UserDataService userDataService;

	@GetMapping(value = "/userData/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserData> getUserData(@PathVariable Integer userId) {
		
		log.info("Hello from UserData Service with userId: {}", userId);
		UserData response = userDataService.getUserData(userId);
	
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}