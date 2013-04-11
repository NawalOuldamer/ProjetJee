<%@ page import="projetjee.Question" %>



<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'ennonce', 'error')} required">
	<label for="ennonce">
		<g:message code="question.ennonce.label" default="Ennonce" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ennonce" required="" value="${questionInstance?.ennonce}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'dateCreation', 'error')} required">
	<label for="dateCreation">
		<g:message code="question.dateCreation.label" default="Date Creation" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateCreation" precision="day"  value="${questionInstance?.dateCreation}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'enseignant', 'error')} required">
	<label for="enseignant">
		<g:message code="question.enseignant.label" default="Enseignant" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="enseignant" name="enseignant.id" from="${projetjee.Enseignant.list()}" optionKey="id" required="" value="${questionInstance?.enseignant?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'reponses', 'error')} ">
	<label for="reponses">
		<g:message code="question.reponses.label" default="Reponses" />
		
	</label>
	<g:select name="reponses" from="${projetjee.Reponse.list()}" multiple="multiple" optionKey="id" size="5" value="${questionInstance?.reponses*.id}" class="many-to-many"/>
</div>

