<#-- @ftlvariable name="campo" type="com.example.models.Campo" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>
            Campo: ${campo.name}
        </h3>
        <p>
            ID: ${campo.id}
        </p>
        <p>
           Value: ${campo.value}
        </p>
        <p>
           SeasonID: ${campo.seasonId}
        </p>
        <p>
           Order: ${campo.order}
        </p>
        <p>
           Description: ${campo.description}
        </p>
        <hr>
        <p>
            <a href="/campos/${campo.id}/edit">Edit campo</a>
        </p>
    </div>
</@layout.header>