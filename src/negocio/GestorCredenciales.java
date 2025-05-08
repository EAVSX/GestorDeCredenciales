package negocio;

import datos.Credencial;
import datos.CredencialEvento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GestorCredenciales {
    private static int contadorId = 1;
    private Credencial plantilla;
    private List<Credencial> credencialesGeneradas;
    private Map<String, List<String>> permisosRol;
    
    public GestorCredenciales(Credencial plantilla) {
        this.plantilla = plantilla;
        this.credencialesGeneradas = new ArrayList<>();
        
        
        this.permisosRol = new HashMap<>();
        
        List<String> permisosParticipante = new ArrayList<>();
        permisosParticipante.add("Acceso General");
        
        List<String> permisosExpositor = new ArrayList<>();
        permisosExpositor.add("Acceso General");
        permisosExpositor.add("Acceso a Sala VIP");
        permisosExpositor.add("Uso de Equipo Multimedia");
        
        List<String> permisosOrganizador = new ArrayList<>();
        permisosOrganizador.add("Acceso General");
        permisosOrganizador.add("Acceso a Sala VIP");
        permisosOrganizador.add("Acceso a Areas Restringidas");
        
        List<String> permisosVIP = new ArrayList<>();
        permisosVIP.add("Acceso General");
        permisosVIP.add("Acceso a Sala VIP");
        permisosVIP.add("Coctel Exclusivo");
        
        this.permisosRol.put("PARTICIPANTE", permisosParticipante);
        this.permisosRol.put("EXPOSITOR", permisosExpositor);
        this.permisosRol.put("ORGANIZADOR", permisosOrganizador);
        this.permisosRol.put("VIP", permisosVIP);
    }
    
  
    public Credencial generarCredencial(String nombre, String rol) {
        try {
          
            Credencial nuevaCredencial = plantilla.clone();
            
            nuevaCredencial.setNombre(nombre);
            nuevaCredencial.setRol(rol);
            nuevaCredencial.setId(String.format("ID%03d", contadorId++));
            
           
            if (nuevaCredencial instanceof CredencialEvento) {
                CredencialEvento credEventoDetallada = (CredencialEvento) nuevaCredencial;
                credEventoDetallada.getPermisos().clear();
                
                String rolUpperCase = rol.toUpperCase();
                if (permisosRol.containsKey(rolUpperCase)) {
                    for (String permiso : permisosRol.get(rolUpperCase)) {
                        credEventoDetallada.agregarPermiso(permiso);
                    }
                } else {
                    credEventoDetallada.agregarPermiso("Acceso General");
                }
            }
            
           
            credencialesGeneradas.add(nuevaCredencial);
            
            return nuevaCredencial;
        } catch (CloneNotSupportedException e) {
            System.out.println("Error al clonar la credencial: " + e.getMessage());
            return null;
        }
    }
    
    public void mostrarCredencialesGeneradas() {
        if (credencialesGeneradas.isEmpty()) {
            System.out.println("\n No hay credenciales generadas aún.");
            return;
        }
        
        System.out.println("\n=== CREDENCIALES GENERADAS ===");
        for (Credencial credencial : credencialesGeneradas) {
            System.out.println(credencial);
            System.out.println();
        }
    }
    
    public int getCantidadCredenciales() {
        return credencialesGeneradas.size();
    }
}