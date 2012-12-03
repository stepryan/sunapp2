package sunapp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
import java. util.*;
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





import java.rmi.RemoteException;


public class Main {
    
    /**
     * @param args
     */
	
	
	public static void main(String[] args) throws RemoteException{
    	
		VSOiService service = new VSOiService(); // creates VSO service using code generated from WSDL to allow it to access service
		VSOiPort port = service.getNsoVSOi();  // creates VSO port to allow queries of DB;
		QueryRequest query =new QueryRequest(); // creates new query to query VSO data;
		Time timeparam = new Time();
	    DateTime time = new DateTime();
       

    
  
         }
    
}





