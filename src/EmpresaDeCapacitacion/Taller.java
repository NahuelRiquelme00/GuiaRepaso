package EmpresaDeCapacitacion;

import java.util.function.Function;
import java.util.function.Predicate;

public class Taller extends Capacitacion {
	private Integer duracionHoras;
	private Double costoHoras;
	private Integer cupoMaximo;
	private Integer cantidadInscriptos;
	
	public Taller(Integer duracionHoras, Double costoHoras, Integer cupoMaximo, Integer cantidadInscriptos, String nom, Boolean flag, Tema tema) {
		this.nombre = nom;
		this.prioritaria = flag;
		this.tema = tema;
		this.duracionHoras = duracionHoras;
		this.costoHoras = costoHoras;
		this.cupoMaximo = cupoMaximo;
		this.cantidadInscriptos = cantidadInscriptos;
	}

	Function<Taller,Integer> creditosPorDuracion = (t) -> (t.duracionHoras>72 ? 12 : t.duracionHoras/6);
	Function<Taller,Integer> creditosPorPrioridad = (t) -> (t.prioritaria ? 1 : 0);

	@Override
	public Integer creditosObtenidos() {
		return creditosPorDuracion.apply(this) + creditosPorPrioridad.apply(this);
	}
	
	Function<Taller,Double> costoPorduracion = (t) -> (t.duracionHoras*t.costoHoras);
	Function<Double,Double> tallerEstrategico = (c) -> (c + c*0.20);
	Function<Taller,Double> costoTaller = (t) -> (t.prioritaria? tallerEstrategico.compose(costoPorduracion).apply(t) : costoPorduracion.apply(t));

	@Override
	public Double costoCapacitacion() {
//		Double costo = 0.0;
//		costo = (duracionHoras * costoHoras);
//		if(this.prioritaria) costo += (costo*0.20);
//		return costo;
		return costoTaller.apply(this);
	}



	@Override
	public String toString() {
		return "Taller [Nombre="+ this.nombre + " costo ="+ this.costoCapacitacion()+ " credito="+ this.creditosObtenidos()+"]";
	}



	@Override
	public Boolean inscribir(Alumno a) throws TallerCompletoException{
		Boolean flag = true;
		if(this.cantidadInscriptos>=this.cupoMaximo) {
			flag = false;
			throw new TallerCompletoException();
		}
		return flag;
	}



	@Override
	public void aprobar(Alumno a) {
		this.cantidadInscriptos--;		
	}
	
	
	

}
