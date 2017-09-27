<%--
  Created by IntelliJ IDEA.
  User: decide
  Date: 2017/9/26
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登陆</title>
    <link href="resource/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="resource/jquery-2.1.4.min.js"></script>
    <script src="resource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style>
    .zz{
      margin: 0 auto;

    }

    </style>
  </head>
  <body>
  <div class="container">
    <div class="row clearfix">
      <div class="col-md-12 column">
        <div class="row clearfix">
          <div class="col-md-12 column">
            <h3 class="text-center">
              h3. 这是一套可视化布局系统.
            </h3>
          </div>
        </div>
        <div class="row clearfix">
          <div class="col-md-12 column">
            <div class="row clearfix">
              <div class="col-md-4 column">
              </div>
              <div class="col-md-4 column">
                <form role="form" action="login.do">
                  <div class="form-group">
                    <label for="name">用户名</label><input type="text" class="form-control" id="name" />
                  </div>
                  <div class="form-group">
                    <label for="Password">密码</label><input type="password" class="form-control" id="Password" />
                  </div>

                  <a id="modal-836920" href="#modal-container-836920" role="button" class="btn btn-default btn-primary" data-toggle="modal">注册</a>
                  <button type="submit" class="btn btn-default btn-primary"  style="float: right">登陆</button>
                </form>
              </div>
              <div class="col-md-4 column">
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


        <div class="modal fade" id="modal-container-836920" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                  标题
                </h4>
              </div>
              <div class="modal-body">
                内容...
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
              </div>
            </div>

          </div>

        </div>

      </div>
    </div>
  </div>
  </body>
</html>
