/**
 * Created by decide on 2017/9/29.
 */
var updatatarget ;
function save() {
    var iftext =  $("#addcanteeLabel").html();
    if("添加"==iftext){
        var membername = $("#membername");
        var canteentype = $("#canteentype");
        var eattype = $("#eattype");
        var typename =  $("#bigen").val();

        var text = $("#"+typename).attr("name");

        var addstr ="<tr class='success'> <td name ='membername'>"+membername.val()+"</td> <td name ='subtype'>"+text+"</td> <td name = 'canteentype' >"+canteentype.val()+"</td> <td name = 'eattype'>"+eattype.val()+"</td> <td><button type='button'class='btn btn-primary' onclick='updatethis($(this))' >修改</button> <button type='button'class='btn btn-primary' onclick='deletethis($(this))'>删除</button> </td> </tr>";
        $("#canteenbody"+typename).append(addstr);
        $('#addcanteenmain').modal('hide');
        removeadd();
    }else if("修改"==iftext) {
        var membername = $("#membername");
        var canteentype = $("#canteentype");
        var eattype = $("#eattype");
        updatatarget.children('td[name="membername"]').html(membername.val());
        updatatarget.children('td[name="canteentype"]').html(canteentype.val());
        updatatarget.children('td[name="eattype"]').html(eattype.val());
        $('#addcanteenmain').modal('hide');
        removeadd();


    }



}
function addthis(bigen) {
    removeadd();
    $("#addcanteeLabel").html("添加");
    $("#bigen").val(bigen);

}
function deletethis(obj) {
    // alert($(this).val());
    obj.parent().parent().remove();
}
function updatethis(obj) {
    $("#addcanteeLabel").html("修改");
    var td = obj.parent().parent();
    updatatarget = td;
    // alert(td.children('td[name="菜品名称"]').html());

    var  membername = td.children('td[name="membername"]').html();
    var canteentype  = td.children('td[name="canteentype"]').html();
    var eattype = td.children('td[name="eattype"]').html();

    $('#addcanteenmain').modal();
    $("#membername").val(membername);//
    $("#canteentype").val(canteentype);
    $("#eattype").val(eattype);
}
function removeadd() {
    var membername = $("#membername");
    var canteentype = $("#canteentype");
    var eattype = $("#eattype");

    membername.val("");
    canteentype.val("");
    eattype.val("");
    $("#bigen").val("");
}
function Confirmed () {
    $('#Confirmed').modal();
}
function submitadd() {
    $('#Confirmed').modal('hide');
    var TC1 = tableTobean("addusertableByTC1");
    var TC2 = tableTobean("addusertableByTC2");

    var tablejsonTC1 = JSON.stringify(TC1);
    var tablejsonTC2 = JSON.stringify(TC2);
    var suttime =  $("#suttime").val();
    // var subtype = $("#subtype").val();

    $.ajax({
        //提交数据的类型 POST GET
        type : "POST",
        //提交的网址
        url : "../addusertable.do",
        //提交的数据
        data : {
            tablejsonTC1:tablejsonTC1,
            tablejsonTC2:tablejsonTC2,
            time:suttime,
            // type:subtype
        },
        beforeSend:function(){


        },
        success : function(data) {

        },
    });


}

function tableTobean(TableId) {
    var item = 0;
    var table = new Array();
    $("#"+TableId).find("tbody").find("tr").each(function () {
        var tr = {};
        $(this).find("td").each(function () {
            var td = $(this);
            if("undefined"!=typeof(td.attr("name")) ){
                tr[td.attr("name")]=td.html();}
        })
        table[item++] = tr;
    })
    return table;
}
function seelctcount(time) {
    $.ajax({
        //提交数据的类型 POST GET
        type : "GET",
        //提交的网址
        url : "../selectcount.do",
        //提交的数据
        data : {
            time:time
        },
        beforeSend:function(){


        },
        success : function(data) {

            var addstr = "";
            var tablearr = JSON.parse(data);
            console.log(tablearr);
            for (var i = 0;i<tablearr.size;i++){
                addstr+= "<tr class='success'> <td name ='selectuser'>"+tablearr[i].userId+"</td> <td name = 'selectT1' >"+tablearr[i].t1Count+"</td> <td name = 'selectT2'>"+tablearr[i].t2Count+"</td> <td></td> </tr>";

            }
            $("#selecttbody").empty();
            $("#selecttbody").append(addstr);
        },
    });
}
function selectDishes(time) {
    $.ajax({
        //提交数据的类型 POST GET
        type : "GET",
        //提交的网址
        url : "../selectDishes.do",
        //提交的数据
        data : {
            time:time
        },
        beforeSend:function(){


        },
        success : function(data) {
       var darr = JSON.parse(data);
       if(Object.prototype.toString.call(darr)=='[object Array]'&&darr.length>0){
            $("#dishes1H").html(darr[0].name);
            $("#dishes1info").html(darr[0].remarks);
            $("#dishes2H").html(darr[1].name);
            $("#dishes2info").html(darr[1].remarks);}else {
           $("#dishes1H").html("");
           $("#dishes1info").html("");
           $("#dishes2H").html("");
           $("#dishes2info").html("");

       }

        },
    });



}
function exit() {
    window.location.href = "../login.jsp";
}