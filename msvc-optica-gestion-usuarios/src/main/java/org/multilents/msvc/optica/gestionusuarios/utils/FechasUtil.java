package org.multilents.msvc.optica.gestionusuarios.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
public class FechasUtil {

  public static String convertDateToString(Date fecha, String formato) {
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat(formato);
    String fechaString = "";
    try {

      if (fecha == null) {
        return "";
      }
      fechaString = formatoDelTexto.format(fecha);
    } catch (Exception e) {
    }
    return fechaString;
  }

  public static String convertDateToString(LocalDateTime fecha, String formato) {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern(formato);
    String fechaString = "";
    try {
      if (fecha == null) {
        return "";
      }
      fechaString = fecha.format(fmt);
    } catch (Exception e) {
      log.info("Error:: convertDateToString"+e.getMessage());
    }
    return fechaString;
  }

  public static Date convertStringToDate(String fecha, String formato) {
    SimpleDateFormat format = new SimpleDateFormat(formato);
    try {
      if (StringUtils.isBlank(fecha)) {
        return null;
      }
      return format.parse(fecha);
    } catch (ParseException e) {
    }
    return null;
  }

  public static Date getToDay() {
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal = Calendar.getInstance();
    format.setCalendar(cal);
    return cal.getTime();
  }


  public static Date getToFullDay() {
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Calendar cal = Calendar.getInstance();
    format.setCalendar(cal);
    return cal.getTime();
  }

  public static LocalDateTime getStringStartDate(String fechaInicial, String formato) {
    return LocalDateTime.parse(fechaInicial + "T00:00:00");
  }

  public static LocalDateTime getStringEndDate(String fechaFin, String formato) {
    return LocalDateTime.parse(fechaFin + "T23:59:59");
  }

  // Permite comparar si fecha inicial es mayor a fecha final
  public static boolean compareDateInitialFinal(String fechaInicial, String fechaFin, String formato) {
    var r = false;

    try {
      var dateFormat = new SimpleDateFormat(formato);
      Date fechai = dateFormat.parse(fechaInicial);
      Date fechaf = dateFormat.parse(fechaFin);

      if (fechai.after(fechaf)) {
        r = true;
      }
    } catch (ParseException ex) {
    }

    return r;
  }

  public static LocalDateTime convertDateToLocalDateTime(String fecha) {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate ld = LocalDate.parse(fecha, formato);
    return LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());
  }

  public static Page<?> paginate(List<?> l, Pageable pageable, Long t) {
    return PageableExecutionUtils.getPage(l, pageable, () -> t);
  }

}
