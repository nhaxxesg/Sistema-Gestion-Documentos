package app.entidades.externos;


public class ValidarInformacion {

	public static boolean esNulo(Object entidad) {
		boolean esNulo = true;
		if (entidad != null) {
			esNulo = false;
		}
		return esNulo;
	}

}
