package com.homie.backend.sisInterno.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ManejoDecimal {

	public static Double redondear(double var) {
	
		System.out.println("var: "+(double) Math.round(((var) * 100d) / 100d));
		return (double) Math.round(((var) * 100d) / 100d);

	}
	
	
	public static Double truncar(double var) {	 
		System.out.println("var: "+Math.floor(var * 100) / 100);
		return Math.floor(var * 100) / 100;

	}



}
