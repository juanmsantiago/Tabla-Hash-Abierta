package act3TablaHash;

import java.util.LinkedList;
// 	Clase de la tabla hash abierta.
public class TablaHash <C, V> {
	
	// Constante que se utiliza para definir el tamaño inicial de la tabla.
	private static final int CAPACIDAD_INICIAL = 16;
	// Constante que se utiliza para determinar cuándo se debe realizar la redispersión directa de la tabla hash.
	private static final double UMBRAL_FACTOR_CARGA = 0.75;
	
	private LinkedList<ParClaveValor<C, V>>[] tabla; //Tabla
	private int tamaño; //contador que se utiliza para rastrear el número de elementos almacenados en la tabla hash. 
	
	// Constructor
	public TablaHash() {
		tabla = new LinkedList[CAPACIDAD_INICIAL];
		tamaño = 0;
	}
	
	// Método hash
	private int hash(C clave) {
		String strClave = (String) clave;
		int hash = 0;
		
		for (int i = 0; i < strClave.length(); i++) {
			hash = 31 * strClave.charAt(i);
		}
		
		return hash % tabla.length;
		//return Math.abs(clave.hashCode() % tabla.length);
	}
	
	// Método para insertar clave-calor en la tbala hash.
	public void insertar(C clave, V valor) {
		if (clave== null) {
			throw new IllegalArgumentException("No se permiten claves nulas.");
		}
		
		int indice = hash(clave);
		
		if (tabla[indice] == null) {
			tabla[indice] = new LinkedList<>();
		}
		
		for (ParClaveValor<C, V> par : tabla[indice]) {
			if (par.clave.equals(clave)) {
				par.valor = valor;
				return;
			}
		}
		
		tabla[indice].add(new ParClaveValor<>(clave, valor));
		tamaño++;
		
		if(obtenerFactorDeCarga()> UMBRAL_FACTOR_CARGA) {
			redispersionDirecta();
		}
		
	}
	
	// Método para buscar un valor asociado con una clave dada en la tabla hash.
	public V obtener(C clave) {
        int indice = hash(clave);
        
        if (tabla[indice] == null) {
            return null;
        }

        for (ParClaveValor<C, V> par : tabla[indice]) {
            if (par.clave.equals(clave)) {
                return par.valor;
            }
        }

        return null;
	}
	
	// Método para eliminar un par clave-valor de la tabla hash.
	public void eleminar(C clave) {
		int indice = hash(clave);
		
        if (tabla[indice] == null) {
        	System.out.println("El elemento que desea eliminar no se encuentra.");
            return;
        }

        for (ParClaveValor<C, V> par : tabla[indice]) {
            if (par.clave.equals(clave)) {
                tabla[indice].remove(par);
                tamaño--;
                
                if (obtenerFactorDeCarga() < 0.25) {
					redispersionInversa();
				}
                
                System.out.println("Elemento eliminado.");
                
                return;
            }
        }
	}
	
	// Método para calcula el factor de carga de la tabla hash.
	private double obtenerFactorDeCarga() {
		return (double) tamaño / tabla.length;
	}
	
	// Método para realiza la redispersión directa.
	private void redispersionDirecta() {
		int nuevaCapacidad = tabla.length * 2;
        LinkedList<ParClaveValor<C, V>>[] nuevaTabla = new LinkedList[nuevaCapacidad];

        for (LinkedList<ParClaveValor<C, V>> lista : tabla) {
            if (lista != null) {
                for (ParClaveValor<C, V> par : lista) {
                    int nuevoIndice = Math.abs(par.clave.hashCode() % nuevaCapacidad);
                    
                    if (nuevaTabla[nuevoIndice] == null) {
                    	nuevaTabla[nuevoIndice] = new LinkedList<>();
                    }
                    
                    nuevaTabla[nuevoIndice].add(par);
                }
            }
        }

        tabla = nuevaTabla;
	}
	
	// Método para realiza la redispersión inversa.
	private void redispersionInversa() {
	    int nuevaCapacidad = tabla.length / 2;
	    
	    if (nuevaCapacidad < CAPACIDAD_INICIAL) {
	        // No se puede reducir más la capacidad, salir.
	        return;
	    }

	    LinkedList<ParClaveValor<C, V>>[] nuevaTabla = new LinkedList[nuevaCapacidad];

	    for (LinkedList<ParClaveValor<C, V>> lista : tabla) {
	        if (lista != null) {
	            for (ParClaveValor<C, V> par : lista) {
	                int nuevoIndice = Math.abs(par.clave.hashCode() % nuevaCapacidad);
	                
	                if (nuevaTabla[nuevoIndice] == null) {
	                    nuevaTabla[nuevoIndice] = new LinkedList<>();
	                }
	                
	                nuevaTabla[nuevoIndice].add(par);
	            }
	        }
	    }

	    tabla = nuevaTabla;
	}
	
	// Método para mostrar el contenido de la tabla hash adaptado con la implementación de guardar contactos.
	public void mostrarContenido() {
	    for (LinkedList<ParClaveValor<C, V>> lista : tabla) {
	        if (lista != null) {
	            for (ParClaveValor<C, V> par : lista) {
	                System.out.println( "Clave: " + par.clave + ", Información: " + par.valor.toString());
	            }
	        }
	    }
	}
	
}
