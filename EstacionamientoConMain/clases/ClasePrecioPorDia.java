package clases;

public class ClasePrecioPorDia extends ParkingLot {

    @Override
    public int PrecioPorDia() {
        if(precioNuevo > 0){
            precioPorDia = precioNuevo;
        }
        return precioPorDia;
    }
}
