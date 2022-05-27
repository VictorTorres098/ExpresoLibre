package expresoLibrePackage;

public abstract class Trasporte {
	
	public Trasporte() {
		
	}
	
	public abstract boolean tieneRefrigeracion();
	
	public abstract double obtenerCargaMaxima();
	
	public abstract double obtenerVolumen();
	
	public abstract double distanciaMáxima ();
	
	public abstract boolean consultarDisponibilidad ();
	
	public abstract double costoPorKM ();
	
	
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
	
	//return tipo trasporte
	public abstract String dameTipo();
	
	//devuelve el destino del trasporte 
	public abstract String destinoActual();
	
	//devuelve la matricula
	public abstract String matricula();
	
	//devuelva es costo
	public abstract double devolverCosto();
	
	//estaEnViaje
	public abstract boolean consultarSiEstaDeViaje();
	
	//cambiar a esta de viaje
	public abstract void iniciarViaje();
	
	//cambiar a finalizar viaje
	public abstract void finalizarViaje();


	

}
