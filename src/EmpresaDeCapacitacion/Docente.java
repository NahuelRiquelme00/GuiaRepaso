package EmpresaDeCapacitacion;

public class Docente {
	private String nombre;
	private String email;
	private Integer antiguedad;
	private Double costoPorHora;
	
	public Docente(String nombre, String email, Integer antiguedad, Double costoPorHora) {
		this.nombre = nombre;
		this.email = email;
		this.antiguedad = antiguedad;
		this.costoPorHora = costoPorHora;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}
	
	public Double getCostoPorHora() {
		return costoPorHora;
	}

	@Override
	public String toString() {
		return "Docente [nombre=" + nombre + "]";
	}
	
	

}
