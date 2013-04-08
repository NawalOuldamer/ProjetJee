<%@ page import="projetjee.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'enseignant', 'error')} required">
	<label for="enseignant">
		<g:message code="user.enseignant.label" default="Enseignant" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="enseignant" name="enseignant.id" from="${projetjee.Enseignant.list()}" optionKey="id" required="" value="${userInstance?.enseignant?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'etudiant', 'error')} required">
	<label for="etudiant">
		<g:message code="user.etudiant.label" default="Etudiant" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="etudiant" name="etudiant.id" from="${projetjee.Etudiant.list()}" optionKey="id" required="" value="${userInstance?.etudiant?.id}" class="many-to-one"/>
</div>

