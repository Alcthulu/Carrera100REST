package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public class Atleta implements Runnable {

	@Override
	public void run() {
		//llamada  al metodo preparado
	
		URL urlPreparado = new URL("http://thecatapi.com/api/images/get");
		HttpURLConnection connPreparado = (HttpURLConnection) urlPreparado.openConnection();
		connPreparado.setRequestMethod("GET");
		if(connPreparado.getResponseCode() != 200) {
		throw new RuntimeException("Failed : HTTP error code : "
		+ connPreparado.getResponseCode());
		}
		//todo  guay llamamos a listo
		
		URL urlListo  = new URL("http://thecatapi.com/api/images/get");
		HttpURLConnection connListo= (HttpURLConnection) urlListo.openConnection();
		connListo.setRequestMethod("GET");
		if(connListo.getResponseCode() != 200) {
		throw new RuntimeException("Failed : HTTP error code : "
		+ connListo.getResponseCode());
		}
		//ponemos a dormir al atleta
		//invocamos  a  carrera llegada
	}
	}



