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
public class DocsSustento {
    
   @SerializedName("docSustento")
   DocSustento docSustento;


    public void setDocSustento(DocSustento docSustento) {
        this.docSustento = docSustento;
    }
    public DocSustento getDocSustento() {
        return docSustento;
    }
    
}
