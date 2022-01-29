package controller;

import java.util.List;

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
public class updatestock {
	
	@Autowired
	LoginDa loginda;
	
	@RequestMapping(value = "/update/{name}", method = RequestMethod.GET)
	public ModelAndView fetchstocks(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("update");
		mav.addObject("update",new stocks());
		
		return mav;
		
	}
	@RequestMapping(value = "/updated", method = RequestMethod.POST)
	public ModelAndView insertstock(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("stock")stocks stock,@PathVariable("name") String name) {
		
		ModelAndView model = new ModelAndView("welcome");
		
		
		List<stocks> liststock = loginda.findStudentByName(name);
		 loginda.update(stock);
		model.addObject("liststock",liststock);
		return model;
		
		
		
	}

}
