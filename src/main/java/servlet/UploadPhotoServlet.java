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

public class UploadPhotoServlet extends HttpServlet {
	public static String filename = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		
	}
	@SuppressWarnings("rawtypes")
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
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
                System.out.println(this.getClass().getResource("/"));
                String realpathdir = "E://MyData//EclipseDev//ServletTest//src//main//webapp//res//image";               
                File f = new File(realpathdir, filename);
                f.getParentFile().mkdirs();
                                
                // 通过item.getInputStream()获取浏览器上传的文件的输入流
                InputStream is = item.getInputStream();
                
                // 复制文件
                FileOutputStream fos = new FileOutputStream(f);
                byte b[] = new byte[1024 * 1024];
                int length = 0;
                while (-1 != (length = is.read(b))) {
                    fos.write(b, 0, length);                    
                }
                fos.flush();
                fos.close();  
                
        	}else {
                System.out.println(item.getFieldName());
                String value = item.getString();
                value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                System.out.println(value);
            }
        }
        
        
       //request.setAttribute("filename", filename);      
       //request.getRequestDispatcher("/showPhoto").forward(request, response);
       response.sendRedirect("/ServletTest/showPhoto?filename="+filename);
       
	}
}
