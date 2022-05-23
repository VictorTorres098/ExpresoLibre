package expresoLibrePackage;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
	private String cuit;
	private String nombre;
	private ArrayList <Paquete> depositoRefrigerado;
	private ArrayList <Paquete> depositoComun;
	private int capacidadDeCadaDeposito;  //se cambio de nombre por el test para mas adelante // no tiene que pasar de esa capacidad
	private HashMap <String, Trasporte> flotaTrasportes;
	//implementacios viajes solo destino y y km
	private HashMap <String, Integer> viajes;
	
	public Empresa (String cuit, String nombre, int capacidadDeCadaDeposito) {
		this.cuit = cuit;
		this.nombre = nombre;
		this.capacidadDeCadaDeposito = capacidadDeCadaDeposito;
		flotaTrasportes = new HashMap <String, Trasporte>();
		depositoRefrigerado = new ArrayList<>();
		depositoComun = new ArrayList<>();
		
		viajes = new HashMap<String, Integer>();
	}
	//INTERFAZ OBLIGATORIA//
	
	//Incorpora un nuevo destino y su distancia en km.
	//Es requisito previo, para poder asignar un destino a un transporte.
	//Si ya existe el destino se debe generar una excepci�n.
	public void agregarDestino(String destino, int km) {
		if(!existeDestino(destino)) {
			viajes.put(destino, km);
		}else {
			System.out.print("Ya existe el destino"); // se debe implementar correctamente la excepcion!!! 
		}
	}
	
	//Los siguientes m�todos agregan los tres tipos de transportes a la
	//empresa, cada uno con sus atributos correspondientes.
	// La matr�cula funciona como identificador del transporte.
	public void agregarTrailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKM, double segCarga) {
		if(!(exiteMatriculaEnFlota(matricula))) {
			flotaTrasportes.put(matricula, new Trailer(matricula, cargaMax, capacidad, tieneRefrigeracion, costoKM, segCarga));
		}		
	}
	public void agregarMegaTrailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm, double segCarga, double costoFijo, double costoComida) {
		if(!exiteMatriculaEnFlota(matricula)) {
			flotaTrasportes.put(matricula, new MegaTrailer(matricula, cargaMax, capacidad, tieneRefrigeracion, costoKm, segCarga, costoFijo, costoComida));
		}
	}
	void agregarFlete(String matricula, double cargaMax, double capacidad, double costoKm, int cantAcompaniantes, double costoPorAcompaniante) {
		if(!exiteMatriculaEnFlota(matricula)) {
			flotaTrasportes.put(matricula, new Flete(matricula, cargaMax, capacidad, costoKm, cantAcompaniantes, costoPorAcompaniante));
		}
	}
	//Se asigna un destino a un transporte dada su matr�cula (el destino
	//debe haber sido agregado previamente, con el m�todo agregarDestino).
	//Si el destino no est� registrado, se debe generar una excepci�n.
	public void asignarDestino(String matricula, String destino) {
		if(existeDestino(destino) && exiteMatriculaEnFlota(matricula)) {
			flotaTrasportes.get(matricula).agregarDestino(destino ,viajes.get(destino));
		}
	}
	//Se incorpora un paquete a alg�n dep�sito de la empresa.
	// Devuelve verdadero si se pudo incorporar, es decir,
	// si el dep�sito acorde al paquete tiene suficiente espacio disponible.
	public boolean incorporarPaquete(String destino, double peso, double volumen, boolean necesitaRefrigeracion) {
		if(necesitaRefrigeracion && depositoDisponibleRefrigerado() ) {
			depositoRefrigerado.add(new Paquete(destino, peso, volumen, necesitaRefrigeracion));
			return true;
		}
		if(depositoDisponibleComun() && !necesitaRefrigeracion) {
			depositoRefrigerado.add(new Paquete(destino, peso, volumen, necesitaRefrigeracion));
			return true;
		}
		return false;
		
	}
	// Dado un ID de un transporte se pide cargarlo con toda la mercader�a
	// posible, de acuerdo al destino del transporte. No se debe permitir
	// la carga si est� en viaje o si no tiene asignado un destino.
	// Utilizar el dep�sito acorde para cargarlo.
	// Devuelve un double con el volumen de los paquetes subidos
	// al transporte.
	public double cargarTransporte(String matricula) {
		return 0;
	}
	// Inicia el viaje del transporte identificado por la
	// matr�cula pasada por par�metro.
	// En caso de no tener mercader�a cargada o de ya estar en viaje
	// se genera una excepci�n.
	public void iniciarViaje(String matricula) {
		
	}
	// Finaliza el viaje del transporte identificado por la 
	// matr�cula pasada por par�metro.
	// El transporte vac�a su carga y blanquea su destino, para poder
	// ser vuelto a utilizar en otro viaje.
	// Genera excepci�n si no est� actualmente en viaje.
	public void finalizarViaje(String matricula) {
		
	}
	// Obtiene el costo de viaje del transporte identificado por la
	// matr�cula pasada por par�metro.
	// Genera Excepci�n si el transporte no est� en viaje.
	public double obtenerCostoViaje(String matricula) {
		return 0;
	}
	// Busca si hay alg�n transporte igual en tipo, destino y carga.
	// En caso de que no se encuentre ninguno, se debe devolver null.
	public String obtenerTransporteIgual(String matricula) {
		return "vacio";
	}
	
	//Fin de Interface obligatoria los metodos que se agregen a continuacion son propios
	
	//Comprueba si si ya exite un trasporte con la mismo matricula
	private boolean exiteMatriculaEnFlota(String matricula) {
		return flotaTrasportes.containsKey(matricula);
	}
	//comprueba que no pase de limite los depositos!
	private boolean depositoDisponibleRefrigerado() {
		return depositoRefrigerado.size() <= capacidadDeCadaDeposito;
	}
	private boolean depositoDisponibleComun() {
		return depositoComun.size() <= capacidadDeCadaDeposito;
	}
	private boolean existeDestino(String destino) {
		return viajes.containsKey(destino);
	}
	//consulta destino dada un matricula
	public boolean cargoExistosamenteDestino(String matricula){
		return flotaTrasportes.get(matricula).exiteDestino();
	}
}
