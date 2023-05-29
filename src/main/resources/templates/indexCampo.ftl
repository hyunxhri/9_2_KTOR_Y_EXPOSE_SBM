<#-- @ftlvariable name="campos" type="kotlin.collections.List<com.example.models.campo.Campo>"-->
<#import "_layout.ftl" as layout />
<@layout.header>
    <#list campos?reverse as campo>
        <div>
            <h3>
                <a href="/campos/${campo.id}">Campo: ${campo.name}</a>
            </h3>
            <p>Value: ${campo.value}</p>
            <p>Season ID: ${campo.seasonId}</p>
            <p>Order: ${campo.order}</p>
            <p>Description: ${campo.value}</p>
        </div>
    </#list>
    <hr>
    <p>
        <a href="/campos/new">Create campo</a>
    </p>
</@layout.header>