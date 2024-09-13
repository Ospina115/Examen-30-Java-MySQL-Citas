package com.examenjava.medico;

import java.util.Date;

public class Medico {
    private int id;
    private String nombre;
    private Date horario_inicio;
    private Date horario_fin;

    public Medico(String nombre, Date horario_inicio, Date horario_fin) {
        this.nombre = nombre;
        this.horario_inicio = horario_inicio;
        this.horario_fin = horario_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(Date horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public Date getHorario_fin() {
        return horario_fin;
    }

    public void setHorario_fin(Date horario_fin) {
        this.horario_fin = horario_fin;
    }

    
}
