<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todo Page</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<s:form action="saveOrUpdateTask">
	<s:push value="task">
		<s:hidden name="id" />
		<s:textfield name="task_name" label="Task Name" required="true"/>
		<s:radio name="priority" label="Priority" list="{'High','Low','Medium'}" />
		<s:select name="status" list="{'WIP','Completed','Abandoned'}" headerKey=""
			headerValue="Select" label="Select Status" />
		<s:textfield name="duedate" label="Due Date" />
		
		<s:submit />
	</s:push>
</s:form>
<s:if test="taskList.size() > 0">
	<div class="content">
	<table class="userTable" cellpadding="5px">
		<tr class="even">
			<th>Task</th>
			<th>Priority</th>
			<th>Status</th>
			<th>Due Date</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<s:iterator value="taskList" status="taskStatus">
			<tr
				class="<s:if test="#taskStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="task_name" /></td>
				<td><s:property value="priority" /></td>
				<td><s:property value="status" /></td>
				<td><s:property value="duedate" /></td>
				<td><s:url id="editURL" action="editTask">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="deleteTask">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>

</body>
</html>