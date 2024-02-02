package br.com.cursos.desafiorocketseatcursos.lib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import br.com.cursos.desafiorocketseatcursos.modules.course.exceptions.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {
  @Autowired
  private MessageSource messageSource;

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ExceptionResponseDTO> handleEntityNotFoundException(EntityNotFoundException e) {
    var exceptionResponse = ExceptionResponseDTO.builder()
        .message(e.getMessage())
        .field("entity-not-found")
        .build();

    var response = ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exceptionResponse);

    return response;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ExceptionResponseDTO>> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {

    var errors = e.getBindingResult().getFieldErrors()
        .stream()
        .map(err -> {
          String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());

          var error = ExceptionResponseDTO.builder()
              .message(message)
              .field(err.getField())
              .build();

          return error;
        })
        .toList();

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<ExceptionResponseDTO> handleNoResourceFoundException(Exception e) {
    var exceptionResponse = ExceptionResponseDTO.builder()
        .message(e.getMessage())
        .field("url")
        .build();

    var response = ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exceptionResponse);

    return response;
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<ExceptionResponseDTO> handleHttpRequestMethodNotSupportedException(
      Exception e) {
    var exceptionResponse = ExceptionResponseDTO.builder()
        .message(e.getMessage())
        .field("method-not-allowed")
        .build();

    var response = ResponseEntity
        .status(HttpStatus.METHOD_NOT_ALLOWED)
        .body(exceptionResponse);

    return response;
  }

}
