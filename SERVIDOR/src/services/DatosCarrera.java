package services;

import java.util.ArrayList;

public class DatosCarrera {
public static long inicioCarrera;
public static ArrayList<String> llegadaAtletas=new ArrayList<String>();
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
	
}
