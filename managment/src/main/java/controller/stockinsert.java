package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import config.frontconf;
import model.stocks;

@Controller
public class stockinsert {

	@Autowired
	frontconf frontConf;
	
	@RequestMapping(value = "/create" , method = RequestMethod.GET)
	public ModelAndView showStocks(HttpServletRequest request, HttpServletResponse response) {
		 ModelAndView mav = new ModelAndView("insert");
		    mav.addObject("stocks", new stocks());
		
		return mav;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertstock(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("stock")stocks stock) {
		
		frontConf.createStock(stock);
		return new ModelAndView("welcome");
				
	}
}
