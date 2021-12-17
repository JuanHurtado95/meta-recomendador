package com.ceiba.api_busqueda.servicio;

import com.ceiba.api_busqueda.modelo.dto.RespApiBusqueda;
import com.ceiba.api_busqueda.modelo.dto.ResultMCO;
import com.ceiba.api_busqueda.modelo.entidad.Busqueda;
import com.ceiba.api_busqueda.puerto.repositorio.IConsumoApi;
import com.ceiba.busqueda.modelo.entidad.BusquedaAlmacenada;

import java.util.ArrayList;
import java.util.List;

public class ServicioCrearApiBusqueda {

    private final IConsumoApi iConsumoApi;
    private RespApiBusqueda apiMCO;
    private RespApiBusqueda apiMEC;
    private final int PRECIO_DOLAR = 4000;
    private final int LIMITE_DE_BUSQUEDA = 20;
    private BusquedaAlmacenada busquedaAlmacenada;

    public ServicioCrearApiBusqueda(IConsumoApi iConsumoApi) {
        this.iConsumoApi = iConsumoApi;
    }

    public RespApiBusqueda ejecutar(Busqueda busqueda){
        apiMCO = this.iConsumoApi.crearBusquedaMCO(busqueda.getPalabraBuscada(), LIMITE_DE_BUSQUEDA);
        apiMEC = this.iConsumoApi.crearBusquedaMEC(busqueda.getPalabraBuscada(), LIMITE_DE_BUSQUEDA);
        apiMCO.setResults(UnirRespApi(apiMCO.getResults(), apiMEC.getResults()));

        busquedaAlmacenada = new BusquedaAlmacenada(0L, busqueda.getIdUsuario(), busqueda.getPalabraBuscada(), apiMCO.getResults().get(0).getCategory_id());
        String guardado = this.iConsumoApi.almacenarBusqueda(busquedaAlmacenada);

        return apiMCO;
    }

    private List<ResultMCO> UnirRespApi(List<ResultMCO> apiMCO, List<ResultMCO> apiMEC){

        List<ResultMCO> resp = new ArrayList<>();

        if(apiMCO == null){
            return apiMEC;
        }
        if(apiMEC == null){
            return apiMCO;
        }
        for(int i=0;i<apiMCO.size();i++){
            if(apiMCO.get(i).getCurrency_id().equals("USD")){
                apiMCO.get(i).setPrice(apiMCO.get(i).getPrice()*PRECIO_DOLAR);
            }
            if(apiMEC.get(i).getCurrency_id().equals("USD")){
                apiMEC.get(i).setPrice(apiMEC.get(i).getPrice()*PRECIO_DOLAR);
            }
            resp.add(apiMCO.get(i));
            resp.add(apiMEC.get(i));
        }

        return resp;
    }
}
