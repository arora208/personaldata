package config;

import model.loginM;
import model.stocks;


public interface frontconf {
	
	 public loginM checkLogin(loginM logM);
	 public int createStock(stocks stock);

}