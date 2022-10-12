/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.octa.invocetransform.Models.ComprobanteRetencionDocSustento;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author dskat
 */
public class ImpuestosDocSustento {

    @SerializedName("impuestoDocSustento")
    List<ImpuestoDocSustento> impuestoDocSustento;

    public void setImpuestoDocSustento(List<ImpuestoDocSustento> impuestoDocSustento) {
        this.impuestoDocSustento = impuestoDocSustento;
    }

    public List<ImpuestoDocSustento> getImpuestoDocSustento() {
        return impuestoDocSustento;
    }
}
