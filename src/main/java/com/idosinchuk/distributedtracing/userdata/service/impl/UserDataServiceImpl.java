package com.idosinchuk.distributedtracing.userdata.service.impl;

import com.idosinchuk.distributedtracing.userdata.dto.AddressDTO;
import com.idosinchuk.distributedtracing.userdata.dto.UserDTO;
import com.idosinchuk.distributedtracing.userdata.dto.UserDataDTO;
import com.idosinchuk.distributedtracing.userdata.service.UserDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${address.service.url}")
    private String addressServiceURL;

    @Value("${user.service.url}")
    private String userServiceURL;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDataServiceImpl.class);

    @Override
    public UserDataDTO getUserData(Integer userId) throws Exception {
        UserDataDTO userDataDTO = new UserDataDTO();

        LOGGER.info("Fetching User and Address details for userId: {}", userId);

        UserDTO user = getUser(userId);

        if (user != null) {
            userDataDTO.setUser(user);
            userDataDTO.setAddress(getAddress(user.getAddressId()));
        } else {
            LOGGER.error("No User found for, userId: {}", userId);
        }

        return userDataDTO;
    }

    private AddressDTO getAddress(Integer addressId) {
        ResponseEntity<AddressDTO> addressDTOResponse = restTemplate.getForEntity(addressServiceURL + addressId, AddressDTO.class);
        return addressDTOResponse.getBody();
    }

    private UserDTO getUser(Integer userId) {
        ResponseEntity<UserDTO> userDTOResponse = restTemplate.getForEntity(userServiceURL + userId, UserDTO.class);
        return userDTOResponse.getBody();
    }
}