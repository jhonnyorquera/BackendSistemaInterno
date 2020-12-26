package com.homie.backend.sisInterno.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ManejoFechas {

	public static Date quitarHora(Date fecha) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();

	}

	public static Date transformarStringADate(String fecha) {

		Date fechaRes = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		try {
			fechaRes = formatter.parse(fecha.replaceAll("Z$", "+0000"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaRes;
	}

	public static Date getFechaInicio(Date fecha) {
		Calendar fechaInicio = Calendar.getInstance();
		fechaInicio.setTime(fecha);
		fechaInicio.set(Calendar.DAY_OF_MONTH, 1);
		return fechaInicio.getTime();

	}

	public static Date getFechaFin(Date fecha) {

		Calendar fechaFin = Calendar.getInstance();
		fechaFin.setTime(fecha);
		fechaFin.set(Calendar.DAY_OF_MONTH, 1);
		fechaFin.add(Calendar.MONTH, 1);
		fechaFin.add(Calendar.DAY_OF_YEAR, -1);
		return fechaFin.getTime();

	}

}
