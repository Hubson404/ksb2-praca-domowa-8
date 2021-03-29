package org.hubson404.ksb2pracadomowa8.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(NoteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void unknownLocationHandler(NoteNotFoundException exception) {
        log.error(exception.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void badRequestHandler(BadRequestException exception) {
        log.error(exception.getMessage());
    }

    @ExceptionHandler(DataProcessingErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    void dataProcessingErrorHandler(DataProcessingErrorException exception) {
        log.error(exception.getMessage());
    }

}

