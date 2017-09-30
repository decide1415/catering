<%--
  Created by IntelliJ IDEA.
  User: decide
  Date: 2017/9/28
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜品预订</title>
    <link href="../resource/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="../resource/jquery-2.1.4.min.js"></script>
    <script src="../resource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="../resource/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <script src="../resource/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
    <script src="../resource/bootstrap-3.3.7-dist/js//locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="../resource/Toolusernmain.js"></script>
    <script src="../resource/json2.js"></script>
</head>
<body>
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
                                <label for="membername">姓名</label><input type="text" class="form-control" id="membername" /><%--<input type="text" class="form-control" id="addcanteenname" />--%>
                            </div>

                            <div class="form-group">
                                <label for="canteentype">食堂</label><select class= "form-control selectpicker"  id="canteentype" ><option>食堂一</option ><option>食堂二</option ></select>
                            </div>
                            <div class="form-group">
                                <label for="eattype">就餐方式</label><select class= "form-control selectpicker"  id="eattype" ><option>打包</option ><option>食堂</option ></select>
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
<<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-6 column">
                            <input type="date" class="form-control" id="suttime" />
                        </div>
                        <div class="col-md-6 column">
                            <select class= "form-control selectpicker"  id="subtype" ><option>套餐一</option ><option>套餐二</option ></select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table" id="addusertable">
                        <thead>
                        <tr>
                            <th>
                              姓名
                            </th>
                            <th>
                               食堂
                            </th>
                            <th>
                                就餐方式
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
</body>
</html>
