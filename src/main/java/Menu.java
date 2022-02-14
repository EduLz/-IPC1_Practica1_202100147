/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Eduardo
 */
public class Menu {

    public static void main(String[] args) {//main de la ejecucion

        Scanner entrada2 = new Scanner(System.in);//escaner entrada nombreJugador
        Scanner entrada3 = new Scanner(System.in);//escaner entrada tamañoTablero           
        Scanner entrada7 = new Scanner(System.in);//escaner entrada posicionTablero
        Scanner entrada8 = new Scanner(System.in);//escaner entrada moverPosicion
        Scanner entrada9 = new Scanner(System.in);//escaner entrada opcionesPausa
        Scanner entrada10 = new Scanner(System.in);//escaner entrada regresarPausa
        Scanner entrada11 = new Scanner(System.in);//escaner entrada iconoJugador
        String[] punteos = new String[1000];

        boolean menuCorrecto = true;//boolean para activar el menu
        while (menuCorrecto) {//este while sirve para evitar generar errores de escritura ej:"1." dentro de la entrada del menu
            try { //se utiliza un try y un catch para almacenar el error y evitar cerrar la ejecucion

                boolean menuActivo = true;//boolean para poder moverme dentro del menu sin que se cierre 

                /*AQUI VAN TODAS LAS VARIABLES DE LA EJECUCION*/
                int columnas = 0;
                int filas = 0;
                int puntuacion = 0;
                int vidas = 3;
                String jugadorActual;
                String[][] tablero;
                String iconoActual = " ";

                while (menuActivo) {
                    /*while del menu para que entre en ciclo activo y seleccionar unicamente las opciones 
                    validas, si se ingresa incorrectamente se regresa hasta que se ingrese correctamente
                     */
                    System.out.println("PACMAN-IPC1-2022");
                    System.out.println("----------------");
                    System.out.println("1.       Iniciar juego");
                    System.out.println("2. Tabla de posiciones");
                    System.out.println("3.               Salir");
                    System.out.println("----------------------");
                    System.out.println("Ingrese una opcion... ");
                    Scanner entrada = new Scanner(System.in);//escaner entrada menuActivo
                    int opciones = entrada.nextInt();// variable opciones igual a la entrada del teclado

                    if (opciones == 1) {//opcion 1 de la ejecucion: iniciar juego, comienza a registrar los datos para el juego
                        System.out.println("---------------------");
                        System.out.println("Bienvenido..............");
                        System.out.println("PACMAN.................");
                        System.out.println("Ingrese su nombre: ");
                        String nombreJugador = entrada2.nextLine(); //se almacena la entrada del teclado en la variable nombreJugador
                        jugadorActual = nombreJugador;//esto solo lo use para no confundirme en el uso de variables

                        boolean seleccionarIcono = true;//booleano true
                        while (seleccionarIcono) {//while para evitar un error de entrada dentro del while para seleccionar icono ej"1. o a"
                            System.out.println("Seleccione su icono: ");
                            System.out.println("1.     A");
                            System.out.println("2.     B");
                            System.out.println("3.     C");
                            System.out.println("4.     D");
                            System.out.println("5.     E");
                            System.out.println("6.     F");
                            System.out.println("7.     G");
                            System.out.println("8.     H");
                            System.out.println("9.     I");
                            System.out.println("10.    J");
                            System.out.println("Seleccionar:            ");
                            int iconoJugador = entrada11.nextInt();
                            /*variable iconoJugador, almacena la entrada del teclado
                            en 1 a 10 para guardar el icono que querramos.*/

                            switch (iconoJugador) {
                                /*se usa switch para ingresar unicamente las opciones disponibles 
                                desde 1 a 10 y asignando el icono a la variable IconoActual.*/
                                case 1:
                                    iconoActual = "A";
                                    seleccionarIcono = false;//el booleano se cambia a false para cerrar el ciclo, terminando asi la eleccion del icono
                                    break;

                                case 2:
                                    iconoActual = "B";
                                    seleccionarIcono = false;
                                    break;

                                case 3:
                                    iconoActual = "C";
                                    seleccionarIcono = false;
                                    break;
                                case 4:
                                    iconoActual = "D";
                                    seleccionarIcono = false;
                                    break;
                                case 5:
                                    iconoActual = "E";
                                    seleccionarIcono = false;
                                    break;
                                case 6:
                                    iconoActual = "F";
                                    seleccionarIcono = false;
                                    break;
                                case 7:
                                    iconoActual = "G";
                                    seleccionarIcono = false;
                                    break;
                                case 8:
                                    iconoActual = "H";
                                    seleccionarIcono = false;
                                    break;
                                case 9:
                                    iconoActual = "I";
                                    seleccionarIcono = false;
                                    break;
                                case 10:
                                    iconoActual = "J";
                                    seleccionarIcono = false;
                                    break;
                                default:
                                    System.out.println("Ingrese un icono válido");                    //el default sirve para regresar a las opciones del switch en caso se ingrese un entero no valido.
                                    break;
                            }// fin del switch de iconos
                        }// fin del while de iconos

                        boolean correctoTablero = true;                                                     //booleano de tablero true
                        while (correctoTablero) {                                                              //este while sirve para evaluar un valor valido y no uno incorrecto ej "axa, ax0"
                            System.out.println("Ingrese el tamaño de su tablero (nxn):  ");    //se solicita uan entrada del tablero en formato nxn
                            String tamañoTablero = entrada3.nextLine();                             //cadena tamañoTablero que almacena la entrada del teclado 
                            try {                                                                                      // try y catch para almacenar un error de entrada detectado y evitar que finalice la ejecucion.
                                String[] datosTablero = tamañoTablero.split("x");
                                   /*variable string que almacena una lista en datos de tablero, se toma el valor ingresado
                                    en tamaño tablero y se corta el string ingresado desde la entrada, en este caso la "," que
                                    es el separador entre nxn y asi usar la primer n de la cadena ingresada. */
                                                                                                                        
                                filas = Integer.parseInt(datosTablero[0]);// filas es igual al entero convertido de nxn en datosTablero, que seria la posicion filas [0] dentro de la matriz
                                columnas = Integer.parseInt(datosTablero[1]);//columnas es igual al entero convertido de nxn en datosTablero, que seria la posicion columnas [1] dentro de la matriz
                                correctoTablero = false;//fin del while correctoTablero
                            } catch (Exception escrituraErrorTamaño) {//catch que almacena la Excepcion o error dentro de la variable escrituraErrorTamaño
                                System.out.println("Ingrese el formato valido");
                            }//fin del catch
                        }//fin del while correcto tablero

                        int cantidadComida = 0; //variable cantidad comida para definir las comidas actuales dentro del tablero

                        boolean comidaCorrecto = true; //booleano comidaCorrecto true
                        while (comidaCorrecto) {//while de comidaCorrecto, sirve para que identifique un valor erroneo de entrada 
                            try { //try para intentar ejecutar esto cuando no hayan errores de entrada 
                                int cantComida = (int) (filas * columnas * 0.4);//entero cantComida es igual al entero entre filas y columnas por 0.4, esto nos devuelve un valor entero aproximado de un posible decimal
                                System.out.println("Ingrese cantidad de comida: [0-" + cantComida + "]");// se imprime la solicitud de entrada que define la cantidad de comida que se quiere ingresar, limitado con la variable cantComida que los limita al 40% del total de la matriz que ingresamos
                                Scanner entrada4 = new Scanner(System.in);//escaner entrada cantidadComida
                                cantidadComida = entrada4.nextInt();//variable cantidadComida que almacena los datos de la entrada
                                comidaCorrecto = false; //se cierra el while al identificar que el formato de datos ingresados fueron los correctos 
                            } catch (Exception comidaFail) {//almacena el error de formato de entrada ingresado en comidaFail y se regresa al inicio del while
                                System.out.println("Ingrese un valor correcto");

                            }

                        }
                        //el ciclo de paredes funciona de igual forma que el ciclo comida en linea 152.
                        int cantidadParedes = 0;//variable cantidad paredes para definir las paredes actuales dentro del tablero
                        boolean paredesCorrecto = true; 
                        while (paredesCorrecto) {
                            try {
                                int cantParedes = (int) (filas * columnas * 0.2);
                                System.out.println("Ingrese cantidad de paredes: [0-" + cantParedes + "]");
                                Scanner entrada5 = new Scanner(System.in);//escaner entrada cantidadParedes
                                cantidadParedes = entrada5.nextInt();
                                paredesCorrecto = false;

                            } catch (Exception paredesFail) {
                                System.out.println("Ingrese un valor correcto");
                            }
                        }
                        //el ciclo de trampas funciona de igual forma que el ciclo comida en linea 152.
                        int cantidadTrampas = 0;//variable cantidad trampas para definir las trampas actuales dentro del tablero
                        boolean trampasCorrecto = true;
                        while (trampasCorrecto) {
                            try {
                                int cantTrampas = (int) (filas * columnas * 0.2);
                                System.out.println("Ingrese cantidad de trampas: [0-" + cantTrampas + "]");
                                Scanner entrada6 = new Scanner(System.in);//escaner entrada cantidadTrampas
                                cantidadTrampas = entrada6.nextInt();
                                trampasCorrecto = false;
                            } catch (Exception trampasFail) {
                                System.out.println("Ingrese un valor correcto");
                            }
                        }

                        tablero = new String[filas][columnas]; //se define el tablero en formato String con variables filas y columnas que ya fueron definidas en linea 141 y linea 142

                        int posicionX = 0; //se define el valor de la posicion X dentro de la variable
                        int posicionY = 0; //se define el valor de la posicion Y dentro de la variable

                         //IMPRESION DE LA MATRIZ DE JUEGO
                        System.out.println("Jugador: " + nombreJugador);
                        System.out.println("_____________________________");

                        for (int i = 0; i < filas; i++) { //for que inicializa el conteo de i ingresando la cantidad de filas definidas por la variable filas en la linea 141 
                            for (int j = 0; j < columnas; j++) {//for que inicializa el conteo de j ingresando la cantidad de columnas definidas por la variable columnas en la linea 142 
                                tablero[i][j] = " "; //se imprimen las filas y columnas en un formato de espacio " " en la matriz

                            }

                        }
                        for (int i = 0; i < cantidadComida; i++) { // for que inicializa el conteo de i ingresando dentro de la matriz el simbolo "@" mientras que el espacio no este ocupado por otro (# o X)

                            boolean randomComida = true;
                            while (randomComida) { //inicio del while para ingresar de manera random dependiendo del for el numero de veces que se ingresa @ en una casilla vacia
                                Random r = new Random();
                                int valorDado = r.nextInt(filas);  // valor random que ingresa el valor @ en una casilla dentro de la matriz en formato filas
                                Random r2 = new Random();
                                int valorDado2 = r2.nextInt(columnas);  // valor random que ingresa el valor @ en una casilla dentro de la matriz en formato filas
                                String comidaTablero = tablero[valorDado][valorDado2]; //comidaTablero se define como la matriz del tablero como filas=valorDado y columnas valorDado2 para verificar en una variable si se encuentran simbolos dentro de un espacio en blanco
                                if (comidaTablero == " ") { //cuando el for encuentre un espacio en blanco, se ingresara el valor @ en posicion filas y posicion columnas definidas
                                    tablero[valorDado][valorDado2] = "@";
                                    randomComida = false;
                                }
                            }

                        }
                        //ESTE FOR FUNCIONA IGUAL QUE EL FOR DE LA LINEA 211
                        for (int i = 0; i < cantidadParedes; i++) {
                            boolean randomParedes = true;
                            while (randomParedes) {
                                Random r = new Random();
                                int valorDado = r.nextInt(filas);  // 
                                Random r2 = new Random();
                                int valorDado2 = r2.nextInt(columnas);  // 
                                String paredesTablero = tablero[valorDado][valorDado2];
                                if (paredesTablero == " ") {
                                    tablero[valorDado][valorDado2] = "#";
                                    randomParedes = false;
                                }
                            }

                        }
                        //ESTE FOR FUNCIONA IGUAL QUE EL FOR DE LA LINEA 211
                        for (int i = 0; i < cantidadTrampas; i++) {
                            boolean randomTrampas = true;
                            while (randomTrampas) {
                                Random r = new Random();
                                int valorDado = r.nextInt(filas);  //  
                                Random r2 = new Random();
                                int valorDado2 = r2.nextInt(columnas);  // 
                                String trampasTablero = tablero[valorDado][valorDado2];
                                if (trampasTablero == " ") {
                                    tablero[valorDado][valorDado2] = "X";
                                    randomTrampas = false;

                                }
                            }
                        }
                        //SE IMPRIME LA MATRIZ 
                        for (int i = 0; i < filas; i++) { //for para tomar la variable filas de la matriz hasta que llegue a i menor a las filas definidas
                            System.out.print("|"); //simbolo para definir un borde dentro de la matriz
                            for (int j = 0; j < columnas; j++) {//for para tomar la variable columnas de la matriz hasta que llegue a i menor a las columnas definidas

                                System.out.print(tablero[i][j] + " ");//IMPRESION DE LA MATRIZ EN VARIABLES i Y j CON SEPARACION DE UN ESPACIO " "

                            }
                            System.out.print("|");  //simbolo para definir un borde de la matriz
                            System.out.println("");//impresion en formato de matriz nxn, mas que nada para que la matriz aparezca como matriz y no como linea.
                        }
                        boolean posicionCorrecta = true;
                        while (posicionCorrecta) { //while que funciona como los demas while 

                            System.out.println("INGRESE LA POSICION INICIAL DEL JUGADOR (x,y): ");  
                            String posicionTablero = entrada7.nextLine();
                            try {
                                String[] datosPosicion = posicionTablero.split(","); //Aqui se define la posicion en formato x,y que va a querer tomar el usuario dentro de la matriz 
                                posicionX = Integer.parseInt(datosPosicion[0]);
                                posicionY = Integer.parseInt(datosPosicion[1]);
                                posicionCorrecta = false;
                            }//try
                            catch (Exception escrituraErrorMovimiento) {
                                System.out.println("Debe ser un formato valido");

                            }//fin catch

                        }//fin while

                        System.out.println("Jugador: " + nombreJugador + ", Punteo: " + puntuacion + ", Vidas: " + vidas);
                        System.out.println("__________________________________");
                        tablero[posicionX][posicionY] = iconoActual;

                        for (int i = 0; i < filas; i++) {
                            System.out.print("|");
                            for (int j = 0; j < columnas; j++) {

                                System.out.print(tablero[i][j] + " ");

                            }
                            System.out.print("|");
                            System.out.println("");
                        }
                        System.out.println("___________________________________");

                        boolean comienzoJuego = true;
                        while (comienzoJuego) {
                            int posicionX2 = posicionX;
                            int posicionY2 = posicionY;
                            System.out.println("Ingresa la posicion a mover");
                            String moverPosicion = entrada8.nextLine();
                            switch (moverPosicion) {  //MOVER POSICION, se toma el valor de la posicion ingresada en la linea 274 para poder mover al usuario con su icono dentro de la matriz
                                case "4":
                                case "a":
                                    posicionY2 = posicionY - 1; //se resta una posicion dentro de la matriz, moviendose el usuario
                                    if (posicionY2 == -1) {//este if determina si el icono del usuario llego a un borde de la matriz, haciendo que aparezca al otro lado de la matriz en forma x o forma y 
                                        posicionY2 = columnas - 1;
                                    }//if
                                    String valor = tablero[posicionX2][posicionY2];
                                    if (valor == "@") {
                                        puntuacion = puntuacion + 5;
                                        if (cantidadComida * 5 == puntuacion) {
                                            comienzoJuego = false;

                                        }
                                    } else if (valor == "#") {
                                        posicionY2 = posicionY;
                                    } else if (valor == "X") {

                                        vidas = vidas - 1;
                                        if (vidas == 0) {
                                            comienzoJuego = false;
                                        }
                                    }
                                    break;
                                case "5":
                                case "s":
                                    posicionX2 = posicionX + 1;
                                    if (posicionX2 + 1 > filas) {//este if determina si el icono del usuario llego a un borde de la matriz, haciendo que aparezca al otro lado de la matriz en forma x o forma y 
                                        posicionX2 = 0;
                                    }//if
                                    String valor1 = tablero[posicionX2][posicionY2];
                                    if (valor1 == "@") {
                                        puntuacion = puntuacion + 5;
                                        if (cantidadComida * 5 == puntuacion) {
                                            comienzoJuego = false;

                                        }
                                    } else if (valor1 == "#") {
                                        posicionX2 = posicionX;
                                    } else if (valor1 == "X") {

                                        vidas = vidas - 1;
                                        if (vidas == 0) {
                                            comienzoJuego = false;
                                        }
                                    }
                                    break;
                                case "6":
                                case "d":
                                    posicionY2 = posicionY + 1;
                                    if (posicionY2 + 1 > columnas) {//este if determina si el icono del usuario llego a un borde de la matriz, haciendo que aparezca al otro lado de la matriz en forma x o forma y 
                                        posicionY2 = 0;
                                    }//if

                                    String valor2 = tablero[posicionX2][posicionY2];
                                    if (valor2 == "@") {
                                        puntuacion = puntuacion + 5;
                                        if (cantidadComida * 5 == puntuacion) {
                                            comienzoJuego = false;

                                        }
                                    } else if (valor2 == "#") {
                                        posicionY2 = posicionY;
                                    } else if (valor2 == "X") {
                                        vidas = vidas - 1;
                                        if (vidas == 0) {
                                            comienzoJuego = false;
                                        }
                                    }
                                    break;
                                case "8":
                                case "w":
                                    posicionX2 = posicionX - 1;
                                    if (posicionX2 == -1) {//este if determina si el icono del usuario llego a un borde de la matriz, haciendo que aparezca al otro lado de la matriz en forma x o forma y 
                                        posicionX2 = filas - 1;
                                    }//if 
                                    String valor3 = tablero[posicionX2][posicionY2];
                                    if (valor3 == "@") {
                                        puntuacion = puntuacion + 5;
                                        if (cantidadComida * 5 == puntuacion) {
                                            comienzoJuego = false;

                                        }
                                    } else if (valor3 == "#") {
                                        posicionX2 = posicionX;
                                    } else if (valor3 == "X") {

                                        vidas = vidas - 1;
                                        if (vidas == 0) {
                                            comienzoJuego = false;
                                        }
                                    }
                                    break;
                                case "e":  //MENU DE PAUSA, se ejecuta del switch un menu de pausa, solo imprime los datos de un menu 
                                    comienzoJuego = false;
                                    System.out.println("Ha ingresado e, juego finalizado");
                                    break;
                                case "m":
                                    boolean menuPausa = true;
                                    while (menuPausa) {
                                        System.out.println("     MENU DE PAUSA    ");
                                        System.out.println("----------------");
                                        System.out.println("1.   Continuar Partida");
                                        System.out.println("2. Tabla de posiciones");  //se muestra la talba de posiciones 
                                        System.out.println("3.       Salir Partida");
                                        System.out.println("----------------------");
                                        System.out.println("Ingrese una opcion... ");
                                        int opcionesPausa = entrada9.nextInt();

                                        if (opcionesPausa == 1) {
                                            menuPausa = false;
                                            break;

                                        } else if (opcionesPausa == 2) {
                                            boolean mantenerPausa = true;
                                            while (mantenerPausa) {//iniciar while del menu pausa para tabla de posiciones
                                                System.out.println("Estas son las posiciones: ");
                                                for (int i = 0; i < punteos.length; i++) {
                                                    if (punteos[i] == null) {
                                                        break;
                                                    }
                                                    for (int j = 0; j < punteos.length; j++) {
                                                        if (punteos[j] == null) {
                                                            break;
                                                        }
                                                        String[] datosUsuariosI = punteos[i].split(",");
                                                        int punteosI = Integer.parseInt(datosUsuariosI[1]);
                                                        String[] datosUsuariosJ = punteos[j].split(",");
                                                        int punteosJ = Integer.parseInt(datosUsuariosJ[1]);

                                                        if (punteosI > punteosJ) {
                                                            String temp = punteos[i];
                                                            punteos[i] = punteos[j];
                                                            punteos[j] = temp;
                                                        }
                                                    }
                                                }
                                                for (int i = 0; i < 10; i++) {
                                                    if (punteos[i] != null) {
                                                        System.out.println(punteos[i]);
                                                    }//if fin
                                                }//fin del for punteos.length                           
                                                /* Hasta aqui se imprimen las posiciones del menu para
                                evitar colocar otras opciones diferentes a 1*/
                                                System.out.println("1.       Regresar");
                                                int regresarPausa = entrada10.nextInt();

                                                if (regresarPausa == 1) {
                                                    mantenerPausa = false;
                                                } else if (regresarPausa != 1) {
                                                    System.out.println("Ingrese un valor valido");
                                                }//fin if regresar al menu pausa
                                            }//fin del while de mantener pausa
                                        }//fin if del menu de pausa
                                        else if (opcionesPausa == 3) {
                                            menuPausa = false;
                                            comienzoJuego = false;
                                            System.out.println("Juego Finalizado");
                                            break;
                                        } else if (opcionesPausa != 1 && opcionesPausa != 2 && opcionesPausa != 3) {
                                            System.out.println("Ingrese un valor válido");
                                        }

                                    }//fin while del menu de pausa
                                default:
                                    System.out.println("Valor no reconocido");
                                    break;
                            }//fin switch moverPosicion
                            tablero[posicionX][posicionY] = " ";
                            posicionX = posicionX2;
                            posicionY = posicionY2;
                            tablero[posicionX][posicionY] = iconoActual;

                            System.out.println("Jugador: " + nombreJugador + ", Punteo: " + puntuacion + ", Vidas: " + vidas);
                            System.out.println("__________________________________");

                            for (int i = 0; i < filas; i++) {
                                System.out.print("|");
                                for (int j = 0; j < columnas; j++) {

                                    System.out.print(tablero[i][j] + " ");

                                }
                                System.out.print("|");
                                System.out.println("");
                            }
                            System.out.println("___________________________________");
                            if (cantidadComida * 5 == puntuacion) {
                                System.out.println("Ganó");
                                for (int i = 0; i < punteos.length; i++) {
                                    if (punteos[i] == null) {
                                        punteos[i] = nombreJugador + "," + puntuacion;
                                        break;
                                    }

                                }
                                puntuacion = 0;
                                vidas = 3;

                            } else if (vidas == 0) {
                                System.out.println("Perdió");
                                for (int i = 0; i < punteos.length; i++) {
                                    if (punteos[i] == null) {
                                        punteos[i] = nombreJugador + "," + puntuacion;
                                        break;
                                    }

                                }
                                puntuacion = 0;
                                vidas = 3;
                            }

                        }// WHILE COMIENZO JUEGOJUEGO ACTIVO

                    }//if opcion iniciar juego
                    else if (opciones == 2) {
                        System.out.println("Estas son las posiciones: ");
                        for (int i = 0; i < punteos.length; i++) {
                            if (punteos[i] == null) {
                                break;
                            }
                            for (int j = 0; j < punteos.length; j++) {
                                if (punteos[j] == null) {
                                    break;
                                }
                                String[] datosUsuariosI = punteos[i].split(",");
                                int punteosI = Integer.parseInt(datosUsuariosI[1]);
                                String[] datosUsuariosJ = punteos[j].split(",");
                                int punteosJ = Integer.parseInt(datosUsuariosJ[1]);

                                if (punteosI > punteosJ) {
                                    String temp = punteos[i];
                                    punteos[i] = punteos[j];
                                    punteos[j] = temp;
                                }
                            }
                        }

                        for (int i = 0; i < 10; i++) {
                            if (punteos[i] != null) {
                                System.out.println(punteos[i]);
                            }//if fin

                        }//for punteos.length

                    }//if opcion tabla de posiciones
                    else if (opciones == 3) {
                        System.out.println("Gracias por jugar");
                        menuActivo = false;
                        menuCorrecto = false;
                    }//if Salir juego
                    else if (opciones != 1 && opciones != 2 && opciones != 3) {
                        System.out.println("Valor ingresado: " + opciones);
                        System.out.println("Ingrese una opción válida");
                    }

                }
            }//fin while menu principal
            catch (Exception menuFail) {
                System.out.println("Ingrese un valor valido");
                System.out.println(menuFail);
            }
        }

    }//clase main

}//fin class

