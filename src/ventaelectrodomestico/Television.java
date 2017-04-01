package ventaelectrodomestico;

/**
 * Clase Television
 * @author Anggy Arguello - Holmes Ayala
 */
public class Television extends Electrodomestico{
    
    //Resolucion en pulgadas de la television
    private int resolucion;
    //True si tiene sintonizadorTDT, de lo contrario false
    private boolean sintonizadorTDT;
    
    /**
     * Constructor con todos los valores por defecto
     */
    public Television() {
        this.resolucion = 20;
        this.sintonizadorTDT = false;
        precioFinal();
    }
    
    /**
     * Contructor que recibe el precioBase y el peso el resto por defecto
     * @param precioBase
     * @param peso 
     */
    public Television( double precioBase, double peso) {
        super(precioBase, peso);
        this.resolucion = 20;
        this.sintonizadorTDT = false;
        precioFinal();
    }
    
    /**
     * Constructor que recibe todos los parametros
     * @param resolucion
     * @param sintonizadorTDT
     * @param precioBase
     * @param color
     * @param consumoEnergetico
     * @param peso 
     */
    public Television(double precioBase, Color color, ConsumoEnergetico consumoEnergetico, double peso,int resolucion, boolean sintonizadorTDT) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
        precioFinal();
    }
    
    /**
     * Especializa el precioFinal de la clase padre
     */
    @Override
    public void precioFinal() {
        super.precioFinal();
        if(this.resolucion > 40){
            this.setPrecioBase(this.getPrecioBase() + (this.getPrecioBase() * 0.3));
        }
        if(this.sintonizadorTDT == true){
            this.setPrecioBase(this.getPrecioBase() + 50);
        }
    }
    
    /**
     * Obtiene la resolucion
     * @return resolucion
     */ 
    public int getResolucion() {
        return resolucion;
    }
    
    /**
     * Modifica la resolucion
     * @param resolucion 
     */
    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }
    
    /**
     * Obtiene sintonizadorTDT
     * @return sintonizadorTDT
     */
    public boolean getSintonizadorTDT() {
        return sintonizadorTDT;
    }
    
    /**
     * Modifica sintonizadorTDT
     * @param sintonizadorTDT 
     */
    public void setSintonizadorTDT(boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }
}
