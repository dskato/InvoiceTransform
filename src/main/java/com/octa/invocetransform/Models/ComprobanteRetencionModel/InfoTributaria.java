package com.octa.invocetransform.Models.ComprobanteRetencionModel;

import com.google.gson.annotations.SerializedName;

   
public class InfoTributaria {

   @SerializedName("claveAcceso")
   String claveAcceso;

   @SerializedName("ruc")
   String ruc;

   @SerializedName("razonSocial")
   String razonSocial;

   @SerializedName("estab")
   String estab;

   @SerializedName("ptoEmi")
   String ptoEmi;

   @SerializedName("ambiente")
   int ambiente;

   @SerializedName("nombreComercial")
   String nombreComercial;

   @SerializedName("codDoc")
   String codDoc;

   @SerializedName("tipoEmision")
   int tipoEmision;

   @SerializedName("secuencial")
   String secuencial;

   @SerializedName("dirMatriz")
   String dirMatriz;


    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }
    public String getClaveAcceso() {
        return claveAcceso;
    }
    
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public String getRuc() {
        return ruc;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    
    public void setEstab(String estab) {
        this.estab = estab;
    }
    public String getEstab() {
        return estab;
    }
    
    public void setPtoEmi(String ptoEmi) {
        this.ptoEmi = ptoEmi;
    }
    public String getPtoEmi() {
        return ptoEmi;
    }
    
    public void setAmbiente(int ambiente) {
        this.ambiente = ambiente;
    }
    public int getAmbiente() {
        return ambiente;
    }
    
    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }
    public String getNombreComercial() {
        return nombreComercial;
    }
    
    public void setCodDoc(String codDoc) {
        this.codDoc = codDoc;
    }
    public String getCodDoc() {
        return codDoc;
    }
    
    public void setTipoEmision(int tipoEmision) {
        this.tipoEmision = tipoEmision;
    }
    public int getTipoEmision() {
        return tipoEmision;
    }
    
    public void setSecuencial(String secuencial) {
        this.secuencial = secuencial;
    }
    public String getSecuencial() {
        return secuencial;
    }
    
    public void setDirMatriz(String dirMatriz) {
        this.dirMatriz = dirMatriz;
    }
    public String getDirMatriz() {
        return dirMatriz;
    }
    
}