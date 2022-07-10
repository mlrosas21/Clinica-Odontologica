package com.example.TFIBackEnd.Model;

public class PacienteDTO {

    private Long id;
    private int dni;
    private String nombre;
    private String apellido;

    public Long getId() {
        return id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
