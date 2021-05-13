package EmpresaDeCapacitacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Empleado {
	private String nombre;
	private List<Capacitacion> capacitaciones;
	
	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
		this.capacitaciones = new ArrayList<Capacitacion>();
	}
	
	public void agregarCapacitacion(Capacitacion c) {
		capacitaciones.add(c);
	}
	public Integer creditosObtenidos() {
		return capacitaciones.stream()
							 .mapToInt(c -> c.creditosObtenidos())
							 .sum();
	}
	
	public Double costoCapacitacion() {
		return capacitaciones.stream()
							 .mapToDouble(c -> c.costoCapacitacion())
							 .sum();
	}
	
	public Double costoPromedioCapacitacion() {
		OptionalDouble resultado;
		resultado = this.capacitaciones.stream()
									   .mapToDouble(c -> c.costoCapacitacion())
									   .average();
		return resultado.orElse(0.0);
//		return this.costoCapacitacion()/this.capacitaciones.size();
	}
	
	
	public List<Capacitacion> listaPorTemas(Tema tema){
		return capacitaciones.stream()
							.filter( c -> c.getTema().equals(tema))
							.sorted((c1,c2) -> c2.costoCapacitacion().compareTo(c1.costoCapacitacion()))//Orden decreciente - De mayor a menor
							.collect(Collectors.toList());	
	}
	
	Function<List<Capacitacion>, Integer> maxCreditosRequeridos = (c) -> (c.stream()
																				.filter(d -> d instanceof Curso)
																				.mapToInt(d -> ((Curso)d).getCreditosRequeridos())
																				.max().getAsInt());
	
	public List<Docente> buscarDocente() {
//		int maxCreditos = capacitaciones.stream()
//										.filter(c -> c instanceof Curso)
//										.mapToInt(c -> ((Curso)c).getCreditosRequeridos())
//										.max().getAsInt();
//		return capacitaciones.stream()
//							 .filter(c -> c instanceof Curso)
//							 .filter(c -> ((Curso)c).getCreditosRequeridos()==maxCreditos)
//							 .map(c->((Curso)c).getDocente())
//							 .collect(Collectors.toList());
		return capacitaciones.stream()
		 .filter(c -> c instanceof Curso)
		 .filter(c -> ((Curso)c).getCreditosRequeridos()==maxCreditosRequeridos.apply(capacitaciones))
		 .map(c->((Curso)c).getDocente())
		 .collect(Collectors.toList());
	}
	
	public List<Capacitacion> listaEstrategicas(){
		return capacitaciones.stream()
							 .filter(c -> c.getPrioritaria()==true)
							 .collect(Collectors.toList());
	}
	
	public List<Capacitacion> listaCapacitaciones(){
		return capacitaciones.stream()
							 .sorted( (c1,c2) -> c2.creditosObtenidos().compareTo(c1.creditosObtenidos()))
							 .collect(Collectors.toList());
	}


	
	
}
