package expresoLibrePackage;

public class Paquete {
	private String destino;
	private double peso;
	private double volumen;
	private boolean necesitaRefrigeracion;
	
	public Paquete(String destino, double peso, double volumen, boolean necesitaRefrigeracion) {
		this.destino = destino;
		this.peso = peso;
		this.volumen = volumen;
		this.necesitaRefrigeracion = necesitaRefrigeracion;
	}
	
	public double obtenerPeso() {
		return 0;
	}
	public double obtenerVolumen() {
		return volumen;
	}
	public String consultarDestino() {
		return "vacion";
	}
	public boolean requiereRefrigeracion() {
		return necesitaRefrigeracion;
	}
	
	
	
	

}
