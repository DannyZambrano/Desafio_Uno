package com.previred.desafio.controller;

import com.previred.desafio.model.Fecha;
import com.previred.desafio.services.DesafioService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;


@RestController
public class DesafioController {

    @Autowired
    DesafioService service;

    @GetMapping(path = "/consulta", produces = MediaType.APPLICATION_JSON_VALUE)
    public Fecha obtenerFechas() throws JSONException, ParseException {

        return service.obtenerFechas();
    }
}
