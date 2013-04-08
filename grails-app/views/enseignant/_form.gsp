<%@ page import="projetjee.Enseignant" %>



<div class="fieldcontain ${hasErrors(bean: enseignantInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="enseignant.email.label" default="Email" />
		
	</label>
	<g:textField name="email" value="${enseignantInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: enseignantInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="enseignant.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${enseignantInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: enseignantInstance, field: 'prenom', 'error')} ">
	<label for="prenom">
		<g:message code="enseignant.prenom.label" default="Prenom" />
		
	</label>
	<g:textField name="prenom" value="${enseignantInstance?.prenom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: enseignantInstance, field: 'pwd', 'error')} ">
	<label for="pwd">
		<g:message code="enseignant.pwd.label" default="Pwd" />
		
	</label>
	<g:textField name="pwd" value="${enseignantInstance?.pwd}"/>
</div>

