package EmpresaDeCapacitacion;

public abstract class Capacitacion {
	protected String nombre;
	protected Boolean prioritaria;
	protected Tema tema;
	
	public abstract Integer creditosObtenidos();
	
	public abstract Double costoCapacitacion();
	
	public final Tema getTema() {
		return tema;
	}

	public final Boolean getPrioritaria() {
		return prioritaria;
	}
	
	public abstract Boolean inscribir(Alumno a) throws TallerCompletoException, CreditosInsuficientesException;
	
	public abstract void aprobar(Alumno a);
	
}
