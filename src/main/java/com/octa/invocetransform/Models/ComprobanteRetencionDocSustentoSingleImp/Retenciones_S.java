/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.octa.invocetransform.Models.ComprobanteRetencionDocSustentoSingleImp;

import com.google.gson.annotations.SerializedName;
import com.octa.invocetransform.Models.ComprobanteRetencionDocSustento.Retencion;

/**
 *
 * @author dskat
 */
public class Retenciones_S {

    @SerializedName("retencion")
    Retencion retencion;

    public Retencion getRetencion() {
        return retencion;
    }

    public void setRetencion(Retencion retencion) {
        this.retencion = retencion;
    }
}
