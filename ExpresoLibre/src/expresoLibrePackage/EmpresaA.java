package expresoLibrePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EmpresaA {
	private String cuit;
	private String nombre;
	private ArrayList <Paquete> depositoRefrigerado;
	private ArrayList <Paquete> depositoComun;
	private int capacidadDeCadaDeposito;  
	private HashMap <String, Trasporte> flotaTrasportes;
	//implementacios viajes solo destino y y km
	private HashMap <String, Integer> viajes;
	//un sumador para cada deposito en volumen
	private double volumneActualRefrigerado = 0; 
	private double volumneActualcomun = 0; 
	
	public EmpresaA (String cuit, String nombre, int capacidadDeCadaDeposito) {
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
		//Si ya existe el destino se debe generar una excepción.
		public void agregarDestino(String destino, int km) {
			if(!existeDestino(destino)) {
				viajes.put(destino, km);
			}else {
				 throw new RuntimeException("El destino ya existe"); // se debe implementar correctamente la excepcion!!! 
			}
		}
		
		//Los siguientes métodos agregan los tres tipos de transportes a la
		//empresa, cada uno con sus atributos correspondientes.
		// La matrícula funciona como identificador del transporte.
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
		//Se asigna un destino a un transporte dada su matrícula (el destino
		//debe haber sido agregado previamente, con el método agregarDestino).
		//Si el destino no está registrado, se debe generar una excepción.
		public void asignarDestino(String matricula, String destino) {
			if(existeDestino(destino) && exiteMatriculaEnFlota(matricula)) {
				flotaTrasportes.get(matricula).agregarDestino(destino ,viajes.get(destino));
			}else {
				throw new RuntimeException("No estÃ¡ registrado el transporte");
			}
		}
		//Se incorpora un paquete a algún depósito de la empresa.
		// Devuelve verdadero si se pudo incorporar, es decir,
		// si el depósito acorde al paquete tiene suficiente espacio disponible.
		public boolean incorporarPaquete(String destino, double peso, double volumen, boolean necesitaRefrigeracion) {
			if(necesitaRefrigeracion) {
				volumneActualRefrigerado += volumen;
			}else {
				volumneActualcomun += volumen;
			}
			if(necesitaRefrigeracion && depositoDisponibleRefrigerado() ) {
				depositoRefrigerado.add(new Paquete(destino, peso, volumen, necesitaRefrigeracion));
				
				return true;
			}
			if(depositoDisponibleComun() && !necesitaRefrigeracion) {
				depositoComun.add(new Paquete(destino, peso, volumen, necesitaRefrigeracion));
				volumneActualcomun += volumen;
				return true;
			}
			volumneActualRefrigerado -= volumen;
			volumneActualcomun -= volumen;
			return false;
			
		}
		// Dado un ID de un transporte se pide cargarlo con toda la mercadería
		// posible, de acuerdo al destino del transporte. No se debe permitir
		// la carga si está en viaje o si no tiene asignado un destino.
		// Utilizar el depósito acorde para cargarlo.
		// Devuelve un double con el volumen de los paquetes subidos
		// al transporte.
		public double cargarTransporte(String matricula) {
				
			//para los depositos refrigerados
			
			if(flotaTrasportes.get(matricula).consultarDisponibilidad() && flotaTrasportes.get(matricula).exiteDestino() && flotaTrasportes.get(matricula).tieneRefrigeracion()) {
				Iterator it = depositoRefrigerado.iterator();
				while(it.hasNext() && flotaTrasportes.get(matricula).espacioRemolqueDisponible()) { //que el 
					Paquete p = (Paquete) it.next(); 					//necesito castearlo para acceder a los metodos
					flotaTrasportes.get(matricula).agregarPaquetes(p);  //agrego la "remolque"
					//volumenTotal += p.obtenerVolumen(); 				//sumo cada volumen del cada paquete
					volumneActualRefrigerado -= p.obtenerVolumen();     //descuento el volumen del depo
					it.remove(); 										//remove??? lo tiene que remover
				}
			}
			
			//para los que no necesitan refrigeracion (deposito comun)
			
			if(flotaTrasportes.get(matricula).consultarDisponibilidad() && flotaTrasportes.get(matricula).exiteDestino() && !flotaTrasportes.get(matricula).tieneRefrigeracion()) {
				Iterator itB = depositoComun.iterator();
				while(itB.hasNext() && flotaTrasportes.get(matricula).espacioRemolqueDisponible()) {
					Paquete p = (Paquete) itB.next(); //comprobar que se pase el objeto completo! 
					flotaTrasportes.get(matricula).agregarPaquetes(p);
					//volumenTotal += p.obtenerVolumen();
					volumneActualcomun -= p.obtenerVolumen();
					itB.remove();
				}
			}
			//new commit comp
			return flotaTrasportes.get(matricula).obtenerVolumen();		
		}
		// Inicia el viaje del transporte identificado por la
		// matrícula pasada por parámetro.
		// En caso de no tener mercadería cargada o de ya estar en viaje
		// se genera una excepción.
		public void iniciarViaje(String matricula) {
			Trasporte t = flotaTrasportes.get(matricula);
			if(t.remolqueCargado() && t.destinoActual()!=null) {
				t.iniciarViaje();
			}else {
				throw new RuntimeException("el trasporte no esta cargado o ya se encuentra en un viaje");
			}
			
			
		}//dos funciones en una???
		
		// Finaliza el viaje del transporte identificado por la 
		// matrícula pasada por parámetro.
		// El transporte vacía su carga y blanquea su destino, para poder
		// ser vuelto a utilizar en otro viaje.
		// Genera excepción si no está actualmente en viaje.
		public void finalizarViaje(String matricula) {
			Trasporte t = flotaTrasportes.get(matricula);
			if(t.consultarSiEstaDeViaje()) { 
				t.finalizarViaje(); //lo podria haber echo en una funcion?? preguntar
			}else {
				throw new RuntimeException("El trasporte no esta en viaje");
			}
			
		}
		// Obtiene el costo de viaje del transporte identificado por la
		// matrícula pasada por parámetro.
		// Genera Excepción si el transporte no está en viaje.
		public double obtenerCostoViaje(String matricula) {
			Trasporte t = flotaTrasportes.get(matricula);
			if(t.consultarSiEstaDeViaje()) {
				return t.devolverCosto();
			}else {
				throw new RuntimeException ("el transporte no esta en viaje");
			}
		}
		// Busca si hay algún transporte igual en tipo, destino y carga. //seria la misma cantidad de carga? //se tiene que devolver la matricula
		// En caso de que no se encuentre ninguno, se debe devolver null.
		//se podria utilizar String builder...
		public String obtenerTransporteIgual(String matricula) {
			String coicidencia = null;
			for(String key : flotaTrasportes.keySet()) {
				if(flotaTrasportes.get(matricula).equals(flotaTrasportes.get(key)) && !(flotaTrasportes.get(matricula).matricula().equals(flotaTrasportes.get(key).matricula()))) { // los dos trasportes tienen que tener un destino asignado!
					coicidencia = flotaTrasportes.get(key).matricula(); //se toma asi mismo....
				}
			}
			return coicidencia;
		}
		
		//Fin de Interface obligatoria los metodos que se agregen a continuacion son propios
		
		//Comprueba si si ya exite un trasporte con la mismo matricula
		private boolean exiteMatriculaEnFlota(String matricula) {
			return flotaTrasportes.containsKey(matricula);
		}
		//comprueba que no pase de limite los depositos!
		private boolean depositoDisponibleRefrigerado() {
			return this.volumneActualRefrigerado <= this.capacidadDeCadaDeposito;
		}
		private boolean depositoDisponibleComun() {
			return this.volumneActualcomun <= this.capacidadDeCadaDeposito;
		}
		private boolean existeDestino(String destino) {
			return viajes.containsKey(destino);
		}
		//consulta destino dada un matricula
		public boolean cargoExistosamenteDestino(String matricula){
			return flotaTrasportes.get(matricula).exiteDestino();
		}
}
