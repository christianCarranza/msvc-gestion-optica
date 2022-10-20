package org.multilents.msvc.optica.msvcopticagestionventas.utils;

public class ConstantesUtil {

  private ConstantesUtil() {
  }

  public static final String TITULO_ALERTAS = "Información";
  public static final String MENSAJE_RESPUESTA_EXITOSA = "Información encontrada";
  public static final String MENSAJE_RESPUESTA_NO_ENCONTRADO = "No se encontraron registros";
  public static final String FORMATO_FECHA_CORTO = "dd/MM/yyyy";
  public static final String FORMATO_FECHA_RAYA_CORTO = "dd-MM-yyyy";
  public static final String FORMATO_FECHA_LARGO = "dd/MM/yyyy HH:mm:ss";
  public static final Integer IND_PRFJ_TIPO_PERSONA = 2;
  public static final Integer IND_CRRLTVO_PERSONA_NAT = 1;
  public static final Integer IND_CRRLTVO_PERSONA_JRICA = 2;
  public static final Integer IND_EDO_ACTIVO = 1;
  public static final Integer IND_EDO_INACTIVO = 2;
  public static final Integer IND_ACT_ACTIVO = 0;
  public static final Integer IND_ACT_INACTIVO = 9;
  public static final String EXCEL_MEDIA_TYPE = "application/vnd.ms-excel";
  public static final String EXCEL_HEADER = "attachment; filename=reporte.xlsx";

  //Path
  public static final String  API_VENTAS="/v1/usuarios";
}
