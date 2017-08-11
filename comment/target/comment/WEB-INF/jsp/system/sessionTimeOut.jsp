<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>session超时</title>

    <script type="text/javascript" src="${basePath}/js/common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${basePath}/js/common/common.js"></script>
    <script type="text/javascript">
        $(function () {
            common.showMessage("${pageCode.msg}");
            //获取顶层window
            var topWindow = window;
            while (topWindow.parent != topWindow) {
                topWindow = topWindow.parent;
            }
            topWindow.location.href = "${basePath}/login";
        });
    </script>
</head>
<body>

</body>
</html>
