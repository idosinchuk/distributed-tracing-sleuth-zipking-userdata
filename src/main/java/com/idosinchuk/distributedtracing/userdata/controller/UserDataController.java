package com.idosinchuk.distributedtracing.userdata.controller;

import com.idosinchuk.distributedtracing.userdata.dto.UserDataDTO;
import com.idosinchuk.distributedtracing.userdata.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserDataController {

	@Autowired
	private UserDataService userDataService;

	@RequestMapping(value = "/userData/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDataDTO getCustomerOrder(@PathVariable Integer userId) throws Exception {
		return userDataService.getUserData(userId);
	}
}