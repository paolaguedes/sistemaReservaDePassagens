
package sistemareservadepassagens;

public class Hora {
    private int hora;
    private int minuto;
    
    public Hora(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }
    
    public Hora() {}

    public int getHora() {
        return this.hora;
    }
    
    public void setHora(int hora) {
        this.hora = hora;
    }
    
    public int getMinuto() {
        return this.minuto;
    }
    
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
}
