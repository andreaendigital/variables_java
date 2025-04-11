/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana05;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andrea
 */
public class Semana05 {

    /**
     * @param args the command line arguments
     */
    
    //Variables estáticas, de clase.
    static String nombreTeatro = "Teatro Moro";
    static int capacidadSala = 50;
    static int entradasDisponibles = capacidadSala; //se inicializa en su capacidad total
    //entradas disponibles = capaciadSala - entradasVendidas
    static int entradasVendidas = 0;
    static int id =1; // al convertirla en variable estática entre clases, se mantiene entre compras
    
    
    //lista de entradas vendidas
    static ArrayList<Entrada> listaEntradas = new ArrayList<>(); //importamos
    
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        
            
        do{ //ciclo principal que genera iteración del menú
             mostrarMenu();  
            
            if(scanner.hasNextInt()){ // validación al ingresar String y no int
                 opcion = scanner.nextInt();
           
            switch(opcion){
                case 1:
                    venderEntrada(scanner);
                    break;
                case 2:
                    //Mostrar Promociones, llama a método
                    mostrarPromociones();
                    break;
                case 3:
                    
                    mostrarMenuBusqueda();
                    
                    int opcionBuqueda = leerOpcionBusqueda(scanner);
                    
                    switch(opcionBuqueda){
                        case 1:
                            //busqueda por id
                            buscarPorId(listaEntradas, scanner);
                            break;
                        case 2:
                            //busqueda por tipo Entrada
                            buscarPorTipoEntrada(listaEntradas, scanner);
                            break;
                        case 3:
                            //busqueda por ubicacion
                            buscarPorUbicacion(listaEntradas, scanner);
                            break;
                        case 4:
                            System.out.println("Volviendo al Menu General");
                            break;
                        default:
                            System.out.println("Opcion no valida intente nuevamente");

                    }
                    
                    
                    
                    break;
                case 4:
                    System.out.println("\n*************************");
                    System.out.println("*******ELIMINACION DE ENTRADA*******");
                    
                    while(true){
                        System.out.println("Ingrese ID para eliminar:");
                        if(scanner.hasNextInt()){
                            int idEliminar = scanner.nextInt();
                            eliminarEntradaPorId(listaEntradas, idEliminar);
                            break; //sale del ciclo si se ingresa un numero valido
                        }else{
                            System.out.println("Opcion no valida, no es un numero. ");
                            scanner.next(); //Limpia el buffer del scanner
                        }
                    }
                    break;
                case 5:
                    listarEntradas(listaEntradas);
                    break;
                case 6:
                    System.out.println("Gracias por utilizar el sistema. ");
                    break;
                default:
                    System.out.println("Opcion no valida intente nuevamente");
            }
        
                 
                 
                 
            } else { //si lo ingresado NO es un número
                System.out.println("Opcion no valida, no es un numero, ingrese nuevamente su opcion");
                scanner.next(); //consumimos entrada no válida: descartamos la entrada incorrecta y evitamos un bucle infinito
            }
        } while( 6 != opcion);
        
 
        
    }
    
    //Método que muestra el menú: 
    static void mostrarMenu(){
        System.out.println("\n****************Bienvenido al " + nombreTeatro + "*****************");
        System.out.println("1. Venta de Entradas");
        System.out.println("2. Ver Promociones");
        System.out.println("3. Buscar Entradas");
        System.out.println("4. Eliminar Entradas");  
        System.out.println("5. Mostrar Lista de Entradas");
        System.out.println("6. Salir");
        System.out.println("Ingrese numero de la opcion que desea ejecutar:");
    }
    
    
    //Método que muestra Promociones:
    static void mostrarPromociones(){
        System.out.println("\n******PROMOCIONES DISPONIBLES********");
        System.out.println(" -> Estudiantes: 10% de descuento");
        System.out.println(" -> Tercera Edad: 15% de descuento");
        System.out.println(" -> Grupal: Si compras 4 entradas la 4ta al 50%");
        System.out.println(" *** Descuentos NO ACUMULATIVOS ***");
        System.out.println(" ***********************************");
    }
    
    // Método para mostrar el menú de búsqueda
    public static void mostrarMenuBusqueda() {
        System.out.println("\nElija el tipo de busqueda:");
        System.out.println("1. Buscar por ID");
        System.out.println("2. Buscar por Tipo de Entrada");
        System.out.println("3. Buscar por Ubicacion");
        System.out.println("4. Salir");
    }

    //Leer la opción y manejar error
    public static int leerOpcionBusqueda(Scanner scanner){
        int opcionBusqueda =-1;
        while(true){
            if(scanner.hasNextInt()){
                opcionBusqueda = scanner.nextInt();
                break;
            }else{
                System.out.println("Por favor ingresa un numero valido");
                scanner.next(); //Evita bucle y limpia la entrada
            }
        }
        return opcionBusqueda;
    }
    
    
    
//Venta de entradas:
public static void venderEntrada(Scanner scanner){

           
        //declaración de variables
        String ubicacion;
        String nombreCliente;
        int numeroEntradas = 0;
        int edad;
        int precioBase = 0;
        int totalPagar;
        double descuento;
        String tipoEntrada;
        int contadorEntradas = 1; //para llevar el control del ID
        int precio_descuento_grupal;
        int precio_descuento_edad;
        int valorUnitario;
        
        if(entradasDisponibles <=0){

            System.out.println("\n*****************************************");
            System.out.println("No hay entradas disponibles para la venta");
            System.out.println("*****************************************");
            try {
                Thread.sleep(3000); // Pausa de 5 segundos (5000 milisegundos)
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }  
            return;
        }    
        
        //Se solicitan los datos necesarios para la compra de entradas***********
        
        //UBICACION
        //manejo de error, validación ingreso usuario con ciclo do-while
        do{
        System.out.println("Ingrese la ubicacion que desea comprar: (VIP, Platea, General)");
        ubicacion = scanner.next().trim().toLowerCase(); 
        //Lee lo que el usuario ingresa, elimina espacios adiiconales antes y después, convierte todo en minúscula
        }while(!ubicacion.equals("vip") && !ubicacion.equals("platea") && !ubicacion.equals("general"));
        
        //NUMERO DE ENTRADAS
        //manejo de error, validación ingreso usuario con ciclo while
        while(true){
            System.out.println("\nIngrese la cantidad de entradas que desea comprar:");
            if(scanner.hasNextInt()){
                numeroEntradas = scanner.nextInt();
                //break; //sale del ciclo si se ingresa un numero valido
            }else{
                System.out.println("Opcion no valida, no es un numero. ");
                scanner.next(); //Limpia el buffer del scanner
            }
            
            System.out.println("\nUsted desea comprar " + numeroEntradas + " entradas");
            //Validar cantidad de entradas disponibles
             if (entradasDisponibles < numeroEntradas){
                System.out.println("Solo hay " + entradasDisponibles + " entradas disponibles.");
                
            }else if(numeroEntradas==0){
                 System.out.println("Gracias. Lo devolveremos al menu.");
                 return;
            }else{
                System.out.println("\n***********************\nQuedan entradas disponibles para la venta.\n***********************\n");
                   break;
            }
            
       }

 
        
        //EDAD
        //manejo de error, validación ingreso usuario con ciclo while
        while(true){
            System.out.println("Ingrese su edad para validar descuentos:");
            if(scanner.hasNextInt()){
                edad = scanner.nextInt(); // 
                break; //sale del ciclo si se ingresa un numero valido
            }else{
                System.out.println("Opcion no valida, no es un numero. ");
                scanner.next(); //Limpia el buffer del scanner
            }
        }   
        
        //NOMBRE DEL CLIENTE
        System.out.println("\nFinalmente ingrese su nombre:");
        nombreCliente = scanner.next().trim().toLowerCase(); 
        
                     
        // APLICO VALORES Y DESCUENTOS PARA CALCULOS *******************
        
        //Uso switch para asignar el precio Base de cada entrada según la ubicación elegida.
            switch (ubicacion){
                case "vip":
                    precioBase = 25000;
                    break;
                case "platea":
                    precioBase = 18000;
                    break;
                case "general":
                    precioBase = 10000;
                    break;
            }
    
                   
        //Se calcula el tipo de descuento según edad y cantidad de entradas
                
            if(edad>60){
                descuento = 0.85;
                precio_descuento_edad = (int) (precioBase * descuento)* numeroEntradas;
                tipoEntrada = "Tercera Edad";


            } else if (edad<23){
                descuento = 0.9;
                precio_descuento_edad = (int) (precioBase * descuento) * numeroEntradas;
                tipoEntrada = "Estudiante";                    

            } else{
                descuento = 0;
                precio_descuento_edad = precioBase*numeroEntradas;
                tipoEntrada = "Normal";
            }
                
            if(4 == numeroEntradas){

                        //descuento = precioBase/2;
                        precio_descuento_grupal = (precioBase * 3) + (precioBase/2);
                        //tipoEntrada = "4ta al 50%";

            } else{
                precio_descuento_grupal = precio_descuento_edad ;  
            }
                
            //depurando código...
            //System.out.println("el precio con descuento de edad: " + precio_descuento_edad);
            //System.out.println("el precio con descuento de grupo: " + precio_descuento_grupal);
            
        //Seleccionar el menor precio
        //Compara el precio del descuento de edad con el descuento grupal
        //Se aplica el descuento mayor, se cobra el menor valor a pagar
        
            if(precio_descuento_grupal < precio_descuento_edad){
             totalPagar = precio_descuento_grupal;
             tipoEntrada = "Grupal";
            } else {
                totalPagar = precio_descuento_edad;

            }

        //Cálculo del valor individual de cada entrada en la compra:   
            valorUnitario = totalPagar/numeroEntradas;

        //Resumen de la compra
            System.out.println("\n************************************"); 
            System.out.println("RESUMEN DE LA COMPRA:");
            System.out.println("Cantidad de entradas compradas: " + numeroEntradas );
            System.out.println("A nombre de : " + nombreCliente);
            System.out.println("Ubicacion de las entradas: " + ubicacion);
            System.out.println("Descuento aplicado: " + tipoEntrada);
            System.out.println("Precio final a pagar: " + totalPagar);
            System.out.println("************************************"); 
            System.out.println("Valor unitario sin descuento: " + precioBase);
            System.out.println("Valor unitario con descuento: " + valorUnitario);
            System.out.println("************************************"); 
    

            System.out.println("\nProcesando la compra..... espere 3 segundos");
            
            try {
                Thread.sleep(3000); // Pausa de 3 segundos (3000 milisegundos)
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }
            
            System.out.println("\n************************************"); 
            System.out.println("Has comprado la entrada exitosamente");
            System.out.println("************************************");                     
                                
             try {
                Thread.sleep(2000); // Pausa 
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }     
            
            System.out.println("\n************************************"); 
            System.out.println("Cargando detalle de cada entrada comprada.... espere 3 segundos.");
            System.out.println("************************************");            
            
            try {
                Thread.sleep(4000); // Pausa de 3 segundos (3000 milisegundos)
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }  
            
        //********ALMACENAR ENTRADA VENDIDA *********
        //guardar entrada en la lista de entradas
        // e imprime el detalle de las entradas
                
            for(int i=1; i<= numeroEntradas; i++){
                entradasVendidas++;
                entradasDisponibles--;

            Entrada nuevaEntrada = new Entrada(nombreCliente, id, tipoEntrada, ubicacion, valorUnitario);
            listaEntradas.add(nuevaEntrada);
            nuevaEntrada.mostrarEntrada();

            contadorEntradas++;
            id++; //permite asignarle un id a cada entrada, distinto y unico y secuencial
            }
                
            try {
                Thread.sleep(3000); // Pausa de 3 segundos (3000 milisegundos)
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }  
            
                System.out.println("\n********RESUMEN DEL SISTEMA***********"); 
                System.out.println("Entradas disponibles a la venta: " + entradasDisponibles );
                System.out.println("Entradas vendidas en total: " + entradasVendidas );
                System.out.println("************************************");
                
            try {
                Thread.sleep(3000); // Pausa de 3 segundos (3000 milisegundos)
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }       
            
            
      
            
            
            
}

//Metodo de busqueda por ID
 public static void buscarPorId(ArrayList<Entrada> listaEntradas, Scanner scanner)   {
     System.out.println("\nIngrese el ID de la entrada que desea buscar: ");
     //int idBuscado = scanner.nextInt();
     int idBuscado = leerOpcionBusqueda(scanner);
     boolean encontrado = false;
     
     for (Entrada entrada : listaEntradas){
         if(entrada.getId() == idBuscado){
             System.out.println("\nEntrada Encontrada: ");
             entrada.mostrarEntrada();
             encontrado = true;
             break;
         }
     }
     
     if(!encontrado){
         System.out.println("No se han encontrado entradas con ese ID");
     }
     
 }

 //Metodo de busqueda por ubicacion
 public static void buscarPorUbicacion(ArrayList<Entrada> listaEntradas, Scanner scanner)   {
     System.out.println("\nIngrese la ubicacion de la entrada que desea buscar: (vip, platea, general) ");
     String ubicacionBuscada = scanner.next().trim().toLowerCase(); 
     boolean encontrado = false;
     int contadorEncontradas = 0;
     
     for (Entrada entrada : listaEntradas){
         
         if(entrada.getUbicacionEntrada().equalsIgnoreCase(ubicacionBuscada)){
             contadorEncontradas ++;
             
             entrada.mostrarEntrada();
             encontrado = true;
             
         }
     }
     
    
     
     if(!encontrado){
         System.out.println("\nNo se han encontrado entradas con esa Ubicacion");
     }else{
          System.out.println("\nHay " + contadorEncontradas + " Entrada(s) en la lista que cumplen con la ubicacion " + ubicacionBuscada);
     }
     
 }
 
  //Metodo de busqueda por tipo de entrada (descuento aplicado)
 public static void buscarPorTipoEntrada(ArrayList<Entrada> listaEntradas, Scanner scanner)   {
     System.out.println("\nIngrese el tipo de entrada que desea buscar: (normal, estudiante, tercera edad, grupal) ");
     scanner.nextLine();
     String tipoBuscado = scanner.nextLine().trim(); 
             
     boolean encontrado = false;
     int contadorEncontradas = 0;
          
     for (Entrada entrada : listaEntradas){
        //Codigo para depurar
        //System.out.println("Comparando id de entrada: " + entrada.getTipoEntrada() + " con el tipo Buscado: " + tipoBuscado);
        
         if(entrada.getTipoEntrada().equalsIgnoreCase(tipoBuscado)){
              contadorEncontradas ++;
             entrada.mostrarEntrada();
             encontrado = true;
             
         }
     }
     
      
     if(!encontrado){
         System.out.println("\nNo se han encontrado entradas con ese tipo");
     }else{
          System.out.println("\nHay " + contadorEncontradas + " Entrada(s) en la lista que cumplen con el tipo " + tipoBuscado);
     }
     
 }
 
//Metodo de eliminacion por ID    
public static void eliminarEntradaPorId(ArrayList<Entrada> listaEntradas, int idAEliminar){
    boolean eliminada = false;
    for(int i=0; i< listaEntradas.size(); i++){
        //Codigo para depurar
        //System.out.println("Comparando id de entrada: " + listaEntradas.get(i).getId() + "con el id ingresado: " + idAEliminar);

        if(listaEntradas.get(i).getId() == idAEliminar){
            listaEntradas.remove(i);
            System.out.println("\nEntrada eliminada correctamente");
            eliminada = true;
                
                entradasDisponibles++;
            break;
        }
    }
    
    if(!eliminada){
        System.out.println("\nNo se ha econtrado entrada con ese ID");
    }
}    

//Recorrer lista de entradas vendidas:
public static void listarEntradas(ArrayList<Entrada> listaEntradas) {
    if (listaEntradas.isEmpty()) {
        System.out.println("\n**************************************\nNo hay entradas registradas aun.");
    } else {
        System.out.println("\nEntradas vendidas hasta ahora: ️" + entradasVendidas);
        for (Entrada entrada : listaEntradas) {
            //System.out.println(entrada);
             entrada.mostrarEntrada(); 
        }
    }
}

//Clase Entrada    
static class Entrada{
    //si la clase Entrada la declaro sin "estatic" generaba error. 
    //No se puede anidar clases a menos que sean Estáticas. 
    //Debería moverse la clase a otro archivo o en su defecto declararla como static.
     
    
    //Variables de instancia, no estáticas:
    String nombre; // quien comprá la entrada
    int idEntrada; // id de la entrada
    String tipoEntrada; //descuento estudiante, descuento tercera edad, normal, 4ta50 grupal
    String ubicacionEntrada; //vip, platea, general
    int valorEntrada; // valor precio unitario, no precio base
 
    //Constructor
    public Entrada(String nombre, int idEntrada, String tipoEntrada, String ubicacionEntrada, int valorEntrada){
        this.nombre = nombre;
        this.idEntrada = idEntrada;
        this.tipoEntrada = tipoEntrada;
        this.ubicacionEntrada = ubicacionEntrada;
        this.valorEntrada = valorEntrada;
    }
    
    //Metodo para mostrar info de la Entrada
    public void mostrarEntrada(){
        System.out.println("");        
        System.out.println("************Detalle de entrada comprada************");
        System.out.println("Num de su entrada: " + idEntrada);
        System.out.println("Tipo de Entrada: " + tipoEntrada); 
        System.out.println("Ubicacion de la Entrada: " + ubicacionEntrada);
        System.out.println("Entrada comprada a nombre de: " + nombre);
        System.out.println("Valor Unitario de la entrada: " + valorEntrada);
        
    }
    
    //Metodo Getter para acceder:
    public int getId(){
        return idEntrada;
    }
    
    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public String getUbicacionEntrada() {
        return ubicacionEntrada;
    }
    
    
    
    
        
}


}