<#-- @ftlvariable name="campo" type="com.example.models.campo.Campo" -->
<#-- @ftlvariable name="articles" type="kotlin.collections.List<com.example.models.article.Article>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Edit campo</h3>
        <form action="/campos/${campo.id}" method="post">
            <p>
                <input type="text" name="value" value="${campo.value}">
            </p>
            <p>
                <input type="text" name="name" value="${campo.name}">
            </p>
            <p>
                <input type="text" name="seasonId" value="${campo.seasonId}">
            </p>
            <p>
                <input type="text" name="order" value="${campo.order}">
            </p>
            <p>
                <textarea name="description">${campo.description}</textarea>
            </p>
            <p>
                <select name="sectionId">
                    <#list articles?reverse as article>
                        <option name="sectionOption" value="${article.id}">${article.id}</option>
                    </#list>
                </select>
            </p>
            <p>
                <input type="submit" name="_action" value="update">
            </p>
        </form>
    </div>
    <div>
        <form action="/campos/${campo.id}" method="post" onsubmit="return confirmButton();">
            <p>
                <input type="submit" name="_action" value="delete">
            </p>
        </form>
    </div>
</@layout.header>
