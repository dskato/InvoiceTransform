package com.octa.invocetransform.Models.ComprobanteRetencionModel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Impuestos {

    @SerializedName("impuesto")
    List<Impuesto> impuesto;

    public void setImpuesto(List<Impuesto> impuesto) {
        this.impuesto = impuesto;
    }

    public List<Impuesto> getImpuesto() {
        return impuesto;
    }

}
