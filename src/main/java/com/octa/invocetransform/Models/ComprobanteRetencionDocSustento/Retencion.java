/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.octa.invocetransform.Models.ComprobanteRetencionDocSustento;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author dskat
 */
public class Retencion {

    @SerializedName("codigo")
    int codigo;

    @SerializedName("codigoRetencion")
    String codigoRetencion;

    @SerializedName("baseImponible")
    double baseImponible;

    @SerializedName("porcentajeRetener")
    int porcentajeRetener;

    @SerializedName("valorRetenido")
    double valorRetenido;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigoRetencion(String codigoRetencion) {
        this.codigoRetencion = codigoRetencion;
    }

    public String getCodigoRetencion() {
        return codigoRetencion;
    }

    public void setBaseImponible(double baseImponible) {
        this.baseImponible = baseImponible;
    }

    public double getBaseImponible() {
        return baseImponible;
    }

    public void setPorcentajeRetener(int porcentajeRetener) {
        this.porcentajeRetener = porcentajeRetener;
    }

    public int getPorcentajeRetener() {
        return porcentajeRetener;
    }

    public void setValorRetenido(double valorRetenido) {
        this.valorRetenido = valorRetenido;
    }

    public double getValorRetenido() {
        return valorRetenido;
    }
}
