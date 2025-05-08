package datos;

public interface Credencial extends Cloneable {
    Credencial clone() throws CloneNotSupportedException;
    void setNombre(String nombre);
    void setRol(String rol);
    void setId(String id);
    String getNombre();
    String getRol();
    String getId();
    String toString();
}