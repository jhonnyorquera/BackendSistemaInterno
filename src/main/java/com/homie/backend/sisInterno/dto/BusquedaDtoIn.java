package com.homie.backend.sisInterno.dto;

import java.util.Date;

public interface BusquedaDtoIn {
	String getPeCodigo();

	String getClCliente();

	Date getPeFecha();

	String getPeEstado();

	Double getPeCantidadHoras();

	String getPeTipo();

	String getPePadre();
}
