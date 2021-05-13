package EmpresaDeCapacitacion;

import java.util.function.Function;

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
	
	Function<Curso,Integer> creditosPorClases = (c) -> (c.cantidadClases>10 ? 10 : c.cantidadClases*2);
	Function<Docente,Integer> creditosPorAntiguedadDocente = (d) -> {
		if(d.getAntiguedad() < 5) {
			return 1;
		}else if(d.getAntiguedad() < 15) {
			return 3;
		}else return 5;
	};
	Function<Curso,Integer> creditosPorPrioridad = (t) -> (t.prioritaria ? 2 : 0);

	@Override
	public Integer creditosObtenidos() {
//		Integer creditos = 0;
//		creditos += 2*cantidadClases;
//		if(creditos>10)creditos=10;
//		creditos += this.antiguedadDocente();
//		if(this.prioritaria) creditos+=2;
//		return creditos;
		return creditosPorClases.apply(this) + creditosPorAntiguedadDocente.apply(this.docente) + creditosPorPrioridad.apply(this);
	}
	
//	public Integer antiguedadDocente() {
//		if(docente.getAntiguedad()>=0 && docente.getAntiguedad()<=4) return 1;
//		if(docente.getAntiguedad()>=5 && docente.getAntiguedad()<=14) return 3;
//		return 5;
//	}
	
	Function<Curso,Double> costoNormal = (c) -> (c.cantidadClases*c.duracionClases*c.docente.getCostoPorHora());
	Function<Curso,Double> costoEstrategico = (c) -> (c.cantidadClases*c.duracionClases*(c.docente.getCostoPorHora()+c.docente.getCostoPorHora()*0.10));
	Function<Curso,Double> costoCurso = (c) -> (c.prioritaria? costoEstrategico.apply(c) : costoNormal.apply(c));
	
	@Override
	public Double costoCapacitacion() {
//		Double costo = 0.0;
//		if(this.prioritaria) {
//			costo += cantidadClases*duracionClases*(docente.getCostoPorHora()+docente.getCostoPorHora()*0.10);
//		}else costo += cantidadClases*duracionClases*docente.getCostoPorHora();		
//		return costo;
		return costoCurso.apply(this);
	}

	@Override
	public String toString() {
		return "Curso [Nombre=" + nombre + " costo="+ this.costoCapacitacion()+ " credito="+ this.creditosObtenidos()+"]";
	}
	
	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}
	
	public Docente getDocente() {
		return docente;
	}

	@Override
	public Boolean inscribir(Alumno a) throws CreditosInsuficientesException {
		Boolean flag = true;
		if(a.creditosObtenidos()<this.creditosRequeridos) {
			flag = false;
			throw new CreditosInsuficientesException();
		}
		return flag;
	}

	@Override
	public void aprobar(Alumno a) {
				
	}
	
	

}
