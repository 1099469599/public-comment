<%@ tag language="java" pageEncoding="utf-8" %>
<%-- attributeb：标签的属性 type：java类型 name：自定义属性名  required="true"：表示必须传递该参数 --%>
<%@ attribute type="com.github.pagehelper.PageInfo" name="page" required="true" %>
<%@ attribute type="java.lang.String" name="jsMethodName" required="true" %>

<script type="text/javascript">
    /**
     *页码查询
     */
    function transCurrentPage(pageNum) {
        var rule = /^[0-9]*[1-9][0-9]*$/;
        if (!rule.test(pageNum)) {
            pageNum = 1;
        }
        eval("${jsMethodName}(pageNum);");
    }
</script>

<div class="page fix">
    <a href="javascript:transCurrentPage('1');" class="first">首页</a>
    <a href="javascript:transCurrentPage('${page.prePage}');" class="pre">上一页</a>
    当前第<span> ${page.pageNum}/${page.pages} </span>页
    <a href="javascript:transCurrentPage('${page.nextPage}');" class="next">下一页</a>
    <a href="javascript:transCurrentPage('${page.pages}');" class="last">末页</a>
    跳至 &nbsp;<input id="currentPageText" value="1" class="allInput w28" type="text"/>&nbsp;页 &nbsp;
    <%-- TODO 跳到最后一页显示5个 --%>
    <a href="javascript:transCurrentPage($('#currentPageText').val());" class="go">GO</a>
</div>