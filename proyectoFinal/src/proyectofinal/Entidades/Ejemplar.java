package proyectofinal.Entidades;

public class Ejemplar {
     int isbn;
    String titulo;
    int anio;
    String tipo;
    String editorial;
    boolean estado;    
    Autor autor;

    public Ejemplar() {
    }

    public Ejemplar(int isbn, String titulo, int anio, String tipo, String editorial, boolean estado, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.tipo = tipo;
        this.editorial = editorial;
        this.estado = estado;
        this.autor = autor;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    
}
