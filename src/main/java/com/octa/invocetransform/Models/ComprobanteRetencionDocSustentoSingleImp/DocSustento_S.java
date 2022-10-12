/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.octa.invocetransform.Models.ComprobanteRetencionDocSustentoSingleImp;

import com.google.gson.annotations.SerializedName;
import com.octa.invocetransform.Models.ComprobanteRetencionDocSustento.ImpuestosDocSustento;
import com.octa.invocetransform.Models.ComprobanteRetencionDocSustento.Pagos;

/**
 *
 * @author dskat
 */
public class DocSustento_S {
    
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
    Retenciones_S retenciones;

    @SerializedName("pagos")
    Pagos pagos;

    public int getCodSustento() {
        return codSustento;
    }

    public void setCodSustento(int codSustento) {
        this.codSustento = codSustento;
    }

    public int getCodDocSustento() {
        return codDocSustento;
    }

    public void setCodDocSustento(int codDocSustento) {
        this.codDocSustento = codDocSustento;
    }

    public int getNumDocSustento() {
        return numDocSustento;
    }

    public void setNumDocSustento(int numDocSustento) {
        this.numDocSustento = numDocSustento;
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

    public int getNumAutDocSustento() {
        return numAutDocSustento;
    }

    public void setNumAutDocSustento(int numAutDocSustento) {
        this.numAutDocSustento = numAutDocSustento;
    }

    public int getPagoLocExt() {
        return pagoLocExt;
    }

    public void setPagoLocExt(int pagoLocExt) {
        this.pagoLocExt = pagoLocExt;
    }

    public double getTotalSinImpuestos() {
        return totalSinImpuestos;
    }

    public void setTotalSinImpuestos(double totalSinImpuestos) {
        this.totalSinImpuestos = totalSinImpuestos;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public ImpuestosDocSustento getImpuestosDocSustento() {
        return impuestosDocSustento;
    }

    public void setImpuestosDocSustento(ImpuestosDocSustento impuestosDocSustento) {
        this.impuestosDocSustento = impuestosDocSustento;
    }

    public Retenciones_S getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(Retenciones_S retenciones) {
        this.retenciones = retenciones;
    }

    public Pagos getPagos() {
        return pagos;
    }

    public void setPagos(Pagos pagos) {
        this.pagos = pagos;
    }
    
    
    
}
