package act3TablaHash;

//Clase que representa un par clave-valor
public class ParClaveValor<C, V> {
	C clave; // Tipo de dato de la clave.
	V valor; // Tipo de dato del valor asociado.
	
	// Constructor
	public ParClaveValor(C clave, V valor) {
		this.clave = clave;
		this.valor = valor;
	}
}
