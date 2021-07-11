package com.nisum.test.nisum.services;

import com.nisum.test.nisum.model.dao.PhoneDao;
import com.nisum.test.nisum.model.dao.UserDao;
import com.nisum.test.nisum.model.dto.UserResponseDto;
import com.nisum.test.nisum.model.entity.User;
import com.nisum.test.nisum.model.exception.*;
import com.nisum.test.nisum.models.MockObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

class UserServiceTest {

    @Autowired
    private UserDao userDaoMock = Mockito.mock(UserDao.class);
    @Autowired
    private PhoneDao phoneDaoMock = Mockito.mock(PhoneDao.class);

    private UserService service;
    private MockObject mocks;

    @BeforeEach
    void setUp() {
        mocks = new MockObject();
        service = new UserService(userDaoMock, phoneDaoMock);
    }

    @Test
    void getUser() throws UserNotFoundException {
        UUID uuid = UUID.fromString("1cfeaa68-a9c1-44ac-938d-af44f9d611c3");
        Mockito.when(userDaoMock.findById(uuid)).then(invocationOnMock -> Optional.of(mocks.getCreateUserRequest()));

        UserResponseDto response = service.getUser(uuid);
        Assertions.assertEquals(response.getUser().getName(), "Juan Rodriguez");
    }

    @Test
    void getUserNotFoundException() {
        UUID uuid = UUID.randomUUID();
        Mockito.when(userDaoMock.findById(uuid)).then(invocationOnMock -> Optional.empty());
        Assertions.assertThrows(UserNotFoundException.class, () -> service.getUser(uuid));
    }

    @Test
    void getUserByEmail() throws UserByEmailNotFoundException {
        String email = mocks.getEmail();
        Mockito.when(userDaoMock.findUserByEmail(email)).then(invocationOnMock -> mocks.getCreateUserRequest());

        UserResponseDto response = service.getUserByEmail(email);
        Assertions.assertEquals(response.getUser().getEmail(), mocks.getEmail());
    }

    @Test
    void getUserByEmailNotFoundException() {
        String email = mocks.getEmail();
        Mockito.when(userDaoMock.findUserByEmail(email)).then(invocationOnMock -> null);
        Assertions.assertThrows(UserByEmailNotFoundException.class, () -> service.getUserByEmail(email));
    }

    @Test
    void createUser() throws EmailBadFormatedException, NotCreatedUserException, EmailExistException {
        User request = mocks.getCreateUserRequest();
        Mockito.when(userDaoMock.findUserByEmail(request.getEmail())).then(invocationOnMock -> null);
        Mockito.when(userDaoMock.save(request)).then(invocationOnMock -> mocks.getCreateUserRequest());

        UserResponseDto response = service.createUser(request);
        Assertions.assertEquals(response.getUser().getId(), request.getId());
    }

    @Test
    void createUserNotFoundException() {
        User request = mocks.getCreateUserRequest();
        Mockito.when(userDaoMock.findUserByEmail(request.getEmail())).then(invocationOnMock -> mocks.getCreateUserRequest());

        Assertions.assertThrows(EmailExistException.class, () -> service.createUser(request));
    }

    @Test
    void createUserBadFormatEmailException() {
        User request = mocks.getBadCreateUserRequest();
        Mockito.when(userDaoMock.findUserByEmail(request.getEmail())).then(invocationOnMock -> null);

        Assertions.assertThrows(EmailBadFormatedException.class, () -> service.createUser(request));
    }

    @Test
    void createUserNotCreateException() {
        User request = mocks.getCreateUserRequest();
        Mockito.when(userDaoMock.findUserByEmail(request.getEmail())).then(invocationOnMock -> null);
        Mockito.when(userDaoMock.save(request)).then(invocationOnMock -> null);

        Assertions.assertThrows(NotCreatedUserException.class, () -> service.createUser(request));
    }
}