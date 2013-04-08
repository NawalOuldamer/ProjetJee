<%@ page import="projetjee.Reponse" %>



<div class="fieldcontain ${hasErrors(bean: reponseInstance, field: 'note', 'error')} required">
	<label for="note">
		<g:message code="reponse.note.label" default="Note" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="note" type="number" value="${reponseInstance.note}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: reponseInstance, field: 'reponse', 'error')} ">
	<label for="reponse">
		<g:message code="reponse.reponse.label" default="Reponse" />
		
	</label>
	<g:textField name="reponse" value="${reponseInstance?.reponse}"/>
</div>

