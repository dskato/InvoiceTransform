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
public class Retenciones {

    @SerializedName("retencion")
    List<Retencion> retencion;

    public void setRetencion(List<Retencion> retencion) {
        this.retencion = retencion;
    }

    public List<Retencion> getRetencion() {
        return retencion;
    }
}
