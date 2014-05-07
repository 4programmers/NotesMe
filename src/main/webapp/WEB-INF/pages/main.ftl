<#ftl encoding='UTF-8'>
<#import "/spring.ftl" as spring />
<#import "../resources/macros.ftl" as macros />

<html>
	<head>
		<link href="/resources/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="/resources/jquery-ui.css" rel="stylesheet" media="screen">
	</head>
	<#include "menu.ftl" />
	<body>
		<div class="container">
			<form action="/add" method="post">
				<@spring.formInput "inputBean.name" />
				<input type="submit" value="Wyślij"/>
			</form>
		</div>
	</body>
</html>