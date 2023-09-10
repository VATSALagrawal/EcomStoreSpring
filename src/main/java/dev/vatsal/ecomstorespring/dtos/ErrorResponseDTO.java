package dev.vatsal.ecomstorespring.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseDTO {
    private HttpStatusCode code;
    private String message;
}
