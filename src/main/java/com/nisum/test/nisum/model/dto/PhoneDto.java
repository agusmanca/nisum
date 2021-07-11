package com.nisum.test.nisum.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PhoneDto {
    private UUID id;
    private String number;
    private String citycode;
    private String contrycode;
}
