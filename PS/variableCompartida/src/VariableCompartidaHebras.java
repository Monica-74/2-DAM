public class VariableCompartidaHebras extends Thread {
    private static int  contador = 0;

    public VariableCompartidaHebras(String nombre){
        super(nombre);
    }



    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
        incrementarContador(); // cdo utilice synchronized
    }
        System.out.println("Hilo" + getName() + "con prioridad de: " + getPriority() + "terminado.");
}

    public  synchronized static void incrementarContador(){ //sincronizamos el contador
        contador++;
    }

    public static void main(String[] args) {
        for (int i=0;i< 10;i++){ //creamos 10 hilos con distintas prioridades
            VariableCompartidaHebras hebras = new VariableCompartidaHebras("Hebra" + i);
            if ( i == 0){
                hebras.setPriority(Thread.MIN_PRIORITY);
            } else if (i == 5) {
                hebras.setPriority(Thread.NORM_PRIORITY);
            } else if (i == 9) {
                hebras.setPriority(Thread.MAX_PRIORITY);
            }else {
                hebras.setPriority(i+1);
            }
            hebras.start(); //// Inicia el hilo, ejecutando el método run() en un nuevo hilo
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("El valor de contador: " + contador);
    }

}


