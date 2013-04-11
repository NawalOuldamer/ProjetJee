<%@ page import="projetjee.Reponse" %>



<div class="fieldcontain ${hasErrors(bean: reponseInstance, field: 'contenuReponse', 'error')} required">
	<label for="contenuReponse">
		<g:message code="reponse.contenuReponse.label" default="Contenu Reponse" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="contenuReponse" required="" value="${reponseInstance?.contenuReponse}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reponseInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="reponse.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${projetjee.User.list()}" optionKey="id" required="" value="${reponseInstance?.user?.id}" class="many-to-one"/>
</div>

