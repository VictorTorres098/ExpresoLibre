package expresoLibrePackage;

import java.util.ArrayList;
import java.util.Iterator;

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
	private ArrayList<Paquete> despositoMegaTrailer;
	private boolean disponible;
	private String tipo = "MegaTrailer";
	private double distanciaMax = 500; //solamente los mayores a 500km
	
	public MegaTrailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm, double segCarga, double costoFijo, double costoComida) { //faltan variables
		this.matricula = matricula;
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.tieneRefrigeracion = tieneRefrigeracion;
		this.costoKm = costoKm;
		this.segCarga = segCarga;
		this.costoFijo = costoFijo;
		this.costoComida = costoComida;
		despositoMegaTrailer = new ArrayList<Paquete>();
		disponible = true;
	}

	@Override
	public boolean tieneRefrigeracion() {
		return this.tieneRefrigeracion;
	}

	@Override
	public double obtenerCargaMaxima() {
		return this.cargaMax;
	}

	@Override
	public double obtenerVolumen() {
		double volumen = 0;
		Iterator itr = despositoMegaTrailer.iterator();
		while(itr.hasNext()) {
			Paquete p = (Paquete) itr.next();
			volumen += p.obtenerVolumen();
		}
		return volumen;
	}

	@Override
	public double distanciaMáxima() {
		return 10000000; //cambiar por un mejor implementacion
	}

	@Override
	public boolean consultarDisponibilidad() {
		return this.disponible;
	}

	@Override
	public double costoPorKM() {
		return costoKm * this.viaje.consultarDistancia(); //no deberia hacer este calculo aca
	}

	@Override
	public void vaciarCarga() {
		Iterator itr = despositoMegaTrailer.iterator();
		while(itr.hasNext()) {
			itr.remove();
		}
		
	}

	@Override
	public void cambiarEstadoDisponible() {
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
			throw new RuntimeException("Ya exite un destino para este trasporte");
		}
		
	}

	@Override
	public boolean exiteDestino() {
		return viaje!=null;
	}

	@Override
	public boolean espacioRemolqueDisponible() {
		return(cargaMax > 0 && capacidad > 0);
	}

	@Override
	public void agregarPaquetes(Paquete paquete) {
		despositoMegaTrailer.add(paquete);
		this.cargaMax -= paquete.obtenerPeso();
		this.capacidad -= paquete.obtenerVolumen();
	}

	@Override
	public boolean remolqueCargado() {
		return despositoMegaTrailer.size() > 0;
	}
	@Override
	public boolean equals(Object trasporte) {
		boolean resultado = false;
		if(trasporte instanceof MegaTrailer) {
			MegaTrailer m = (MegaTrailer) trasporte;
			resultado = (this.dameTipo().equals(m.dameTipo()) && this.destinoActual().equals(m.destinoActual()) && this.obtenerVolumen() == m.obtenerVolumen());
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

	@Override
	public double devolverCosto() {
		return costoPorKM() + this.segCarga + this.costoFijo + this.costoComida;
	}

	@Override
	public boolean consultarSiEstaDeViaje() {
		return this.disponible;
	}

	@Override
	public void iniciarViaje() {
		this.disponible = false;
		
	}

	@Override
	public void finalizarViaje() {
		this.disponible = true;
		
	}



}
