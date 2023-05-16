package tipoExamenVuelos;

public class Principal {
	private Modelo modelo;

	public static void main(String[] args) {
		new Principal();
	}

	public Principal() {
		this.modelo = new Modelo();

		this.addDatosDePrueba();

		// PARA MOSTRAR EL MODELO. DESCOMENTAR PARA VERLO.
		// System.out.println(this.modelo);
		// APARTADO HAY ERRORES
		System.out
				.println("�Hay errores (vuelo de ciudad a s� misma)? (debe salir false): " + this.modelo.hayErrores());
		this.modelo.addVueloALocalidad(new Localidad("Washington D. C. ", 692700),
				new Vuelo(new LineaAerea("Lufthansa", 260), new Localidad("Washington D. C. ", 692700)));
		System.out.println("�Hay errores (vuelo de ciudad a s� misma)? (debe salir true): " + this.modelo.hayErrores());

		// APARTADO A CUANTAS LOCALIDADES CON MAS DE 1.000.000 HABS TIENE VUELOS UNA
		// LOCALIDAD DADA
		System.out.println("La localidad Washington D. C. tiene "
				+ this.modelo.numVuelosALocsMillon(new Localidad("Washington D. C. ", 692700))
				+ " vuelos a localidades de mas de 1.000.000 habs.");
		System.out
				.println("La localidad Miami tiene " + this.modelo.numVuelosALocsMillon(new Localidad("Miami", 454279))
						+ " vuelos a localidades de mas de 1.000.000 habs.");

		// APARTADO LINEAS AEREAS QUE TIENEN COMO DESTINO A UNA LOCALIDAD DADA
		System.out.println("A la localidad Berl�n vuelan las l�neas a�reas :"
				+ this.modelo.lineasHasta(new Localidad("Berl�n", 3645000)));

		// APARTADO NUM TOTAL DE AVIONES DE LAS LINEAS QUE TIENEN VUELOS QUE SALEN DE
		// UNA LOCALIDAD
		System.out.println("Suma de todos los aviones de todas las l�neas que vuelan desde Frankfurt: "
				+ this.modelo.totalAvionesDesde(new Localidad("Frankfurt", 753056)));

		// APARTADO EXISTEN DOS CIUDADES A,B QUE TENGAN VUELOS DE A->B Y DE B->A?
		System.out.println("�Existen al menos dos ciudades que tengan vuelos en los dos sentidos?"
				+ this.modelo.hayVuelosReciprocos());

	}

	private void addDatosDePrueba() {
		LineaAerea l01 = new LineaAerea("Iberia", 148);
		LineaAerea l02 = new LineaAerea("American Airlines", 950);
		LineaAerea l03 = new LineaAerea("Delta Air Lines", 850);
		LineaAerea l04 = new LineaAerea("United Airlines", 745);
		LineaAerea l05 = new LineaAerea("Southwest Airlines", 697);
		LineaAerea l06 = new LineaAerea("British Airways", 255);
		LineaAerea l07 = new LineaAerea("Air France", 213);
		LineaAerea l08 = new LineaAerea("Ryanair", 413);
		LineaAerea l09 = new LineaAerea("Emirates", 257);
		LineaAerea l10 = new LineaAerea("Lufthansa", 260);
		LineaAerea l11 = new LineaAerea("Turkish Airlines", 329);

		this.modelo.addLinea(l01);
		this.modelo.addLinea(l02);
		this.modelo.addLinea(l03);
		this.modelo.addLinea(l04);
		this.modelo.addLinea(l05);
		this.modelo.addLinea(l06);
		this.modelo.addLinea(l07);
		this.modelo.addLinea(l08);
		this.modelo.addLinea(l09);
		this.modelo.addLinea(l10);
		this.modelo.addLinea(l11);

		Localidad c01 = new Localidad("Boston", 685000);
		Localidad c02 = new Localidad("Chicago", 2710000);
		Localidad c03 = new Localidad("Los �ngeles", 3967000);
		Localidad c04 = new Localidad("Miami", 454279);
		Localidad c05 = new Localidad("Nueva York", 8419000);
		Localidad c06 = new Localidad("San Francisco", 875000);
		Localidad c07 = new Localidad("Washington D. C. ", 692700);
		Localidad c08 = new Localidad("Ciudad de M�xico", 8855000);
		Localidad c09 = new Localidad("Berl�n", 3645000);
		Localidad c10 = new Localidad("Dusseldorf", 619294);
		Localidad c11 = new Localidad("Frankfurt", 753056);
		Localidad c12 = new Localidad("Hamburgo", 1841000);
		Localidad c13 = new Localidad("M�nich", 1472000);
		Localidad c14 = new Localidad("Stuttgart", 635000);
		Localidad c15 = new Localidad("Viena", 1897000);
		Localidad c16 = new Localidad("Bruselas", 1209000);
		Localidad c17 = new Localidad("Split", 349000);
		Localidad c18 = new Localidad("Zagreb", 806000);
		Localidad c19 = new Localidad("Copenhague", 1970000);

		this.modelo.addLocalidad(c01);
		this.modelo.addLocalidad(c02);
		this.modelo.addLocalidad(c03);
		this.modelo.addLocalidad(c04);
		this.modelo.addLocalidad(c05);
		this.modelo.addLocalidad(c06);
		this.modelo.addLocalidad(c07);
		this.modelo.addLocalidad(c08);
		this.modelo.addLocalidad(c09);
		this.modelo.addLocalidad(c10);
		this.modelo.addLocalidad(c11);
		this.modelo.addLocalidad(c12);
		this.modelo.addLocalidad(c13);
		this.modelo.addLocalidad(c14);
		this.modelo.addLocalidad(c15);
		this.modelo.addLocalidad(c16);
		this.modelo.addLocalidad(c17);
		this.modelo.addLocalidad(c18);
		this.modelo.addLocalidad(c19);

		this.modelo.addVueloALocalidad(c01, new Vuelo(l01, c15));
		this.modelo.addVueloALocalidad(c01, new Vuelo(l04, c05));
		this.modelo.addVueloALocalidad(c01, new Vuelo(l05, c13));
		this.modelo.addVueloALocalidad(c01, new Vuelo(l05, c14));
		this.modelo.addVueloALocalidad(c01, new Vuelo(l08, c08));
		this.modelo.addVueloALocalidad(c01, new Vuelo(l10, c19));
		this.modelo.addVueloALocalidad(c01, new Vuelo(l11, c16));
		this.modelo.addVueloALocalidad(c02, new Vuelo(l05, c19));
		this.modelo.addVueloALocalidad(c02, new Vuelo(l08, c13));
		this.modelo.addVueloALocalidad(c02, new Vuelo(l11, c04));
		this.modelo.addVueloALocalidad(c03, new Vuelo(l02, c09));
		this.modelo.addVueloALocalidad(c03, new Vuelo(l03, c05));
		this.modelo.addVueloALocalidad(c03, new Vuelo(l09, c04));
		this.modelo.addVueloALocalidad(c03, new Vuelo(l09, c15));
		this.modelo.addVueloALocalidad(c03, new Vuelo(l11, c13));
		this.modelo.addVueloALocalidad(c03, new Vuelo(l11, c18));
		this.modelo.addVueloALocalidad(c04, new Vuelo(l05, c14));
		this.modelo.addVueloALocalidad(c04, new Vuelo(l08, c08));
		this.modelo.addVueloALocalidad(c04, new Vuelo(l09, c15));
		this.modelo.addVueloALocalidad(c04, new Vuelo(l10, c03));
		this.modelo.addVueloALocalidad(c04, new Vuelo(l10, c06));
		this.modelo.addVueloALocalidad(c05, new Vuelo(l01, c19));
		this.modelo.addVueloALocalidad(c05, new Vuelo(l03, c03));
		this.modelo.addVueloALocalidad(c05, new Vuelo(l07, c07));
		this.modelo.addVueloALocalidad(c05, new Vuelo(l07, c13));
		this.modelo.addVueloALocalidad(c05, new Vuelo(l08, c17));
		this.modelo.addVueloALocalidad(c05, new Vuelo(l10, c18));
		this.modelo.addVueloALocalidad(c06, new Vuelo(l02, c03));
		this.modelo.addVueloALocalidad(c06, new Vuelo(l02, c05));
		this.modelo.addVueloALocalidad(c06, new Vuelo(l06, c19));
		this.modelo.addVueloALocalidad(c06, new Vuelo(l09, c07));
		this.modelo.addVueloALocalidad(c06, new Vuelo(l10, c01));
		this.modelo.addVueloALocalidad(c06, new Vuelo(l10, c16));
		this.modelo.addVueloALocalidad(c07, new Vuelo(l07, c10));
		this.modelo.addVueloALocalidad(c07, new Vuelo(l09, c12));
		this.modelo.addVueloALocalidad(c07, new Vuelo(l10, c14));
		this.modelo.addVueloALocalidad(c08, new Vuelo(l01, c19));
		this.modelo.addVueloALocalidad(c08, new Vuelo(l02, c15));
		this.modelo.addVueloALocalidad(c08, new Vuelo(l05, c03));
		this.modelo.addVueloALocalidad(c08, new Vuelo(l10, c09));
		this.modelo.addVueloALocalidad(c08, new Vuelo(l10, c17));
		this.modelo.addVueloALocalidad(c09, new Vuelo(l03, c08));
		this.modelo.addVueloALocalidad(c09, new Vuelo(l08, c11));
		this.modelo.addVueloALocalidad(c09, new Vuelo(l08, c16));
		this.modelo.addVueloALocalidad(c09, new Vuelo(l08, c17));
		this.modelo.addVueloALocalidad(c09, new Vuelo(l09, c03));
		this.modelo.addVueloALocalidad(c09, new Vuelo(l10, c02));
		this.modelo.addVueloALocalidad(c09, new Vuelo(l10, c10));
		this.modelo.addVueloALocalidad(c10, new Vuelo(l02, c19));
		this.modelo.addVueloALocalidad(c10, new Vuelo(l04, c09));
		this.modelo.addVueloALocalidad(c10, new Vuelo(l07, c05));
		this.modelo.addVueloALocalidad(c10, new Vuelo(l11, c06));
		this.modelo.addVueloALocalidad(c10, new Vuelo(l11, c08));
		this.modelo.addVueloALocalidad(c10, new Vuelo(l11, c16));
		this.modelo.addVueloALocalidad(c11, new Vuelo(l01, c03));
		this.modelo.addVueloALocalidad(c11, new Vuelo(l02, c17));
		this.modelo.addVueloALocalidad(c11, new Vuelo(l03, c02));
		this.modelo.addVueloALocalidad(c11, new Vuelo(l10, c09));
		this.modelo.addVueloALocalidad(c12, new Vuelo(l01, c07));
		this.modelo.addVueloALocalidad(c12, new Vuelo(l01, c11));
		this.modelo.addVueloALocalidad(c12, new Vuelo(l07, c16));
		this.modelo.addVueloALocalidad(c12, new Vuelo(l08, c14));
		this.modelo.addVueloALocalidad(c12, new Vuelo(l09, c08));
		this.modelo.addVueloALocalidad(c12, new Vuelo(l09, c09));
		this.modelo.addVueloALocalidad(c12, new Vuelo(l10, c05));
		this.modelo.addVueloALocalidad(c12, new Vuelo(l10, c10));
		this.modelo.addVueloALocalidad(c13, new Vuelo(l01, c10));
		this.modelo.addVueloALocalidad(c13, new Vuelo(l05, c16));
		this.modelo.addVueloALocalidad(c13, new Vuelo(l06, c02));
		this.modelo.addVueloALocalidad(c13, new Vuelo(l06, c04));
		this.modelo.addVueloALocalidad(c13, new Vuelo(l07, c12));
		this.modelo.addVueloALocalidad(c13, new Vuelo(l07, c19));
		this.modelo.addVueloALocalidad(c14, new Vuelo(l01, c18));
		this.modelo.addVueloALocalidad(c14, new Vuelo(l02, c04));
		this.modelo.addVueloALocalidad(c14, new Vuelo(l03, c08));
		this.modelo.addVueloALocalidad(c14, new Vuelo(l05, c10));
		this.modelo.addVueloALocalidad(c14, new Vuelo(l06, c17));
		this.modelo.addVueloALocalidad(c14, new Vuelo(l07, c02));
		this.modelo.addVueloALocalidad(c14, new Vuelo(l10, c12));
		this.modelo.addVueloALocalidad(c15, new Vuelo(l02, c19));
		this.modelo.addVueloALocalidad(c15, new Vuelo(l04, c18));
		this.modelo.addVueloALocalidad(c15, new Vuelo(l10, c13));
		this.modelo.addVueloALocalidad(c16, new Vuelo(l03, c13));
		this.modelo.addVueloALocalidad(c16, new Vuelo(l04, c07));
		this.modelo.addVueloALocalidad(c16, new Vuelo(l04, c12));
		this.modelo.addVueloALocalidad(c16, new Vuelo(l05, c11));
		this.modelo.addVueloALocalidad(c16, new Vuelo(l11, c14));
		this.modelo.addVueloALocalidad(c17, new Vuelo(l08, c19));
		this.modelo.addVueloALocalidad(c17, new Vuelo(l09, c10));
		this.modelo.addVueloALocalidad(c17, new Vuelo(l11, c03));
		this.modelo.addVueloALocalidad(c17, new Vuelo(l11, c11));
		this.modelo.addVueloALocalidad(c18, new Vuelo(l01, c16));
		this.modelo.addVueloALocalidad(c18, new Vuelo(l04, c19));
		this.modelo.addVueloALocalidad(c19, new Vuelo(l01, c12));
		this.modelo.addVueloALocalidad(c19, new Vuelo(l05, c05));
		this.modelo.addVueloALocalidad(c19, new Vuelo(l08, c09));
	}
}