<#-- @ftlvariable name="articles" type="kotlin.collections.List<com.example.models.article.Article>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Create campo</h3>
        <form action="/campos" method="post">
            <p>
                <label for="value">Value:</label>
                <input type="text" name="value">
            </p>
            <p>
                <label for="name">Name:</label>
                <input type="text" name="name">
            </p>
            <p>
                <label for="seasonId">SeasonID:</label>
                <input type="text" name="seasonId">
            </p>
            <p>
                <label for="order">Order:</label>
                <input type="text" name="order">
            </p>
            <p>
                <label for="description">Description:</label>
                <textarea name="description"></textarea>
            </p>
            <p>
                <label for="sectionId">Section Id:</label>
                <select name="sectionId">
                    <#list articles?reverse as article>
                        <option name="sectionOption" value="${article.id}">${article.id}</option>
                    </#list>
                </select>
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</@layout.header>