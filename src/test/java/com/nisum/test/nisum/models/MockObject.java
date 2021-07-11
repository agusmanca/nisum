package com.nisum.test.nisum.models;

import com.nisum.test.nisum.model.dto.PhoneDto;
import com.nisum.test.nisum.model.dto.UserDto;
import com.nisum.test.nisum.model.dto.UserResponseDto;
import com.nisum.test.nisum.model.entity.Phone;
import com.nisum.test.nisum.model.entity.User;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MockObject {
    private UserResponseDto response;
    private User request;
    private UserDto userDto;
    private List<PhoneDto> phoneDtoList = new ArrayList<>();
    private ModelMapper mapeador = new ModelMapper();

    public MockObject() { }

    public User getCreateUserRequest() {
        request = new User();
        request.setName("Juan Rodriguez");
        request.setPassword("Hu22");
        request.setEmail("juan2@rodriguez.cl");
        request.setPhones(
                phoneDtoList.stream()
                                .map(p -> mapeador.map(p, Phone.class))
                                .collect(Collectors.toList())
        );
        request.setCreateDate(new Date());
        request.setModifiedDate(new Date());
        request.setLastLogin(new Date());
        request.setToken("");
        request.setActive(true);

        return request;
    }

    public User getBadCreateUserRequest() {
        request = new User();
        request.setName("Juan Rodriguez");
        request.setPassword("Hu22");
        request.setEmail("juan2@rodriguez.org");
        request.setPhones(
                phoneDtoList.stream()
                        .map(p -> mapeador.map(p, Phone.class))
                        .collect(Collectors.toList())
        );
        request.setCreateDate(new Date());
        request.setModifiedDate(new Date());
        request.setLastLogin(new Date());
        request.setToken("");
        request.setActive(true);

        return request;
    }

    public UserResponseDto getResponse() {
        setUserdto();

        response = new UserResponseDto();
        response.setUser(userDto);
        response.setCreateDate(new Date());
        response.setModifiedDate(new Date());
        response.setLastLogin(new Date());
        response.setToken("");
        response.setActive(true);

        return response;
    }

    public String getEmail() {
        return "juan2@rodriguez.cl";
    }

    private void setUserdto() {
        setPhoneDto();

        userDto = new UserDto();
        userDto.setId(UUID.fromString("1cfeaa68-a9c1-44ac-938d-af44f9d611c3"));
        userDto.setName("Juan Rodriguez");
        userDto.setPassword("Hu22");
        userDto.setEmail("juan2@rodriguez.cl");
        userDto.setPhones(phoneDtoList);
    }

    private void setPhoneDto() {
        PhoneDto phone = new PhoneDto();
        phone.setId(UUID.fromString("0532a2cb-d34f-4168-ba88-8158b5ecff78"));
        phone.setNumber("1234567");
        phone.setContrycode("57");
        phone.setCitycode("1");

        phoneDtoList.add(phone);
    }
}
