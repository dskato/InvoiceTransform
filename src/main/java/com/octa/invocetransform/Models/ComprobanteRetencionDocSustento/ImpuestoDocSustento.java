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
public class ImpuestoDocSustento {

    @SerializedName("codImpuestoDocSustento")
    int codImpuestoDocSustento;

    @SerializedName("codigoPorcentaje")
    int codigoPorcentaje;

    @SerializedName("baseImponible")
    int baseImponible;

    @SerializedName("tarifa")
    int tarifa;

    @SerializedName("valorImpuesto")
    int valorImpuesto;

    public void setCodImpuestoDocSustento(int codImpuestoDocSustento) {
        this.codImpuestoDocSustento = codImpuestoDocSustento;
    }

    public int getCodImpuestoDocSustento() {
        return codImpuestoDocSustento;
    }

    public void setCodigoPorcentaje(int codigoPorcentaje) {
        this.codigoPorcentaje = codigoPorcentaje;
    }

    public int getCodigoPorcentaje() {
        return codigoPorcentaje;
    }

    public void setBaseImponible(int baseImponible) {
        this.baseImponible = baseImponible;
    }

    public int getBaseImponible() {
        return baseImponible;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setValorImpuesto(int valorImpuesto) {
        this.valorImpuesto = valorImpuesto;
    }

    public int getValorImpuesto() {
        return valorImpuesto;
    }
}
