package expresoLibrePackage;

public abstract class Trasporte {
	
	public Trasporte() {
		
	}
	
	public abstract boolean tieneRefrigeracion();
	
	public abstract int obtenerCargaMaxima();
	
	public abstract int obtenerVolumen();
	
	public abstract int distanciaMáxima ();
	
	public abstract boolean consultarDisponibilidad ();
	
	public abstract int costoPorKM ();
	
	public abstract void agregarDestino (Viaje destino);
	
	public abstract void agregarPaquetes (Paquete paquete);
	
	public abstract void vaciarCarga ();
	
	public abstract void cambiarEstadoDisponible ();


	

}
