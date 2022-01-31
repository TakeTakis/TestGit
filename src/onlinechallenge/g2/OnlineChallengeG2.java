
package onlinechallenge.g2;

import java.util.ArrayList;
import java.util.Scanner;

/*
G2_Challengers Participantes:

Minoja Leilani Martínez Tortolero
Marko Adrian Sánchez Cruz
Axel Alejandro Perez Gomez
*/

public class OnlineChallengeG2 {
        //listas que tendran al polinomio
        static ArrayList<ClassPolinomio> listaPoli1 = new ArrayList<ClassPolinomio>();
        static ArrayList<ClassPolinomio> listaPoli2 = new ArrayList<ClassPolinomio>();
        static ArrayList<ClassPolinomio> listaResultante = new ArrayList<ClassPolinomio>();
        static ArrayList<ClassPolinomio> lista = new ArrayList<>();
               
        static Scanner sc = new Scanner(System.in);
        static int op=0;
    
    public static void main(String[] args) {
        
        //Entraras al Primer bucle para el Polinomio 1
        EscribirPolinomio1();
        
        //PROBANDO
        System.out.println("Metodo Crudo: "+MostrarPolinomioCRUDO(1));
        System.out.println("Metodo Procesado: "+MostrarTodoPolinomio(1));
        //Its Working
        
        System.out.println("------------------------------------------------");
        System.out.println("Ingresa los datos del Segundo Polinomio");
        
        EscribirPolinomio2();
        
        System.out.println("Metodo Crudo: "+MostrarPolinomioCRUDO(2));
        System.out.println("Metodo Procesado: "+MostrarTodoPolinomio(2));
        
        System.out.println("------------------------------------------------");
        
        //Menu
        while(op!=5){
            menu();
            op=sc.nextInt();
            switch(op){
                case 0:
                    System.out.println("------------------------------------------------");
                    System.out.println("Primer Polinomio: "+MostrarTodoPolinomio(1));
                    System.out.println("Segundo Polinomio: "+MostrarTodoPolinomio(2));
                    System.out.println("------------------------------------------------");
                    break;
                case 1:
                    MenuCambioPol();
                    break;
                case 2:
                    sumarPolinomios();
                    break;
                case 3:
                    MenuRestaPolis();
                    break;
                case 4:
                    multiplicarPolinomios();
                    break;
                case 5:
                    System.out.println("Cerrando el programa...");
                    break;
                default:
                    System.out.println("Vuelva a intentarlo ");
                    break;
                
            }
        }
    }
    //Menu en el cual se reescribe el polinomio 
    public static void MenuCambioPol(){
        op=1;
        while (op!=3){
             System.out.println("------------------------------------------------\n"
                     + "1.- Reescribir Polinomio 1\n"
                     + "2.- Reescribir Polinomio 2\n"
                     + "3.- Salir al menu anterior\n"
                     + "------------------------------------------------");
            op=sc.nextInt();
            switch(op){
                case 1:
                    listaPoli1.clear();
                    EscribirPolinomio1();
                    System.out.println("------------------------------------------------");
                    System.out.println("El Primer Polinomio Reescrito queda asi:");
                    System.out.println("Metodo Crudo: "+MostrarPolinomioCRUDO(1));
                    System.out.println("Metodo Procesado: "+MostrarTodoPolinomio(1));
                    System.out.println("------------------------------------------------");
                    break;
                case 2:
                    listaPoli2.clear();
                    EscribirPolinomio2();
                    System.out.println("------------------------------------------------");
                    System.out.println("El Segundo Polinomio Reescrito queda asi:");
                    System.out.println("Metodo Crudo: "+MostrarPolinomioCRUDO(2));
                    System.out.println("Metodo Procesado: "+MostrarTodoPolinomio(2));
                    System.out.println("------------------------------------------------");
                    break;
                case 3:
                    System.out.println("Saliendo del miniMenu de los Polinomios");
                    break;
                default:
                    System.out.println("Vuelva a escribirlo ");
                    break;

            }
        }
    }
    public static void EscribirPolinomio1(){
        do{
            int Coeficiente=PedirCoeficiente("Primer");
            int Exponente=PedirExponente("Primer");
            
            ClassPolinomio ObjetoPolinomio = new ClassPolinomio(Coeficiente,Exponente);
            //ListasPoli es una lista de objetos
            listaPoli1.add(ObjetoPolinomio);
            do{
            System.out.println("Desesa Seguir agragando Elementos al Primer Polinomio?");
            System.out.println("1.- Si");
            System.out.println("2.- No");
            op=sc.nextInt();
            }while(op!=1&&op!=2);
        }while(op==1);
    }
    
    public static void EscribirPolinomio2(){
        do{
            int Coeficiente=PedirCoeficiente("Segundo");
            int Exponente=PedirExponente("Segundo");
            
            ClassPolinomio ObjetoPolinomio = new ClassPolinomio(Coeficiente,Exponente);
            listaPoli2.add(ObjetoPolinomio);
            
            System.out.println("Desesa Seguir agragando Elementos al Segundo Polinomio?");
            System.out.println("1.- Si");
            System.out.println("2.- No");
            op=sc.nextInt();
        }while(op==1);
    }
    
    public static void sumarPolinomios(){
        
        listaResultante.clear();
        for (int i = 0; i < listaPoli1.size(); i++) {
            listaResultante.add(listaPoli1.get(i));
        }
        for (int i = 0; i < listaPoli2.size(); i++) {
            listaResultante.add(listaPoli2.get(i));
        }
        System.out.println("------------------------------------------------");
        System.out.println("Metodo Crudo: "+MostrarPolinomioCRUDO(3));
        System.out.println("Metodo Procesado: "+MostrarTodoPolinomio(3));
        System.out.println("------------------------------------------------");
    }
    public static void MenuRestaPolis(){
        
        System.out.println("------------------------------------------------\n"
                + "1.- Restar el Polinomio 1 menos el Polinomio 2\n"
                + "2.- Restar el Polinomio 2 menos el Polinomio 1\n"
                + "3.- Salir al Menu anterior\n"
                + "------------------------------------------------");   
        op=sc.nextInt();
        listaResultante.clear();
            switch(op){
                case 1:
                    
                    for (int i = 0; i < listaPoli1.size(); i++) {
                        listaResultante.add(listaPoli1.get(i));
                    }
                    lista=listaPoli2;
                    for (int i = 0; i < lista.size(); i++) {
                        ClassPolinomio ObjetoPolinomio = new ClassPolinomio(lista.get(i).getParteNumeral()*(-1),lista.get(i).getParteAlgebraica());
                        listaResultante.add(ObjetoPolinomio);
                    }
                    System.out.println("------------------------------------------------");
                    System.out.println("Los Resultado de Restar el Polinomio 1 menos el Polinomio 2 son:");
                    System.out.println("Metodo Crudo: "+MostrarPolinomioCRUDO(3));
                    System.out.println("Metodo Procesado: "+MostrarTodoPolinomio(3));
                    System.out.println("------------------------------------------------");
                    break;
                    /*
                    +4x^4+6x^3+2x^2
                    +6x^6+2x^4+2x^2
                    
                    -6x^6+2x^4+6x^3
                    Correcto
                    */
                case 2:
                    for (int i = 0; i < listaPoli2.size(); i++) {
                        listaResultante.add(listaPoli2.get(i));
                    }
                    lista=listaPoli1;
                    for (int i = 0; i < lista.size(); i++) {
                        ClassPolinomio ObjetoPolinomio = new ClassPolinomio(lista.get(i).getParteNumeral()*(-1),lista.get(i).getParteAlgebraica());
                        listaResultante.add(ObjetoPolinomio);
                    }
                    System.out.println("------------------------------------------------");
                    System.out.println("Los Resultado de Restar el Polinomio 2 menos el Polinomio 1 son:");
                    System.out.println("Metodo Crudo: "+MostrarPolinomioCRUDO(3));
                    System.out.println("Metodo Procesado: "+MostrarTodoPolinomio(3));
                    System.out.println("------------------------------------------------");
                    break;
                    /*
                    +4x^4+6x^3+2x^2
                    +6x^6+2x^4+2x^2
                    
                    +6x^6-2x^4-6x^3
                    Correcto
                    */
                case 3:
                    System.out.println("Saliendo al menu anterior");
                    break;
                default:
                    System.out.println("Vuelva a intentarlo ");
                    break;
            
        }
    }
    public static void multiplicarPolinomios(){
        listaResultante.clear();
        for (int i = 0; i < listaPoli1.size(); i++) {
            for (int j = 0; j < listaPoli2.size(); j++) {
                ClassPolinomio ObjetoPolinomio = new ClassPolinomio(listaPoli1.get(i).getParteNumeral()*listaPoli2.get(j).getParteNumeral(),(listaPoli1.get(i).getParteAlgebraica()+listaPoli2.get(j).getParteAlgebraica()));
                listaResultante.add(ObjetoPolinomio);
            }
        }
        System.out.println("------------------------------------------------");
        System.out.println("Los Resultado de la Multiplicacion  del Polinomio 1 por el Polinomio 2 son:");
        System.out.println("Metodo Crudo: "+MostrarPolinomioCRUDO(3));
        System.out.println("Metodo Procesado: "+MostrarTodoPolinomio(3));
        System.out.println("------------------------------------------------");
        /*
        +4x^4+6x^3+2x^2
        +6x^6+2x^4+2x^2
        
        Metodo Crudo: +24x^10+8x^8+8x^6+36x^9+12x^7+12x^5+12x^8+4x^6+4x^4
        Metodo Procesado: +24x^10+36x^9+20x^8+12x^7+12x^6+12x^5+4x^4
        */
    }
    
    public static void menu(){
        System.out.println("------------------------------------------------");
        System.out.println("0.- Mostrar Polinomios");
        System.out.println("1.- Volver a Escribir un Polinomio (1 o 2)");
        System.out.println("2.- Sumar Polinomio 1 y Polinomio 2");
        System.out.println("3.- Restar Polinomios ( 1-2 o 2-1 )");
        System.out.println("4.- Multiplicar Polinomio 1 y Polinomio 2");
        System.out.println("5.- Salir");
        System.out.println("Su respuesta ->");
        System.out.println("------------------------------------------------");
    }
    
    
    
    public static int PedirCoeficiente(String cadena){
            System.out.print("Dame el Coeficiente del "+cadena+" Polinomio: ");
            int Coeficiente=sc.nextInt();
            return Coeficiente;
        }
    
    public static int PedirExponente(String cadena){
            System.out.print("Dame el Exponente del "+cadena+" Polinomio: ");
            int Exponente=sc.nextInt();
            return Exponente;
    }
    
    //quizas el metodo mas importante, reduce terminos
    public static void Reducir_Terminos_Polis(int op){
        
        SwitchParaLista(op);
            
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (i!=j) {
                    //Reuducir terminos
                    if (lista.get(i).getParteAlgebraica()==lista.get(j).getParteAlgebraica()) {
                        int sumaCoeficientes = lista.get(i).getParteNumeral()+lista.get(j).getParteNumeral();
                        ClassPolinomio ObjetoPolinomioDeOperaciones = new ClassPolinomio(sumaCoeficientes,lista.get(j).getParteAlgebraica());
                        
                        int Limite=0;
                          
                        for (int k = 0; k < lista.size(); k++) {
                            
                            if (Limite == 2) {
                                break;
                            }
                            else{
                                if (lista.get(k).getParteAlgebraica()==lista.get(i).getParteAlgebraica()) {
                                    lista.remove(k);
                                    Limite++;
                                    k=k-1;
                                }
                            }
                        }
                        lista.add(ObjetoPolinomioDeOperaciones);
                        //El siguiente for remueve los numeros con coeficiente 0
                        for (int k = 0; k < lista.size(); k++) {
                            if (lista.get(k).getParteNumeral()==0) {
                                lista.remove(k);
                            }
                        }
                        Reducir_Terminos_Polis(op);
                        /*
                        Expo: 2 3 4 
                        3 2 4 3
                        2 3 2 4 3
                        */
                    }
                }
            }
        }
  
    }
    
    //Retorna todo el Polinomio 1 acomodado de mayor a menor exponente
    public static String MostrarTodoPolinomio(int op){
        SwitchParaLista(op);
        Reducir_Terminos_Polis(op);
        int ExpoMax=0;
        String CadenaReturn="";
        
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getParteAlgebraica()>ExpoMax) {
            ExpoMax=lista.get(i).getParteAlgebraica();
            }
        }
        for (int i = ExpoMax; i > 0; i--) {
            for (int j = 0; j < lista.size(); j++) {
                if(lista.get(j).getParteAlgebraica()==i){
                    if (lista.get(j).getParteNumeral()>0) {
                        CadenaReturn=CadenaReturn+("+"+lista.get(j).getParteNumeral())+"x^"+lista.get(j).getParteAlgebraica();
                    }else{
                        CadenaReturn=CadenaReturn+(lista.get(j).getParteNumeral())+"x^"+lista.get(j).getParteAlgebraica();
                    }
                    
                }
            }
        }
        return CadenaReturn;
    }
    
    public static void SwitchParaLista(int op){
        switch(op){
            case 1:
                lista = listaPoli1;
                break;
            case 2:
                lista = listaPoli2;
                break;
            case 3:
                lista = listaResultante;
                break;
        }
    }
    
    //Con Crudo se refiere a no reducir terminos
    public static String MostrarPolinomioCRUDO(int op){
        
        SwitchParaLista(op);
        String CadenaReturn="";
            for (int j = 0; j < lista.size(); j++) {
                    if (lista.get(j).getParteNumeral()>0) {
                        CadenaReturn=CadenaReturn+("+"+lista.get(j).getParteNumeral())+"x^"+lista.get(j).getParteAlgebraica();
                    }
                    else{
                        CadenaReturn=CadenaReturn+(lista.get(j).getParteNumeral())+" "+lista.get(j).getParteAlgebraica();
                    }
                }
        return CadenaReturn;
    }

}
/* Comprobando:
+4x^4+6x^3+2x^2
+6x^6+2x^4+2x^2

suma:
+2x^2+4x^4+6x^3+2x^2+6x^6+2x^4
+6x^6+6x^4+6x^3+4x^2
Correcto

Resta (1-2):

+4x^4+6x^3+2x^2-6x^6-2x^4-2x^2
-6x^6+2x^4+6x^3
Correcto

Resta(2-1):
+6x^6-2x^4-6x^3

Multiplicacion:
+4x^4+6x^3+2x^2
+6x^6+2x^4+2x^2
Metodo Crudo: +24x^10+8x^8+8x^6+36x^9+12x^7+12x^5+12x^8+4x^6+4x^4
Metodo Procesado: +24x^10+36x^9+20x^8+12x^7+12x^6+12x^5+4x^4

Correcto
*/