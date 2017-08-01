package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public void init(ServletConfig config){
        System.out.println("init of Servlet");
    }
    
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String name = request.getParameter("name");
	    String password = request.getParameter("password");
	       
/*	    String html = null;
	    if(name.equals("admin") && password.equals("123")){
	    	html = "<div style = 'color:green'>登录成功</div>";
	    }else{
	    	html = "<div style = 'color:red'>登录失败</div>";
	    }
	    response.setContentType("text/html; charset=UTF-8");
	    response.getWriter().println(html);	*/
        if ("admin".equals(name) && "123".equals(password)) {
            request.getRequestDispatcher("success.jsp").forward(request, response);
        }
        else{
            response.sendRedirect("fail.jsp");
        }
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		
	}
	
	
}
