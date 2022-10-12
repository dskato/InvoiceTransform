/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.octa.invocetransform.Models.ComprobanteRetencionDocSustento;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author dskat
 */
public class Pago {

    @SerializedName("formaPago")
    int formaPago;

    @SerializedName("total")
    double total;

    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
    }

    public int getFormaPago() {
        return formaPago;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }
}
