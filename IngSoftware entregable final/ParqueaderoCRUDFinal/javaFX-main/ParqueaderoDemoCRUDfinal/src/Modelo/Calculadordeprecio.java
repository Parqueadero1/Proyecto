package Modelo;

/**
 * Clase que retorna el valor de la tarifa del tipo de vehiculo y su nombre
 * @return
 */
public abstract class Calculadordeprecio {

	
	/**
	 * 
	 * @return tarifa
	 */
	public final int plena () {
		return vehiculo()+500;
	}
		
/**
 * 
 * @return nombre vehiculo
 */
	public String nameClase() {
		return getClass().getSimpleName();
	}
	public abstract int vehiculo ();
}
