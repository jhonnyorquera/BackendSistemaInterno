package com.homie.backend.sisInterno.utils;

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
}
