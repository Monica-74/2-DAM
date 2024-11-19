//no siempre salen igual ya que muchas veces no se incrementan porque se pisan
//unas a otras por lo que si lo ejecutamos varias veces nos da distintas opciones
public class VariableCompartida extends Thread {


    private static int contador; // no se instancia la clase pq es unica por eso se instancia con contador

    //el método run() está sobrescribiendo un método de una superclase o interfaz.
    // En este caso, está sobrescribiendo el método run() de la interfaz Runnable.
    //public void run(): Este es el método que contiene el código que se ejecutará cuando
    // el hilo asociado a esta tarea se inicie.


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            contador++; // cdo no lo utilice con lo que es raro que salga un millon

        }
    }


// si introduzco synchronized, hace que se esperen las demas y solo se haga la que se vaya ejecutando
    //una por una y salga 100000

    public  synchronized static void incrementarContador(){
        contador++;
    }

    public static void main(String[] args) {
            for (int i=0;i< 1000;i++){
                VariableCompartida hebra = new VariableCompartida();
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
