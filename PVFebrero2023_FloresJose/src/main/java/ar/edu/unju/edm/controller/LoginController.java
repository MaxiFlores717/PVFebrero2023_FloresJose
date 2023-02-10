package ar.edu.unju.edm.controller;

import java.security.Principal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
	
	@GetMapping(value = "/login")
	public String login(@RequestParam(value = "error", required=false) String error, //cuando ingresan una sesion mal se manda x la url un
			// variable error y esa la caputramos con esto para usarla en la vista y mostrar msj de errores
			Model model, Principal principal, RedirectAttributes flash) {
		/*
		 * el principal de java Security es bien importante ya que nos permite validar por ejemplo con un if si principal es distinto de 
		 * Null es porque ya había iniciado sesión anteriormente. 
		 * Entonces para que no vuelva a iniciar sesión y para que no vuelva a mostrar la página de login, el formulario login, Tenemos que 
		 * redirigir con un redirect, hacia la pagina de inicio, solamente para evitar que haga doblemente inicio de sesion
		 */
		if(principal != null) {
			flash.addFlashAttribute("info", "Ya ha iniciado sesión anteriormente");
			return "redirect:/";
			
		}
		
		if(error != null) {
			model.addAttribute("error", "Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
		}
		
		return "login";
	}
	
	
}
