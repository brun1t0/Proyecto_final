///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package proyectofinal.Entidades;
//
///**
// *
// * @author Usuario
// */
//public class Ejemplar {
//  private Libro libro;  
//  private int codigo;
//  private boolean estado;
//  
//  public Ejemplar(){}  
//
//    public Ejemplar(Libro libro, int codigo, boolean estado) {
//        this.libro = libro;
//        this.codigo = codigo;
//        this.estado = estado;
//    }
//
//    public Ejemplar(Libro libro, boolean estado) {
//        this.libro = libro;
//        this.estado = estado;
//    }
//
//    public Libro getLibro() {
//        return libro;
//    }
//
//    public void setLibro(Libro libro) {
//        this.libro = libro;
//    }
//
//    public int getCodigo() {
//        return codigo;
//    }
//
//    public void setCodigo(int codigo) {
//        this.codigo = codigo;
//    }
//
//    public boolean isEstado() {
//        return estado;
//    }
//
//    public void setEstado(boolean estado) {
//        this.estado = estado;
//    }
//  
//  
//}

package proyectofinal.Entidades;

public class Ejemplar {
  private Libro libro;  
  private int idCodigo;
  private boolean estado;
  private long isbn;
  
  
  public Ejemplar(){}  

    public Ejemplar(Libro libro, int idCodigo, boolean estado, long isbn) {
        this.libro = libro;
        this.idCodigo = idCodigo;
        this.estado = estado;
        this.isbn = isbn;
       
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
     

    
    public void setNombreLibro(String nombreLibro) {
        this.libro.setTitulo(nombreLibro);
    }
    
    @Override
    public String toString() {
        return "Ejemplar{" + "libro=" + libro + ", idCodigo=" + idCodigo + ", estado=" + estado + ", isbn=" + isbn + '}';
    }
  
    
  
}
