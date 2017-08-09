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
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lol?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "root");
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
    	String sql = "select name, hp, damage, imgsrc from hero";
    	PreparedStatement s = c.prepareStatement(sql);
    	ResultSet rs = s.executeQuery(sql);
    	while(rs.next()){
        	Map<String, Object> hero = new HashMap<String, Object>();
    		hero.put("name", rs.getString(1));
    		hero.put("hp", rs.getInt(2));
    		hero.put("damage", rs.getInt(3));
    		hero.put("imgsrc", rs.getString(4));
    		resultList.add(hero);
    	} 
    	return resultList;
    }
    
    public boolean addRecord(String name, String hp, String damage, String img) throws Exception{
    	Connection c = getConnection();
    	String sql = "insert into hero (name, hp, damage, imgsrc) values (?, ?, ?, ?)";
    	PreparedStatement s = c.prepareStatement(sql);
    	s.setString(1, name);
    	s.setString(2, hp);
    	s.setString(3, damage);
    	s.setString(4, img);
    	boolean b = s.execute();
		return b;   	
    }
    
    public boolean updateRecord(String id, String name, String hp, String damage) throws Exception{
    	Connection c = getConnection();
    	String sql = "update hero set (name, hp, damage) values (?, ?, ?) where id = ?";
    	PreparedStatement s = c.prepareStatement(sql);
    	s.setString(1, name);
    	s.setString(2, hp);
    	s.setString(3, damage);
    	s.setString(4, id);
    	boolean b = s.execute();
		return b;   	
    }
    
    public boolean deleteRecord(String id) throws Exception{
    	Connection c = getConnection();
    	String sql = "delete from hero where id = ?";
    	PreparedStatement s = c.prepareStatement(sql);
    	s.setString(1, id);
    	boolean b = s.execute();
		return b;   	
    }
    
}
