<%@ page import="projetjee.question.Question" %>



<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'contenuQuestion', 'error')} required">
	<label for="contenuQuestion">
		<g:message code="question.contenuQuestion.label" default="Contenu Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="contenuQuestion" required="" value="${questionInstance?.contenuQuestion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'dateCreationQuestion', 'error')} required">
	<label for="dateCreationQuestion">
		<g:message code="question.dateCreationQuestion.label" default="Date Creation Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateCreationQuestion" precision="day"  value="${questionInstance?.dateCreationQuestion}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'enseignant', 'error')} required">
	<label for="enseignant">
		<g:message code="question.enseignant.label" default="Enseignant" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="enseignant" name="enseignant.id" from="${projetjee.profile.Enseignant.list()}" optionKey="id" required="" value="${questionInstance?.enseignant?.id}" class="many-to-one"/>
</div>

