package com.idosinchuk.distributedtracing.userdata.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserData {

    private User user;
    
    private Address address;

}