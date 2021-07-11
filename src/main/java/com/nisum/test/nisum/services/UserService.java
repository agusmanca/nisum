package com.nisum.test.nisum.services;

import com.nisum.test.nisum.model.dao.PhoneDao;
import com.nisum.test.nisum.model.dao.UserDao;
import com.nisum.test.nisum.model.dto.UserResponseDto;
import com.nisum.test.nisum.model.entity.User;
import com.nisum.test.nisum.model.exception.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("USER_SERVICE")
public class UserService {

    private UserDao userDao;
    private PhoneDao phoneDao;
    private ModelMapper mapeador = new ModelMapper();

    public UserService(UserDao userDao, PhoneDao phoneDao) {
        this.userDao = userDao;
        this.phoneDao = phoneDao;
    }

    public List<UserResponseDto> getUsers() throws UserNotFoundException {
        List<User> users = userDao.findAll();

        if(Objects.isNull(users)){
            throw new UserNotFoundException();
        }

        List<UserResponseDto> usersResponse = users.stream()
                                                      .map(u -> mapeador.map(u, UserResponseDto.class))
                                                      .collect(Collectors.toList());

        return usersResponse;
    }

    public UserResponseDto getUser(UUID id) throws UserNotFoundException {
        if(!userDao.findById(id).isPresent()){
            throw new UserNotFoundException(": El usuario no pudo ser encontrado en el sistema.");
        }
        User findUser = userDao.findById(id).get();

        return mapeador.map(findUser, UserResponseDto.class);
    }

    public UserResponseDto getUserByEmail(String email) throws UserByEmailNotFoundException {
        User findUser = userDao.findUserByEmail(email);
        if(Objects.isNull(findUser)){
            throw new UserByEmailNotFoundException(": El email " + email + "no pudo ser encontrado en el sistema.");
        }
        return mapeador.map(findUser, UserResponseDto.class);
    }

    public UserResponseDto createUser(User request) throws EmailExistException, EmailBadFormatedException, NotCreatedUserException {

        if(!Objects.isNull(userDao.findUserByEmail(request.getEmail()))) {
            throw new EmailExistException("El email " + request.getEmail() + " ya existe en el sistema.");
        }

        if(!request.getEmail().matches("^[a-zA-Z0-9.!#$%&'*+=?^_`{|}~-]+@[a-zA-Z]*.cl$")) {
            throw new EmailBadFormatedException("");
        }

        Date date = new Date();

        request.setCreateDate(date);
        request.setModifiedDate(date);
        request.setLastLogin(date);

        User response = userDao.save(request);

        if(Objects.isNull(response)){
            throw new NotCreatedUserException();
        }

        return mapeador.map(response, UserResponseDto.class);
    }

    public UserResponseDto updateUser(User request) throws UserNotFoundException, EmailExistException, EmailBadFormatedException, NotUpdatedUserException {
        User updatedUser;
        User response;

        if(userDao.findById(request.getId()).isPresent()) {
            updatedUser = userDao.findById(request.getId()).get();
        } else {
            throw new UserNotFoundException();
        }

        if(!Objects.isNull(userDao.findUserByEmail(request.getEmail()))) {
            throw new EmailExistException("El email " + request.getEmail() + " ya existe en el sistema.");
        }

        if(!request.getEmail().matches("^[a-zA-Z0-9.!#$%&'*+=?^_`{|}~-]+@[a-zA-Z]*.cl$")) {
            throw new EmailBadFormatedException("");
        }

        if(!Objects.isNull(updatedUser)) {

            Date tmpCreateDate = updatedUser.getCreateDate();
            Date tmpLasLoginDate = updatedUser.getLastLogin();

            mapeador.map(request, updatedUser);
            updatedUser.setCreateDate(tmpCreateDate);
            updatedUser.setModifiedDate(new Date());
            updatedUser.setLastLogin(tmpLasLoginDate);

            response = userDao.save(updatedUser);

            if(Objects.isNull(response)){
                throw new NotUpdatedUserException("");
            }
            return mapeador.map(updatedUser, UserResponseDto.class);
        }
        return null;
    }

    public boolean deleteUser(UUID id) throws UserNotFoundException, NotDeletedUserException {
        User deletedUser;
        Boolean response = false;

        if(userDao.findById(id).isPresent()) {
            deletedUser = userDao.findById(id).get();
        } else {
            throw new UserNotFoundException(": El usuario no fue encontrado.");
        }

        if(!Objects.isNull(deletedUser)){
            try {
                userDao.delete(deletedUser);
            } catch (Exception ex) {
                throw new NotDeletedUserException();
            }
            response = true;
        }
        return response;
    }
}
