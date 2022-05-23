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
	private ArrayList<Paquete> depositoTrailer;
	private boolean disponible;
	
	public Trailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKM, double segCarga) { //faltan las variables
		this.matricula = matricula;
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.tieneRefrigeracion = tieneRefrigeracion;
		this.costoKM = costoKM;
		this.segCarga = segCarga;
		this.viaje = null; //inicia sin ningun viaje
		depositoTrailer = new ArrayList<Paquete>();
		disponible = true; // comienza estando disponible ya que no tiene ningun viaje
	}

	@Override
	public boolean tieneRefrigeracion() {
		return tieneRefrigeracion;
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
		return disponible;
	}

	@Override
	public int costoPorKM() {
		// TODO Auto-generated method stub
		return 0;
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
	
	public boolean exiteDestino() {
		return viaje!=null;
	}

	@Override
	public boolean espacioRemolqueDisponible() {
		return (cargaMax > 0 && capacidad > 0); //Si es mayor o igual a 0 hay espacio  
	}//crear una funcion que vaya restando la capacidad y la cargamax 

	@Override
	public void agregarPaquetes(Paquete paquete) {
		depositoTrailer.add(paquete);
		this.cargaMax -= paquete.obtenerPeso();
		this.capacidad -= paquete.obtenerVolumen(); //leer bien la especificacion para no restar valores incorrectos
		
	}

}
