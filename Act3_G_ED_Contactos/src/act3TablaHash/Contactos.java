package act3TablaHash;

import javax.swing.JOptionPane;

//Clase de prueba de manera dinámica para verificar el funcionamiento de la tbala hash sobre un problema real
public class Contactos {
	public static void main(String[] args) {
		int opcion = 0;
		String clave, nombre, telefono, correo;
		
		// Creando la tabla hash
		TablaHash<String, Contacto> tabla = new TablaHash<>();
		
		// Menú de opciones con JOptionPane
		do {
			try {
				// Definiendo las opciones del menú
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Insertar un nuevo contacto. \n" + 
						"2. Buscar un contacto. \n" +
						"3. Eliminar un contacto.\n" +
						"4. Mostar todos los contactos. \n" +
						"5. Salir \n" +
						"\nSeleccione una opción: ", "Árbol binario de búsqueda (ABB)", JOptionPane.QUESTION_MESSAGE));
				
				// Comprobar la opción seleccionada
				switch (opcion) {
					case 1:
						// Acción para agregar un contacto
						clave = JOptionPane.showInputDialog(null, "Ingrese como desea guardar el contacto: ", "Agregando", JOptionPane.QUESTION_MESSAGE);
						nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto: ", "Agregando nombre", JOptionPane.QUESTION_MESSAGE);
						telefono = JOptionPane.showInputDialog(null, "Ingrese el número de teléfono del contacto: ", "Agregando teléfono", JOptionPane.QUESTION_MESSAGE);
						correo = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico del contacto: ", "Agregando correo", JOptionPane.QUESTION_MESSAGE);
						
						tabla.insertar(clave, new Contacto(nombre, telefono, correo));
						System.out.println(" ");
						break;
					case 2:
						// Acción para buscar un contacto
						clave = JOptionPane.showInputDialog(null, "Ingrese el contacto que desea buscar:   ", "Buscar contacto", JOptionPane.QUESTION_MESSAGE);
						Contacto contactoBuscar = tabla.obtener(clave);
						
						if (contactoBuscar == null) {
							System.out.println("Contacto no encontrado");
						} else {
							System.out.println("Contacto " + contactoBuscar.getNombre() + ", Número de teléfono: " + contactoBuscar.getTelefono() + ", Correo electrónico: " + contactoBuscar.getCorreo());
						}
						
						System.out.println(" ");
						break;
					case 3:
						// Acción para borrar un contacto
						String claveEliminar = JOptionPane.showInputDialog(null, "Ingrese el contacto que desea borrar:   ", "Borrar contacto", JOptionPane.QUESTION_MESSAGE);
						tabla.eleminar(claveEliminar);
						System.out.println(" ");
						break;
					case 4:
						// Acción para mostar los contactos agregados
						tabla.mostrarContenido();
						System.out.println(" ");
						break;
					case 5:
						// Acción para salir
						JOptionPane.showMessageDialog(null, "Aplicación finalizada ", "Fin", JOptionPane.INFORMATION_MESSAGE);
						break;
					
				default:
	                JOptionPane.showMessageDialog(null, "Opción incorrecta ", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (NumberFormatException numero) {
                JOptionPane.showMessageDialog(null, "Error " + numero.getMessage(), "Error al seleccionar", JOptionPane.INFORMATION_MESSAGE);
			}
		} while (opcion != 5);
	}
}
