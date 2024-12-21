import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        var salir = false;
        while (!salir) {
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            }catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }

            System.out.println();
        }//fin while
    }//fin main

    private static void mostrarMenu(){
        System.out.println("***** Listado Personas *****");
        System.out.println("""
                    1.Agregar
                    2.Lista
                    3.Salir""");
        System.out.print("Proporcione la opcion: ");
    }//fin mostrarMenu

    private static  boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        //Revicion de opcion proporcionada
        switch (opcion){
            case 1 -> { //Agregar persona a la Lista
                System.out.print("Proporciona el Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Proporciona el telefono: ");
                var tel =consola.nextLine();
                System.out.print("Proporciona el Email: ");
                var email = consola.nextLine();

                //Crear el objeto persona
                var persona = new Persona(nombre, tel, email);
                //Agregar objeto a lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");

            }//Fin caso 1
            case 2 ->{//Listar las personas
                System.out.println("Listado de Personas: ");
                //Mejora usando lambda y metodo de referencia
                //personas.forEach((persona -> System.out.println(persona)));
                personas.forEach(System.out::println);
            }//fin caso 2
            case 3 ->{//Salir de ciclo
                System.out.println("Hasta pronto...");
                System.out.println("Creador Santiago Valdez");
                salir = true;
            }
            default -> System.out.println("Opcion erronea: " + opcion);
        }//fin switch
        return salir;
    }
}//fin clase