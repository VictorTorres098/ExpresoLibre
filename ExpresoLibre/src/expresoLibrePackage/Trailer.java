package expresoLibrePackage;

import java.util.ArrayList;

public class Trailer extends Trasporte {
	private String matricula;
	private double cargaMax;
	private double capacidad; //Ojo con esta!!! seria volumen o peso?
	private boolean tieneRefrigeracion;
	private double costoKM;
	private double segCarga;
	private Viaje viaje;
	private ArrayList<Paquete> despositoTrasporte;
	private boolean disponible;
	
	public Trailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKM, double segCarga) { //faltan las variables
		this.matricula = matricula;
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.tieneRefrigeracion = tieneRefrigeracion;
		this.costoKM = costoKM;
		this.segCarga = segCarga;
		this.viaje = null; //inicia sin ningun viaje
		despositoTrasporte = new ArrayList<Paquete>();
		disponible = true; // comienza estando disponible ya que no tiene ningun viaje
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
