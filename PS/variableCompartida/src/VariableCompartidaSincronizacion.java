//ahora sí saldría igual siempre que lo ejecutemos

public class VariableCompartidaSincronizacion extends Thread {


    private static int contador; // no se instancia la clase pq es unica por eso se instancia con contador


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
    }

    public static void main(String[] args) {
        for (int i=0;i< 1000;i++){
            VariableCompartidaSincronizacion hebra = new VariableCompartidaSincronizacion();
            hebra.start();
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("El valor de contador: " + contador);
    }
}
