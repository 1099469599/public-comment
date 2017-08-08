<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ tag language="java" import="com.cheng.util.CommonUtil" %>
<%@ tag language="java" import="com.cheng.constant.SessionKeyConst" %>
<%@ tag language="java" import="java.util.List" %>
<%@ tag language="java" import="com.cheng.dto.ActionDto" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="url" type="java.lang.String" required="true" %>
<%@ attribute name="method" type="java.lang.String" %>

<% if (CommonUtil.contains(session, url, method)) { %>
<jsp:doBody/>
<% } %>