package com.octa.invocetransform.Models.ComprobanteRetencionModel;

import com.google.gson.annotations.SerializedName;

public class FacturaComprobante {

    @SerializedName("comprobanteRetencion")
    ComprobanteRetencion comprobanteRetencion;

    private String fechaAutorizacion;
    private String numeroAutorizacion;
    private String estado;
    
    private boolean isValidDocApp;

    public boolean isIsValidDocApp() {
        return isValidDocApp;
    }

    public void setIsValidDocApp(boolean isValidDocApp) {
        this.isValidDocApp = isValidDocApp;
    }

    public String getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(String fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public String getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    public void setNumeroAutorizacion(String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setComprobanteRetencion(ComprobanteRetencion comprobanteRetencion) {
        this.comprobanteRetencion = comprobanteRetencion;
    }

    public ComprobanteRetencion getComprobanteRetencion() {
        return comprobanteRetencion;
    }

}
