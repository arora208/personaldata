package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Dao.LoginDa;
import model.stocks; 

@Controller
public class stockscon {
	
	@Autowired
	LoginDa loginda;
	
	@RequestMapping(value = "/fetching", method = RequestMethod.GET)
	public ModelAndView fetchstocks(ModelAndView Model,HttpServletRequest request,HttpServletResponse response, 
		@ModelAttribute("stock") stocks stock) {
		
		List<stocks> stocklist = loginda.stocklist();
		Model.addObject("stocklist", stocklist);
		Model.setViewName("welcome");

		    return Model;
		
	}
	

}
