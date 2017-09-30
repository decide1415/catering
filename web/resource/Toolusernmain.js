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

        var addstr ="<tr class='success'> <td name ='membername'>"+membername.val()+"</td> <td name = 'canteentype' >"+canteentype.val()+"</td> <td name = 'eattype'>"+eattype.val()+"</td> <td><button type='button'class='btn btn-primary' onclick='updatethis($(this))' >修改</button> <button type='button'class='btn btn-primary' onclick='deletethis($(this))'>删除</button> </td> </tr>";
        $("#canteenbody").append(addstr);
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
function addthis() {
    $("#addcanteeLabel").html("添加");
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
}
function Confirmed () {
    $('#Confirmed').modal();
}
function submitadd() {
    $('#Confirmed').modal('hide');
    var table = tableTobean("addusertable");
    var tablejson = JSON.stringify(table);
    var suttime =  $("#suttime").val();
    var subtype = $("#subtype").val();

    $.ajax({
        //提交数据的类型 POST GET
        type : "POST",
        //提交的网址
        url : "../addusertable.do",
        //提交的数据
        data : {
            tablejson:tablejson,
            time:suttime,
            type:subtype
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
            for (var i = 0;i<tablearr.size;i++){
                addstr+= "<tr class='success'> <td name ='selectuser'>"+tablearr[i].userId+"</td> <td name = 'selectT1' >"+tablearr[i].t1Count+"</td> <td name = 'selectT2'>"+tablearr[i].t2Count+"</td> <td></td> </tr>";

            }
            $("#selecttbody").empty();
            $("#selecttbody").append(addstr);
        },
    });
}