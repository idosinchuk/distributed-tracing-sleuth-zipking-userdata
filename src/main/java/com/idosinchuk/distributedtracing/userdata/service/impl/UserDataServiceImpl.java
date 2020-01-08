package com.idosinchuk.distributedtracing.userdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.idosinchuk.distributedtracing.userdata.dto.Address;
import com.idosinchuk.distributedtracing.userdata.dto.User;
import com.idosinchuk.distributedtracing.userdata.dto.UserData;
import com.idosinchuk.distributedtracing.userdata.service.UserDataService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserDataServiceImpl implements UserDataService {

	private RestTemplate restTemplate;

	@Value("${address.service.url}")
	private String addressServiceURL;

	@Value("${user.service.url}")
	private String userServiceURL;

	@Autowired
	public UserDataServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public UserData getUserData(Integer userId) {

		log.info("Fetching User and Address details by userId: {}", userId);

		User user = getUser(userId);

		return UserData.builder().user(user).address(getAddress(user.getAddressId())).build();
	}

	private User getUser(Integer userId) {

		log.info("Call restTemplate to obtain User data by userId: {}", userId);

		ResponseEntity<User> user = restTemplate.getForEntity(userServiceURL + userId, User.class);

		return user.getBody();
	}

	private Address getAddress(Integer addressId) {

		log.info("Call restTemplate to obtain Address data by addressId: {}", addressId);

		ResponseEntity<Address> address = restTemplate.getForEntity(addressServiceURL + addressId, Address.class);

		return address.getBody();
	}
}