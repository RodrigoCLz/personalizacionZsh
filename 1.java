public class laboratorio5 {

    public static void main(String[] args) {
        Soldado[][] tablero = new Soldado[10][10];
        Soldado[] ejercito1 = generarSoldados(tablero);
        Soldado[] ejercito2 = generarSoldados(tablero);

        System.out.println("Ejercito 1");
        mostrarEjercito(ejercito1);
        System.out.println("------------------------------");
        System.out.println("Ejercito 2");
        mostrarEjercito(ejercito2);
        mostrarTablero(tablero, ejercito1, ejercito2);

        System.out.println("Ejercito 1");
        mostrarDatos(ejercito1);
        System.out.println("Ejercito 2");
        mostrarDatos(ejercito2);

        while (true) {
            System.out.println("Indique las coordenadas de ");
        }
    }
    public static void mostrarDatos(Soldado[] ejercito) {
        System.out.println("Soldado con mayor vida: " + mayorVidaSoldado(ejercito).getNombre());
        System.out.println("Promedio de nivel de vida: " + promedioDeVida(ejercito));
        System.out.println("El nivel de vida del ejercito es: " + nivelDeVidaEjercito(ejercito));    
    }
    public static void ordenamientoBurbujaVida(Soldado[] ejercito) {
        Soldado aux;
        for (int i = 0; i < ejercito.length -1; i++) {
            for (int j = 0; j < ejercito.length -i-1; j++) {
                if (ejercito[j].getNivelDeVida() > ejercito[j+1].getNivelDeVida()) {
                    aux = ejercito[j];
                    ejercito[j] = ejercito[j+1];
                    ejercito[j+1] = aux;
                }
            }
        }
    }
    public static void ordenamientoSeleccionVida(Soldado[] ejercito) {
        for (int i = 0; i < ejercito.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < ejercito.length; j++) {
                if (ejercito[j].getNivelDeVida() < ejercito[indiceMinimo].getNivelDeVida()) {
                    indiceMinimo = j;
                }
            }
            Soldado temp = ejercito[i];
            ejercito[i] = ejercito[indiceMinimo];
            ejercito[indiceMinimo] = temp;
        }
    }
    public static int nivelDeVidaEjercito(Soldado[] ejercito) {
        int var = 0;
        for (int i = 0; i < ejercito.length; i++) {
            if(ejercito[i] != null){
                var += ejercito[i].getNivelDeVida();
            }
        }
        return var;
    }
    public static double promedioDeVida(Soldado[] ejercito) {   
        int var = 0;
        double sum = 0;
        for (int i = 0; i < ejercito.length; i++) {
            if(ejercito[i] != null){
                var++;
                sum += ejercito[i].getNivelDeVida();
            }
        }   
        double promedio = sum / var;
        return promedio;
    }
    public static Soldado mayorVidaSoldado(Soldado[] ejercito) {
        Soldado aux = new Soldado();
        for (int i = 0; i < ejercito.length; i++) {
            if (ejercito[i] != null) {
                if (ejercito[i].getNivelDeVida() > aux.getNivelDeVida()) {
                    aux = ejercito[i];
                }
            }
        
        }
        return aux;
    }
    public static Soldado[] generarSoldados(Soldado[][] tablero) {
        int nroSoldados = (int)(Math.random()*10 + 1);
        Soldado[] ejercito = new Soldado[nroSoldados];
        for (int i = 0; i < nroSoldados; i++) {
            String nombre = "Soldado" + (i + 1); 
            int fila = (int)(Math.random()*10);
            int columna = (int)(Math.random()*10);
            int nivelDeVida = (int)(Math.random()*5 + 1);
            Soldado aux = new Soldado(nombre, nivelDeVida, fila, columna);
            if (!coincidencias(tablero, aux)) {
                ejercito[i] = aux;
                tablero[fila][columna] = aux;
            }else {
                i--;
            }
        }
        return ejercito;
    }
    public static boolean coincidencias(Soldado[][] tablero, Soldado soldado) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) {
                    if (tablero[i][j].getFila() == soldado.getFila() && 
                        tablero[i][j].getColumna() == soldado.getColumna()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void mostrarTablero(Soldado[][] tablero, Soldado[] ejercito1, Soldado[] ejercito2) {
        System.out.print("\t");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("   " + (char)(65 + i) + "  ");
        }
        System.out.println("\n\t.___________________________________________________________.");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("   " + (i + 1) + "\t|");
            for (int j = 0; j < tablero[i].length; j++) {
                if(tablero[i][j] != null){
                    if (perteneceA(ejercito1, tablero[i][j])) {
                        System.out.print("_s1__|");
                    } else {
                        System.out.print("_s2__|");
                    }
                }else {
                    System.out.print("_____|");
                }
            }
            System.out.println();
        }
    }
    public static boolean perteneceA(Soldado[] ejercito, Soldado soldado) {
        for (int i = 0; i < ejercito.length; i++) {
            if (soldado.getColumna() == ejercito[i].getColumna() &&
                soldado.getFila() == ejercito[i].getFila()) {
                return true;
            }
        }
        return false;
    }
    public static void mostrarEjercito(Soldado[] ejercito) {
        for (int i = 0; i < ejercito.length; i++) {
            System.out.println(ejercito[i]);
        }
    }
}

