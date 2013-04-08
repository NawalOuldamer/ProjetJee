
<%@ page import="projetjee.Inscription" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'inscription.label', default: 'Inscription')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-inscription" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-inscription" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list inscription">
			
				<g:if test="${inscriptionInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="inscription.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${inscriptionInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${inscriptionInstance?.prenom}">
				<li class="fieldcontain">
					<span id="prenom-label" class="property-label"><g:message code="inscription.prenom.label" default="Prenom" /></span>
					
						<span class="property-value" aria-labelledby="prenom-label"><g:fieldValue bean="${inscriptionInstance}" field="prenom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${inscriptionInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="inscription.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${inscriptionInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${inscriptionInstance?.pwd}">
				<li class="fieldcontain">
					<span id="pwd-label" class="property-label"><g:message code="inscription.pwd.label" default="Pwd" /></span>
					
						<span class="property-value" aria-labelledby="pwd-label"><g:fieldValue bean="${inscriptionInstance}" field="pwd"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${inscriptionInstance?.pwdC}">
				<li class="fieldcontain">
					<span id="pwdC-label" class="property-label"><g:message code="inscription.pwdC.label" default="Pwd C" /></span>
					
						<span class="property-value" aria-labelledby="pwdC-label"><g:fieldValue bean="${inscriptionInstance}" field="pwdC"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${inscriptionInstance?.id}" />
					<g:link class="edit" action="edit" id="${inscriptionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
