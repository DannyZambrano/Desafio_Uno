package com.previred.desafio.model;

import java.time.LocalDate;
import java.util.List;

public class Fecha {

    private int id;

    private String fechaIni;

    private String fechaFin;

    private List<String> listaFechas;

    private List<String> fechasFaltantes;

    public Fecha() {
    }

    public Fecha(int id, String fechaIni, String fechaFin, List<String> listaFechas, List<String> fechasFaltantes) {
        this.id = id;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.listaFechas = listaFechas;
        this.fechasFaltantes = fechasFaltantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<String> getListaFechas() {
        return listaFechas;
    }

    public void setListaFechas(List<String> listaFechas) {
        this.listaFechas = listaFechas;
    }

    public List<String> getFechasFaltantes() {
        return fechasFaltantes;
    }

    public void setFechasFaltantes(List<String> fechasFaltantes) {
        this.fechasFaltantes = fechasFaltantes;
    }
}
