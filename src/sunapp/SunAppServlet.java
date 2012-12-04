package sunapp;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SunAppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
	//	resp.setContentType("text/html");
   //     ServletOutputStream out = resp.getOutputStream();
         DisplayImage images= new DisplayImage();
         images.Image(); 
       
        QueryRecords count = new QueryRecords();
        int total = count.Records();
        String answer = Integer.toString(total);
        req.setAttribute("total", answer);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        
    }
    
}
