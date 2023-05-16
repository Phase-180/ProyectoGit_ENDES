package tipoExamenVuelos;

import java.util.Objects;

public class Localidad  implements Comparable<Localidad>{
	
	private String nombre;
	private int habitantes;
	
	public Localidad(String nombre, int habitantes){
		super();
		this.nombre = nombre;
		this.habitantes = habitantes;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public int getHabitantes(){
		return habitantes;
	}
	
	public void setHabitantes(int habitantes){
		this.habitantes = habitantes;
	}
	
	@Override
	public String toString(){
		return "Localidad [nombre=" + nombre + ", habitantes=" + habitantes + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(habitantes, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidad other = (Localidad) obj;
		return habitantes == other.habitantes && Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Localidad o) {
		
		return this.getNombre().compareTo(o.getNombre());
	}

	
	
}
