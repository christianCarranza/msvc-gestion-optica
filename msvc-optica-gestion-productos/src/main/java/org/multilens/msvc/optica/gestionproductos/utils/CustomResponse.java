package org.multilens.msvc.optica.gestionproductos.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class CustomResponse {

    private String status; // success, info, error
    private Object data; //Devuelve el Object
    private String message;//Mensaje
    private List<?> list;//Retorna la lista siempre y cuando sea Success
    private Date timestamp;  //La fecha y hora de consulta o transaccion
    private UUID id; //Id del objeto persistido cuando la transaccion es success

    public CustomResponse() {
        super();
    }

    public CustomResponse(String status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public CustomResponse(String status, List<?> list, String message) {
        this.status = status;
        this.list = list;
        this.message = message;
    }

    public CustomResponse(String status, String message, UUID id) {
        this.status = status;
        this.message = message;
        this.id = id;
    }

    public CustomResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp != null ? timestamp : FechasUtil.getToFullDay();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}