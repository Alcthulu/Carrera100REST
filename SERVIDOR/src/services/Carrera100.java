package services;


import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.lang.*;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
@Path("Carrera100")//ruta a la clase
public class Carrera100 {
	long inicioCarrera;
	CyclicBarrier preparados;
	CyclicBarrier listos;
	ArrayList<String> llegadaAtletas=new ArrayList<String>();
	@GET //tipo de petición HTTP
	@Produces(MediaType.TEXT_PLAIN) //tipo de texto devuelto
	@Path("reinicio") //ruta al método
	public void reinicio(@DefaultValue("4") @QueryParam(value="numAtletas") int numAtletas) //el método debe retornar String
	{
			inicioCarrera=System.currentTimeMillis();
			CyclicBarrier preparados=new CyclicBarrier(numAtletas);
			CyclicBarrier listos=new CyclicBarrier(numAtletas);
	}
	@Path("preparado") //ruta al método
	public void preparado() //el método debe retornar String
	{
		try {
			preparados.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Path("listo") //ruta al método
	public void listo() //el método debe retornar String
	{
		try {
			listos.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Path("llegada") //ruta al método
	public String llegada( @QueryParam(value="dorsal") int dorsal) //el método debe retornar String
	{
		String  tiempoDorsal= "Dorsal: "+dorsal+String.format("%d", (System.currentTimeMillis()-inicioCarrera));
		llegadaAtletas.add(tiempoDorsal);
		return tiempoDorsal;
	}
	@Path("resultados") //ruta al método
	public String resultados() //el método debe retornar String
	{
		return llegadaAtletas.toString();
	}
	}

