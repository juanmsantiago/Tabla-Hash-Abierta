package act3TablaHash;

//Clase de prueba para verificar el funcionamiento de la tabla Hash
public class TestTablaHash {
	public static void main(String[] args) {
		TablaHash<String, Contacto> tabla = new TablaHash<>();
		
		// Insertar datos en la tabla hash
		tabla.insertar("Juan", new Contacto("Juan", "1234567890", "juan@dominio.com"));
		tabla.insertar("Manuel", new Contacto("Manuel", "1234567890", "manuel@dominio.com"));
		tabla.insertar("Mariana", new Contacto("Mariana", "1234567890", "mariana@dominio.com"));
		tabla.insertar("Moises", new Contacto("Moises", "1234567890", "moises@dominio.com"));
		tabla.insertar("Alejandra", new Contacto("Alejandra", "1234567890", "alejandra@dominio.com"));
		tabla.insertar("Itzel", new Contacto("Itzel", "1234567890", "itzel@dominio.com"));
		tabla.insertar("Magali", new Contacto("Magali", "1234567890", "magali@dominio.com"));
	

		// Obtener datos de la tabla hash
		Contacto contactoJuan = tabla.obtener("Juan");
        Contacto contactoMariana = tabla.obtener("Mariana");
        Contacto contactoMoises = tabla.obtener("Moises");
        Contacto contactoAlejandra = tabla.obtener("Alejandra");
        
		System.out.println("Contacto " + contactoJuan.getNombre() + ", Número de teléfono: " + contactoJuan.getTelefono() + ", Correo electrónico: " + contactoJuan.getCorreo());
		System.out.println("Contacto " + contactoMariana.getNombre() + ", Número de teléfono: " + contactoMariana.getTelefono() + ", Correo electrónico: " + contactoMariana.getCorreo());
		System.out.println("Contacto " + contactoMoises.getNombre() + ", Número de teléfono: " + contactoMoises.getTelefono() + ", Correo electrónico: " + contactoMoises.getCorreo());
		System.out.println("Contacto " + contactoAlejandra.getNombre() + ", Número de teléfono:" + contactoAlejandra.getTelefono() + ", Correo electrónico: " + contactoAlejandra.getCorreo());
		
		
		System.out.println(" ");
		tabla.mostrarContenido();
		
		System.out.println(" ");
		
		// Eliminar datos de la tabla hash
		tabla.eleminar("Juan");
		Contacto contactoEliminado = tabla.obtener("Juan");
		
		// Comprobar si los datos se eliminaron con éxito
		if (contactoEliminado == null) {
			System.out.println("Contacto no encontrado");
		} else {
			System.out.println("Contacto " + contactoEliminado.getNombre() + ", Número de teléfono: " + contactoEliminado.getTelefono() + ", Correo electrónico: " + contactoEliminado.getCorreo());
		}
		
		System.out.println(" ");
		tabla.mostrarContenido();	
	}
}
