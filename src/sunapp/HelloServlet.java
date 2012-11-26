package sunapp;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		resp.setContentType("text/html");
        ServletOutputStream out = resp.getOutputStream();
        Calendar calendar = new GregorianCalendar(); // create a new gregorian calendar
        int  year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // add 1 to month as month starts at 0 not 1
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        String yearString = Integer.toString(year);
        String monthString = Integer.toString(month);
        String dayString = Integer.toString(dayOfMonth);
        String stringDate = yearString+"-" + monthString+ "-" + dayString;
        
        //java.util.Date dateToday = new java.util.Date();
     //   DateFormat dateform = new SimpleDateFormat("yyyy/MM/dd");
      //  Date date =new Date();
     //  dateform.format(date);
        //
    //    String currdate = dateform.format(date).toString();
         String searchurl ="http://sdowww.lmsal.com/hek/her?suntoday_date=";
         String dateplusurl = searchurl + stringDate;
       
         VSOWSDLService client = new  VSOWSDLService();
         int recreturn = client.returnQuery();
         String reccount = Integer.toString(recreturn);
         out.write(reccount.getBytes());
         out.write(":Records retrieved:".getBytes());
       out.write(stringDate.getBytes());
      //  System.out.println(dateform.format(date));
        out.write("Hello Heroku".getBytes());
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                                        "Transitional//EN\">\n" +
                "<HTML>\n" +
                "<HEAD><TITLE>Hello WWW</TITLE></HEAD>\n" +
                "<BODY>\n" +
                "<H1>Hello WWW</H1>\n" +
                "<href>http://www.lmsal.com/hek/her?cosec=2&cmd=search&type=column&event_type=ar,fl,ef&event_starttime=2007-04-29T00:00:00&event_endtime=2007-05-07T00:00:00&event_coordsys=helioprojective&x1=-1200&x2=1200&y1=-1200&y2=1200</href> "
                +
                "</BODY></HTML>");
        out.flush();
        out.close();
    }
    
}
