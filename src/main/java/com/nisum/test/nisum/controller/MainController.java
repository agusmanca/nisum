package com.nisum.test.nisum.controller;

import com.nisum.test.nisum.model.dto.UserResponseDto;
import com.nisum.test.nisum.model.entity.User;
import com.nisum.test.nisum.model.exception.*;
import com.nisum.test.nisum.services.UserService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api")
@Api(tags = "Main Controller", value = "Operations for Main Controller")
public class MainController {

    private UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    @ApiOperation(nickname = "getUsers", value = "Get a all users registered", notes = "Allow get all users list.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessful", response = ResponseEntity.class) })
    public @ResponseBody ResponseEntity<List<UserResponseDto>> getUsers() throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(nickname = "getUser", value = "Get user by ID", notes = "Allow get user by ID.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessful", response = ResponseEntity.class) })
    public @ResponseBody ResponseEntity<UserResponseDto> getUser(@ApiParam(value = "Unique number ID of user.") @PathVariable UUID id) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    @ApiOperation(nickname = "getUserByEmail", value = "Get user by email", notes = "Allow get user by email.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessful", response = ResponseEntity.class) })
    public @ResponseBody ResponseEntity<UserResponseDto> getUserByEmail(@ApiParam(value = "Unique email ID of user.") @PathVariable String email) throws UserByEmailNotFoundException {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @PostMapping()
    @ApiOperation(nickname = "createUser", value = "Create a new User", notes = "Allow create new user.")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Sucessful", response = ResponseEntity.class) })
    public @ResponseBody ResponseEntity<UserResponseDto> createUser(@ApiParam(value = "Request body.") @RequestBody User request) throws EmailBadFormatedException, EmailExistException, NotCreatedUserException {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @PutMapping()
    public @ResponseBody ResponseEntity<UserResponseDto> updateUser(@RequestBody User request) throws UserNotFoundException, EmailExistException, EmailBadFormatedException, NotUpdatedUserException {
        return new ResponseEntity<>(userService.updateUser(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(nickname = "deleteUser", value = "Delete a User", notes = "Allow delete user.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessful", response = ResponseEntity.class) })
    public @ResponseBody ResponseEntity<String> deleteUser(@ApiParam(value = "Request body.") @PathVariable UUID id) throws NotDeletedUserException, UserNotFoundException {
        if(userService.deleteUser(id)) {
            return new ResponseEntity<>("El usuario fue borrado correctamente", HttpStatus.OK);
        } else {
            throw new NotDeletedUserException();
        }
    }
}
