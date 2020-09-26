package com.algaworks.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;

@Controller
public class ConvidadosController {
	
	@Autowired
	Convidados convidados;

	@RequestMapping("/convidados")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaConvidados");
		mv.addObject("convidados", convidados.findAll());
		mv.addObject(new Convidado());
		return mv;
	}
	
	@RequestMapping(value="/convidados/cadastrar", method = RequestMethod.POST)
	public String salvar(Convidado convidado) {
		this.convidados.save(convidado);
		return "redirect:/convidados";
	}
	
	@RequestMapping(value="/convidados/deletar/{id}")
	public String excluir(@PathVariable("id") Long idConvidado) {
		this.convidados.delete(idConvidado);
		return "redirect:/convidados";
	}
}
