package com.idosinchuk.distributedtracing.userdata.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Integer userId;

    private String name;

    private String surname;

    private String identityCard;

    private String dateOfBirth;

    private Integer addressId;

}