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
    private Object domicilio;
    private String mail;
    private boolean estado;
    
    public Lector(){}
    
    public Lector(int numSocio, String nombreSocio, Object domicilioSocio, String mailSocio, boolean estadoSocio){
    nroSocio = numSocio;
    nombre = nombreSocio;
    domicilio = domicilioSocio;
    mail = mailSocio;
    estado = estadoSocio;
    }
    
    public Lector(String nombreSocio, Object domicilioSocio, String mailSocio, boolean estadoSocio){
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

    public Object getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Object domicilio) {
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

    @Override
    public String toString() {
        return "Socio: " + nroSocio + ", nombre: " + nombre + ", domicilio: " + domicilio + ", mail: " + mail + ", estado: " + estado;
    }
    
}
