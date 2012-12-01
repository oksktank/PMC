<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/upload">

 
                <p>
                    Name<br/>
                    <input type="text" name="name"/>
                </p>
 
                <p>
                    File<br/>
                    <input name="fileData" type="file"/>
                </p>
 
                <p>
                    <input type="submit" />
                </p>
 
        </form>