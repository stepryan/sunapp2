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


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>Welcome to Sunapp Home Page</title>
    <link rel="stylesheet" href="styles/styles.css" type="text/css" media="screen">
    <meta http-equiv="REFRESH" content="0 ,url=http://sunapp.elasticbeanstalk.com/">
</head>
<body>
              <div id="content" class="container">
<img name="SDO" src="" class="DisplayImage" width="512" height="512" alt="SDO Image" >

</div>
<div>
     	<% String reccount =(String) request.getAttribute("total"); %>
     	<p>Record count is:</p><%=reccount %>
</div>
<div>
  <form name="form1" method="post" action="">
    <label for="VSOAIA">VSOAIA IMAGELIST</label>
    <select name="VSOAIA" id="VSOAIA">
    </select>
  </form>
</div>
       
</body>
</html>