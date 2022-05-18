package expresoLibrePackage;

public class Viaje {
	private String destino;
	private int km;
	
	public Viaje(String destino, int km) {
		this.destino = destino;
		this.km = km;
	}
	public String consultarDestino() {
		return destino;
	}
	public int consultarDistancia() {
		return km;
	}
	
}
