package com.swordfish.bdd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Classe que gera as paginas com os erros das Responses
 * 
 * @author juccelino.barros
 *
 */
@ControllerAdvice
public class ErrorController {

	/**
	 * Resposta ao erro de parse do body da requisição
	 * 
	 * @param e
	 *            Exceção de erro de parse
	 * @return json com mensagem de erro
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView handleMessageNotReadableException(IllegalArgumentException e) {
		return handleError(e);
	}

	private ModelAndView handleError(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.setView(new MappingJackson2JsonView());
		mav.addObject("message", e.getMessage());

		return mav;
	}

}
