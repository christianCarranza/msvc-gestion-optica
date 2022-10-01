package org.multilens.msvc.optica.gestionproductos.exception;

public class UnknownException extends RuntimeException {

  private static final String DESCRIPTION = "UnknownException (500)";

  public UnknownException(String mensaje) {
    super(DESCRIPTION + ". " + mensaje);
  }
}
