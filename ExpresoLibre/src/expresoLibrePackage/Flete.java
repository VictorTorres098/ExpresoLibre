package expresoLibrePackage;

import java.util.ArrayList;
import java.util.Iterator;

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
	private String tipo = "Flete";
	private double destinoMax = 500;
	
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
		return false;
	}

	@Override
	public double obtenerCargaMaxima() {
		return this.cargaMax;
	}

	@Override
	public double obtenerVolumen() {
		double volumen = 0;
		Iterator itr = depositoFlete.iterator();
		while(itr.hasNext()) {
			Paquete p = (Paquete) itr.next();
			volumen += p.obtenerVolumen();
		}
		return volumen;
	}

	@Override
	public double distanciaMáxima() {
		return this.destinoMax;
	}

	@Override
	public boolean consultarDisponibilidad() {
		return disponible;
	}

	@Override
	public double costoPorKM() {
		return costoKm * this.viaje.consultarDistancia(); //se podria hacer en obtener costo
	}

	@Override
	public void vaciarCarga() {
		Iterator itr = depositoFlete.iterator();
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
	public void agregarDestino(String destino, Integer km) {
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
		return (cargaMax > 0 && capacidad > 0);
	}

	@Override
	public void agregarPaquetes(Paquete paquete) {
		depositoFlete.add(paquete);	
		this.cargaMax -= paquete.obtenerPeso();
		this.capacidad -= paquete.obtenerVolumen();
	}

	@Override
	public boolean remolqueCargado() {
		return depositoFlete.size() > 0;
	}
	@Override
	public boolean equals(Object trasporte) {
		boolean resultado = false;
		if(trasporte instanceof Flete) {
			Flete f = (Flete) trasporte;
			resultado = (this.dameTipo().equals(f.dameTipo()) && this.destinoActual().equals(f.destinoActual()) && this.obtenerVolumen() == f.obtenerVolumen());
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
		return costoPorKM() + (this.cantAcompaniantes * this.costoPorAcompaniante);
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
