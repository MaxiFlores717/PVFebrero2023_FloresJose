package ar.edu.unju.edm.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.edm.models.Pregunta;
import ar.edu.unju.edm.models.Usuario;
import ar.edu.unju.edm.models.UsuarioPregunta;
import ar.edu.unju.edm.service.IPreguntaService;
import ar.edu.unju.edm.service.IUsuarioPreguntaService;
import ar.edu.unju.edm.service.IUsuarioService;


@Controller
public class PreguntaController {

	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private IPreguntaService preguntaService;
	
	@Autowired
	private IUsuarioPreguntaService usuarioPreguntaService;

	@RequestMapping(value = "/listarPregunta", method = RequestMethod.GET)
	public String listar(Model model, Authentication authentication) {
		
		if(authentication != null) {
			logger.info("Hola usuario autenticado, tu username es: ".concat(authentication.getName()));
		}		
		
		model.addAttribute("titulo", "Listado de preguntas");
		model.addAttribute("preguntas", preguntaService.findAll());
		return "listarPregunta";
	}
	@RequestMapping(value = "/listarNivel/{nivel}", method = RequestMethod.GET)
	public String listarNivel(@PathVariable(value = "nivel") int nivel, Model model, Authentication authentication) {
		
		if(authentication != null) {
			logger.info("Hola usuario autenticado, tu username es: ".concat(authentication.getName()));
		}		
		UsuarioPregunta resultado = new UsuarioPregunta();
		model.addAttribute("resultado", resultado);
		model.addAttribute("titulo", "Resolver:");
		model.addAttribute("preguntas", preguntaService.findByNivel(nivel));
		return "listarNivel";
	}
	
	@RequestMapping(value = "/listarNivel", method = RequestMethod.POST)
	public String listarNivel(@Valid UsuarioPregunta resultado, BindingResult result, Model model, RedirectAttributes flash) {
		
		usuarioPreguntaService.save(resultado);
			flash.addFlashAttribute("success", "Resultado creado con exito!");
			return "redirect:listar";
	}

	@RequestMapping(value = "/indexEstudiante", method = RequestMethod.GET)
	public String listarNivel (Model model, Authentication authentication) {
		
		if(authentication != null) {
			logger.info("Hola usuario autenticado, tu username es: ".concat(authentication.getName()));
		}		
		
		model.addAttribute("titulo", "ESTUDIANTE Elija un nivel para resolver:");
		return "indexEstudiante";
	}
	
	@RequestMapping(value = "/formPregunta")
	public String crear(Model model) {
		Pregunta pregunta = new Pregunta();
		model.addAttribute("pregunta", pregunta);
		model.addAttribute("titulo", "Formulario de Pregunta");
		return "formPregunta";
	}

	@RequestMapping(value = "/formPregunta", method = RequestMethod.POST)
	public String guardar(@Valid Pregunta pregunta, BindingResult result, Model model, RedirectAttributes flash) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Pregunta");
			return "formPregunta";
		} else {
			preguntaService.save(pregunta);
			flash.addFlashAttribute("success", "pregunta creada con exito!");
			return "redirect:listarPregunta";
		}
	}

	@RequestMapping(value = "/formPregunta/{codigo}")
	public String modificar(@PathVariable(value = "codigo") Long codigo, Model model) {
		Pregunta pregunta = null;
		pregunta = preguntaService.buscarId(codigo);
		model.addAttribute("pregunta", pregunta);
		model.addAttribute("titulo", "Editar pregunta");

		return "formPregunta";
	}

	@RequestMapping(value = "/eliminarPregunta/{codigo}")
	public String eliminar(@PathVariable(value = "codigo") Long codigo, RedirectAttributes flash) {
		preguntaService.eliminar(codigo);
		flash.addFlashAttribute("error", "pregunta ha sido eliminada con exito!");
		return "redirect:/listarPregunta";
	}

	
}
