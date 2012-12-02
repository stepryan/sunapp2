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
import java.util.ArrayList;
import java.util.SimpleTimeZone;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.List;

import java.rmi.RemoteException;

@WebService
@SOAPBinding(style = Style.RPC)

@SuppressWarnings({ "unused" })
public class VSOWSDLService {
	
    int numberofrecordsfound;
    int numberofrecordsreturned;
    
    
 
    VSOiService service = new VSOiService(); // creates VSO service using code generated from WSDL to allow it to access service
    VSOiPort port = service.getNsoVSOi();  // creates VSO port to allow queries of DB;
    QueryRequest query =new QueryRequest(); // creates new query to query VSO data;
  
    QueryRequestBlock datablock = new QueryRequestBlock();
    public List<GetDataResponseItem> returnQuery() {
    	Time timeParamaters = new Time();
    	DateTime time = new DateTime();
    	List<String[]> querydata = new ArrayList<String[]>();
    	     
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
    	    	 if(queryresponse.getStatus() != null) 
    	    		
    	    		numberofrecordsfound = queryresponse.getNoOfRecordsFound();
    	    		numberofrecordsreturned = queryresponse.getNoOfRecordsReturned();
    	    		
    	    		QueryResponseBlockArray block = queryresponse.getRecord();
    	    		
    	    	 
    	    	 List <QueryResponseBlock> records = block.getRecorditem();
    	    	 for(QueryResponseBlock rec:records ){
        	    	 List<String> fids = null;
        	    	 String provider = rec.getProvider();
        	    	 if(!getDataMap.containsKey(provider)){
        	    	 fids = new ArrayList<String>();
        	    	 getDataMap.put(provider, fids);
        	    	 } else{
        	    		 fids = getDataMap.get(provider);
        	    	 }
        	    	 fids.add(rec.getFileid());
    	     }
    	     
    	    
    	     
    }
    	     
    	     
    	     VSOGetDataRequest vsodRequest = new VSOGetDataRequest();
    	     GetDataRequest request = new GetDataRequest();
    	     MethodItem Item = new MethodItem();
    	     List<String> getDataMethods = Item.getMethodtype();
    	     getDataMethods.add("URL-File");
    	     request.setMethod(Item);
    	     
    	     DataContainer data = new DataContainer();
    	     List<DataRequestItem> listOfData = new ArrayList<DataRequestItem>();
    	     List<DataRequestItem> dataReqList = new ArrayList<DataRequestItem>();
    	     
    	     for (Object provider: getDataMap.keySet().toArray()){
    	    	 DataRequestItem element = new DataRequestItem();
    	    	 element.setProvider((String) provider);
    	    	 dataReqList.add(element);
    	    	 List<String> fids = getDataMap.get(provider);
    	    	 FileidItem fidItem = new FileidItem();
    	    	 element.setFileiditem(fidItem);
    	    	 
    	    	 List <String> fidList = fidItem.getFileid();
    	    	 
    	    	 fidList.addAll(fids);
    	    	 
    	     }
    	     
    	     listOfData.addAll(dataReqList);
    	     List<DataRequestItem> drItems = data.getDatarequestitem();
    	     for(DataRequestItem drItem:drItems){
    	    	 List<String> fids = drItem.getFileiditem().getFileid();
    	     }
    	     
    	     request.setDatacontainer(data);
    	     
    	     vsodRequest.setRequest(request);
    	     vsodRequest.setVersion("1");
    	     
    	     VSOGetDataResponse gdResponse = port.getData(vsodRequest);
    	     
    	     List<GetDataResponseItem> grespItem = gdResponse.getGetdataresponseitem();
    	     for(GetDataResponseItem item:grespItem){
    	    	 String provider  = item.getProvider();
    	    	 GetDataItem gItem = item.getGetdataitem();
    	    	 List<DataItem> dItem = gItem.getDataitem();
    	    	 
    	    	
    	     }
    	     
    	     
    	     
    	     return grespItem;
    	     
    	     

    }
}
