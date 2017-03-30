package ventaelectrodomestico;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public abstract class Electrodomestico {
    
    private double precioBase;

    private Color color;
    
    private ConsumoEnergetico consumoEnergetico;
    
    private double peso;

    private char validar = 'x';
    public Electrodomestico() {
        this.precioBase = 100;
        this.color = Color.BLANCO;
        this.consumoEnergetico = ConsumoEnergetico.F;
        this.peso = 5;
    }

    public Electrodomestico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = Color.BLANCO;
        this.consumoEnergetico = ConsumoEnergetico.F;
    }

    public Electrodomestico(double precioBase, Color color, ConsumoEnergetico consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
    }

    public char comprobarConsumoEnergetico(char opcion){
        switch(opcion){
            case 'A': case 'a':
                validar = 'A';
                break;
            case 'B': case 'b':
                validar = 'B';
                break;
            case 'C': case 'c':
                validar = 'C';
                break;
            case 'D': case 'd':
                validar = 'D';
                break;
            case 'E': case 'e':
                validar = 'E';
                break;
            case 'F': case 'f':
                validar = 'F';
                break;
        }
        return validar;
    }
    
    public short comprobarColor(String color){
        short validarColor = 0;
        switch(color){
            case "BLANCO": case "Blanco": case "blanco":
                validarColor = 1;
                break;
            case "NEGRO": case "Negro": case "negro":
                validarColor = 2;
                break;
            case "ROJO": case "Rojo": case "rojo":
                validarColor = 3;
                break;
            case "AZUL": case "Azul": case "azul":
                validarColor = 4;
                break;
            case "GRIS": case "Gris": case "gris":
                validarColor = 5;
                break;
        }
        return validarColor;
    }
    
    public void precioFinal(char validar){
        switch(validar){
            case 'A': case 'a':
                this.precioBase += 100;
                break;
            case 'B': case 'b':
                this.precioBase += 80;
                break;
            case 'C': case 'c':
                this.precioBase += 60;
                break;
            case 'D': case 'd':
                this.precioBase += 50;
                break;
            case 'E': case 'e':
                this.precioBase += 30;
                break;
            case 'F': case 'f':
                this.precioBase += 10;
                break;
        }
        precioTamano();
    }
    
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
    
    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ConsumoEnergetico getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(ConsumoEnergetico consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
