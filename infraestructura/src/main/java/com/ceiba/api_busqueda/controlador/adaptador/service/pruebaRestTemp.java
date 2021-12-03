package com.ceiba.api_busqueda.controlador.adaptador.service;

import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.busqueda.modelo.entidad.BusquedaAlmacenada;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.ceiba.api_busqueda.puerto.repositorio.IConsumoApi;

@Repository
public class pruebaRestTemp implements IConsumoApi {

    private final String MERCADOLIBRECOLOMBIA = "MCO";
    private final String MERCADOLIBREECUADOR = "MEC";
    private final int LIMITE_DE_BUSQUEDA = 20;

    @Override
    public RespApiBusqueda crearBusquedaMCO(String palabra) {
        String url = "https://api.mercadolibre.com/sites/"+MERCADOLIBRECOLOMBIA+"/search?q="+palabra+"&limit="+LIMITE_DE_BUSQUEDA;
        RestTemplate plantilla = new RestTemplate();
        RespApiBusqueda resultado = plantilla.getForObject(url, RespApiBusqueda.class);
        return resultado;
    }

    @Override
    public RespApiBusqueda crearBusquedaMEC(String palabra) {
        String url = "https://api.mercadolibre.com/sites/"+MERCADOLIBREECUADOR+"/search?q="+palabra+"&limit="+LIMITE_DE_BUSQUEDA;
        RestTemplate plantilla = new RestTemplate();
        RespApiBusqueda resultado = plantilla.getForObject(url, RespApiBusqueda.class);
        return resultado;
    }

    @Override
    public String almacenarBusqueda(BusquedaAlmacenada busquedaAlmacenada) {
        String url = "http://localhost:8083/meta-recomendador/busquedas";
        RestTemplate plantilla = new RestTemplate();
        String result = plantilla.postForObject(url, busquedaAlmacenada, String.class);
        return result;
    }
}
