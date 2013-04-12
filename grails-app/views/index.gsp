<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Application Question/Reponses Interactive</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
				label{
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
			
			<div id="page-body" role="main">
			<h1>Question/Reponses</h1>
			<p>Bienvenue dans notre application interactive Question/Reponses. Le but de cette application réalisée en JEE est de créer un échange entre les professeurs et leurs étudiants autour d'une question.
			Le principe est de poster une question pendant le cours sur cette application,les étudiants y répondent, ensuite le professeurs reçoit un rapport de toutes les réponses, ainsi il a une idée de la tendance de compréhension du cours par ces éleves.</p>
			<p>
			Nous vous invitons à vous authentifier, pour accéder aux différentes questions proposer, ou à vous inscrire si cela n'est pas encore fait.
			</p>

			<div id="controller-list" role="navigation">
				 <h2>Available Controllers:</h2>
				<ul>
				<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
					</g:each>
					<p>
					${flash.message}
					<g:form style="padding-left:200px"  controller="User" action="login" >
							<label>Entrez votre Mail:</label> <input type="text" name="myLogin" value=""/>
							<label>Password :</label> <input type="password" name="myPassword" value=""/>
							<br><label>Rôle :</label> <input type="checkbox" name="myRole" value="Enseignant">Enseignant&nbsp;<input type="checkbox" name="myRole" value="Etudiant">Etudiant
							<label>&nbsp;</label><input type="submit" value="Se connecter"/>
					</g:form>
					<br>
					Si vous n'avez pas encore de compte, nous vous invitons à vous<g:link controller="User" action="create">inscrire ici</g:link> 
				</ul>
			</p>
			</div>
		</div>
	</body>
</html>