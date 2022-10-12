package com.octa.invocetransform.Models.ComprobanteRetencionModel;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

   
public class Impuesto {

   @SerializedName("codigoRetencion")
   String codigoRetencion;

   @SerializedName("codigo")
   int codigo;

   @SerializedName("valorRetenido")
   double valorRetenido;

   @SerializedName("numDocSustento")
   String numDocSustento;

   @SerializedName("codDocSustento")
   int codDocSustento;

   @SerializedName("baseImponible")
   double baseImponible;

   @SerializedName("porcentajeRetener")
   double porcentajeRetener;

   @SerializedName("fechaEmisionDocSustento")
   String fechaEmisionDocSustento;


    public void setCodigoRetencion(String codigoRetencion) {
        this.codigoRetencion = codigoRetencion;
    }
    public String getCodigoRetencion() {
        return codigoRetencion;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }
    
    public void setValorRetenido(double valorRetenido) {
        this.valorRetenido = valorRetenido;
    }
    public double getValorRetenido() {
        return valorRetenido;
    }
    
    public void setNumDocSustento(String numDocSustento) {
        this.numDocSustento = numDocSustento;
    }
    public String getNumDocSustento() {
        return numDocSustento;
    }
    
    public void setCodDocSustento(int codDocSustento) {
        this.codDocSustento = codDocSustento;
    }
    public int getCodDocSustento() {
        return codDocSustento;
    }
    
    public void setBaseImponible(double baseImponible) {
        this.baseImponible = baseImponible;
    }
    public double getBaseImponible() {
        return baseImponible;
    }
    
    public void setPorcentajeRetener(double porcentajeRetener) {
        this.porcentajeRetener = porcentajeRetener;
    }
    public double getPorcentajeRetener() {
        return porcentajeRetener;
    }
    
    public void setFechaEmisionDocSustento(String fechaEmisionDocSustento) {
        this.fechaEmisionDocSustento = fechaEmisionDocSustento;
    }
    public String getFechaEmisionDocSustento() {
        return fechaEmisionDocSustento;
    }
    
}