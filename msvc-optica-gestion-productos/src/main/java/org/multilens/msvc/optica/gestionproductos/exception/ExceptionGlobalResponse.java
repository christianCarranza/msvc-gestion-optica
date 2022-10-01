package pe.gob.vuce.zee.exception;

import java.nio.file.AccessDeniedException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pe.gob.vuce.zee.dtos.ResponseDTO;

@RestControllerAdvice
@Slf4j
public class ExceptionGlobalResponse extends ResponseEntityExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public final ResponseEntity<ResponseDTO> notFoundException(NotFoundException ex) {
    ResponseDTO response = new ResponseDTO("error", ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BadRequestException.class)
  public final ResponseEntity<ResponseDTO> badRequestException(BadRequestException ex) {
    ResponseDTO response = new ResponseDTO("error", ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodNotAllowedException.class)
  public final ResponseEntity<ResponseDTO> methodNotAllowedException(MethodNotAllowedException ex) {
    ResponseDTO response = new ResponseDTO("error", ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
  }

  @ExceptionHandler(VuceZeeException.class)
  public final ResponseEntity<ResponseDTO> vuceZeeExceptionPersonalizado(VuceZeeException ex) {
    log.error("Ingreso a vuceZeeExceptionPersonalizado global===========");
    ResponseDTO response = new ResponseDTO(ex.getTipo(), ex.getMensaje());
    return new ResponseEntity<>(response, HttpStatus.NOT_IMPLEMENTED);
  }

  @ExceptionHandler(AccessDeniedException.class)
  public final ResponseEntity<ResponseDTO> accesoDenegadoException(AccessDeniedException ex) {
    log.error("Ingreso a accesoDenegadoException global===========");
    ResponseDTO response = new ResponseDTO("error", "No estas autorizado para acceder a este recurso");
    return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(DataAccessException.class)
  public final ResponseEntity<ResponseDTO> DataAccessException(DataAccessException ex) {
    log.error("Ingreso a DataAccessException global===========" + ex.getMessage());
    ResponseDTO response = new ResponseDTO("error", ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ResponseDTO> manejarTodasExcepciones(Exception ex) {
    log.error("Ingreso a accesoDenegadoException global===========");
    String message = ex.getCause() != null ? (ex.getCause().getCause() != null ? ex.getCause().getCause().getMessage() : ex.toString()) :
            ex.toString();
    ResponseDTO response = new ResponseDTO("error", message);
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
