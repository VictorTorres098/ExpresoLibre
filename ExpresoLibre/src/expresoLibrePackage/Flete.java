package expresoLibrePackage;

import java.util.ArrayList;

public class Flete extends Trasporte{
	
	private String matricula;
	private double cargaMax;
	private double capacidad;
	private double costoKm;
	private int cantAcompaniantes;
	private double costoPorAcompaniante;
	private Viaje viaje;
	private ArrayList <Paquete> depositoFlete;
	private boolean disponible;
	
	public Flete(String matricula, double cargaMax, double capacidad, double costoKm, int cantAcompaniantes, double costoPorAcompaniante) {		//falta variables en el contructor
		this.matricula = matricula;
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.costoKm = costoKm;
		this.cantAcompaniantes = cantAcompaniantes;
		this.costoPorAcompaniante = costoPorAcompaniante;
		depositoFlete = new ArrayList <Paquete>();
		disponible = true;
	}

	@Override
	public boolean tieneRefrigeracion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int obtenerCargaMaxima() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtenerVolumen() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int distanciaMáxima() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean consultarDisponibilidad() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int costoPorKM() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void agregarDestino(Viaje destino) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarPaquetes(Paquete paquete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vaciarCarga() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarEstadoDisponible() {
		// TODO Auto-generated method stub
		
	}

}
