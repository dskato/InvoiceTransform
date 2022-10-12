package com.octa.invocetransform.Models.ComprobanteRetencionModelSingleImp;

import com.octa.invocetransform.Models.ComprobanteRetencionModel.*;
import com.google.gson.annotations.SerializedName;

public class ComprobanteRetencion_S {

    @SerializedName("infoTributaria")
    InfoTributaria infoTributaria;

    @SerializedName("impuestos")
    Impuestos_S impuestos;

   
    @SerializedName("id")
    String id;

    @SerializedName("infoCompRetencion")
    InfoCompRetencion infoCompRetencion;

    @SerializedName("version")
    String version;

   
    
    public void setInfoTributaria(InfoTributaria infoTributaria) {
        this.infoTributaria = infoTributaria;
    }

    public InfoTributaria getInfoTributaria() {
        return infoTributaria;
    }

    public Impuestos_S getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Impuestos_S impuestos) {
        this.impuestos = impuestos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setInfoCompRetencion(InfoCompRetencion infoCompRetencion) {
        this.infoCompRetencion = infoCompRetencion;
    }

    public InfoCompRetencion getInfoCompRetencion() {
        return infoCompRetencion;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

}
