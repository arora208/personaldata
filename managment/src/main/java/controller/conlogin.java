package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import model.loginM;
import config.frontconf;


@Controller
public class conlogin {
	
	@Autowired
	frontconf frontConf;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView Userlogin(HttpServletRequest request,HttpServletResponse response) {
		
		 ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new loginM());

		    return mav;
		
	}
	
	  @RequestMapping(value = "/loginProcess",method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request,HttpServletResponse response,
	      @ModelAttribute("login") loginM login) {
	    ModelAndView mav = null;

	    loginM loginm = frontConf.checkLogin(login);

	    if (null != loginm) {
	      mav = new ModelAndView("welcome");
	      mav.addObject("username", loginm.getUsername());
	    } else {
	      mav = new ModelAndView("login");
	      mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }
	
}
