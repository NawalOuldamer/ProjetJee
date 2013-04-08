
<%@ page import="projetjee.Inscription" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'inscription.label', default: 'Inscription')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-inscription" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-inscription" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nom" title="${message(code: 'inscription.nom.label', default: 'Nom')}" />
					
						<g:sortableColumn property="prenom" title="${message(code: 'inscription.prenom.label', default: 'Prenom')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'inscription.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="pwd" title="${message(code: 'inscription.pwd.label', default: 'Pwd')}" />
					
						<g:sortableColumn property="pwdC" title="${message(code: 'inscription.pwdC.label', default: 'Pwd C')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${inscriptionInstanceList}" status="i" var="inscriptionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${inscriptionInstance.id}">${fieldValue(bean: inscriptionInstance, field: "nom")}</g:link></td>
					
						<td>${fieldValue(bean: inscriptionInstance, field: "prenom")}</td>
					
						<td>${fieldValue(bean: inscriptionInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: inscriptionInstance, field: "pwd")}</td>
					
						<td>${fieldValue(bean: inscriptionInstance, field: "pwdC")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${inscriptionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
