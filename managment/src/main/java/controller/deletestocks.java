package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Dao.LoginDa;
import model.stocks;

@Controller
public class deletestocks {

	@Autowired
	LoginDa loginda;
	
	@RequestMapping(value = "/delete/{name}", method = RequestMethod.GET)
	public ModelAndView deletestock(HttpServletRequest request,HttpServletResponse response, 
		@ModelAttribute("stock") stocks stock,@PathVariable("name")String name) {
		
		loginda.delete(name);
		ModelAndView mav = new ModelAndView("welcome");
	    mav.addObject("stocks", new stocks());
	    System.out.println("stock has been deleted");
	
	return mav;
		
	}
}
