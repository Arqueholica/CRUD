
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
Tienes un carrito de la compra donde puedas añadir, leer, modificar, borrar y BUSCAR elementos.
Crear menú con opciones. Si opción = ‘salir’ u opción 0, se acaba el programa.
Se propone que sean objetos Comida: nombre, origen, peso, precio.
Se aconseja en este caso realizar un switch dentro de un while. El switch sobre las opciones del menú del tipo:
1- Añadir comida (implica añadir por teclado todas las características del objeto)
2- Mostrar lista completa
3- Mostrar un producto específico por nombre (implica opción buscar)
4- Modificar por nombre. ¿Cuál quieres modificar? (implica opción buscar)
5- Borrar elemento por nombre (implica opción buscar)
0- Salir
Para buscar, se aconseja el méthod equalsIgnoreCase().

 */
        Scanner sc = new Scanner(System.in);
        sc.useLocale(new Locale("es", "ES"));

        ArrayList<Comida> list = new ArrayList<>();
        list.add(new Comida("Pera", "Albacete", 0.8, 4.8));
        list.add(new Comida("Manzana", "Georgia", 0.5, 1.2));
        list.add(new Comida("Plátano", "Canarias", 1.2, 2.5));
        list.add(new Comida("Cerezas", "Tombuctú", 0.85, 5));
        list.add(new Comida("Mango", "República Dominicana", 0.82, 10.8));

       ComidaHelper.allFood(list);

int answer;

        do{
            System.out.println('\n' + "--- MENÚ ---" + '\n');
            System.out.println("1 - Introducir alimento");
            System.out.println("2 - Mostrar carrito");
            System.out.println("3 - Buscar alimento POR NOMBRE");
            System.out.println("4 - Modificar alimento POR NOMBRE");
            System.out.println("5 - Eliminar alimento");
            System.out.println("0 - Salir y pagar");
            System.out.println();
            System.out.println("¿Qué desea hacer? Seleccione una opción");

            answer = sc.nextInt();
            sc.nextLine();

            switch (answer){
                case 0:
                    System.out.println("¡Gracias por su visita! ¡Vuelva pronto!");
                    break;
                case 1:
                    System.out.println("Introduce los datos del nuevo producto:");
                    System.out.println("Producto: ");
                    String name = sc.nextLine();
                    System.out.println("Origen: ");
                    String origin = sc.nextLine();
                    System.out.println("Peso por unidad: ");
                    double weight = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Precio por kilo: ");
                    double price = sc.nextDouble();
                    sc.nextLine();


                    list.add(new Comida(name,origin,weight,price));

                    System.out.println("¡Nuevo producto añadido con éxito!");
                    break;
                case 2:
                    System.out.println("Carrito completo");
                    ComidaHelper.allFood(list);
                    break;
                case 3:
                    System.out.println("Introduce el nombre del producto que buscas: ");
                    String prod = sc.nextLine();
                    boolean found = false;
                    for(Comida food: list){
                       if(food.getName().equalsIgnoreCase(prod)){
                           System.out.println(food);
                           found = true;
                       }
                    }
                    if(!found){
                        System.out.println("El producto que buscas no existe");
                    }
                    break;
                case 4:
                    System.out.println("Introduce el nombre del producto que quieres modificar: ");
                    String modificar = sc.nextLine();
                    found = false;
                    for (Comida food: list){
                        if(food.getName().equalsIgnoreCase(modificar)){
                            System.out.println( "Introduce el nuevo nombre: ");
                            String newName = sc.nextLine();
                            String rename = food.setName(newName);
                            System.out.println("El nuevo nombre es: " + rename);
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("No se encuentra el producto a modificar");
                    }
                    break;
                case 5:
                    System.out.println("Indica qué producto quieres eliminar: ");
                    String eliminar = sc.nextLine();
                    found = false;
                    int id = -1;

                    for (int i = 0; i < list.size() ; i++) {
                        Comida food = list.get(i);
                        if(food.getName().equalsIgnoreCase(eliminar)){
                            id = i;
                            found = true;
                            break;
                        }

                    }
                        if(found){
                            list.remove(id);
                            System.out.println("El producto se ha eliminado correctamente");
                        }
                        if(!found){
                    System.out.println("No se encuentra el producto a eliminar");
                    }
                        break;
                 }




        }while(answer != 0);




        sc.close();
    }
}