package com.ceiba.api_busqueda.puerto.repositorio;

import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.busqueda.modelo.entidad.BusquedaAlmacenada;

public interface IConsumoApi {

    RespApiBusqueda crearBusquedaMCO(String palabra);

    RespApiBusqueda crearBusquedaMEC(String palabra);

    String almacenarBusqueda(BusquedaAlmacenada busquedaAlmacenada);

}
