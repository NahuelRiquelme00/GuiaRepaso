package EmpresaDeCapacitacion;

public class App {
	
	
	public static void main(String[] args) {
		
		//prueba1();
		//prueba2();
		//prueba3();
		prueba4();
		
	}
	
	static void prueba1() {
		Docente d1 = new Docente("0","0",8,0.0);
		Capacitacion c1 = new Taller(100,0.0,0,0,"0",true,Tema.GESTION);
		Capacitacion c2 = new Curso(d1,5,0,0,"0",false,Tema.IA);
		Empleado e1 = new Empleado("Nahuel");
		
		e1.agregarCapacitacion(c1);
		e1.agregarCapacitacion(c2);
		
		System.out.println(e1.creditosObtenidos());
		
	}
	
	static void prueba2() {
		Docente d1 = new Docente("0","0",8,5.0);
		Capacitacion c1 = new Taller(10,2.0,0,0,"Datos",true,Tema.GESTION); //10*2 + 20% = 24
		Capacitacion c2 = new Curso(d1,5,2,0,"0",true,Tema.IA); // 55
		Empleado e1 = new Empleado("Nahuel");
		
		e1.agregarCapacitacion(c1);
		e1.agregarCapacitacion(c2);
		
		System.out.println(e1.costoCapacitacion()); //79
		
	}
	
	static void prueba3() {
		Docente d1 = new Docente("Martin","0",8,5.0);
		Docente d2 = new Docente("Pepe","0",20,5.0);
		Docente d3 = new Docente("Roberto","0",8,5.0);
		Capacitacion c1 = new Taller(10,2.0,0,0,"AMI",true,Tema.GESTION); //10*2 + 20% = 24
		Capacitacion c2 = new Curso(d1,5,2,1,"DAN",false,Tema.IA); // 50
		Capacitacion c3 = new Curso(d2,10,2,2,"DIED",false,Tema.IA); // 100
		Capacitacion c4 = new Curso(d3,20,2,1,"DAM",false,Tema.PROGRAMACION); // 200
		Empleado e1 = new Empleado("Nahuel");
		
		e1.agregarCapacitacion(c1);
		e1.agregarCapacitacion(c2);
		e1.agregarCapacitacion(c3);
		e1.agregarCapacitacion(c4);
		
		System.out.println(e1.costoCapacitacion()); //374
		
		System.out.println(e1.costoPromedioCapacitacion()); //93.5
		
		System.out.println(e1.listaPorTemas(Tema.IA).toString()); // 50 , 100
		
		System.out.println(e1.buscarDocente().toString()); //Pepe
		
		System.out.println(e1.listaEstrategicas().toString()); //AMI
		
		System.out.println(e1.listaCapacitaciones().toString()); //AMI - DAN - DAM - DIED
		
		
		
	}

	static void prueba4() {
		
		Docente d2 = new Docente("Pepe","0",20,5.0);
		Capacitacion c3 = new Curso(d2,10,2,0,"DIED",false,Tema.IA);
		Capacitacion c1 = new Taller(10,2.0,10,10,"AMI",true,Tema.GESTION);
		Alumno a1 = new Alumno(1717,"Nahuel Riquelme");
		
		a1.inscribir(c3);
		a1.inscribir(c1);
		
	}
}
