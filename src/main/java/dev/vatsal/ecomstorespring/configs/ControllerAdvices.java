package dev.vatsal.ecomstorespring.configs;


import dev.vatsal.ecomstorespring.Exceptions.NotFoundException;
import dev.vatsal.ecomstorespring.dtos.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(NotFoundException ex){
//        ResponseEntity<ErrorResponseDTO> responseEntity = new ResponseEntity<>(new ErrorResponseDTO(HttpStatus.NOT_FOUND,ex.getMessage()),HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }
}
