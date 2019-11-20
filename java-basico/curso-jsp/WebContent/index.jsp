<jsp:useBean id="calcula" class="beans.BeanCursoJsp"
	type="beans.BeanCursoJsp" scope="page"></jsp:useBean>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Curso-JSP</title>
</head>
<body>
	<%-- <c:out value="${'Bem vindo ao JSTL' }"></c:out> --%>

	<%-- <c:import var="data" url="https://www.google.com.br"></c:import>
<c:out value="${data}"></c:out>
 --%>

	<%-- <c:set var="data" scope="page" value="${500*6}"></c:set>
<c:remove var="data"/>
<c:out value="${data}"></c:out>
 --%>

	<%-- 
	<c:catch var="erro">
		<%
			int var = 100 / 0;
		%>
	</c:catch>
	<c:if test="${erro != null }">
		${erro.message }
	</c:if>
 --%>

	<%-- <c:set var = "salary" scope = "session" value = "${10*2}"/>
      <p>Your salary is : <c:out value = "${salary}"/></p>
      
      <c:choose>
         
         <c:when test = "${salary > 50}">
      	<c:out value="${'Maior que 50' }"></c:out>
         </c:when>
         
         <c:when test = "${salary < 50}">
           	<c:out value="${'Menor que 50' }"></c:out>
         </c:when>
         
         <c:otherwise>
           	<c:out value="${'Não encontrou Valor' }"></c:out>
         </c:otherwise>
      </c:choose>
 --%>

	<%--  <c:forEach var="n" begin="1" end="${20}">
 	 Item: ${n}
 </c:forEach> --%>

	<%-- 
 <c:forTokens items="thomas-erick-fernandes" delims="-" var="nome">
    Nome: <c:out value="${nome }"></c:out> 
 </c:forTokens>
 --%>

	<%-- <c:url value="acessoLiberado.jsp" var="acesso">
<c:param name="param1" value="123"></c:param>
<c:param name="param2" value="123"></c:param>
</c:url>
${acesso }
 --%>

<%-- <c:set var = "numero" scope = "session" value = "${100*2}"/>
	<c:if test="${numero >=50}">
		<c:redirect url="https://www.google.com.br"></c:redirect>
	</c:if> --%>

	<!-- 	<h1>Index</h1>
	<form action="LoginServlet" method="post">
		<input type="text" id="login" name="login">
		<br /> 
		<input type="text" id="senha" name="senha"> 
		<br />
		<input type="submit" value="logar">
	</form> -->
</body>
</html>