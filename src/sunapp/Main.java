package sunapp;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java. util.*;

//import org.eclipse.jetty.webapp.WebAppContext;
import javax.xml.ws.handler.HandlerResolver;
import org.virtualsolar.vso.vsoi.DataContainer;
import org.virtualsolar.vso.vsoi.DataItem;
import org.virtualsolar.vso.vsoi.DataRequestItem;
import org.virtualsolar.vso.vsoi.Field;
import org.virtualsolar.vso.vsoi.FileidItem;
import org.virtualsolar.vso.vsoi.GetDataItem;
import org.virtualsolar.vso.vsoi.GetDataRequest;
import org.virtualsolar.vso.vsoi.GetDataResponseItem;
import org.virtualsolar.vso.vsoi.MethodItem;
import org.virtualsolar.vso.vsoi.ProviderQueryResponse;
import org.virtualsolar.vso.vsoi.QueryRequest;
import org.virtualsolar.vso.vsoi.QueryRequestBlock;
import org.virtualsolar.vso.vsoi.QueryResponse;
import org.virtualsolar.vso.vsoi.QueryResponseBlock;
import org.virtualsolar.vso.vsoi.QueryResponseBlockArray;
import org.virtualsolar.vso.vsoi.Time;
import org.virtualsolar.vso.vsoi.VSOGetDataRequest;
import org.virtualsolar.vso.vsoi.VSOGetDataResponse;
import org.virtualsolar.vso.vsoi.VSOiPort;
import org.virtualsolar.vso.vsoi.VSOiService;
import org.virtualsolar.vso.vsoi.Wave;

import com.sun.net.httpserver.HttpServer;

import sunapp.DateTime;
import java.rmi.RemoteException;
/**
 * 
 * This class launches the web application in an embedded Jetty container.
 * This is the entry point to your application. The Java command that is used for
 * launching should fire this main method.
 *
 */

public class Main {
    
    /**
     * @param args
     */
    @SuppressWarnings("unused")
	public static void main(String[] args) throws RemoteException{
  

       

        VSOiService service = new VSOiService(); // creates VSO service using code generated from WSDL to allow it to access service
        VSOiPort port = service.getNsoVSOi();  // creates VSO port to allow queries of DB;
        QueryRequest query =new QueryRequest(); // creates new query to query VSO data;
       Time timeparam = new Time();
        DateTime time = new DateTime();
        time(timeparam);
        VSOWSDLService client2 = new VSOWSDLService();
        client2.setTime(time);
        
        
         

  
         }

	private static void time(Time timeparam) {
		Calendar calendar = new GregorianCalendar(); // create a new gregorian calendar
        int  year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // add 1 to month as month starts at 0 not 1
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        int DayMinus = dayOfMonth -1;
        
        
        String yearString = Integer.toString(year);
        String monthString = Integer.toString(month);
        String dayString = Integer.toString(dayOfMonth);
        String stringDate = yearString + monthString +  dayString;

        String hourString = Integer.toString(hours);
        String minuteString = Integer.toString(minutes);
        String secondString = Integer.toString(seconds);
        String DayPreviousString = Integer.toString(DayMinus);
        String stringTimeCurrent = hourString + minuteString + secondString;
    	
    	String dateTimeCurrent = stringDate + stringTimeCurrent;
    	

    	String stringTimePrevious = DayPreviousString + minuteString + secondString;   
        String dateTimePrevious = stringDate + stringTimePrevious;
        timeparam.setStart(dateTimePrevious);
        timeparam.setEnd(dateTimeCurrent);
        timeparam.setNear(dateTimeCurrent);
		
	}
         
        
    }





