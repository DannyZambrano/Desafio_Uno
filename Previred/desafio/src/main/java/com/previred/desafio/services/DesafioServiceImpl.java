package com.previred.desafio.services;

import com.previred.desafio.model.Fecha;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DesafioServiceImpl implements DesafioService{

    @Autowired
    RestTemplate template;

    String url="http://127.0.0.1:8080/periodos/api";
    @Override
    public Fecha obtenerFechas() throws JSONException, ParseException {

        Fecha fecha = new Fecha();
        String fechasAPI = template.getForObject(url,String.class);
        JSONObject jsonResponse = new JSONObject(fechasAPI);
        List<String> listAux = new ArrayList<>();

        fecha.setId(Integer.parseInt(jsonResponse.getString("id")));
        fecha.setFechaIni(jsonResponse.getString("fechaCreacion"));
        fecha.setFechaFin(jsonResponse.getString("fechaFin"));

        JSONArray array = jsonResponse.getJSONArray("fechas");
        ///  Se recorre un el jsonarray
        for (int i = 0; i < array.length(); i++) {

            listAux.add(array.get(i).toString());

        }

        fecha.setListaFechas(listAux);

        return validaLista(fecha);

    }

    private Fecha validaLista(Fecha fecha){

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse(fecha.getFechaIni(), formato);
        LocalDate fin = LocalDate.parse(fecha.getFechaFin(), formato);

        List<String> listFaltantes = new ArrayList<>();

        while (inicio.isBefore(fin) ){

            if(!fecha.getListaFechas().contains(inicio.toString())){
                listFaltantes.add(inicio.toString());
            }

            inicio = inicio.plusMonths(1);
        }

        fecha.setFechasFaltantes(listFaltantes);

        return fecha;
    }
}