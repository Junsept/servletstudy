package servlet;

import java.util.*;

import javax.servlet.http.*;

import crud.HeroDAO;
import net.sf.json.JSONArray;

public class ShowHeroServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response){
		HeroDAO dao = new HeroDAO();
		try {
			List<Map<String, Object>> allHero = dao.getAllRecord();
			JSONArray Heros = JSONArray.fromObject(allHero);	
			System.out.println(Heros);
			request.setAttribute("Heros", Heros);
			request.getRequestDispatcher("/showhero.jsp").forward(request,response); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
}
