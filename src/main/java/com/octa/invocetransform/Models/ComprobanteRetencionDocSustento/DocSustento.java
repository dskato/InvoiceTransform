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
public class DocSustento {

    @SerializedName("codSustento")
    int codSustento;

    @SerializedName("codDocSustento")
    int codDocSustento;

    @SerializedName("numDocSustento")
    int numDocSustento;

    @SerializedName("fechaEmisionDocSustento")
    String fechaEmisionDocSustento;

    @SerializedName("fechaRegistroContable")
    String fechaRegistroContable;

    @SerializedName("numAutDocSustento")
    int numAutDocSustento;

    @SerializedName("pagoLocExt")
    int pagoLocExt;

    @SerializedName("totalSinImpuestos")
    double totalSinImpuestos;

    @SerializedName("importeTotal")
    double importeTotal;

    @SerializedName("impuestosDocSustento")
    ImpuestosDocSustento impuestosDocSustento;

    @SerializedName("retenciones")
    Retenciones retenciones;

    @SerializedName("pagos")
    Pagos pagos;

    public void setCodSustento(int codSustento) {
        this.codSustento = codSustento;
    }

    public int getCodSustento() {
        return codSustento;
    }

    public void setCodDocSustento(int codDocSustento) {
        this.codDocSustento = codDocSustento;
    }

    public int getCodDocSustento() {
        return codDocSustento;
    }

    public void setNumDocSustento(int numDocSustento) {
        this.numDocSustento = numDocSustento;
    }

    public int getNumDocSustento() {
        return numDocSustento;
    }

    public String getFechaEmisionDocSustento() {
        return fechaEmisionDocSustento;
    }

    public void setFechaEmisionDocSustento(String fechaEmisionDocSustento) {
        this.fechaEmisionDocSustento = fechaEmisionDocSustento;
    }

    public String getFechaRegistroContable() {
        return fechaRegistroContable;
    }

    public void setFechaRegistroContable(String fechaRegistroContable) {
        this.fechaRegistroContable = fechaRegistroContable;
    }

    public void setNumAutDocSustento(int numAutDocSustento) {
        this.numAutDocSustento = numAutDocSustento;
    }

    public int getNumAutDocSustento() {
        return numAutDocSustento;
    }

    public void setPagoLocExt(int pagoLocExt) {
        this.pagoLocExt = pagoLocExt;
    }

    public int getPagoLocExt() {
        return pagoLocExt;
    }

    public void setTotalSinImpuestos(double totalSinImpuestos) {
        this.totalSinImpuestos = totalSinImpuestos;
    }

    public double getTotalSinImpuestos() {
        return totalSinImpuestos;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImpuestosDocSustento(ImpuestosDocSustento impuestosDocSustento) {
        this.impuestosDocSustento = impuestosDocSustento;
    }

    public ImpuestosDocSustento getImpuestosDocSustento() {
        return impuestosDocSustento;
    }

    public void setRetenciones(Retenciones retenciones) {
        this.retenciones = retenciones;
    }

    public Retenciones getRetenciones() {
        return retenciones;
    }

    public void setPagos(Pagos pagos) {
        this.pagos = pagos;
    }

    public Pagos getPagos() {
        return pagos;
    }
}
