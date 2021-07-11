package com.nisum.test.nisum.config;

import com.nisum.test.nisum.model.ErrorMessage;
import com.nisum.test.nisum.model.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserNotFoundException.class, UserByEmailNotFoundException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(Exception exception) {
        return new ErrorMessage(exception);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EmailBadFormatedException.class, PasswordBadFormatedException.class, EmailExistException.class})
    @ResponseBody
    public ErrorMessage badRequest(Exception exception) {
        return new ErrorMessage(exception);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({AccessDeniedException.class})
    @ResponseBody
    public ErrorMessage forbidden(Exception exception) {
        return new ErrorMessage(exception);
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({UnknownException.class, NotCreatedUserException.class, NotUpdatedUserException.class, NotDeletedUserException.class})
    @ResponseBody
    public ErrorMessage internalServerError(Exception exception) {
        return new ErrorMessage(exception);
    }
}
