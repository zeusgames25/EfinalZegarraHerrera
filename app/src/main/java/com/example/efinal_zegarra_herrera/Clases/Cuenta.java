package com.example.efinal_zegarra_herrera.Clases;

import com.google.gson.annotations.SerializedName;

public class Cuenta {
    private String nombre;
    private int monto;
    @SerializedName("fecha_creacion")
    private String fechacreacion;
    @SerializedName("sucursal_1")
    private String sucursal1;
    @SerializedName("sucursal_2")
    private String sucursal2;
    @SerializedName("sucursal_3")
    private String sucursal3;
    private String imagen;

    public Cuenta(String nombre, int monto, String fechacreacion, String sucursal1, String sucursal2, String sucursal3, String imagen) {
        this.nombre = nombre;
        this.monto = monto;
        this.fechacreacion = fechacreacion;
        this.sucursal1 = sucursal1;
        this.sucursal2 = sucursal2;
        this.sucursal3 = sucursal3;
        this.imagen = imagen;
    }

    public Cuenta() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getSucursal1() {
        return sucursal1;
    }

    public void setSucursal1(String sucursal1) {
        this.sucursal1 = sucursal1;
    }

    public String getSucursal2() {
        return sucursal2;
    }

    public void setSucursal2(String sucursal2) {
        this.sucursal2 = sucursal2;
    }

    public String getSucursal3() {
        return sucursal3;
    }

    public void setSucursal3(String sucursal3) {
        this.sucursal3 = sucursal3;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
