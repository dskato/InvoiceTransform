package com.octa.invocetransform.Models.ComprobanteRetencionModel;

import com.google.gson.annotations.SerializedName;
import com.octa.invocetransform.Models.ComprobanteRetencionDocSustento.DocsSustento;

public class ComprobanteRetencion {

    @SerializedName("infoTributaria")
    InfoTributaria infoTributaria;

    @SerializedName("impuestos")
    Impuestos impuestos;

    @SerializedName("id")
    String id;

    @SerializedName("infoCompRetencion")
    InfoCompRetencion infoCompRetencion;
    
    @SerializedName("docsSustento")
    DocsSustento docsSustento;

    @SerializedName("version")
    String version;

    public DocsSustento getDocsSustento() {
        return docsSustento;
    }

    public void setDocsSustento(DocsSustento docsSustento) {
        this.docsSustento = docsSustento;
    }

    
    public void setInfoTributaria(InfoTributaria infoTributaria) {
        this.infoTributaria = infoTributaria;
    }

    public InfoTributaria getInfoTributaria() {
        return infoTributaria;
    }

    public void setImpuestos(Impuestos impuestos) {
        this.impuestos = impuestos;
    }

    public Impuestos getImpuestos() {
        return impuestos;
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
