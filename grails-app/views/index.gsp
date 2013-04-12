
<html>
	<head>
	Authentification
	</head>

	<body>

	<g:form controller="UserController" action="authenticate" style="padding-left:200px">
		<div style="width:200px">		
			Email : <g:textField name="myField" value="" />
			Password : <g:passwordField name="myPasswordField" value="" />			
		</div> 		
		<g:actionSubmit value="Login"/>	
		<g:actionSubmit value="register"/>	
			
	</g:form>	
</body>
</html>