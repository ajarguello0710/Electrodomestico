package ventaelectrodomestico;

/**
 * Clase Electrodomestico
 * @author Anggy Arguello - Holmes Ayala
 */
public abstract class Electrodomestico implements IOperaciones{
    
    //  Precio base del electrodomestico
    private double precioBase;
    //  Color del electrodomestico
    private Color color;
    //  Consumo de energia del electrodomestico
    private ConsumoEnergetico consumoEnergetico;
    //  Peso del electrodomestico
    private double peso;
    //  Tipo de electrodomestico
    private int tipo;
    
    /**
     * Contructor con los valores predeterminados
     */
    public Electrodomestico() {
        this.precioBase = 100;
        this.color = Color.BLANCO;
        this.consumoEnergetico = ConsumoEnergetico.F;
        this.peso = 5;
    }

    /**
     * Contructor que recibe el precio base y el peso, el resto por defecto
     * @param precioBase
     * @param peso 
     */
    public Electrodomestico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = Color.BLANCO;
        this.consumoEnergetico = ConsumoEnergetico.F;
    }

    /**
     * Constructor que recibe todos los parametros
     * @param precioBase
     * @param color
     * @param consumoEnergetico
     * @param peso 
     */
    public Electrodomestico(double precioBase, Color color, ConsumoEnergetico consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
    }

    /**
     * Valida la letra para el consumo energetico
     * @param opcion
     * @return validar
     */
    public boolean comprobarConsumoEnergetico(String opcion){
        boolean validar = false;
        switch(opcion){
            case "A": case "a":
                validar = true;
                break;
            case "B": case "b":
                validar = true;
                break;
            case "C": case "c":
                validar = true;
                break;
            case "D": case "d":
                validar = true;
                break;
            case "E": case "e":
                validar = true;
                break;
            case "F": case "f":
                validar = true;
                break;
        }
        return validar;
    }
    
    /**
     * Valida el color
     * @param color
     * @return validarColor      
     */
    public short comprobarColor(short color) {
        short validarColor = 0;
        switch(color){
            case 1:
                validarColor = 1;
                break;
            case 2:
                validarColor = 2;
                break;
            case 3:
                validarColor = 3;
                break;
            case 4:
                validarColor = 4;
                break;
            case 5:
                validarColor = 5;
                break;
        }return validarColor;
    }
    
    /**
     *Calcula el precio final 
     */
    public void precioFinal(){
        if(consumoEnergetico == ConsumoEnergetico.A){
            this.precioBase += 100;
        }
        else if(consumoEnergetico == ConsumoEnergetico.B){
            this.precioBase += 80;
        }
        else if(consumoEnergetico == ConsumoEnergetico.C){
            this.precioBase += 60;
        }
        else if(consumoEnergetico == ConsumoEnergetico.D){
            this.precioBase += 50;
        }
        else if(consumoEnergetico == ConsumoEnergetico.E){
            this.precioBase += 30;
        }
        else if(consumoEnergetico == ConsumoEnergetico.F){
            this.precioBase += 10;
        }
        precioTamano();
    }
    
    /**
     * Aumenta el precio base según su tamaño
     */
    public void precioTamano(){
        if(peso >= 80){
            this.precioBase += 100;
        }
        else if(peso >= 50){
            this.precioBase += 80;
        }
        else if(peso >= 20){
            this.precioBase += 50;
        }
        else if(peso > 0){
            this.precioBase += 10;
        }
    }
    
    /**
     * Obtiene el valor de precioBase
     * @return precioBase 
     */
    public double getPrecioBase() {
        return precioBase;
    }
    
    /**
     * Modifica el precioBase
     * @param precioBase 
     */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Obtiene el color
     * @return color 
     */    
    public Color getColor() {
        return color;
    }
    
    /**
     * Modifica el color
     * @param color 
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * Obtiene el consumoEnergetico
     * @return consumoEnergetico
     */
    public ConsumoEnergetico getConsumoEnergetico() {
        return consumoEnergetico;
    }
    
    /**
     * Modifica el consumoEnergetico
     * @param consumoEnergetico 
     */
    public void setConsumoEnergetico(ConsumoEnergetico consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }
    
    /**
     * Obtiene el peso
     * @return peso 
     */
    public double getPeso() {
        return peso;
    }
    
    /**
     * Modifica el peso
     * @param peso 
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene tipo
     * @return tipo
     */
    public int getTipo() {
        return tipo;
    }
     
    /**
     * Modifica tipo
     * @param tipo 
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
