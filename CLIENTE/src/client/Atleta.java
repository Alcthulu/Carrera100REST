package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public class Atleta extends Thread {
	
	String dorsal;
	String time;
	
	
	public Atleta(String dorsal) {
		super();
		this.dorsal = dorsal;
	}



	@Override
	public void run() {
		//llamada  al metodo preparado
		try {
			preparado();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//todo  guay llamamos a listo
		try {
			listo();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//ponemos a dormir al atleta
		try {
			Thread.sleep((1000*(int)(Math.random()*(11-9+1)+9)));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//invocamos  a  carrera llegada
		try {
			time=llegada();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private String llegada() throws Exception {
		
		URL urlListo = null;
		StringBuilder dorsal = new StringBuilder();
		
		urlListo = new URL("http://localhost:8080/Carrera100REST/Carrera100/llegada?dorsal=" + this.dorsal);
		
		HttpURLConnection connListo = null;
		connListo = (HttpURLConnection) urlListo.openConnection();
		connListo.setRequestMethod("GET");
		
				
		BufferedReader rd = new BufferedReader(new InputStreamReader(connListo.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a dorsal
		while ((linea = rd.readLine()) != null) {
			dorsal.append(linea);
		}
		// Cerrar el BufferedReader
		rd.close();
		// Regresar dorsal, pero como cadena, no como StringBuilder
		return dorsal.toString();
	}


	void preparado() throws Exception{
		URL urlPreparado = null;
		urlPreparado = new URL("http://localhost:8080/Carrera100REST/Carrera100/preparado");

		HttpURLConnection connPreparado = null;

		connPreparado = (HttpURLConnection) urlPreparado.openConnection();
	
		connPreparado.setRequestMethod("GET");

		
	}
	
	void listo() throws Exception {
		URL urlListo = null;

			urlListo = new URL("http://localhost:8080/Carrera100REST/Carrera100/listo");

		HttpURLConnection connListo = null;

		connListo = (HttpURLConnection) urlListo.openConnection();
		
		connListo.setRequestMethod("GET");
		
		
	}
}



