package com.idosinchuk.distributedtracing.userdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.idosinchuk.distributedtracing.userdata.dto.UserData;
import com.idosinchuk.distributedtracing.userdata.service.UserDataService;

@RestController
public class UserDataController {

	@Autowired
	private UserDataService userDataService;

	@GetMapping(value = "/userData/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserData getUserData(@PathVariable Integer userId) {
		return userDataService.getUserData(userId);
	}
}