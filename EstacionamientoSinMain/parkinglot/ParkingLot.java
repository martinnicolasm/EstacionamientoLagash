package parkinglot;

public class ParkingLot {
    int cantAutosEstacionados = 0, espacioTotal = 100, cantAutosIngresados = 0,
            cantAutosEgresados = 0, precioPorDia = 400, totalEstadia = 0;
    
    //Método que devuelve la cantidadde autos estacionados.
    public int CantidadEstacionados() {
        return cantAutosEstacionados;
    }

    //Método que devuelve cantidad de plazas disponibles para estacionar.
    public int EspaciosDisponibles() {
        return espacioTotal;
    }

    //Método que devuelve precio por día.
    public int PrecioPorDia(){
        return precioPorDia;
    }

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
        ServicioExterno.EnviarMail("asunto", CrearCuerpoMail(), "mail@ejemplo.com");
        System.out.println("------------------------------");
        System.out.println("El mail fue envíado con éxito.");
        System.out.println("------------------------------");
    }
}
