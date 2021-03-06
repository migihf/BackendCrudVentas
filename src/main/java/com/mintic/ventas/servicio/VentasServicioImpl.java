package com.mintic.ventas.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.ventas.dao.IVentasRepositorio;
import com.mintic.ventas.excepcion.ResourceNotFoundException;
import com.mintic.ventas.modelo.Ventas;

@Service
@Transactional
public class VentasServicioImpl implements VentasServicio {

	@Autowired
	private IVentasRepositorio ventaRepo;

	@Override
	public Ventas crearVentas(Ventas ventas) {
		return ventaRepo.save(ventas);
	}

	@Override
	public Ventas updateVentas(Ventas ventas) {
		// Se busca el cliente con el Id del objeto cliente recibido
		Optional<Ventas> ventasDb = this.ventaRepo.findById(ventas.get_id());
		
		if(ventasDb.isPresent()) {
			// Se crea un objeto tipo Producto con los datos recuperados
			Ventas ventasUpdate = ventasDb.get();
			// Se actualiza el valor de cada atributo con el get correspondiente de producto
			ventasUpdate.set_id(ventas.get_id());
			ventasUpdate.setCedula_cliente(ventas.getCedula_cliente());
			ventasUpdate.setCodigo_venta(ventas.getCodigo_venta());
			ventasUpdate.setDetalle_venta(ventas.getDetalle_venta());
			ventasUpdate.setIvaventa(ventas.getIvaventa());
			ventasUpdate.setTotal_venta(ventas.getTotal_venta());
			ventasUpdate.setValor_venta(ventas.getValor_venta());
			// Se actualizan los valores del objeto producto
			ventaRepo.save(ventasUpdate);
			return ventasUpdate;
		} else {
			throw new ResourceNotFoundException("Venta no encontrada, Id:"+ventas.get_id());
		}
	}

	@Override
	public List<Ventas> getAllVentas() {
		return ventaRepo.findAll();
	}

	@Override
	public Ventas getVentasById(String ventasId) {
		Optional<Ventas> ventasDb = this.ventaRepo.findById(ventasId);
		if (ventasDb.isPresent())  {
			return ventasDb.get();
		} else {
			throw new ResourceNotFoundException("Venta no encontrada, Id:"+ventasId);
		}
	}

	@Override
	public void deleteVentas(String ventasId) {
		Optional<Ventas> ventaDb = this.ventaRepo.findById(ventasId);
		if( ventaDb.isPresent() ) {
			this.ventaRepo.delete(ventaDb.get());
		} else {
			throw new ResourceNotFoundException("Venta no encontrada, Id:"+ventasId);
		}
	}
}
