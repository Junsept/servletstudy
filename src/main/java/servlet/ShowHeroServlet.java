package servlet;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.*;

import crud.HeroDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShowHeroServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response){
		HeroDAO dao = new HeroDAO();
		String action = request.getParameter("action");
		if(("query").equals(action)){
			try {
				List<Map<String, Object>> allHero = dao.getAllRecord();
				JSONArray Heros = JSONArray.fromObject(allHero);
				
			    response.setContentType("text/javascript;charset=utf-8");  		       
			    PrintWriter out = response.getWriter(); 
			    Map<String, Object> map = new HashMap<String, Object>();
			    map.put("total", Heros.size());
			    map.put("rows", Heros);
			    JSONObject json = JSONObject.fromObject(map);
			    out.print(json);
			    out.flush();
			    out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}else if(("delete").equals(action)){
			String id = request.getParameter("id");
			try {
				dao.deleteRecord(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(("update").equals(action)){
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String damage = request.getParameter("damage");
			try {
				dao.updateRecord(id, name, hp, damage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
