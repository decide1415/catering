<%@ page import="java.util.List" %>
<%@ page import="com.JavaBean.TdTrade" %><%--
  Created by IntelliJ IDEA.
  User: decide
  Date: 2017/10/8
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详细</title>
    <link href="../resource/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="../resource/jquery-2.1.4.min.js"></script>
    <script src="../resource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="../resource/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <script src="../resource/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
    <script src="../resource/bootstrap-3.3.7-dist/js//locales/bootstrap-datetimepicker.zh-CN.js"></script>

</head>
<body>
<%
List<TdTrade> tradelist = (List<TdTrade>) request.getAttribute("tradelist");
%>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>
                        姓名
                    </th>
                    <th>
                        菜品
                    </th>

                    <th>
                       就餐方式
                    </th>
                </tr>
                </thead>
                <tbody>
<% for (TdTrade t:tradelist){%>
                <tr class="success">
                    <td>
                       <%=t.getMembername()%>
                    </td>
                    <td>
                        <%=t.getDishestype()%>
                    </td>

                    <td>
                       <%=t.getEattype()%>
                    </td>
                </tr>
<%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
