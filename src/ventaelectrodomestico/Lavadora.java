package ventaelectrodomestico;

/**
 * Clase Lavadora
 * @author Anggy Arguello - Holmes Ayala
 */
public class Lavadora extends Electrodomestico {
    
    // cargar o capacidad de la lavadora
    private double carga;

    /**
     * Contructor con todos los valores por defecto
     */
    public Lavadora() {
        this.carga = 5;
        precioFinal();
    }

    /**
     * Contructor que recibe el precio base, el peso y el resto por defecto
     * @param precioBase
     * @param peso 
     */
    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
        this.carga = 5;
        precioFinal();
    }

    /**
     * Constructor que recibe todos los parametros
     * @param precioBase
     * @param color
     * @param consumoEnergetico
     * @param peso
     * @param carga 
     */
    public Lavadora(double precioBase, Color color, ConsumoEnergetico consumoEnergetico, double peso, double carga) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
        precioFinal();
    }
    
    /**
     * Especializa el metodo precioFinal de la clase Electrodomestico
     */
    @Override
    public void precioFinal(){
        if(this.carga > 30){
            this.setPrecioBase(this.getPrecioBase() + 50);
        }
        super.precioFinal();
    }

    /**
     * Obtiene el valor de carga
     * @return carga
     */
    public double getCarga() {
        return carga;
    }

    /**
     * Cambia el valor de carga
     * @param carga 
     */
    public void setCarga(double carga) {
        this.carga = carga;
    }
}