package filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    
		String ip = req.getRemoteAddr();
        String uri = req.getRequestURI();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String date = sdf.format(d);
        System.out.printf("%s %s 访问了 %s%n", date, ip, uri);

		if(uri.endsWith("login.jsp") || uri.endsWith("login")|| uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png")|| uri.endsWith(".jpg")){
			chain.doFilter(request, response); //进入下一个filter,直接放行
			return;		
		}
		
        String userName = (String) req.getSession().getAttribute("name");
        if (null == userName) {
            res.sendRedirect("/ServletTest/login.jsp");
            return;
        }
 
        chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
