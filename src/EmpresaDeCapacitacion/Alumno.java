package EmpresaDeCapacitacion;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private Integer nroMatricula;
	private String nombre;
	private List<Capacitacion> capCompletadas;
	private List<Capacitacion> capEnCurso;
	
	
	
	public Alumno(Integer nroMatricula, String nombre) {
		this.nroMatricula = nroMatricula;
		this.nombre = nombre;
		this.capCompletadas = new ArrayList<Capacitacion>();
		this.capEnCurso = new ArrayList<Capacitacion>();
	}

	public Integer creditosObtenidos() {
		return capCompletadas.stream().mapToInt(c -> c.creditosObtenidos()).sum();
	}
	
	public void inscribir(Capacitacion c){
		try {
			if(c.inscribir(this)) {
				this.capEnCurso.add(c);
			}
		} catch (TallerCompletoException e) {
			System.out.println(e.getMessage());
		} catch (CreditosInsuficientesException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void aprobar(Capacitacion c) {
		c.aprobar(this);
		this.capEnCurso.remove(c);
		this.capCompletadas.add(c);
	}
	
	

}
