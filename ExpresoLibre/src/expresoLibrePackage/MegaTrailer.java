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
	private ArrayList<Paquete> despositoMegaTrailer;
	private boolean disponible;
	private String tipo = "MegaTrailer";
	
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
		return despositoMegaTrailer.size();
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



}
