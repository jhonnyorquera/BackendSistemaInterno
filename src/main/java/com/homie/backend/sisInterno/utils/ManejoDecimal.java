package com.homie.backend.sisInterno.utils;

public class ManejoDecimal {

	public static Double redondear(double var) {
		return (double) Math.round(((var) * 100d) / 100d);

	}
	
	
	public static Double truncar(double var) {	 
		return Math.floor(var * 100) / 100;

	}



}
