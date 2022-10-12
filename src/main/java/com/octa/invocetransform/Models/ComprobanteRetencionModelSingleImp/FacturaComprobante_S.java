package com.octa.invocetransform.Models.ComprobanteRetencionModelSingleImp;

import com.octa.invocetransform.Models.ComprobanteRetencionModel.*;
import com.google.gson.annotations.SerializedName;

public class FacturaComprobante_S {

    @SerializedName("comprobanteRetencion")
    ComprobanteRetencion_S comprobanteRetencion;

    private String fechaAutorizacion;
    private String numeroAutorizacion;
    private String estado;

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

    public void setComprobanteRetencion(ComprobanteRetencion_S comprobanteRetencion) {
        this.comprobanteRetencion = comprobanteRetencion;
    }

    public ComprobanteRetencion_S getComprobanteRetencion() {
        return comprobanteRetencion;
    }

}
