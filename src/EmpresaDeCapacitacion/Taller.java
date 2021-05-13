package EmpresaDeCapacitacion;

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



	@Override
	public Integer creditosObtenidos() {
		Integer creditos = 0;
		creditos = duracionHoras/6;
		if (creditos > 12) creditos = 12;
		if (this.prioritaria) creditos+=1;
		return creditos;
	}



	@Override
	public Double costoCapacitacion() {
		Double costo = 0.0;
		costo = (duracionHoras * costoHoras);
		if(this.prioritaria) costo += (costo*0.20);
		return costo;
	}



	@Override
	public String toString() {
		return "Taller [Nombre = "+ this.nombre + "]";
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
