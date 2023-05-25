<#-- @ftlvariable name="article" type="com.example.models.Article" -->
<#-- @ftlvariable name="campos" type="kotlin.collections.List<com.example.models.Campo>"-->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h2>ARTICLE:</h2>
        <h3>
            ${article.title}
        </h3>
        <p>
            ${article.body}
        </p>
        <br><br>
        <h2>CAMPOS:</h2>
        <#list campos as campo>
            <#if campo??>
                <div>
                    <h3>
                        <a href="/campos/${campo.id}">Campo: ${campo.name}</a>
                    </h3>
                    <p>Value: ${campo.value}</p>
                    <p>Season ID: ${campo.seasonId}</p>
                    <p>Order: ${campo.order}</p>
                    <p>Description: ${campo.value}</p>
                </div>
            </#if>
        </#list>
        <hr>
        <p>
            <a href="/articles/${article.id}/edit">Edit article</a>
        </p>
    </div>
</@layout.header>