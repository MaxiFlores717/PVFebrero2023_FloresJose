package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.edm.dao.IUsuarioDao;
import ar.edu.unju.edm.models.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;


@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@RequestMapping(value = { "/listar", "/" }, method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarioService.findAll());
		return "listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Formulario de Usuario");
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes flash) {//el usuario ya viene con los datos poblados
		/*@Valid: habilita la validacion de la anotaciones en usuario como @notnull*/
//		el BindingResult es para ver si tiene errores una vez q haga la validacion x eso preguntamos en el if si tiene errores y devolvemos
//		al usuario al formulario para que los corrija junto con los msj de validacion
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Usuario");
			return "form";
		} else {
			usuarioService.save(usuario);
			flash.addFlashAttribute("success", "Usuario creado con exito!");
			return "redirect:listar";
		}
	}

	@RequestMapping(value = "/form/{dni}")//{dni}seria un parametro de la ruta un wilcat
	public String modificar(@PathVariable(value = "dni") Long dni, Model model) {//@pathvariable captura e inyecta el parametro en la funcion
		Usuario usuario = null;
		usuario = usuarioService.buscarDni(dni);
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Editar Usuario");

		return "form";
	}

	@RequestMapping(value = "/eliminar/{dni}")
	public String eliminar(@PathVariable(value = "dni") Long dni, RedirectAttributes flash) {
		usuarioService.eliminar(dni);
		flash.addFlashAttribute("error", "Usuario ha sido eliminado con exito!");
		return "redirect:/listar";
	}

}
