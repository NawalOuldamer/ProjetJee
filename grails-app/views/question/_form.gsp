<%@ page import="projetjee.Question" %>



<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'question', 'error')} ">
	<label for="question">
		<g:message code="question.question.label" default="Question" />
		
	</label>
	<g:textField name="question" value="${questionInstance?.question}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'reponse', 'error')} ">
	<label for="reponse">
		<g:message code="question.reponse.label" default="Reponse" />
		
	</label>
	<g:select name="reponse" from="${projetjee.Reponse.list()}" multiple="multiple" optionKey="id" size="5" value="${questionInstance?.reponse*.id}" class="many-to-many"/>
</div>

