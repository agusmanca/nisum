package com.nisum.test.nisum.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class UserResponseDto {
    private UserDto user;
    private Date createDate;
    private Date modifiedDate;
    private Date lastLogin;
    private String token;
    private boolean isActive;
}
