package clases;

public class Main extends ParkingLot {

    public static void main(String[] args) {
        ParkingLot mensajero = new ClasePrecioPorDia();
        mensajero.MenuEleccion();
    }

    @Override
    public int PrecioPorDia(){
        if(precioNuevo > 0){
            precioPorDia = precioNuevo;
        }
        return precioPorDia;
    }
}
