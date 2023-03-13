package practica.pkg1;

import java.util.Scanner;

public class Practica1 {

    private static double end; //Esta variable será usada posteriormente para recoger el resultado de la calculadora
    private static int ejecuciones; //Esta para contar las veces que se ha usado la calculadora, lo cual se usara posteriormente
    private static int eleccion; //Esta para la eleccion en el menu
    private static int eleccionp; //Y esta para la eleccion en el submenu de numeros primos
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(menu()); //Imprimimos en consola el menu
            Practica1.eleccion = sc.nextInt(); //La proxima entrada en consola sera recogida y utilizada en el switch de abajo
            switch (eleccion) { //Dependiendo del numero introducido se ejecutara una funcion u otra
                case 1 ->
                    calculadora();
                case 2 ->
                    ultimo();
                case 3 ->
                    menuprimo();
                case 4 ->
                    cuadricula();
                case 5 ->
                    escalera();
                case 6 ->
                    info();
                default -> {
                }
            }
        } while (eleccion != 0); //En caso de que la eleccion sea 0 se finalizara el programa

    }

    public static String menu() { //Creo un metodo tipo string llamado menu el cual contendra las lineas de texto del menu en una variable string 
        limpiar(); //Ejecutamos el metodo limpiar el cual esta declarado mas abajo
        String resultado;
        resultado = "Elige una opcion: \n";
        resultado += "1. Calculadora\n";
        resultado += "2. Ver ultimo resultado de la calculadora\n";
        resultado += "3. Numero primo\n";
        resultado += "4. Cuadricula\n";
        resultado += "5. Piramide de numeros\n";
        resultado += "6. Informacion de la aplicacion\n";
        resultado += "0. Salir\n";
        return resultado; //Devolvemos la variable String resultado
    }

    public static void calculadora() { //Se ejecutara al elegir la opcion 1 en el menu principal
        Scanner scc = new Scanner(System.in); //Creamos un escaner para caracteres y otro para numeros
        Scanner scd = new Scanner(System.in); 
        char operacionc; //Declaramos una variable char para recoger el caracter de la operacion
        double num; //Declaramos una variable double para recoger el primer numero y otra para el segundo
        double num2; 
        int operacion = 1; //Declaramos una variable int para la eleccion de operacion
        limpiar();
        do{
        System.out.println("Escribe la operacion [+,-,*,/]");
        operacionc = scc.next().charAt(0);
        switch (operacionc) { //Este switch nos derivara a una operacion u otra dependiendo del caracter introducido
            case '+' ->
                operacion = 1;
            case '-' ->
                operacion = 2;
            case '*' ->
                operacion = 3;
            case '/' ->
                operacion = 4;
            default -> {
            }
        } } while(operacionc != '+' && operacionc != '-' && operacionc != '*' && operacionc != '/'); //Se ejecutara una y otra vez hasta que elijamos una de las opciones disponibles
        limpiar();
        System.out.println("Escribe el primer operando:"); //Preguntamos los operandos
        num = scd.nextDouble();
        limpiar();
        System.out.println("Escribe el segundo operando:");
        num2 = scd.nextDouble();
        limpiar();

        switch (operacion) { //Se realizara una operacion u otra en base a la elegida 
            case 1 -> {
                System.out.println("El resultado de " + num + " " + operacionc + " " + num2 + " = " + (num + num2));
                Practica1.end = num + num2; //Se guardara el valor obtenido en la variable end
                ejecuciones++; //Incrementamos ejecuciones en 1 lo cual se utilizara posteriormente
            }
            case 2 -> {
                System.out.println("El resultado de " + num + " " + operacionc + " " + num2 + " = " + (num - num2));
                Practica1.end = num - num2;
                ejecuciones++;
            }
            case 3 -> {
                System.out.println("El resultado de " + num + " " + operacionc + " " + num2 + " = " + (num * num2));
                Practica1.end = num * num2;
                ejecuciones++;
            }
            case 4 -> {
                System.out.println("El resultado de " + num + " " + operacionc + " " + num2 + " = " + (num / num2));
                Practica1.end = num / num2;
                ejecuciones++;
            }
            default -> {
            }
        }
        pulsaEnter(); //Ejecutaremos la funcion pulsaEnter declarada mas abajo
                
    }
    
    public static void ultimo() { //El metodo ultimo se ejecutara cuando elijamos la opcion 2 en el menu principal
        if (Practica1.end == 0 && ejecuciones == 0) { //En caso de que end valga 0 y ejecuciones tambien, nos imprimira esto
            limpiar();
            System.out.println("No se ha usado la calculadora aun");
            pulsaEnter();
        } else { //Sino nos dira el resultado anterior
            limpiar();
            System.out.println("El ultimo resultado de la calculadora era " + Practica1.end);
            pulsaEnter();
        }
    }

    public static void menuprimo() { //Este submenu se ejecutara al elegir la opcion 3 en el menu principal
        Scanner sc = new Scanner(System.in);
        String menuprimo;
        limpiar();
        menuprimo = "Elige una opcion\n";
        menuprimo += "1. Mostrar los numeros primos hasta un valor\n";
        menuprimo += "2. Ver si el numero introducido es primo\n";
        menuprimo += "0. Volver al menu principal\n";
        do{
        System.out.println(menuprimo); //nos imprimira el correspondiente menu
        eleccionp = sc.nextInt();
        switch (eleccionp) { //En base a nuestra eleccion se ejecutara una funcion u otra
            case 1 ->
                todosPrimos();
            case 2 ->
                esPrimo();
            case 0 ->
                menu();
            default -> {
            }
        }} while(eleccionp != 1 && eleccionp != 2 && eleccionp != 0); //El menu se seguira ejecutando mientras la eleccion no sea 1, 2 o 0
    }
    
    public static boolean primosCalc(int num) { //Recogeremos el numero del usuario y lo introduciremos a esta funcion
        boolean primo = true;
        if (num == 1 || (num % 2 == 0 && num > 2)) { //Si el numero es 1 o su modulo entre 2 es 0 y es mayor a 2
            primo = false; //No sera primo
        } else {
            for (int i = 2; i < (num / 2); i++) { //Si no cumple con lo anterior lo meteremos a este bucle for que empieza en 2, termina cuando i es menor que el numero / 2 y se incrementa +1
                if (num % i == 0) { //Si aun asi el modulo del numero entre i es igual a 0
                    primo = false; //No sera primo
                    break;
                }
            }
        } //En caso contrario a lo anterior el numero sera primo
        return primo;
    }
    
    public static void todosPrimos() { //Se ejecutara al elegir la opcion 1 en menuprimo
        Scanner sc = new Scanner(System.in);
        int cantPrimos = 0; //Declaramos una variable que nos guardara la cantidad de numeros primos que hay entre el 1 y el numero elegido
        limpiar();
        System.out.println("Introduce un numero");
        int num = sc.nextInt(); //Recogemos el numero del usuario
        for (int i = 1; i <= num; i++) { //Hacemos que se calculen desde el 1 hasta el numero del usuario
            if (primosCalc(i)) { //La funcion primosCalc dira cada numero primo, estos van introduciendose continuamente gracias a la variable i del bucle for
                System.out.print(i + " "); //Imprimiremos cada numero primo
                cantPrimos++; //Y aumentaremos en 1 la variable cada vez que se detecte un primo
            }
        }
        System.out.println("\nHay " + cantPrimos + " numeros primos entre el 1 y el " + num); //Imprimiremos la cantidad de primos final
        pulsaEnter();
    }

    public static void esPrimo() { //Se ejecutara al elegir la opcion 2 en menuprimo
        Scanner sc = new Scanner(System.in);
        int num;
        limpiar();
        System.out.println("Introduce un numero");
        num = sc.nextInt(); //Recogeremos el numero del usuario
        if (primosCalc(num)) { //La funcion primosCalc dira si es primo o no
            System.out.println("El numero " + num + " es primo"); //En base a si es true o false se imprimira una cosa o la otra
        } else {
            System.out.println("El numero " + num + " no es primo"); 
        }
        pulsaEnter();
    }

    

    public static void cuadricula() { //Se ejecutara al elegir la opcion 4 en el menu principal
        Scanner sc = new Scanner(System.in);
        limpiar();
        System.out.println("Introduce el numero de filas:");
        int filas = sc.nextInt(); //Pediremos el numero de filas al usuario
        limpiar();
        System.out.println("Introduce el numero de columnas:");
        int cols = sc.nextInt(); //El de columnas
        limpiar();
        System.out.println("Introduce el caracter de relleno:");
        char caracter = sc.next().charAt(0); //Y el caracter que quiere utilizar
        limpiar();
        for (int i = 0; i < filas; i++) { //Utilizamos este bucle for para las filas
            for (int j = 0; j < cols; j++) { //Este para las columnas
                System.out.print(caracter + " "); //E imprimiremos el caracter cada vez que el segundo bucle se ejecute
            }
            System.out.println(""); //Imprimiremos un salto de linea cada vez que se termine de ejecutar una fila
        }
        System.out.println("Esto es una cuadricula de " + filas + "x" + cols + "\n"); //Debajo de la cuadricula indicaremos sus propiedades
        pulsaEnter();
    }

    public static void escalera() { //Se ejecutara al elegir la opcion 5 en el menu principal
        Scanner sc = new Scanner(System.in);
        limpiar();
        System.out.println("Introduce un numero");
        int num = sc.nextInt();//Pediremos el numero de filas de la escalera al usuario
        limpiar();
        if (num > 0) { //Si el numero es mayor a 0 (positivo)
            for (int i = 1; i <= num; i++) { //Haremos un bucle for que se ejecutara hasta el numero de filas indicadas
                for (int j = 1; j <= i; j++) { //Y otro para la cantidad de caracteres por fila haciendo que esta aumente hasta igualar a i
                    System.out.print(i + " "); //Imprimiremos los numeros
                }
                System.out.println(""); //Y un salto de linea al finalizar cada fila
            }

        } else if (num < 0) { //Si el numero es menor a 0 (negativo)
            for (int i = -num; i >= 1; i--) { //Haremos un bucle for que empiece en el numero negativo convertido a positivo (con un - delante), continuara hasta que i sea mayorigual a 1 y decrecera 1 cada vez que se ejecute (seran las filas)
                for (int j = i; j >= 1; j--) { //Haremos otro para la cantidad de caracteres por fila que empezara en i terminara cuando sea mayorigual a 1 y decrecera 1 en cada ejecucion
                    System.out.print(i + " "); //Imprimiremos los numeros
                }
                System.out.println(""); //Haremos un salto de linea cada vez que se acabe una fila
            }
        } pulsaEnter();
    }

    public static void info() { //Se ejecutara al elegir la opcion 6 del menu principal
        limpiar();
        String infoapp = "Jordi Alejandro Sumba Rodriguez\n";
        infoapp += "1º DAM\n";
        infoapp += "Cesur Plaza Eliptica\n";
        infoapp += "Madrid, Comunidad de Madrid, España, Europa, Tierra, Via Lactea, Grupo Local, Supercumulo de Virgo\n";
        infoapp += "Octubre 2022";
        System.out.println(infoapp);//Desplegara una variable String con toda la info del creador
        System.out.println("");
        pulsaEnter();
    }

    public static void limpiar() { //Esta es una funcion adicional la cual utilizo multiples veces a lo largo del programa
        for (int i = 0; i < 1000; i++) { //Se basa de un bucle for que empieza en 0 y acaba en 1000
            System.out.println("\n"); //Y nos imprimira 1000 saltos de linea para despejar la consola visible
        }
    }

    public static void pulsaEnter() { //Esta es una funcion adicional tambien
        Scanner sc = new Scanner (System.in);
        System.out.println("Pulsa enter para continuar...");
        sc.nextLine(); //Simplemente pausara el programa hasta que hagamos una nueva introduccion en la consola(puramente estetico)
    }
}
