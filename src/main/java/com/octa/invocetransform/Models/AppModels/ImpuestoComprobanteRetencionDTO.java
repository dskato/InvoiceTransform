/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.octa.invocetransform.Models.AppModels;

/**
 *
 * @author dskat
 */
public class ImpuestoComprobanteRetencionDTO {
    
   
    private int cellPorcentajeRetencion;
    private int cellBaseImponible;
    private int cellValorRetenido;
    private double valorRetenido;

    public double getValorRetenido() {
        return valorRetenido;
    }

    public void setValorRetenido(double valorRetenido) {
        this.valorRetenido = valorRetenido;
    }
    
    

    public int getCellPorcentajeRetencion() {
        return cellPorcentajeRetencion;
    }

    public void setCellPorcentajeRetencion(int cellPorcentajeRetencion) {
        this.cellPorcentajeRetencion = cellPorcentajeRetencion;
    }

    public int getCellBaseImponible() {
        return cellBaseImponible;
    }

    public void setCellBaseImponible(int cellBaseImponible) {
        this.cellBaseImponible = cellBaseImponible;
    }

    public int getCellValorRetenido() {
        return cellValorRetenido;
    }

    public void setCellValorRetenido(int cellValorRetenido) {
        this.cellValorRetenido = cellValorRetenido;
    }

    
    
    
    
    
    
}
