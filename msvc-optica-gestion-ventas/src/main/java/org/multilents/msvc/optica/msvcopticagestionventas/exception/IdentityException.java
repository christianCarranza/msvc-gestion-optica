package org.multilents.msvc.optica.msvcopticagestionventas.exception;

public class IdentityException extends RuntimeException {
  private String code;

  public IdentityException(String message) {
    super(message);
  }

  public IdentityException(String code, String message) {
    super(message);
    this.code = code;
  }
}
