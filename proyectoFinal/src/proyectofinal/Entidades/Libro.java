package proyectofinal.Entidades;

public class Libro {
    private int isbn;
    private String titulo;
    private int anio;
    private String tipo;
    private String editorial;
    private boolean estado;    
    private String autor;

    public Libro() {
    }

    public Libro(int isbn, String titulo, int anio, String tipo, String editorial, boolean estado, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.tipo = tipo;
        this.editorial = editorial;
        this.estado = estado;
        this.autor = autor;
    }
    
    public Libro(int isbn, String titulo, int anio, String tipo, String editorial, boolean estado) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.tipo = tipo;
        this.editorial = editorial;
        this.estado = estado;

    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", anio=" + anio + ", tipo=" + tipo + ", editorial=" + editorial + ", estado=" + estado + ", autor=" + autor + '}';
    }

   
}
