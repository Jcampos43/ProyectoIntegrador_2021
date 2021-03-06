package com.veterinaria.service; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.veterinaria.entity.*;
import com.veterinaria.repository.*;

@Service
public class BoletaServiceImpl implements BoletaService{

	@Autowired
	private BoletaRepository boletaRepository;
	
	@Autowired
	private ProductoHasBoletaRepository detalleRepository;
	

	
    @Override
	@Transactional
	public Boleta insertaBoleta(Boleta obj) {
		Boleta cabecera = boletaRepository.save(obj);
		for (ProductoHasBoleta d : cabecera.getDetallesBoleta()) {
			d.getProductoHasBoletaPK().setNum_boleta(cabecera.getNum_boleta());
			detalleRepository.actualizaStock(d.getCantidad(), d.getProductoHasBoletaPK().getCod_pro());
			detalleRepository.save(d);
		}
		return cabecera;
	}
    
	@Override
	public List<Boleta> buscarPorCodUsuario(int cod_usu) {
		return boletaRepository.buscarPorCodUsuario(cod_usu);
	}
	
	@Override
	public List<Boleta> listaPedido() {
		return boletaRepository.findAll();
	}

	@Override
	public int actualizarEstadoPedido(Integer estado, Integer num_boleta) {
		return boletaRepository.actualizarEstadoPedido(estado, num_boleta);
	}

}
