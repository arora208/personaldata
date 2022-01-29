package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Dao.UserMapper;
import model.loginM;
import model.stocks;



public class LoginDao implements LoginDa {
	
	@Autowired
	  DataSource datasource;
	
	@Autowired
	 JdbcTemplate JdbcTemplate;
	
	public LoginDao(DataSource DataSource) {
		JdbcTemplate = new JdbcTemplate(DataSource);
	}
	
	@Override
	public loginM checkLogin(loginM logM) {
		
		String sql = "select * from New_1 where username ='" + logM.getUsername() + "' and psword ='" + logM.getPsword()
        + "'";
            List<loginM> users = JdbcTemplate.query(sql, new UserMapper());

          return users.size() > 0 ? users.get(0) : null;
	}
	
	
	@Override
	public List<stocks> stocklist(){
		
		List<stocks> list = JdbcTemplate.query("SELECT * FROM Stock_details", new RowMapper<stocks>() {
			
			public stocks mapRow(ResultSet rs, int rowNum) throws SQLException {
				stocks stok = new stocks();

				stok.setName(rs.getString("name"));
				stok.setArrival_date(rs.getString("arrival_date"));
				stok.setDispatch(rs.getString("dispatch"));
				stok.setStatus(rs.getString("status"));
				stok.setQuantity(rs.getString("quantity"));
				stok.setAddress(rs.getString("address"));
				stok.setDetails(rs.getString("details"));
				

				return stok;
			}

		});

		return list;
		}
	
	@Override
	public int createStock(stocks stock) {

	    String sql = "insert into Stock_details values(?,?,?,?,?,?,?)";

	    return JdbcTemplate.update(sql, new Object[] {stock.getName(),stock.getArrival_date(),stock.getDispatch(),stock.getStatus(),stock.getQuantity(),stock.getAddress(),stock.getDetails()});
		
	}
	
	@Override
	public List<stocks> findStudentByName(String name){
		
		List<stocks> find = JdbcTemplate.query("SELECT * FROM Stock_details WHERE name = ? ", new RowMapper<stocks>() {
			
			public stocks mapRow(ResultSet rs, int rowNum) throws SQLException {
				stocks stk = new stocks();
				
				stk.setName(rs.getString("name"));
				stk.setArrival_date(rs.getString("arrival_date"));
				stk.setDispatch(rs.getString("dispatch"));
				stk.setStatus(rs.getString("status"));
				stk.setQuantity(rs.getString("quantity"));
				stk.setAddress(rs.getString("address"));
				stk.setStatus(rs.getString("details"));

				return stk;
				
		}
		});
			return find;
	}
	
	public int update(stocks stock) {
		
		String sql = "update  Stock_details set name = ?,arrival_date = ? ,dispatch = ? ,status = ? ,quantity = ? ,address = ? ,details = ? where name = ?";

	    return JdbcTemplate.update(sql, new Object[] {stock.getName(),stock.getArrival_date(),stock.getDispatch(),stock.getStatus(),stock.getQuantity(),stock.getAddress(),stock.getDetails()});
	
	}
	
	public int delete(String name) {
		
		 String sql = "DELETE FROM Stock_details WHERE name = ?";

		    return JdbcTemplate.update(sql, new Object[] {name });
			
	}
			
}
class UserMapper implements RowMapper<loginM> {

	  public loginM mapRow(ResultSet rs, int arg1) throws SQLException {
		  loginM user = new loginM();
		  
	    user.setUsername(rs.getString("username"));
	    user.setPsword(rs.getString("psword"));
	    
	    return user;
	  }
	}
