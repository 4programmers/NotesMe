<#ftl encoding='UTF-8'>
<#import "/spring.ftl" as spring />
<#import "../resources/macros.ftl" as macros />

<@spring.bind "data" />

<html>
	<head>
		<link href="/resources/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="/resources/jquery-ui.css" rel="stylesheet" media="screen">
	</head>
	<body>
		<#include "menu.ftl" />
		<div class="container">
			<#list data as item>
				${item.name}
				<br/>
			</#list>
		</div>
	</body>
</html>