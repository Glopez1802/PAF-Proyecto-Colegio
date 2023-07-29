package com.colegio.ProyectoColegio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.colegio.ProyectoColegio.service.UsuarioService;
import org.springframework.ui.Model;
//import ch.qos.logback.core.model.Model;

@Controller
public class MainController {
    private final UsuarioService UsuarioService;
    
    @Autowired
    public MainController(UsuarioService UsuarioService) {
        this.UsuarioService = UsuarioService;
    }
	@GetMapping("/docente")
    public String getDocente(Model model) {
		return "docente";
	}
	
	@GetMapping("/alumno")
    public String getAlumno(Model model) {
		return "alumno";
	}

	@GetMapping("/apoderado")
    public String getApoderado(Model model) {
		return "apoderado";
	}
	
	@GetMapping("/matricula")
    public String getMatricula(Model model) {
		return "matricula";
	}
	
	@GetMapping("/asignacion")
    public String getAsignacion(Model model) {
		return "asignacion";
	}
	
	@GetMapping("/curso")
    public String getCurso(Model model) {
		return "curso";
	}
	
	@GetMapping("/aula")
    public String getAula(Model model) {
		return "aula";
	}
	
	@GetMapping("/horario")
    public String getHorario(Model model) {
		return "horario";
	}
	
	@GetMapping("/usuarios")
    public String getUsuarios(Model model) {
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//model.addAttribute("usuario", auth.getName());
		return "usuarios";
	}
	
	@GetMapping("/login")
    public String mostrarFormularioLogin() {
		return "login";
	}
	
	@PostMapping("/login")
    public String procesarFormularioLogin(@RequestParam("email") String email,
                                          @RequestParam("password") String password,
                                          Model model) {
        // Aquí puedes utilizar el servicio de usuario para validar las credenciales ingresadas
        // Si las credenciales son válidas, puedes redireccionar al usuario a su página de inicio
        // Si las credenciales no son válidas, puedes mostrar un mensaje de error en la página de login

         try {
			if (UsuarioService.validarContraseña( email,password)) {
			     return "redirect:/docente"; // Redireccionar a la página de inicio
			 } else {
			     model.addAttribute("error", "Credenciales inválidas. Inténtalo de nuevo.");
			     return "login"; // Mostrar el formulario de login con mensaje de error
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // En este ejemplo, redirigimos al usuario a la página de inicio sin realizar validación real
        return "redirect:/docente";
    }
}
