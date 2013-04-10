<%@ page import="projetjee.Cours" %>



<div class="fieldcontain ${hasErrors(bean: coursInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="cours.nom.label" default="Nom" />
		
	</label>
	<g:select name="nom" from="${coursInstance.constraints.nom.inList}" value="${coursInstance?.nom}" valueMessagePrefix="cours.nom" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coursInstance, field: 'utilisateur', 'error')} ">
	<label for="utilisateur">
		<g:message code="cours.utilisateur.label" default="Utilisateur" />
		
	</label>
	
</div>

