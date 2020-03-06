package services;


import java.util.ArrayList;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.io.Serializable;
import java.lang.*;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



@Path("Carrera100")//ruta a la clase
public class Carrera100 {
	long inicioCarrera;
	DatosCarrera datosCarrera=new DatosCarrera();
	CyclicBarrier preparados;
	CyclicBarrier listos;
	@GET //tipo de petici�n HTTP
	@Produces(MediaType.TEXT_PLAIN) //tipo de texto devuelto
	@Path("reinicio") //ruta al m�todo
	public String reinicio(@DefaultValue("4") @QueryParam(value="numAtletas") int numAtletas) //el m�todo debe retornar String
	{
			datosCarrera.clearList();
			datosCarrera.setInicioCarrera(System.currentTimeMillis());
			//System.out.println(salida);
			CyclicBarrier preparados=new CyclicBarrier(numAtletas);
			CyclicBarrier listos=new CyclicBarrier(numAtletas);
			return ""+inicioCarrera;
	}
	@GET //tipo de petici�n HTTP
	@Produces(MediaType.TEXT_PLAIN) //tipo de texto devuelto
	@Path("preparado") //ruta al m�todo
	public void preparado() //el m�todo debe retornar String
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
	@GET //tipo de petici�n HTTP
	@Produces(MediaType.TEXT_PLAIN) //tipo de texto devuelto
	@Path("listo") //ruta al m�todo
	public void listo() //el m�todo debe retornar String
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
	@GET //tipo de petici�n HTTP
	@Produces(MediaType.TEXT_PLAIN) //tipo de texto devuelto
	@Path("llegada") //ruta al m�todo
	public String llegada( @QueryParam(value="dorsal") int dorsal) //el m�todo debe retornar String
	{
	long tiempoTotal= ((System.currentTimeMillis() - datosCarrera.getInicioCarrera()));
		String  tiempoDorsal= "Dorsal: "+dorsal+" Tiempo: "+String.format("%d", tiempoTotal);
		
		datosCarrera.getLlegadaAtletas().add(tiempoDorsal);
		
		return tiempoDorsal;
	}
	@GET //tipo de petici�n HTTP
	@Produces(MediaType.TEXT_PLAIN) //tipo de texto devuelto
	@Path("resultados") //ruta al m�todo
	public String resultados() //el m�todo debe retornar String
	{
		String salida="";
		for(int i=0;i<datosCarrera.getLlegadaAtletas().size();i++) {
			salida=salida+datosCarrera.getLlegadaAtletas().get(i)+"\n";
		}
		return salida;
	}
	@GET //tipo de petici�n HTTP
	@Produces(MediaType.TEXT_PLAIN) //tipo de texto devuelto
	@Path("saludo") //ruta al m�todo
	public String saludo() //el m�todo debe retornar String
	{
	return "Hola gente!!";
	}

	}

