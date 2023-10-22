public class Soldado {
    private String nombre;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelDeVida;
    private int vidaActual;
    private int velocidad = 0;
    private String actitud = "";
    private int fila;
    private int columna;

    public Soldado(String nombre, int nivelDeVida, int fila, int columna){
        this.nombre = nombre;
        this.nivelDeVida = nivelDeVida;
        this.fila = fila;
        this.columna = columna;
    }
    public Soldado() {
        nombre = "";
        nivelDeVida = 0;
        fila = 0;
        columna = 0;
    }
    public String getNombre() {
        return nombre;
    }
    public int getNivelDeVida() {
        return nivelDeVida;
    }
    public int getColumna() {
        return columna;
    }
    public int getFila() {
        return fila;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNivelDeVida(int nivelDeVida) {
        this.nivelDeVida = nivelDeVida;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public String toString() {
        return getNombre() + "\t|fila " + (getFila() + 1) + "\t|col " + (getColumna() + 1) + "\t|nvida " + getNivelDeVida();  
    }
    public void avanzar() {
        velocidad++;
    }
    public void defender() {
        velocidad = 0;
    }
    public void huir() {
        velocidad += 2;
    }
    public void retroceder() {
        if (velocidad > 0) {
            velocidad = 0;
            actitud = "pasiva";
        }else if (velocidad == 0){
            velocidad--;
        }
    }
    public void setAtacado() {
        nivelDeVida--;
    }
    public void morir() {
        nivelDeVida = 0;
    }
}
