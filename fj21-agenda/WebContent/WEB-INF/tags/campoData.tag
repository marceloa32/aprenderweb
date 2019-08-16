<%@ attribute name="id" required="true" %>
<%@ attribute name="valor" required="false" %>
<input type="text" id="${id}" name="${id}" value="${valor}"/>
<script type="text/javascript">    	
    $("#${id}").datepicker({
		dateFormat: 'dd/mm/yy',
		changeMonth: true,
		changeYear: true
	});
</script>