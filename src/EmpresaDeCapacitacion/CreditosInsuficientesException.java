package EmpresaDeCapacitacion;

public class CreditosInsuficientesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "Sus creditos son insuficiente para inscribirse en el curso seleccionado";
	}
	

}
