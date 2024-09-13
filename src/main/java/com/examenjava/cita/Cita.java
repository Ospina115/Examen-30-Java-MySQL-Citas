public class Cita {
    private int id;
    private DateTime fecha_hora;
    private String estado;
    
    public Cita(DateTime fecha_hora, String estado) {
        this.fecha_hora = fecha_hora;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(DateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
