package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainCarrera {
	
	public static void main(String[] args) throws Exception {
		
		int numAtletas=2;
		ArrayList<Atleta> atletas = new ArrayList<Atleta>();
		URL url = new URL("http://localhost:8080/Carrera100REST/Carrera100/reinicio?numAtletas="+numAtletas);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		if(conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
		}
		//todo  guay
		conn.disconnect();
		
		for(int i=0; i<numAtletas; i++) {
			Atleta nw = new Atleta(""+i);
			atletas.add(nw);
		}
		for(int i=0; i<numAtletas; i++) {
			atletas.get(i).start();
		}
		TimeUnit.SECONDS.sleep(12);
		resultado();
	}
	
	
private static void resultado() throws Exception {
		
		URL urlListo = null;
		StringBuilder dorsal = new StringBuilder();
		
		urlListo = new URL("http://localhost:8080/Carrera100REST/Carrera100/resultados");
		
		HttpURLConnection connListo = null;
		connListo = (HttpURLConnection) urlListo.openConnection();
		connListo.setRequestMethod("GET");
		if(connListo.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "+ connListo.getResponseCode());
		}else {
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(connListo.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a dorsal
		while ((linea = rd.readLine()) != null) {
			dorsal.append("\t" + linea + "\n");
		}
		// Cerrar el BufferedReader
		rd.close();
		
		// Regresar dorsal, pero como cadena, no como StringBuilder
		System.out.println("FINALCARRERA:\n");
		System.out.println(dorsal.toString());

		}
	
	}

}
