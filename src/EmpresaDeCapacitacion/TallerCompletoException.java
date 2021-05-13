package EmpresaDeCapacitacion;

public class TallerCompletoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "El taller seleccionado se encuentra completamente lleno";
	}

}
