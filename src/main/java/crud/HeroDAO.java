package crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HeroDAO {
	/**加载驱动**/
    public HeroDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**连接数据库**/
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hero?characterEncoding=UTF-8", "root", "root");
    }
    
    /**获取数据库条数**/
    public int getTotal() throws Exception{
        int total = 0;       
    	Connection c = getConnection();    	
        String sql = "select count(*) from hero";        
    	PreparedStatement s = c.prepareStatement(sql);    	
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            total = rs.getInt(1);
        }  
        System.out.println("total:" + total); 
        return total;
    }
    
    /**获取数据库所有记录**/
    public List<Map<String, Object>> getAllRecord() throws Exception{
    	List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
    	Connection c = getConnection();
    	String sql = "select name, hp, damage from hero";
    	PreparedStatement s = c.prepareStatement(sql);
    	ResultSet rs = s.executeQuery(sql);
    	while(rs.next()){
        	Map<String, Object> hero = new HashMap<String, Object>();
    		hero.put("name", rs.getString(1));
    		hero.put("hp", rs.getFloat(2));
    		hero.put("damage", rs.getInt(3));
    		resultList.add(hero);
    	} 
    	return resultList;
    }
    
}
