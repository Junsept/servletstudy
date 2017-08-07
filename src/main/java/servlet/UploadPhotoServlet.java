package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import crud.HeroDAO;

public class UploadPhotoServlet extends HttpServlet {
	String name, hp, damage, img;
	HeroDAO dao = new HeroDAO();
	public static String filename = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        String userName = (String) request.getSession().getAttribute("name");
        if (null == userName) {
            response.sendRedirect("/ServletTest/login.jsp");
            return;
        }
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		factory.setSizeThreshold(1024 * 1024);
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }       
        Iterator iter = items.iterator();
        while(iter.hasNext()){
        	FileItem item = (FileItem) iter.next();
        	if(!item.isFormField()){
        		
                // 根据时间戳创建头像文件
                filename = System.currentTimeMillis() + ".jpg";
                System.out.println(request.getContextPath());
                /*File f = new File(getServletContext().getRealPath("upload"));*/
                File f = new File("D://image");
                if (!f.exists()) {  
                    f.mkdir();  
                } 
                String imgsrc = f + "/" + filename;
                
                // 复制文件
                InputStream is = item.getInputStream();               
                FileOutputStream fos = new FileOutputStream(imgsrc);
                byte b[] = new byte[1024 * 1024];
                int length = 0;
                while (-1 != (length = is.read(b))) {
                    fos.write(b, 0, length);                    
                }
                fos.flush();
                fos.close();  
                
        	}else {
                String Fieldname = item.getFieldName();
                System.out.println(Fieldname);
                String value = item.getString();
                value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                if(Fieldname.equals("heroName")){
                	name = value;
                }else if(Fieldname.equals("heroHp")){
                	hp = value;
                }else if(Fieldname.equals("heroDamage")){
                	damage = value;
                }
            }
        	
        }
        img = filename;
        try {
			dao.addRecord(name, hp, damage, img);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //request.setAttribute("filename", filename);      
        //request.getRequestDispatcher("/showPhoto").forward(request, response);
        response.sendRedirect("/ServletTest/showPhoto?filename="+filename);
       
	}
}
