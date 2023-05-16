package tipoExamenVuelos;

import java.util.Objects;

public class Vuelo 
{
	private LineaAerea linea;
	private Localidad destino;
	
	public Vuelo(LineaAerea linea, Localidad destino){
		super();
		this.linea = linea;
		this.destino = destino;
	}
	
	public LineaAerea getLinea(){
		return linea;
	}
	
	public void setLinea(LineaAerea linea)	{
		this.linea = linea;
	}
	
	public Localidad getDestino() {
		return destino;
	}
	
	public void setDestino(Localidad destino)	{
		this.destino = destino;
	}
	
	@Override
	public String toString(){
		return "Vuelo [linea=" + linea + ", destino=" + destino + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino, linea);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(destino, other.destino) && Objects.equals(linea, other.linea);
	}





}
