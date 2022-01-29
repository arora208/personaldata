package config;

import org.springframework.beans.factory.annotation.Autowired;
import Dao.LoginDa;
import model.loginM;
import model.stocks;


public class WebMvcConfig implements frontconf {
	
	@Autowired
	public LoginDa Loginda;
	
	  public loginM checkLogin(loginM logM) {
	    return Loginda.checkLogin(logM);
	  }
	  
	  public int createStock(stocks stock) {
		  return Loginda.createStock(stock);
	  }
	
}
