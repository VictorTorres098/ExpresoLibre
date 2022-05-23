package expresoLibrePackage;

public class PruebasSimples {

	public static void main(String[] args) {
		Empresa test1 = new Empresa("pepe", "deps", 1);
		
		//test1.agregarDestino("buenos aire", 33);
		//test1.agregarDestino("buenos aire", 33);
		
		//cargo un trasporte 
		test1.agregarTrailer("esas", 2, 3, false, 1, 1);
		//cargo un destino 
		test1.agregarDestino("buenos aire", 33);
		//asigno un destino 
		test1.asignarDestino("esas", "buenos aire");
		
		//compruebo que destino no sea null y que contenga un obj
		System.out.println(test1.cargoExistosamenteDestino("esas"));
		
		
		
	}

}
