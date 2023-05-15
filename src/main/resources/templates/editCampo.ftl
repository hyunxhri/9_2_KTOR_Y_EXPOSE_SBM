<#-- @ftlvariable name="campo" type="com.example.models.Campo" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        val id: String, val value: String, val name: String, val description: String, val seasonId: String, val order: Int
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
        </form>
    </div>
    <div>
        <form action="/campos/${campo.id}" method="post">
            <p>
                <input type="submit" name="_action" value="delete">
            </p>
        </form>
    </div>
</@layout.header>