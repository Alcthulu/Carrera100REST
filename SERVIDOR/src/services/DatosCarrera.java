package services;

import java.util.ArrayList;

public class DatosCarrera {
	private static long inicioCarrera;
	private static ArrayList<String> llegadaAtletas=new ArrayList<String>();
	private static int numAtl=2;
	private static boolean carrera=false;
	public static int getNumAtl() {
		return numAtl;
	}
	public static void setNumAtl(int numAtl) {
		DatosCarrera.numAtl = numAtl;
	}
	public DatosCarrera() {
	}
	public void clearList() {
		llegadaAtletas.clear();
	}
	public long getInicioCarrera() {
		return inicioCarrera;
	}
	public void setInicioCarrera(long inicioCarrera) {
		this.inicioCarrera = inicioCarrera;
	}
	public ArrayList<String> getLlegadaAtletas() {
		return llegadaAtletas;
	}
	public void setLlegadaAtletas(ArrayList<String> llegadaAtletas) {
		this.llegadaAtletas = llegadaAtletas;
	}
	public static boolean getCarrera() {
		return carrera;
	}
	public static void setCarrera(boolean carrera) {
		DatosCarrera.carrera = carrera;
	}
	
}
