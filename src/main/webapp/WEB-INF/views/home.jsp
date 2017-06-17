<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<form:form id="mainForm" method="post" commandName="model">  
           <strong>Choose the batch:</strong>  
           <form:select path="selectedBatch.id" onchange="submitForm()">  
                <form:options items="${model.batches }" itemValue="id" itemLabel="name"/>  
           </form:select>  
           <br/><br/>  
           <strong>Students engaged to the batch: </strong><br/>  
           <c:forEach items="${model.selectedBatch.students }" var="student">  
                ${student.id } - ${student.name } <br/>  
           </c:forEach>            
      </form:form>  
 </body>  
 <script type="text/javascript">  
      function submitForm(){  
           document.getElementById('mainForm').submit();  
      }  
 </script>  
</body>
</html>
