<#macro enumSelect selectName enumClass>
<select name="${selectName}">
    <#list enumClass.values() as enum>
        <option value="${enum}">{$enum.description}</option>
    </#list>
</select>
</#macro>