package com.ceiba.recomendacion.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.recomendacion.comando.ComandoConsultarRecomendacion;
import com.ceiba.recomendacion.modelo.entidad.Recomendacion;
import com.ceiba.recomendacion.puerto.dao.DaoRecomendacion;
import com.ceiba.recomendacion.servicio.ServicioConsultarRecomendacion;
import com.ceiba.recomendacion.servicio.ServicioCrearRecomendacion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ManejadorConsultarRecomendacion implements ManejadorComandoRespuesta<ComandoConsultarRecomendacion, ComandoRespuesta<RespApiBusqueda>> {

    private final DaoRecomendacion daoRecomendacion;
    private final ServicioCrearRecomendacion servicioCrearRecomendacion;
    private final ServicioConsultarRecomendacion consultarRecomendacion;
    private List<String> json;

    public ManejadorConsultarRecomendacion(DaoRecomendacion daoRecomendacion, ServicioCrearRecomendacion servicioCrearRecomendacion, ServicioConsultarRecomendacion consultarRecomendacion) {
        this.daoRecomendacion = daoRecomendacion;
        this.servicioCrearRecomendacion = servicioCrearRecomendacion;
        this.consultarRecomendacion = consultarRecomendacion;
    }

    public ComandoRespuesta<RespApiBusqueda> ejecutar(ComandoConsultarRecomendacion comandoConsultarRecomendacion){
        json = this.daoRecomendacion.consultar(comandoConsultarRecomendacion.getIdUsuario());
        String js = json.get(0);
        List<String> r = new ArrayList<String>(Arrays.asList(js.split(",")));
        Recomendacion recomendacion = new Recomendacion(r);
        return new ComandoRespuesta<>(this.servicioCrearRecomendacion.ejecutar(recomendacion));
//        return new ComandoRespuesta<>(this.consultarRecomendacion.ejecutar(json));
    }
}
