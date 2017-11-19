<%@ page import="java.util.List" %>
<%@ page import="com.JavaBean.TdTrade" %>
<%@ page import="java.util.Map" %><%--
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
    <script src="../resource/jquery.PrintArea.js"></script>
<script>
    function printftable() {

        $("#usertab").printArea();
    }
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return decodeURI(r[2]); return null;
    }
    function statistics() {
        var CP =$("#CP").val();
        var ZS =$("#ZS").val();
        var type = getQueryString("type");
        var time  =getQueryString("time");
        var user = getQueryString("user");

        $.ajax({
            //提交数据的类型 POST GET
            type : "GET",
            //提交的网址
            url : "../statistics.do",
            //提交的数据
            data : {
                    CP:CP,
                ZS:ZS,
                TYPE:type,
                USER:user,
                TIME:time
                // type:subtype
            },
            beforeSend:function(){


            },
            success : function(data) {
            alert("查询结果为："+data);
            },
        });
    }

</script>
</head>
<body>
<%
List<TdTrade> tradelist = (List<TdTrade>) request.getAttribute("tradelist");
List<Map<String,Object>> itemlist = (List<Map<String,Object>>) request.getAttribute("useritem");
%>
<div class="container">
    <div class="row clearfix">
        <div id="usertab" class="col-md-12 column">
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h3 class="text-center">
                            详细
                        </h3>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
            <table  class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>
                        姓名
                    </th>
                    <th>
                        菜品
                    </th>

                    <th>
                       主食
                    </th>
                    <th>
                        午餐/晚餐
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
                    <td>
                        <%=t.getTimetype()%>
                    </td>
                </tr>
<%}%>
                </tbody>
            </table>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h3 class="text-center">
                          统计
                        </h3>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr>

                                <th>
                                    餐品
                                </th>
                                <th>
                                    主食
                                </th>
                                <th>
                                    数量
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                    <%for (Map<String,Object> m :itemlist){%>
                            <tr class="success">

                                <td>
                                  <%=m.get("dishestype").toString()%>
                                </td>
                                <td>
                                    <%=m.get("eattype").toString()%>
                                </td>
                                <td>
                                    <%=m.get("item")%>
                                </td>
                            </tr>
                    <%}%>


                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>


</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-4 column">
                </div>
                <div class="col-md-4 column">
                    <button type="button" class="btn btn-default btn-primary"  data-dismiss="modal" onclick="printftable()">打印</button>
                </div>
                <div class="col-md-4 column">
                </div>
            </div>
        </div>
    </div>
</div>





</body>
</html>
