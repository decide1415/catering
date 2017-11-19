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
    <%--<link href="../resource/select2/bootstrap-select.min.css" rel="stylesheet">--%>
    <link href="../resource/select2/select2.min.css" rel="stylesheet">
    <script src="../resource/jquery-2.1.4.min.js"></script>
    <script src="../resource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="../resource/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <script src="../resource/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
    <script src="../resource/bootstrap-3.3.7-dist/js//locales/bootstrap-datetimepicker.zh-CN.js"></script>

    <script src="../resource/json2.js"></script>
    <script src="../resource/jquerySession.js"></script>
    <script src="../resource/select2/select2.min.js"></script>
    <script src="../resource/select2/zh-CN.js"></script>
    <%--<script src="../resource/select2/select2.full.min.js"></script>--%>
    <%--<script src="../resource/select2/bootstrap-select.min.js"></script>--%>

    <script src="../resource/Toolusernmain.js"></script>



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

            <div class="modal fade" id="addcanteenmain" role="dialog" aria-labelledby="addcanteeLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="addcanteeLabel">

                            </h4>
                            <input id="bigen" style="display: none"/>

                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="membername">姓名</label>
                                <%--<select id="membername" class=" form-control " multiple="multiple">--%>

                                <%--</select>--%>
                                <input id="membername" type="text" class="form-control" id="bookselectname"  oninput="selectmember($(this))"/>

                                <select id="namelist" multiple class="form-control">

                                </select>

                                <br/>
                                <%--<input type="text" class="form-control" id="membername" />&lt;%&ndash;<input type="text" class="form-control" id="addcanteenname" />&ndash;%&gt;--%>
                            </div>

                            <div class="form-group">
                                <label for="canteentype">食堂</label><select class= "form-control selectpicker"  id="canteentype" autocomplete="off" ><option name='ByST1' selected="selected">食堂一</option ><option name='ByST2'>食堂二</option ></select>
                            </div>
                            <div class="form-group">
                                <label for="eattype">主食</label><select class= "form-control selectpicker"  id="eattype" ><option selected="selected">米饭</option ><option>面</option ></select>
                            </div>
                            <div class="form-group">
                                <label for="eattype">午餐/晚餐</label><select class= "form-control selectpicker"  id="timetype" ><option selected="selected">午餐</option ><option>晚餐</option ></select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary" onclick="if(xy()){save()}else {alert('请填写姓名！')}">保存</button>
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
            <div class="row clearfix">
                <div class="container">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <div class="row clearfix">
                                <div class="col-md-5 column">
                                    <dl>
                                        <dt class="text-center">
                                            <h3 id="dishes1H"></h3>
                                        </dt>
                                        <dd id="dishes1info" style="font-weight: bold;font-size: 18px">

                                        </dd>

                                    </dl>
                                </div>
                                <div class="col-md-2 column">
                                </div>
                                <div class="col-md-5 column">
                                    <dl>
                                        <dt class="text-center">
                                          <h3 id="dishes2H"></h3>
                                        </dt>
                                        <dd id="dishes2info" style="font-weight: bold;font-size: 18px">

                                        </dd>

                                    </dl>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-6 column">

                            <div class="form-group">
                                <label for="suttime">订餐时间</label> <input type="date" class="form-control" id="suttime" onchange="selectDishes($(this).val())" />
                            </div>
                        </div>
                        <div class="col-md-6 column">
                            <%--<select class= "form-control selectpicker"  id="subtype" ><option>套餐一</option ><option>套餐二</option ></select>--%>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h3 id="ByTC1" name="套餐一"  class="text-center">
                            套餐一
                        </h3>
                    </div>
                </div>
            </div>
            <div class="row clearfix" >
                <div class="col-md-12 column">
                    <table class="table" id="addusertableByTC1">
                        <thead>
                        <tr>
                            <th>
                              姓名
                            </th>
                            <th>
                                套餐
                            </th>
                            <th>
                               食堂
                            </th>
                            <th>
                                就餐方式
                            </th>
                            <th>
                                午餐/晚餐
                            </th>

                            <th>
                              操作
                            </th>
                        </tr>
                        </thead>
                        <tbody id="canteenbodyByTC1">


                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-4 column">
                            <a id="modal-52640" href="#addcanteenmain" role="button" class="btn btn-primary" data-toggle="modal" onclick="addthis('ByTC1')">添加</a>
                        </div>
                        <div class="col-md-4 column">

                        </div>
                        <div class="col-md-4 column">
                            <%--<button type="button" class="btn btn-primary" onclick="Confirmed()">提交</button>--%>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h3 id="ByTC2" name = "套餐二" class="text-center">
                            套餐二
                        </h3>
                    </div>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table" id="addusertableByTC2">
                        <thead>
                        <tr>
                            <th>
                                姓名
                            </th>
                            <th>
                                套餐
                            </th>
                            <th>
                                食堂
                            </th>
                            <th>
                                就餐方式
                            </th>
                            <th>
                                午餐/晚餐
                            </th>
                            <th>
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody id="canteenbodyByTC2">


                        </tbody>
                    </table>
                </div>
            </div>

                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <div class="row clearfix">
                            <div class="col-md-4 column">
                                <a id="modal-52640" href="#addcanteenmain" role="button" class="btn btn-primary" data-toggle="modal" onclick="addthis('ByTC2')">添加</a>
                            </div>
                            <div class="col-md-4 column">

                            </div>
                            <div class="col-md-4 column">

                            </div>
                        </div>
                    </div>
                </div>
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h3 id="ByTC3" name="回民餐"  class="text-center">
                           回民餐
                        </h3>
                    </div>
                </div>
            </div>
            <div class="row clearfix" >
                <div class="col-md-12 column">
                    <table class="table" id="addusertableByTC3">
                        <thead>
                        <tr>
                            <th>
                                姓名
                            </th>
                            <th>
                                套餐
                            </th>
                            <th>
                                食堂
                            </th>
                            <th>
                                就餐方式
                            </th>
                            <th>
                                午餐/晚餐
                            </th>
                            <th>
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody id="canteenbodyByTC3">


                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-4 column">
                            <a id="modal-52640" href="#addcanteenmain" role="button" class="btn btn-primary" data-toggle="modal" onclick="addthis('ByTC3')">添加</a>
                        </div>
                        <div class="col-md-4 column">

                        </div>
                        <div class="col-md-4 column">
                            <button id="sub" type="button" class="btn btn-primary" onclick="if($('#suttime').val().replace(/\s/g, '') !=''){Confirmed()}else {alert('请选择订餐时间')}">提交</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

</body>

</html>
