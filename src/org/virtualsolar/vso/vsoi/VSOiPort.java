
package org.virtualsolar.vso.vsoi;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "VSOiPort", targetNamespace = "http://virtualsolar.org/VSO/VSOi")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface VSOiPort {


    /**
     * 
     * @param body
     * @return
     *     returns org.virtualsolar.vso.vsoi.QueryResponse
     */
    @WebMethod(operationName = "Query", action = "http://virtualsolar.org/VSO/VSOi#Query")
    @WebResult(name = "body", partName = "body")
    public QueryResponse query(
        @WebParam(name = "body", partName = "body")
        QueryRequest body);

    /**
     * 
     * @param body
     * @return
     *     returns org.virtualsolar.vso.vsoi.VSOGetDataResponse
     */
    @WebMethod(operationName = "GetData", action = "http://virtualsolar.org/VSO/VSOi#GetData")
    @WebResult(name = "body", partName = "body")
    public VSOGetDataResponse getData(
        @WebParam(name = "body", partName = "body")
        VSOGetDataRequest body);

}
