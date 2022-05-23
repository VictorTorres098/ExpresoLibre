package expresoLibrePackage;

import java.util.ArrayList;

public class MegaTrailer extends Trasporte {
	private String matricula;
	private double cargaMax;
	private double capacidad;
	private boolean tieneRefrigeracion;
	private double costoKm;
	private double segCarga;
	private double costoFijo;
	private double costoComida;
	private Viaje viaje;
	private ArrayList<Paquete> despositoTrasporte;
	private boolean disponible;
	
	public MegaTrailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm, double segCarga, double costoFijo, double costoComida) { //faltan variables
		this.matricula = matricula;
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.tieneRefrigeracion = tieneRefrigeracion;
		this.costoKm = costoKm;
		this.segCarga = segCarga;
		this.costoFijo = costoFijo;
		this.costoComida = costoComida;
		despositoTrasporte = new ArrayList<Paquete>();
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

	@Override
	protected void agregarDestino(String destino, Integer km) {
		if(viaje==null) {
			this.viaje = new Viaje(destino, km);
		}else {
			System.out.print("Ya exite un destino para este trasporte"); //implementar excepcion
		}
		
	}

	@Override
	public boolean exiteDestino() {
		return viaje!=null;
	}

}
