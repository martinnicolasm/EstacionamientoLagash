package clases;

public class ClasePrecioPorDiaNuevo extends ParkingLot{
    
    @Override
    public int PrecioPorDia(){
        System.out.println("-------------------------------------------");
        System.out.print("Por favor, ingrese el nuevo precio por día: $");
        precioNuevo = entrada.nextInt();
        System.out.println("---------------------------------------------");
        precioPorDia = precioNuevo;
        return precioNuevo;
    }
}
