package com.example.examenfinaldominicgalarce;

public class Animales {

    private int id;
    private String[] tipo = {"Animal Domestico", "Animal Salvaje", "Otros"};
    private int[] precioTipo = {25000, 45000, 18000};
    private String[] enfermedad = {"Brucelosis", "Fiebre Aftosa", "Salmonella", "Rabia"};
    private int[] precioEnfermedad = {75000, 22500, 35000, 54000};

    public Animales() {
        id = 1;
    }

    public Animales(int id, String[] tipo, int[] precioTipo, String[] enfermedad, int[] precioEnfermedad) {
        this.id = id;
        this.tipo = tipo;
        this.precioTipo = precioTipo;
        this.enfermedad = enfermedad;
        this.precioEnfermedad = precioEnfermedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getTipo() {
        return tipo;
    }

    public void setTipo(String[] tipo) {
        this.tipo = tipo;
    }

    public int[] getPrecioTipo() {
        return precioTipo;
    }

    public void setPrecioTipo(int[] precioTipo) {
        this.precioTipo = precioTipo;
    }

    public String[] getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String[] enfermedad) {
        this.enfermedad = enfermedad;
    }

    public int[] getPrecioEnfermedad() {
        return precioEnfermedad;
    }

    public void setPrecioEnfermedad(int[] precioEnfermedad) {
        this.precioEnfermedad = precioEnfermedad;
    }
}