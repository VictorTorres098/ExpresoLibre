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
	
	
	public abstract void agregarPaquetes (Paquete paquete);
	
	public abstract void vaciarCarga ();
	
	public abstract void cambiarEstadoDisponible ();

	protected abstract void agregarDestino(String destino, Integer integer);
	
	//se tiene que borrar
	public abstract boolean exiteDestino();


	

}
