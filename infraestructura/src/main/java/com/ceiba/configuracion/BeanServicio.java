package com.ceiba.configuracion;

import com.ceiba.api_busqueda.puerto.repositorio.IConsumoApi;
import com.ceiba.api_busqueda.servicio.ServicioCrearApiBusqueda;
import com.ceiba.busqueda.puerto.repositorio.RepositorioBusqueda;
import com.ceiba.busqueda.servicio.ServicioCrearBusqueda;
import com.ceiba.preferencia.puerto.repositorio.RepositorioPreferencia;
import com.ceiba.preferencia.servicio.ServicioActualizarPreferencia;
import com.ceiba.preferencia.servicio.ServicioCrearPreferencia;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearPreferencia servicioCrearPreferencia(RepositorioPreferencia repositorioPreferencia){
        return new ServicioCrearPreferencia(repositorioPreferencia);
    }

    @Bean
    public ServicioActualizarPreferencia servicioActualizarPreferencia(RepositorioPreferencia repositorioPreferencia){
        return new ServicioActualizarPreferencia(repositorioPreferencia);
    }

    @Bean
    public ServicioCrearBusqueda servicioCrearBusqueda(RepositorioBusqueda repositorioBusqueda){
        return new ServicioCrearBusqueda(repositorioBusqueda);
    }

    @Bean
    public ServicioCrearApiBusqueda servicioCrearApiBusqueda(IConsumoApi iConsumoApi){
        return new ServicioCrearApiBusqueda(iConsumoApi);
    }
}
