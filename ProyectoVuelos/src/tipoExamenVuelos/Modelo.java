package tipoExamenVuelos;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Modelo {

	private TreeMap<Localidad, HashSet<Vuelo>> conexiones;
	private TreeSet<LineaAerea> lineas;

	public Modelo() {
		this.conexiones = new TreeMap<Localidad, HashSet<Vuelo>>();
		this.lineas = new TreeSet<LineaAerea>();
	}

	public void addLinea(LineaAerea linea) {
		this.lineas.add(linea);
	}

	/*
	 * 
	 * @param localidad añade al mapa de conexiones una nueva pareja con la
	 * localidad pasada como parámetro y un nuevo conjunto de vuelos vacío.
	 * 
	 * 
	 **/

	public void addLocalidad(Localidad localidad) {
		this.conexiones.put(localidad, new HashSet<>());

	}

	/*
	 * En esta clase añadimos vuelos
	 * 
	 * @param localidad indica la localidad donde se va añadir el vuelo
	 * 
	 * @param vuelo que va a ser añadido al conjunto de vuelos de la localidad
	 * 
	 **/

	public void addVueloALocalidad(Localidad localidad, Vuelo vuelo) {

		if (conexiones.get(localidad) == null) {

			this.addLocalidad(localidad);
		}

		conexiones.get(localidad).add(vuelo);

	}

	/*
	 * @return: Devuelve un boolean indicando si hay errores en los datos, es decir,
	 * 
	 *
	 */

	public boolean hayErrores() {
		boolean hayError = false;

		for (Iterator<Localidad> iterator = conexiones.keySet().iterator(); iterator.hasNext();) {
			Localidad loc = (Localidad) iterator.next();
//			System.out.println(loc.getNombre());
			HashSet<Vuelo> vuelos = conexiones.get(loc);
			for (Iterator iterator2 = vuelos.iterator(); iterator2.hasNext();) {
				Vuelo vuelo = (Vuelo) iterator2.next();
//				System.out.println("--------" + vuelo.getDestino().getNombre());

				if (loc.compareTo(vuelo.getDestino()) == 0) {
					hayError = true;
				}
			}

		}

		return hayError;
	}

	/*
	 * 
	 * @param loc Pasamos por parametro la localidad a consultar el numero de vuelos
	 * asociados
	 * 
	 * @return devuelve un entero con el número de vuelos que parten de la localidad
	 * pasada como paámetro y llegan a localidades con más de 1.000.000 habs.
	 *
	 * 
	 */

	public int numVuelosALocsMillon(Localidad loc) {
		int numVuelosALocsMillon = 0;

		HashSet<Vuelo> vuelos = conexiones.get(loc);

		for (Iterator iterator = vuelos.iterator(); iterator.hasNext();) {
			Vuelo vuelo = (Vuelo) iterator.next();
			Localidad destino = vuelo.getDestino();

			if (destino.getHabitantes() < 1000000) {

				numVuelosALocsMillon++;

			}

		}

		return numVuelosALocsMillon;
	}

	/*
	 * 
	 * @param localidad Pasamos por parametro la localidad a consultar todas las
	 * lineas aereas que tienen vuelos hacia la localidad pasada como par�metro.
	 * asociados
	 * 
	 * @return Devuelve un TreeSet con todas las líneas aéreas que tienen vuelos
	 * hacia la localidad pasada como parámetro.
	 * 
	 *
	 * 
	 */

	public TreeSet<LineaAerea> lineasHasta(Localidad localidad) {

		TreeSet<LineaAerea> lineasHasta = new TreeSet<>();

		HashSet<Vuelo> vuelos = conexiones.get(localidad);
		int num = 0;
		for (Iterator iterator = vuelos.iterator(); iterator.hasNext();) {
			Vuelo vuelo = (Vuelo) iterator.next();
			System.out.println(num + " -  " + vuelo.getLinea());
			num++;
			LineaAerea currentLinea = vuelo.getLinea();
			lineasHasta.add(currentLinea);

		}

		return lineasHasta;
	}

	/*
	 * 
	 * @param localidad Pasamos por parametro la localidad a consultar
	 * 
	 * @return Devuelve un entero con la suma de todos los aviones que tienen las
	 * líneas que hacen vuelos desde la localidad pasada como parámetro.
	 * 
	 *
	 * 
	 */

	public int totalAvionesDesde(Localidad localidad) {
		int totalAvionesDesde = 0;

		HashSet<Vuelo> vuelos = conexiones.get(localidad);

		for (Iterator iterator = vuelos.iterator(); iterator.hasNext();) {
			Vuelo vuelo = (Vuelo) iterator.next();

			totalAvionesDesde += vuelo.getLinea().getNumAviones();

		}

		return totalAvionesDesde;
	}

	/*
	 * 
	 * @return Devuelve un boolean indicando si existen dos ciudades entre las que
	 * hay vuelos en los dos sentidos.
	 * 
	 */

	public boolean hayVuelosReciprocos() {
		boolean hayVuelosReciprocos = false;
		for (Iterator<Localidad> iterator = conexiones.keySet().iterator(); iterator.hasNext();) {
			Localidad loc = (Localidad) iterator.next();

			HashSet<Vuelo> vuelos = conexiones.get(loc);
			for (Iterator iterator2 = vuelos.iterator(); iterator2.hasNext();) {
				Vuelo vuelo = (Vuelo) iterator2.next();

				for (Iterator<Localidad> it = conexiones.keySet().iterator(); it.hasNext();) {
					Localidad loc2 = (Localidad) it.next();

					HashSet<Vuelo> vuelosDestino = conexiones.get(loc2);
					for (Iterator iterator3 = vuelos.iterator(); iterator3.hasNext();) {
						Vuelo vueloDestino = (Vuelo) iterator3.next();

						if (loc.equals(vueloDestino.getDestino())) {

							hayVuelosReciprocos = true;
						}

					}
				}
			}

		}

		return hayVuelosReciprocos;
	}

	@Override
	public String toString() {
		String res = "";
		for (Localidad l : this.conexiones.keySet()) {
			res += "\nDesde: " + l.getNombre() + " hasta:\n";
			for (Vuelo v : this.conexiones.get(l))
				res += v.getDestino().getNombre() + " con " + v.getLinea() + ", ";
		}

		return res;
	}

}
