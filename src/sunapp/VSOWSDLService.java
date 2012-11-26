package sunapp;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
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
import sunapp.DateTime;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.List;

import java.rmi.RemoteException;

@WebService
@SOAPBinding(style = Style.RPC)

@SuppressWarnings({ "unused", "restriction" })
public class VSOWSDLService {
	
    int numberofrecordsfound;
    int numberofrecordsreturned;
    
    
    public  DateTime setTime(DateTime time){
    	return time;
    }
  
   // String currentTime =  timedate.stringCurrentDate();
    VSOiService service = new VSOiService(); // creates VSO service using code generated from WSDL to allow it to access service
    VSOiPort port = service.getNsoVSOi();  // creates VSO port to allow queries of DB;
    QueryRequest query =new QueryRequest(); // creates new query to query VSO data;
  
    QueryRequestBlock datablock = new QueryRequestBlock();
    public int returnQuery() {
    	Time timeParamaters = new Time();
    	timeParamaters.setStart("20121126161400");
    	   timeParamaters.setEnd(  "20121126151500");     
    	   
    	//    getTimeParams(timeParameters);    	     
    	query.setVersion(new Float("0.6").floatValue());
    	     
    	     datablock.setTime(timeParamaters);
    	     datablock.setPixels("1024");
    	     datablock.setProvider("jsoc");
    	     datablock.setInstrument("aia");
    	     Field fields  = new Field();
    	     List <String> items = fields.getFielditem();
    	     items.add("thumbnail");
    	     items.add("detector");
    	     datablock.setField(fields);
    	     query.setBlock(datablock);
    	     QueryResponse response = port.query(query);
    	     List<ProviderQueryResponse> queryReturn = response.getProvideritem();
    	     Map<String,List<String>> getDataMap = new HashMap<String,List<String>>();
    	     for(ProviderQueryResponse queryresponse:queryReturn) {
    	    	 System.out.println("Provider:" + queryresponse.getProvider());
    	    	 if(queryresponse.getStatus() != null) {
    	    		System.out.println("Status" + queryresponse.getStatus()) ;
    	    		System.out.println("Number of Records Found:"+ queryresponse.getNoOfRecordsFound());
    	    		System.out.println("Number of Records Returned" + queryresponse.getNoOfRecordsReturned());
    	    		
    	    		numberofrecordsfound = queryresponse.getNoOfRecordsFound();
    	    		numberofrecordsreturned = queryresponse.getNoOfRecordsReturned();
    	    		
    	    		QueryResponseBlockArray block = queryresponse.getRecord();
    	    	 }
    	     }
    	     return numberofrecordsfound;
    }
  

}
