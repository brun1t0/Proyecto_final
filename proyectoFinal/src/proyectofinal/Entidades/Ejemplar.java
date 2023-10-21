package proyectofinal.Entidades;

public class Ejemplar {
  private Libro libro;  
  private int idCodigo;
  private boolean estado;
  private long isbn;
  private String nombreLibro;
  
  
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
    public boolean getEstado() {
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

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }
     

    public String getComboBoxDisplay() {
    if (getIdCodigo() == -1) {
        return "Seleccione un ejemplar";
    } else {
        return "N°: "+getIdCodigo() + " - " + getNombreLibro();
    }
}
    
    @Override
    public String toString() {
        return "Ejemplar{" + "libro=" + libro + ", idCodigo=" + idCodigo + ", estado=" + estado + ", isbn=" + isbn + '}';
    }
  
    
  
}
