package Modelo;

public class Cliente {

	/**
	 * Clase main
	 * @param args
	 */
public static void main(String[] args) {
		
		Calculadordeprecio car= new Carro();
		Calculadordeprecio elec = new Carroelec();
		System.out.println(car.nameClase() + " " + car.plena());
		System.out.println(elec.nameClase() + " " +elec.plena());
		
	}
}
