package ventaelectrodomestico;

import java.util.Scanner;
/**
 * Clase VentaElectrodomestico
 * @author Anggy Arguello - Holmes Ayala
 */
public class VentaElectrodomestico {
    
    //Objeto de la clase Scanner
    Scanner leer = new Scanner(System.in);
    //Arreglo de objetos de la clase electrodomestico
    private Electrodomestico electrodomestico[];
    //Se usa paea recorre el arreglo de electrodomestico 
    private short contador = 0;
    //Objeto de la clase color
    Color color = null;
    //Objeto de la clase consumoEnergetico
    ConsumoEnergetico consumoEnergetico = null;
    
    /**
     * Construtor de VentaElectrodomestico
     */
    public VentaElectrodomestico() {
        this.electrodomestico = new Electrodomestico[10];
        menu();
    }
    
    /**
     * Menu de opciones
     */
    public void menu() {
        short opcion = 0;
        do {
            if(contador < 10) {
                System.out.println("\n\033[31mOpciones:");
                System.out.println("\033[34m1- Lavadora");
                System.out.println("\033[35m2- Televisor");
                System.out.println("\033[36m3- Precios Totales");
                System.out.print("\033[31mOpcion: "); 
                opcion = leer.nextShort();
            }
            else{
                opcion = 3;
            }
            switch(opcion) {
                case 1: case 2: menuSecundario(opcion);
                    break;
                case 3: imprimirPrecio();
                    break;
            }
        }while(opcion != 3);
    }

    /**
     * Menu de opciones secundarias
     * @param _opcion 
     */    
    public void menuSecundario(short _opcion) {
        System.out.println("\n\033[31mOpciones:\n\033[31mAsignar:");
        System.out.println("\033[32m1- Valores por defecto");
        System.out.println("\033[32m2- Precio Base y Peso");
        System.out.println("\033[32m3- Todos los valores");
        System.out.print("\033[31mOpcion: ");
        short opcion = leer.nextShort();
        if(_opcion == 1) {
            iniciarLavadora(opcion);
            contador++;
        }
        else if(_opcion == 2) {
            iniciarTelevisor(opcion);
            contador++;
        }
    }
    
    /**
     * Recibe los datos de la lavadora
     * @param _opcion
     */
    public void iniciarLavadora(short _opcion)  {
        if(_opcion == 1) {
            electrodomestico[contador] = new Lavadora();
        } else if(_opcion == 2) {
            System.out.println("\n\033[34mDatos de la lavadora:");
            System.out.print("\033[34mPrecio Base: ");
            double precioBase = leer.nextDouble();
            System.out.print("\033[34mPeso: ");
            double peso = leer.nextDouble();
            electrodomestico[contador] = new Lavadora(precioBase, peso);
        } else {
            electrodomestico[contador] = new Lavadora(0, null, null, 0, 0);
            System.out.println("\n\033[34mDatos de la lavadora:");
            System.out.print("\033[34mPrecio Base: ");
            double precioBase = leer.nextDouble();
            solicitarColor(electrodomestico[contador]);
            solicitarConsumoEnergetico();
            System.out.print("\033[34mPeso: ");
            double peso = leer.nextDouble();
            System.out.print("\033[34mCarga Kg: ");
            double carga = leer.nextDouble();
            electrodomestico[contador] = new Lavadora(precioBase, color, consumoEnergetico, peso, carga);
        }
        electrodomestico[contador].setTipo(1);
    }
    
    /**
     * Recibe los datos de Television
     * @param _opcion
     */
    public void iniciarTelevisor(short _opcion) {
        if(_opcion == 2 || _opcion == 3) {
            System.out.println("\033[35mDatos del Televisor:");
        }
        pedirDatos(_opcion);
    }
    
    /**
     * Pide los datos de television
     * @param _opcion 
     */
    public void pedirDatos(short _opcion) {
        double precioBase = 0, peso = 0;
        if(_opcion == 1) {
            electrodomestico[contador] = new Television();
        } else {
            System.out.print("\033[35mPrecio Base: ");
            precioBase = leer.nextDouble();
            System.out.print("\033[35mPeso: ");
            peso = leer.nextDouble();
        } if(_opcion == 3) {
            electrodomestico[contador] = new Television(0, null, null, 0, 0, false);
            solicitarColor(electrodomestico[contador]);
            solicitarConsumoEnergetico();
            System.out.print("\033[35mResolucion (pulgadas): ");
            int resolucion = leer.nextInt();
            short sintonizador;
            do {
                System.out.print("\033[35mSintonizadorTDT\n1- Si 2- No: ");
                sintonizador = leer.nextShort();
            }while(sintonizador < 0 || sintonizador > 2);
            boolean validar = false;
            validar = sintonizador == 1;
            electrodomestico[contador] = new Television(precioBase, color, consumoEnergetico, peso, resolucion, validar);
        } else if(_opcion == 2){
            electrodomestico[contador] = new Television(precioBase, peso);
        }
        electrodomestico[contador].setTipo(2);
    }
    
    /**
     * Solicita el color del Electrodomestico
     * @param electrodomestico 
     */
    public void solicitarColor(Electrodomestico electrodomestico) {
        short validar;
        do {
            System.out.print("\033[35mColor (1-Blanco 2- Negro 3- Rojo 4- Azul 5- Gris): ");
            short colorP = leer.nextShort();
            validar = electrodomestico.comprobarColor(colorP);
        }while(validar == 0);
        switch(validar){
            case 1: color = Color.BLANCO;
                break;
            case 2: color = Color.NEGRO;
                break;
            case 3: color = Color.ROJO;
                break;
            case 4: color = Color.AZUL;
                break;
            case 5: color = Color.GRIS;
                break;
        }
    }
    
    /**
     * Solicita el ConsumoEnergetico
     */
    public void solicitarConsumoEnergetico() {
        boolean validar = true; String consumo;
        leer.nextLine();
        do {
            System.out.print("\033[35mConsumo Energetico (A - B - C - D - E - F): ");
            consumo = leer.nextLine();
            validar = electrodomestico[contador].comprobarConsumoEnergetico(consumo);
        }while(validar == false);
        switch(consumo){
            case "A": case "a": consumoEnergetico = ConsumoEnergetico.A; 
                break;
            case "B": case "b": consumoEnergetico = ConsumoEnergetico.B;
                break;
            case "C": case "c": consumoEnergetico = ConsumoEnergetico.C;
                break;
            case "D": case "d": consumoEnergetico = ConsumoEnergetico.D;
                break;
            case "E": case "e":consumoEnergetico = ConsumoEnergetico.E;
                break;
            case "F": case "f":consumoEnergetico = ConsumoEnergetico.F;
                break;
        }
    }
    
    /**
     * Imprime los datos finales
     */
    public void imprimirPrecio() {
        
        double precioTelevisores = 0;
        
        double precioLavadoras = 0;
        
        for(int i = 0; i < contador; i++) {
            if(electrodomestico[i].getTipo() == 1) {
                precioLavadoras += electrodomestico[i].getPrecioBase();
            }
            if(electrodomestico[i].getTipo() == 2) {
                precioTelevisores +=  electrodomestico[i].getPrecioBase();
            }
        }
        double precioTotal = precioLavadoras + precioTelevisores;
        System.out.println("\n\n\033[33mInforme de precios:");
        System.out.println("\033[33mPrecio Televisores: " + precioTelevisores);
        System.out.println("\033[33mPrecio Lavadoras: " + precioLavadoras);
        System.out.println("\033[33mPrecio Total: " + precioTotal);
    }
    
    
    /**
     * Inicia el main
     * @param args 
     */
    public static void main(String[] args) {
        VentaElectrodomestico ventaElectrodomestico = new VentaElectrodomestico();
    }
    
}
