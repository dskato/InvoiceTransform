package com.octa.invocetransform.Models.ComprobanteRetencionModelSingleImp;
import com.octa.invocetransform.Models.ComprobanteRetencionModel.*;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Impuestos_S {

   @SerializedName("impuesto")
   Impuesto impuesto;

  
   
   
    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }
   

    
}