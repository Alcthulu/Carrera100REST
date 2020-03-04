package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainCarrera {
	public static void main() throws IOException {
		URL url = new URL("http://thecatapi.com/api/images/get");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		if(conn.getResponseCode() != 200) {
		throw new RuntimeException("Failed : HTTP error code : "
		+ conn.getResponseCode());
		}
		//todo  guay
		conn.disconnect();
	}
}
