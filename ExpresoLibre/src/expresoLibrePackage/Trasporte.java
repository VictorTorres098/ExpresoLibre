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
	
	//no tiene que borrar
	public abstract boolean exiteDestino();
	
	//cuando llega a 0 no tiene mas espacio para la carga
	public abstract boolean espacioRemolqueDisponible();
	
	//tiene paquetes cargados 
	public abstract boolean remolqueCargado();
	
	//cambiar estado no disponible



	

}
