package com.idosinchuk.distributedtracing.userdata.dto;

import lombok.Data;

@Data
public class UserDataDTO {

    private UserDTO user;

    private AddressDTO address;
}