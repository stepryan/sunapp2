<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.amazonaws.*" %>
<%@ page import="com.amazonaws.auth.*" %>
<%@ page import="com.amazonaws.services.ec2.*" %>
<%@ page import="com.amazonaws.services.ec2.model.*" %>
<%@ page import="com.amazonaws.services.s3.*" %>
<%@ page import="com.amazonaws.services.s3.model.*" %>
<%@ page import="com.amazonaws.services.simpledb.*" %>
<%@ page import="com.amazonaws.services.simpledb.model.*" %>
<%@ page import="sunapp.*" %>
<%@ page import= "org.virtualsolar.vso.vsoi.*" %>
<%@ page import= "java.util.List" %>
<%! // Share the client objects across threads to
    // avoid creating new clients for each web request
    private AmazonEC2      ec2;
    private AmazonS3        s3;
    private AmazonSimpleDB sdb;
    private List <GetDataResponseItem> recordtotal ;
 %>

<%
    /*
     * AWS Elastic Beanstalk checks your application's health by periodically
     * sending an HTTP HEAD request to a resource in your application. By
     * default, this is the root or default resource in your application,
     * but can be configured for each environment.
     *
     * Here, we report success as long as the app server is up, but skip
     * generating the whole page since this is a HEAD request only. You
     * can employ more sophisticated health checks in your application.
     */
    if (request.getMethod().equals("HEAD")) return;
%>

<%
    if (ec2 == null) {
        AWSCredentials credentials = new PropertiesCredentials(
            getClass().getClassLoader().getResourceAsStream("AwsCredentials.properties"));
        ec2 = new AmazonEC2Client(credentials);
        s3  = new AmazonS3Client(credentials);
        sdb = new AmazonSimpleDBClient(credentials);
    }
%>

<%
	VSOiService service = new VSOiService(); // creates VSO service using code generated from WSDL to allow it to access service
	VSOiPort port = service.getNsoVSOi();  // creates VSO port to allow queries of DB;
	QueryRequest query =new QueryRequest(); // creates new query to query VSO data;
	Time timeparam = new Time();
    DateTime time = new DateTime();
    VSOWSDLService client = new VSOWSDLService();
   recordtotal =client.returnQuery();






%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>Welcome to Sunapp Home Page</title>
    <link rel="stylesheet" href="styles/styles.css" type="text/css" media="screen">
    <meta http-equiv="REFRESH" content="0 ,url=http://sunapp.elasticbeanstalk.com/hello">
</head>
<body>
  <div class="section grid grid5 s3">
        <h2>Amazon S3 Buckets:</h2>
            <ul>
            <% for (Bucket bucket : s3.listBuckets()) { %>
               <li> <%= bucket.getName() %> </li>
            <% } %>
            </ul>
</div>

        <div class="section grid grid5 sdb">
            <h2>Amazon SimpleDB Domains:</h2>
            <ul>
            <% for (String domainName : sdb.listDomains().getDomainNames()) { %>
               <li> <%= domainName %></li>
            <% } %>
            </ul>
        </div>

<div class="section grid grid5 gridlast ec2">
            <h2>Amazon EC2 Instances:</h2>
            <ul>
            <% for (Reservation reservation : ec2.describeInstances().getReservations()) { %>
           <% for (Instance instance : reservation.getInstances()) { %>
                   <li> <%= instance.getInstanceId() %></li>
                <% } %>
            <% } %>
            </ul>
        </div>
              <div id="content" class="container">
<img name="SDO" src="" width="32" height="32" alt="SDO Image">
</div>
<div>
<ul>
 <%
        	out.print("the number of records returned:"+ recordtotal); %>
</ul>
</div>
       
</body>
</html>