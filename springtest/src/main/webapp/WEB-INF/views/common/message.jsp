<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>

let msg ='${msg}';
let url = '<c:url value="${url}"></c:url>';
alert(msg);
location.href=url;


</script>