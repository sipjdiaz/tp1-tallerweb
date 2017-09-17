package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHome {
	
	float total = 0;
	
	@RequestMapping(path = "/{operacion}/{numero1}/{numero2}")
	public ModelAndView calcular(@PathVariable String operacion, @PathVariable Integer numero1, @PathVariable Integer numero2 )
	{
		if(!operacion.contentEquals("sumar") && !operacion.contentEquals("restar") && !operacion.contentEquals("multiplicar") && !operacion.contentEquals("dividir"))
			return new ModelAndView("redirect:/error");
		
		ModelMap mp = new ModelMap();
		
		if(operacion.contains("sumar"))
		{
			total = (float)numero1 + numero2;
		}
		else if(operacion.contains("restar"))
		{
			total = (float)numero1 - numero2;
		}
		else if(operacion.contains("multiplicar"))
		{
			total = (float)numero1 * numero2;
		}
		else if(operacion.contains("dividir"))
		{
			if(numero2 == 0)
				return new ModelAndView("redirect:/dividir/error");

			total = (float)numero1 / numero2;
		}
		
		mp.put("mensaje", "El resultado de "+operacion+" entre "+numero1+" y "+numero2+" da "+total);
		
		return new ModelAndView("home", mp);
	}
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelMap mp = new ModelMap();
		
		mp.put("mensaje", "Escriba las siguientes opciones por url: sumar, restar, multiplicar, dividir. Seguido por /numero1/numero2.  Ej: sumar/3/2");
		return new ModelAndView("home", mp);
	}
	
	@RequestMapping("/error")
	public ModelAndView mostrarMensajeError()
	{
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/{operacion}/error")
	public ModelAndView mostrarMensajeErrorSegunOperacion(@PathVariable String operacion)
	{
		ModelMap mp = new ModelMap();
		
		if(!operacion.contentEquals("dividir"))
			return new ModelAndView("redirect:/error");
		
		if(operacion.contains("dividir"))
			mp.put("msgError", "No se puede dividir por 0.");
		
		return new ModelAndView("error", mp);
	}
	
	@RequestMapping("/{param}")
	public ModelAndView mostrarMensajeCualquiera(@PathVariable String param)
	{
		if(!param.contentEquals("sumar") && !param.contentEquals("restar") && !param.contentEquals("multiplicar") && !param.contentEquals("dividir"))
			return new ModelAndView("redirect:/error");
		else{
			ModelMap mp = new ModelMap();
			mp.put("mensaje", "Ingresa los valores para realizar la operación.");
			return new ModelAndView("home", mp);
		}
	}
}
