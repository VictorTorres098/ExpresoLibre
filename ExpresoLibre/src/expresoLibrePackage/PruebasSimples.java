package expresoLibrePackage;

public class PruebasSimples {

	public static void main(String[] args) {
		Empresa test1 = new Empresa("pepe", "deps", 50);
//		
//		//test1.agregarDestino("buenos aire", 33);
//		//test1.agregarDestino("buenos aire", 33);
//		
//		//cargo un trasporte 
//		test1.agregarTrailer("esas", 2, 3, false, 1, 1);
//		//cargo un destino 
//		test1.agregarDestino("buenos aire", 33);
//		//asigno un destino 
//		test1.asignarDestino("esas", "buenos aire");
//		
//		//compruebo que destino no sea null y que contenga un obj
//		System.out.println(test1.cargoExistosamenteDestino("esas"));
		
		//cargar un trasporte (trailer)
		
		
//		//cargo un trasporte
//		test1.agregarTrailer("1234", 3, 5, true, 1, 1); 
//		//cargo un destino
//		test1.agregarDestino("buenos aires", 30);
//		//cargo un destino al trasporte
//		test1.asignarDestino("1234", "buenos aires");
//		
//		//cargo dos paquete
//		test1.incorporarPaquete("buenos aires", 1, 1, true);
//		test1.incorporarPaquete("buenos aires", 1, 1, true);
//		
//		//cargo el trasporte con los paquetes del deposito
//		System.out.println(test1.cargarTransporte("1234"));
//		
		//cargo dos trasportes iguales
		test1.agregarTrailer("1234", 2, 3, true, 1, 1);
		test1.agregarTrailer("4321", 2, 3, true, 1, 1);
		
		//tengo que asiganarle un destino o tira error corregir!
		
//		//agrego el destino
//		test1.agregarDestino("buenos aires", 30);
//		test1.agregarDestino("codoba", 100);
//		
//		//asigno el destino a los dos trasportes
//		test1.asignarDestino("1234", "buenos aires");
//		test1.asignarDestino("4321", "buenos aires");
//		
//		System.out.print(test1.obtenerTransporteIgual("1234"));
		
		
		///FALTAN IREPS Y LIMITADORES DE ALGUNAS FUNCIONES!!!!!!!!!!!!!!!!!!
		
		//carga correcta de volumen
		//agrego 1 trasporte
		test1.agregarTrailer("12345", 12000, 60, true, 5, 100);
		
		//agrego 2 paquete
		test1.incorporarPaquete("cordoba", 2, 5, true);
		test1.incorporarPaquete("cordoba", 2, 10, true);
		test1.incorporarPaquete("cordoba", 2, 11, false);
		
		//agrego un destino
		test1.agregarDestino("cordoba", 350);
		
		//asigno un destino al trasporte
		test1.asignarDestino("12345", "cordoba");
		
		//cargo el trasporte
		System.out.println(test1.cargarTransporte("12345"));
		
		System.out.println(test1.obtenerCostoViaje("12345"));
		
		
		
		
	}

}
