package act3TablaHash;

//Clase que representa el contacto
public class Contacto {
	private String nombre;
    private String telefono;
    private String correo;

    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre: " + nombre +
	           ", Teléfono: " + telefono +
	           ", Correo electrónico: " + correo;
	}
}
