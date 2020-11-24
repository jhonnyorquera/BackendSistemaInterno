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
        calendar.set(Calendar.MINUTE,0);
        return calendar.getTime();
        
    }
	
	public static Date transformarStringADate(String fecha) {

		Date fechaRes = new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"); 
		
		
		
		try {
			 fechaRes = formatter.parse(fecha.replaceAll("Z$", "+0000"));
			
		
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return fechaRes;
		
		
	}
}
