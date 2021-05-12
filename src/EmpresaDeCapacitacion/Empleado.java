package EmpresaDeCapacitacion;

import java.util.ArrayList;
import java.util.List;
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
//		int sum = 0;
//		for(Capacitacion c : capacitaciones) {
//			sum += c.creditosObtenidos();
//		}
//		return sum;
		return capacitaciones.stream().mapToInt(c -> c.creditosObtenidos()).sum();
	}
	
	public Double costoCapacitacion() {
		return capacitaciones.stream().mapToDouble(c -> c.costoCapacitacion()).sum();
	}
	
	public Double costoPromedioCapacitacion() {
		return this.costoCapacitacion()/this.capacitaciones.size();
	}
	
	public List<Capacitacion> listaPorTemas(Tema tema){
		return capacitaciones.stream().filter( c -> c.getTema()==tema).sorted((c1,c2) -> c1.costoCapacitacion().compareTo(c2.costoCapacitacion())).collect(Collectors.toList());	
	}
	
	public List<Docente> buscarDocente() {
		int maxCreditos = capacitaciones.stream().filter(c -> c instanceof Curso).mapToInt(c -> ((Curso)c).getCreditosRequeridos()).max().getAsInt();
		return capacitaciones.stream().filter(c -> c instanceof Curso).filter(c -> ((Curso)c).getCreditosRequeridos()==maxCreditos).map(c->((Curso)c).getDocente()).collect(Collectors.toList());
	}
	
	public List<Capacitacion> listaEstrategicas(){
		return capacitaciones.stream().filter(c -> c.getPrioritaria()==true).collect(Collectors.toList());
	}
	
	public List<Capacitacion> listaCapacitaciones(){
		return capacitaciones.stream().sorted( (c1,c2) -> c1.creditosObtenidos().compareTo(c2.creditosObtenidos())).collect(Collectors.toList());
	}


	
	
}
