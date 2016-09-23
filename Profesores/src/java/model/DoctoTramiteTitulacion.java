/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author adri_
 */
public class DoctoTramiteTitulacion {
    private int idDocto;
    private String notas;
    private int tramiteTitulacion;
    private String activo;
    private String descripcion;

    public DoctoTramiteTitulacion(int idDocto, String notas, int tramiteTitulacion, String activo, String descripcion) {
        this.idDocto = idDocto;
        this.notas = notas;
        this.tramiteTitulacion = tramiteTitulacion;
        this.activo = activo;
        this.descripcion = descripcion;
    }

    public DoctoTramiteTitulacion() {
        this(0,"",0,"","");
    }

    public int getIdDocto() {
        return idDocto;
    }

    public void setIdDocto(int idDocto) {
        this.idDocto = idDocto;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public int getTramiteTitulacion() {
        return tramiteTitulacion;
    }

    public void setTramiteTitulacion(int tramiteTitulacion) {
        this.tramiteTitulacion = tramiteTitulacion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "DoctoTramiteTitulacion{" + "idDocto=" + idDocto + ", notas=" + notas + ", tramiteTitulacion=" + tramiteTitulacion + ", activo=" + activo + ", descripcion=" + descripcion + '}';
    }
}
