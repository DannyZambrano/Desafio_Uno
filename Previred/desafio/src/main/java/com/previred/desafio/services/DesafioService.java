package com.previred.desafio.services;

import com.previred.desafio.model.Fecha;
import org.json.JSONException;

import java.text.ParseException;

public interface DesafioService {

    Fecha obtenerFechas() throws JSONException, ParseException;
}
