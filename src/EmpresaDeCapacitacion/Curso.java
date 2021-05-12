package EmpresaDeCapacitacion;

public class Curso extends Capacitacion {
	private Docente docente;
	private Integer cantidadClases;
	private Integer duracionClases;
	private Integer creditosRequeridos;
	
	public Curso(Docente docente, Integer cantidadClases, Integer duracionClases, Integer creditosRequeridos, String nom, Boolean flag, Tema tema) {
		this.nombre = nom;
		this.prioritaria = flag;
		this.tema = tema;
		this.docente = docente;
		this.cantidadClases = cantidadClases;
		this.duracionClases = duracionClases;
		this.creditosRequeridos = creditosRequeridos;
	}

	@Override
	public Integer creditosObtenidos() {
		Integer creditos = 0;
		creditos += 2*cantidadClases;
		if(creditos>10)creditos=10;
		creditos += this.antiguedadDocente();
		if(this.prioritaria) creditos+=2;
		return creditos;
	}
	
	public Integer antiguedadDocente() {
		if(docente.getAntiguedad()>=0 && docente.getAntiguedad()<=4) return 1;
		if(docente.getAntiguedad()>=5 && docente.getAntiguedad()<=14) return 3;
		return 5;
	}

	@Override
	public Double costoCapacitacion() {
		Double costo = 0.0;
		if(this.prioritaria) {
			costo += cantidadClases*duracionClases*(docente.getCostoPorHora()+docente.getCostoPorHora()*0.10);
		}else costo += cantidadClases*duracionClases*docente.getCostoPorHora();		
		return costo;
	}

	@Override
	public String toString() {
		return "Curso [Nombre=" + nombre + " costo ="+ this.costoCapacitacion()+"]";
	}
	
	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}
	
	public Docente getDocente() {
		return docente;
	}
	
	

}
