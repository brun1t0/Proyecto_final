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

    public Ejemplar(Libro libro, int idCodigo, boolean estado) {
        this.libro = libro;
        this.idCodigo = idCodigo;
        this.estado = estado;
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
