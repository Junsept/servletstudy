package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnLineNumListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		ServletContext application = se.getSession().getServletContext();
		Integer onLineNum = (Integer) application.getAttribute("onLineNum");
		if(null == onLineNum){
			onLineNum = 0;
		}
		onLineNum ++;
		application.setAttribute("onLineNum", onLineNum);
		System.out.println("新增一位在线用户");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		ServletContext application = se.getSession().getServletContext();
		Integer onLineNum = (Integer) application.getAttribute("onLineNum");
		if(null == onLineNum){
			onLineNum = 0;
		}
		onLineNum --;
		application.setAttribute("onLineNum", onLineNum);
		System.out.println("一位用户离线");
	}
	
}
