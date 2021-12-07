package com.mintic.ventas.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mintic.ventas.modelo.Ventas;

@Repository
public interface IVentasRepositorio extends MongoRepository<Ventas, String> {
}