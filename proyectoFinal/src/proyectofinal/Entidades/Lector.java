/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal.Entidades;

/**
 *
 * @author Usuario
 */
public class Lector {
    private int nroSocio;
    private String nombre;
    private String domicilio;
    private String mail;
    private boolean estado;
    
    public Lector(){}
    
    public Lector(int numSocio, String nombreSocio, String domicilioSocio, String mailSocio, boolean estadoSocio){
    nroSocio = numSocio;
    nombre = nombreSocio;
    domicilio = domicilioSocio;
    mail = mailSocio;
    estado = estadoSocio;
    }
    
    public Lector(String nombreSocio, String domicilioSocio, String mailSocio, boolean estadoSocio){
    nombre = nombreSocio;
    domicilio = domicilioSocio;
    mail = mailSocio;
    estado = estadoSocio;
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    public String getComboBoxDisplay() {
    if (getNroSocio() == -1) {
        return "Seleccione el lector";
    } else {
        return "ID: "+getNroSocio() + " - " + getNombre();
    }
}
    

    
    @Override
    public String toString() {
        return "ID: " + nroSocio + ", Nombre: " + nombre + ", Domicilio: " + domicilio + ", Mail: " + mail + ", Estado: " + estado;
    }
    
    

   
}
