package Dao;

import java.util.List;

import model.loginM;
import model.stocks;

public interface LoginDa {

	 public  loginM checkLogin(loginM logM);
	 public List<stocks> stocklist();
	 public int createStock(stocks stock);
	 public List<stocks> findStudentByName(String name);
	 public int update(stocks stock);
	 public int delete(String name);
}
