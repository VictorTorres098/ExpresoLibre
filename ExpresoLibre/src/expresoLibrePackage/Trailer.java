package expresoLibrePackage;

import java.util.ArrayList;
import java.util.Iterator;

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
	private String tipo = "Trailer";
	
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
		Iterator itr = depositoTrailer.iterator();
		while(itr.hasNext()) {
			itr.remove();
		}
		
	}

	@Override
	public void cambiarEstadoDisponible() { //si esta true pasa false y si esta false pasa true
		if(disponible) {
			this.disponible = false;
		}else {
			this.disponible = true;
		}
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

	@Override
	public boolean remolqueCargado() {
		return depositoTrailer.size() > 0; 
	}
	@Override
	public boolean equals(Object trasporte) {
		boolean resultado = false;
		if(trasporte instanceof Trailer) {
			Trailer t = (Trailer) trasporte;
			resultado = (this.dameTipo().equals(t.dameTipo()) && this.destinoActual().equals(t.destinoActual()) && this.obtenerVolumen() == t.obtenerVolumen());
		}
		return resultado;	
	}

	@Override
	public String dameTipo() {
		return this.tipo;
	}

	@Override
	public String destinoActual() {
		return this.viaje.consultarDestino();
	}

	@Override
	public String matricula() {
		return this.matricula;
	}

}
