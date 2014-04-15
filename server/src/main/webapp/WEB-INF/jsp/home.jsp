<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="form" uri="/WEB-INF/tld/spring-form.tld"%>

<!DOCTYPE html>
<html>

<head>
	<%@ include file="include/head.jsp" %>
</head>
<body>

	<%@ include file="include/navbar.jsp" %>

	<div id="maincontainer" class="container-fluid">
		
		This page has simple links that test location strategies of verious elements.
	
		<div id="divid">Check divid text value</div>
		
		<a id="byId" href="${contextpath}/page/success">success</a><p>
		
		<a href="${contextpath}/page/success">ByLink</a><p>
		
		<a name="byName" href="${contextpath}/page/success">ByName</a>
		
	</div>
	
	<button class="myClass">Test Button by class</button>
	<button id="nexttest">Next Test</button>
<%@ include file="include/javascript.jsp" %>
<script>

	$(function() {
		loadEvent('.myClass', '${contextpath}/page/success');
		loadEvent('#nexttest', '${contextpath}/page/jquery');
	});
	

</script>
</body>
</html>
