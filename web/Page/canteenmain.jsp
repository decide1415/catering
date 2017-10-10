<%--
  Created by IntelliJ IDEA.
  User: decide
  Date: 2017/9/28
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>餐品管理</title>
    <link href="../resource/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="../resource/jquery-2.1.4.min.js"></script>
    <script src="../resource/jquerySession.js"></script>
    <script src="../resource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="../resource/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <script src="../resource/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
    <script src="../resource/bootstrap-3.3.7-dist/js//locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="../resource/Toolcanteenmain.js"></script>
    <script src="../resource/json2.js"></script>


</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-8 column">
                        </div>
                        <div class="col-md-4 column">
                            <div class="row clearfix">
                                <div class="col-md-6 column">
                                    <p>

                                    </p>
                                </div>
                                <div class="col-md-6 column">
                                    <button type="button" class="btn btn-primary btn-block btn-default" onclick="exit()" >退出</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="tabbable" id="tabs-993075">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#panel-799116" data-toggle="tab">订餐查询</a>
                            </li>
                            <li >
                                <a href="#panel-130906" data-toggle="tab">餐品发布</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="panel-799116">

                                <div class="container">
                                    <div class="row clearfix">
                                        <div class="col-md-12 column">
                                            <div class="row clearfix">
                                                <div class="col-md-2 column">
                                                    <h4 class="text-center">查询条件</h4>
                                                </div>
                                                <div class="col-md-7 column">
                                                    <div class="row clearfix">
                                                        <div class="col-md-4 column">

                                                            <input type="date" class="form-control" id="selecttime" />
                                                        </div>
                                                        <div class="col-md-4 column">

                                                            <select class= "form-control selectpicker"  id="selecttype" ><option>食堂一</option ><option>食堂二</option ></select>

                                                        </div>
                                                        <div class="col-md-4 column">
                                                            <button type="button" class="btn btn-default btn-primary" onclick="seelctcount()">查询</button>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="col-md-1 column">
                                                </div>
                                            </div>
                                            <div class="row clearfix">
                                                <div class="col-md-12 column">
                                                    <table class="table table-hover table-bordered">
                                                        <thead>
                                                        <tr>
                                                            <th>
                                                               订餐账户
                                                            </th>
                                                            <th>
                                                                套餐一
                                                            </th>
                                                            <th>
                                                                套餐二
                                                            </th>
                                                            <th>
                                                                操作
                                                            </th>
                                                        </tr>
                                                        </thead>
                                                        <tbody id="selecttbody">




                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="tab-pane " id="panel-130906">
                                <div class="container">
                                    <div class="row clearfix">
                                        <div class="col-md-12 column">


                                            <div class="modal fade" id="addcanteenmain" role="dialog" aria-labelledby="addcanteeLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                            <h4 class="modal-title" id="addcanteeLabel">

                                                            </h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="form-group">
                                                                <label for="addcanteenname">菜品名称</label><select class= "form-control selectpicker"  id="addcanteenname" ><option>套餐一</option ><option>套餐二</option ></select> <%--<input type="text" class="form-control" id="addcanteenname" />--%>
                                                            </div>

                                                            <div class="form-group">
                                                                <label for="addcanteenremarks">菜品说明</label><textarea id="addcanteenremarks" class="form-control" rows="3"></textarea>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="addcanteentime">就餐时间</label><input type="date" class="form-control" id="addcanteentime" />
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary" onclick="save()">保存</button>
                                                        </div>
                                                    </div>

                                                </div>

                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="container">
                                    <div class="row clearfix">
                                        <div class="col-md-12 column">

                                            <div class="modal fade" id="Confirmed" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                            <h4 class="modal-title" id="myModalLabel">

                                                            </h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <h2 style="color: red">注意！</h2><br><h4>餐品提交后将无法更改或删除！</h4>
                                                    </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">返回</button> <button type="button" class="btn btn-primary" onclick="submitadd()">继续提交</button>
                                                        </div>
                                                    </div>

                                                </div>

                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="container">
                                    <div class="row clearfix">
                                        <div class="col-md-12 column">
                                            <table id="addtable" class="table table-bordered table-hover">
                                                <thead>
                                                <tr>
                                                    <th>
                                                       菜品名称
                                                    </th>
                                                    <th>
                                                        菜品说明
                                                    </th>
                                                    <th>
                                                        就餐时间
                                                    </th>
                                                    <th>
                                                        操作
                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody id="canteenbody">

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="container">
                                    <div class="row clearfix">
                                        <div class="col-md-12 column">
                                            <div class="row clearfix">
                                                <div class="col-md-4 column">
                                                    <a id="modal-52640" href="#addcanteenmain" role="button" class="btn btn-primary" data-toggle="modal" onclick="addthis()">添加</a>
                                                </div>
                                                <div class="col-md-4 column">

                                                </div>
                                                <div class="col-md-4 column">
                                                    <button type="button" class="btn btn-primary" onclick="Confirmed()">提交</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
