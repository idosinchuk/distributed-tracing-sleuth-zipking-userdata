package com.idosinchuk.distributedtracing.userdata.dto;

import lombok.Data;

@Data
public class Address {

    private Integer addressId;

    private String street;

    private Integer number;

    private String floor;

    private String city;

    private String postalCode;

    private String country;

}