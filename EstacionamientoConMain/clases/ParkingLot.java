package clases;

import java.util.Scanner;

public abstract class ParkingLot {

    int totalEstadia = 0, cantAutosEstacionados = 0, espacioTotal = 100, precioPorDia = 400
    , cantAutosIngresados = 0, cantAutosEgresados = 0, precioNuevo = 0;
    Scanner entrada = new Scanner(System.in);

    //método para el armado de un menú para uso del usuario.
    public void MenuEleccion() {
        int bandera = 0;
        int seleccion = 0;
        do {
            do {
                System.out.println("");
                System.out.println("**************Por favor, indique la operacion a realizar.**************");
                System.out.println("Ingrese 1 para notificar el INGRESO de un auto.");
                System.out.println("Ingrese 2 para notificar el EGRESO de un auto.");
                System.out.println("Ingrese 3 para consultar cantidad de autos estacionados.");
                System.out.println("Ingrese 4 para consultar espacios disponibles.");
                System.out.println("Ingrese 5 para facturar estadía.");
                System.out.println("Ingrese 6 para consultar el precio por día.");
                System.out.println("Ingrese 7 para establecer un NUEVO precio por día.");
                System.out.println("Ingrese 8 para notificar la finalización del día.");
                System.out.println("Ingrese 9 para cerrar el programa.");
                System.out.println("");
                seleccion = entrada.nextInt();

                if (seleccion >= 1 && seleccion <= 9) {
                    bandera = 1;
                } else {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Opcion no disponible, por favor, vuelva a intentar");
                    System.out.println("--------------------------------------------------");
                }
            } while (bandera == 0);

            if (seleccion == 1) {
                this.IngresoDetectado();
            } else if (seleccion == 2) {
                this.EgresoDetectado();
            } else if (seleccion == 3) {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("La cantidad de autos estacionados es: " + this.CantidadEstacionados());
                System.out.println("--------------------------------------------------------------------");
            } else if (seleccion == 4) {
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("El espacio que hay disponible es de " + this.EspaciosDisponibles() + " plaza(s).");
                System.out.println("--------------------------------------------------------------------------------");
            } else if (seleccion == 5) {
                this.FacturarEstadia(precioPorDia);
            } else if (seleccion == 6) {
                ParkingLot mensajero = new ClasePrecioPorDia();
                System.out.println("----------------------------------------------------");
                System.out.println("El precio por día actual es: $" + mensajero.PrecioPorDia());
                System.out.println("----------------------------------------------------");
            } else if (seleccion == 7) {
                ParkingLot mensajero = new ClasePrecioPorDiaNuevo();
                System.out.println("----------------------------------------------------");
                System.out.println("El precio por día actual es: $" + mensajero.PrecioPorDia());
                System.out.println("----------------------------------------------------");
            } else if (seleccion == 8) {
                this.NotificarFinalizacionDelDia();
            } else if (seleccion == 9) {
                System.out.println("------------------------------------------------");
                System.out.println("Gracias por utilizar el programa. Vuelva pronto.");
                System.out.println("------------------------------------------------");
                bandera = 2;
            }
        } while (bandera != 2);

    }

    //Método que devuelve la cantidadde autos estacionados.
    public int CantidadEstacionados() {
        return cantAutosEstacionados;
    }

    //Método que devuelve cantidad de plazas disponibles para estacionar.
    public int EspaciosDisponibles() {
        return espacioTotal;
    }

    //Método que devuelve precio por día o actualiza el precio por dia.
    public abstract int PrecioPorDia();

    //Método que detecta el ingreso de un auto al estacionamiento.
    public void IngresoDetectado() {
        if (cantAutosEstacionados < 100) {
            cantAutosIngresados += 1;
            cantAutosEstacionados += 1;
            espacioTotal -= 1;
            System.out.println("------------------------------------------------");
            System.out.println("El INGRESO del auto fue detectado correctamente.");
            System.out.println("------------------------------------------------");
        } else {
            System.out.println("----------------------------------------------------");
            System.out.println("NO HAY MÁS ESPACIO DISPONIBLE EN EL ESTACIONAMIENTO.");
            System.out.println("----------------------------------------------------");
        }
    }

    //Método que detecta el egreso de un auto al estacionamiento.
    public void EgresoDetectado() {
        if (cantAutosEstacionados > 0) {
            cantAutosEgresados += 1;
            cantAutosEstacionados -= 1;
            espacioTotal += 1;
            System.out.println("-----------------------------------------------");
            System.out.println("El EGRESO del auto fue detectado correctamente.");
            System.out.println("-----------------------------------------------");
        } else {
            System.out.println("--------------------------");
            System.out.println("NO HAY AUTOS ESTACIONADOS.");
            System.out.println("--------------------------");
        }
    }

    //Método que calcula la facturación del estacionamiento en cuanto a autos que quedaron estacionados.
    public void FacturarEstadia(int precioPorDia) {
        this.precioPorDia = precioPorDia;
        /*
         *Entiendo que éste cálculo se basa en los autos que han quedado 
         estacionados, en concepto de Estadía. SIN CONTAR AQUELLOS QUE HAN INGRESADO
         Y EGRESADO DEL ESTACIONAMIENTO.
         */
        totalEstadia = (precioPorDia * cantAutosEstacionados);
        System.out.println("---------------------------------------");
        System.out.println("El total recaudado es: $" + totalEstadia);
        System.out.println("---------------------------------------");
    }

    //Método que crea el cuerpo del mail.
    public String CrearCuerpoMail() {
        String cuerpo = "El monto total de la estadía del día de hoy fue: $" + totalEstadia;
        return cuerpo;
    }

    //método que notifica por mail la finalizacion del día.
    public void NotificarFinalizacionDelDia() {
        //ServicioExterno.EnviarMail("asunto", CrearCuerpoMail(), "mail@ejemplo.com");
        System.out.println("------------------------------");
        System.out.println("El mail fue envíado con éxito.");
        System.out.println("------------------------------");
    }

}
