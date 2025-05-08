package negocio;


public class ConfiguracionEvento {
   
    private static ConfiguracionEvento instancia;
    
   
    private String nombreEvento;
    private String fechaEvento;
    private String lugarEvento;
    private int duracionHoras;
    private String idioma;
    
    
    private ConfiguracionEvento() {
        nombreEvento = "Clase Patrones de diseno";
        fechaEvento = "10/05/2025";
        lugarEvento = "Sala de clases";
        duracionHoras = 2;
        idioma = "Español";
    }
    
    
    public static ConfiguracionEvento getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionEvento();
        }
        return instancia;
    }
    
    // Getters y setters
    public String getNombreEvento() {
        return nombreEvento;
    }
    
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
    
    public String getFechaEvento() {
        return fechaEvento;
    }
    
    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }
    
    public String getLugarEvento() {
        return lugarEvento;
    }
    
    public void setLugarEvento(String lugarEvento) {
        this.lugarEvento = lugarEvento;
    }
    
    public int getDuracionHoras() {
        return duracionHoras;
    }
    
    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }
    
    public String getIdioma() {
        return idioma;
    }
    
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    @Override
    public String toString() {
        return "Configuracion del Evento:\n" +
               "Nombre: " + nombreEvento + "\n" +
               "Fecha: " + fechaEvento + "\n" +
               "Lugar: " + lugarEvento + "\n" +
               "Duracion: " + duracionHoras + " horas\n" ;
               
    }
}