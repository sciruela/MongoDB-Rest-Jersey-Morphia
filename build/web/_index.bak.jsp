<%-- 
    Document   : index
    Created on : Mar 11, 2012, 12:58:30 PM
    Author     : sciruela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="org.mongodb.connection.DBConnection,com.mongodb.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get Information from MongoDB</title>
    </head>
    <body>
        <h1>Data from MongoDB</h1>
        <%
        try{
        if(DBConnection.getDBCollection("things")!=null){
        DBCursor cursor=DBConnection.getDBCollection("things").find();
        while(cursor.hasNext()){
             out.println(cursor.next());
               }
                   }   
               }catch(Exception e){out.println(e.getMessage());}
        %>
        
    </body>
</html>
