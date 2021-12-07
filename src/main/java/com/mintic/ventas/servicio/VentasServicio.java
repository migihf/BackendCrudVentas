package com.mintic.ventas.servicio;

import java.util.List;

import com.mintic.ventas.modelo.Ventas;

public interface VentasServicio {

	Ventas crearVentas(Ventas ventas);

	Ventas updateVentas(Ventas ventas);

	List<Ventas> getAllVentas();

	Ventas getVentasById(String ventasId);

	void deleteVentas(String ventasId);
}