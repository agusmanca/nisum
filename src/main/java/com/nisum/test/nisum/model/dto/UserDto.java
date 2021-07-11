package com.nisum.test.nisum.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserDto {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private List<PhoneDto> phones;
}
