package datos;

import java.util.ArrayList;
import java.util.List;


public class CredencialEvento implements Credencial {
    private String nombre;
    private String rol;
    private String id;
    private String evento;
    private String fecha;
    private List<String> permisos;
    
    public CredencialEvento(String evento, String fecha) {
        this.evento = evento;
        this.fecha = fecha;
        this.nombre = "NOMBRE_ASISTENTE";
        this.rol = "PARTICIPANTE";
        this.id = "ID000";
        this.permisos = new ArrayList<>();
        this.permisos.add("Acceso General");
    }
    
    @Override
    public Credencial clone() throws CloneNotSupportedException {
       
        CredencialEvento clon = (CredencialEvento) super.clone();
        
        clon.permisos = new ArrayList<>(this.permisos);
        
        return clon;
    }
    
    public void agregarPermiso(String permiso) {
        this.permisos.add(permiso);
    }
    
    public List<String> getPermisos() {
        return permisos;
    }
    
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String getRol() {
        return rol;
    }
    
    @Override
    public String getId() {
        return id;
    }
    
    @Override
    public String toString() {
        StringBuilder permisosStr = new StringBuilder();
        for (String permiso : permisos) {
            permisosStr.append(permiso).append(", ");
        }
        String permisosTexto = permisosStr.length() > 0 ? 
                              permisosStr.substring(0, permisosStr.length() - 2) : "";
        
        return "-------------------------------------- \n" +
               "-           CREDENCIAL OFICIAL        -\n" +
               "-                                     -\n" +
               "-  Evento: " + evento + "             -\n" +
               "-  Fecha: " + fecha + "               -\n" +
               "-                                     -\n" +
               "-  ID: " + id + "                     -\n" +
               "-  Nombre: " + nombre + "             -\n" +
               "-  Rol: " + rol + "                   -\n" +
               "-  Permisos: " + permisosTexto + "    -\n" +
               "-                                     -\n" +
               "-----------------------------------------";
    }
}