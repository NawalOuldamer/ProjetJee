<%@ page import="projetjee.Inscription" %>



<div class="fieldcontain ${hasErrors(bean: inscriptionInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="inscription.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${inscriptionInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inscriptionInstance, field: 'prenom', 'error')} required">
	<label for="prenom">
		<g:message code="inscription.prenom.label" default="Prenom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="prenom" required="" value="${inscriptionInstance?.prenom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inscriptionInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="inscription.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${inscriptionInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inscriptionInstance, field: 'pwd', 'error')} required">
	<label for="pwd">
		<g:message code="inscription.pwd.label" default="Pwd" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="pwd" maxlength="10" required="" value="${inscriptionInstance?.pwd}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: inscriptionInstance, field: 'pwdC', 'error')} required">
	<label for="pwdC">
		<g:message code="inscription.pwdC.label" default="Pwd C" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="pwdC" required="" value="${inscriptionInstance?.pwdC}"/>
</div>

