package com.octa.invocetransform.Models.ComprobanteRetencionModel;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

   
public class InfoCompRetencion {

   @SerializedName("razonSocialSujetoRetenido")
   String razonSocialSujetoRetenido;

   @SerializedName("tipoIdentificacionSujetoRetenido")
   String tipoIdentificacionSujetoRetenido;

   @SerializedName("contribuyenteEspecial")
   int contribuyenteEspecial;

   @SerializedName("obligadoContabilidad")
   String obligadoContabilidad;

   @SerializedName("fechaEmision")
   String fechaEmision;

   @SerializedName("dirEstablecimiento")
   String dirEstablecimiento;

   @SerializedName("periodoFiscal")
   String periodoFiscal;

   @SerializedName("identificacionSujetoRetenido")
   String identificacionSujetoRetenido;


    public void setRazonSocialSujetoRetenido(String razonSocialSujetoRetenido) {
        this.razonSocialSujetoRetenido = razonSocialSujetoRetenido;
    }
    public String getRazonSocialSujetoRetenido() {
        return razonSocialSujetoRetenido;
    }
    
    public void setTipoIdentificacionSujetoRetenido(String tipoIdentificacionSujetoRetenido) {
        this.tipoIdentificacionSujetoRetenido = tipoIdentificacionSujetoRetenido;
    }
    public String getTipoIdentificacionSujetoRetenido() {
        return tipoIdentificacionSujetoRetenido;
    }
    
    public void setContribuyenteEspecial(int contribuyenteEspecial) {
        this.contribuyenteEspecial = contribuyenteEspecial;
    }
    public int getContribuyenteEspecial() {
        return contribuyenteEspecial;
    }
    
    public void setObligadoContabilidad(String obligadoContabilidad) {
        this.obligadoContabilidad = obligadoContabilidad;
    }
    public String getObligadoContabilidad() {
        return obligadoContabilidad;
    }
    
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public String getFechaEmision() {
        return fechaEmision;
    }
    
    public void setDirEstablecimiento(String dirEstablecimiento) {
        this.dirEstablecimiento = dirEstablecimiento;
    }
    public String getDirEstablecimiento() {
        return dirEstablecimiento;
    }
    
    public void setPeriodoFiscal(String periodoFiscal) {
        this.periodoFiscal = periodoFiscal;
    }
    public String getPeriodoFiscal() {
        return periodoFiscal;
    }
    
    public void setIdentificacionSujetoRetenido(String identificacionSujetoRetenido) {
        this.identificacionSujetoRetenido = identificacionSujetoRetenido;
    }
    public String getIdentificacionSujetoRetenido() {
        return identificacionSujetoRetenido;
    }
    
}