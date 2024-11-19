//ahora sí saldría igual siempre que lo ejecutemos

public class VariableCompartidaSincronizacionNombre extends Thread {
    private static int  contador = 0;

    public VariableCompartidaSincronizacionNombre(String nombre){

        super(nombre);
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            //contador++; // cdo no lo utilice con lo que es raro que salga un millon
            incrementarContador(); // cdo utilice synchronized
        }
    }


// si introduzco synchronized, hace que se esperen las demas y solo se haga la que se vaya ejecutando
    //una por una y salga 100000

    public  synchronized static void incrementarContador(){
        contador++;
        System.out.println(Thread.currentThread().getName() + "incremetó el contador a : " + contador);
    }

    public static void main(String[] args) {
        for (int i=0;i< 1000;i++){
            VariableCompartidaSincronizacionNombre hebraSincronizada = new VariableCompartidaSincronizacionNombre("Hebra1" + i);
            hebraSincronizada.start();
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("El valor de contador: " + contador);
    }

}
