<%--
  Created by IntelliJ IDEA.
  User: decide
  Date: 2017/9/27
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜品管理</title>
    <link href="../resource/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="../resource/jquery-2.1.4.min.js"></script>
    <script src="../resource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="../resource/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <script src="../resource/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
    <script src="../resource/bootstrap-3.3.7-dist/js//locales/bootstrap-datetimepicker.zh-CN.js"></script>

    <script>
        function init() {
            $('.form_date').datetimepicker({
                language:  'zh-CN',
                weekStart: 1,
                todayBtn:  1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                minView: 2,
                forceParse: 0
            });
        }

    </script>
</head>
<body onload="init()">
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-striped">
                <thead>
                <tr>

                    <th>
                        菜品名称
                    </th>
                    <th>
                       菜品明细
                    </th>
                    <th>
                        就餐日期
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <input type="text" class="form-control" id="name" name="name" />
                    </td>
                    <td>
                        <input type="text" class="form-control" id="remarks" name="remarks" />
                    </td>
                    <td>
                        <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd">
                            <input class="form-control" size="16" type="text" value="" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>

                    </td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
