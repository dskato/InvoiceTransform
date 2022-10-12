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
public class Pagos {

    @SerializedName("pago")
    List<Pago> pago;

    public void setPago(List<Pago> pago) {
        this.pago = pago;
    }

    public List<Pago> getPago() {
        return pago;
    }
}
