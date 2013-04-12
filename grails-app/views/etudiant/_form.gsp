<%@ page import="projetjee.profile.Etudiant" %>



<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="etudiant.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${etudiantInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'prenom', 'error')} required">
	<label for="prenom">
		<g:message code="etudiant.prenom.label" default="Prenom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="prenom" required="" value="${etudiantInstance?.prenom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="etudiant.password.label" default="Password" />
		
	</label>
	<g:textField name="password" maxlength="10" value="${etudiantInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'role', 'error')} ">
	<label for="role">
		<g:message code="etudiant.role.label" default="Role" />
		
	</label>
	<g:select name="role" from="${etudiantInstance.constraints.role.inList}" value="${etudiantInstance?.role}" valueMessagePrefix="etudiant.role" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'mail', 'error')} required">
	<label for="mail">
		<g:message code="etudiant.mail.label" default="Mail" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="mail" required="" value="${etudiantInstance?.mail}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'reponses', 'error')} ">
	<label for="reponses">
		<g:message code="etudiant.reponses.label" default="Reponses" />
		
	</label>
	<g:select name="reponses" from="${projetjee.reponse.Reponse.list()}" multiple="multiple" optionKey="id" size="5" value="${etudiantInstance?.reponses*.id}" class="many-to-many"/>
</div>

