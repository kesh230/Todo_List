    <%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
    <div class="container">
        <h2>Enter new list of todos details:-</h2>
        <form:form method="post" modelAttribute="todo">
            <fieldset class="mb-3">
               <form:label path="description">Description</form:label>
               <form:input type="text"  path="description" required="required"/>
               <form:errors path="description" cssClass="text-warning"/>
            </fieldset>
            <fieldset class="mb-3">
               <form:label path="localdate">TargetDate</form:label>
               <form:input type="text"  path="localdate" required="required"/>
               <form:errors path="localdate" cssClass="text-warning"/>
            </fieldset>
            <!-- <form:input type="text"  path="id"/> -->
                <form:input type="text"  path="done"/>
            <input type="submit" class="btn btn-success"/>
        </form:form>
    </div>
<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
	$('#localdate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>