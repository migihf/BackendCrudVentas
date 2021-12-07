package com.mintic.ventas.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ventas")
public class Ventas {

	@Id
	private String _id;

	private String sucursal;
	private int cedula_cliente;
	private int codigo_venta;
	private List<DetalleVenta> detalle_venta;
	private double ivaventa;
	private double total_venta;
	private double valor_venta;

	public Ventas() {
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public int getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(int cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public int getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public List<DetalleVenta> getDetalle_venta() {
		return detalle_venta;
	}

	public void setDetalle_venta(List<DetalleVenta> detalle_venta) {
		this.detalle_venta = detalle_venta;
	}

	public double getIvaventa() {
		return ivaventa;
	}

	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

}