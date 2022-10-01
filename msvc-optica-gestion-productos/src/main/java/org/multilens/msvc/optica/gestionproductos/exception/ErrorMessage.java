package pe.gob.vuce.zee.exception;

import pe.gob.vuce.zee.utils.ConstantesUtil;

public class ErrorMessage {

  private String status;
  private Integer code;
  private String error;
  private String message;
  private String path;

  public ErrorMessage(Exception exception, Integer code, String path) {
    this.status = ConstantesUtil.RPTA_ERROR;
    this.code = code;
    this.error = exception.getClass().getSimpleName();
    this.message = exception.getMessage();
    this.path = path;
  }

  public String getStatus() {
    return status;
  }

  public Integer getCode() {
    return code;
  }

  public String getError() {
    return error;
  }

  public String getMessage() {
    return message;
  }

  public String getPath() {
    return path;
  }

  @Override
  public String toString() {
    return "ErrorMessage [code=" + code + ", error=" + error + ", message=" + message + ", path=" + path + "]";
  }

}
