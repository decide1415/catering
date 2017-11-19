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
<% String errcode =  "ture".equals(request.getParameter("errcode"))?"true":"false";

%>
    <script type="text/javascript">
       function isc() {
           var chrome = /chrom(e|ium)/.test(navigator.userAgent.toLowerCase());
            //var is360 = (window.external&&window.external.twGetRunPath&&window.external.twGetRunPath().toLowerCase().indexOf("360se")>-1)

           if(!chrome){
                //下载浏览器
                   alert("您正在使用非 360 浏览器  或浏览器非极速模式！\\n 入使用非360浏览器 请点击 网页下边 连接下载安装！\\n");

               }

       }
      if(<%=errcode%>){
        alert("登陆失败！请检查输入的用户名密码！")

      }
      function download() {
          window.open("/catering/resource/360se9.1.0.356.exe");
      }

    </script>
  </head>
  <body style="background:url('resource/DL.jpg') no-repeat center fixed;background-size:100% 100%;" onload="isc()">
  <div class="container" > <%-- border-image: url('resource/DL.jpg');background-size:100% 100%--%>
    <div class="row clearfix">
      <div class="col-md-12 column">
        <div class="row clearfix">
          <div class="col-md-12 column">
            <h3 class="text-center" style="color: white">
             用户登录
            </h3>
          </div>
        </div>
        <div class="row clearfix">
          <div class="col-md-12 column">
            <div class="row clearfix">
              <div class="col-md-4 column">
              </div>
              <div class="col-md-4 column">

                <form  action="login.do" method="get">
                  <div class="form-group">
                    <label for="name" style="color:white;">用户名</label><input type="text" class="form-control" id="name" name="username" />
                  </div>
                  <div class="form-group">
                    <label for="Password" style="color: white">密码</label><input type="password" class="form-control" id="Password" name="Password"/>
                  </div>

                  <a id="modal-836920" href="#modal-container-836920" role="button" class="btn btn-default btn-primary" data-toggle="modal">注册</a>
                  <button type="submit" class="btn btn-default btn-primary"  style="float: right">登陆</button>
                </form>
              </div>
              <div class="col-md-4 column">
                <button type="button" class="btn btn-default btn-primary" onclick="download()">浏览器下载</button>
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
