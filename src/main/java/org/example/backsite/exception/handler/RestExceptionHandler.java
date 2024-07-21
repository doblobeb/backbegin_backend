package org.example.backsite.exception.handler;

import org.example.backsite.exception.BadRequestException;
import org.example.backsite.exception.CustomNotFoundException;
import org.example.backsite.exception.DatabaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@SuppressWarnings({"NullableProblems", "PlaceholderCountMatchesArgumentCount"})
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);




    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        logger.error(ex.getMessage(), "Bad request exception");
        return buildResponseEntity(new ErrorResults(ex.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }

    /**
     * Custom not found exception for not found operations.
     *
     * @param ex CustomNotFoundException
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler(CustomNotFoundException.class)
    protected ResponseEntity<Object> handleCustomNotFoundException(CustomNotFoundException ex) {
        logger.error(ex.getLocalizedMessage(), "Not found exception");
        return buildResponseEntity(new ErrorResults(ex.getMessage(), 404), HttpStatus.NOT_FOUND);
    }

    /**
     * Database exception class for errors while exchanging data with database.
     *
     * @param ex DatabaseException
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler(DatabaseException.class)
    protected ResponseEntity<Object> handleDatabaseException(DatabaseException ex) {
        logger.error(ex.getLocalizedMessage(), "Database exception");
        return buildResponseEntity(new ErrorResults(ex.getMessage(), 501), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResults errorResults, HttpStatus httpStatus) {
        return new ResponseEntity<>(errorResults, httpStatus);
    }


}

