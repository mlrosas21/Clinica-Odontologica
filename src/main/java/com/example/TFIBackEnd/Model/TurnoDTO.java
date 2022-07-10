package com.example.TFIBackEnd.Model;

import java.time.LocalDate;
import java.util.Date;

public class TurnoDTO {
    private Long id;
    private LocalDate fecha;
    private Paciente paciente;

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    private Odontologo odontologo;
}
