/**
 * Created by decide on 2017/9/29.
 */
var updatatarget ;
function save() {
   var iftext =  $("#addcanteeLabel").html();
   if("添加"==iftext){
       var addcanteenname = $("#addcanteenname");
       var addcanteenremarks = $("#addcanteenremarks");
       var addcanteentime = $("#addcanteentime");

    var addstr ="<tr  class='success'> <td name='canteenname'> "+addcanteenname.val()+"</td> <td name='canteenremarks'>"+addcanteenremarks.val()+"</td> <td name='canteentime'>"+addcanteentime.val()+"</td> <td><button type='button'class='btn btn-primary' onclick='updatethis($(this))' >修改</button> <button type='button'class='btn btn-primary' onclick='deletethis($(this))'>删除</button> </td> </tr>";
    $("#canteenbody").append(addstr);
    $('#addcanteenmain').modal('hide');
    removeadd();}else if("修改"==iftext) {
       var addcanteenname = $("#addcanteenname");
       var addcanteenremarks = $("#addcanteenremarks");
       var addcanteentime = $("#addcanteentime");
        updatatarget.children('td[name="canteenname"]').html(addcanteenname.val());
       updatatarget.children('td[name="canteenremarks"]').html(addcanteenremarks.val());
        updatatarget.children('td[name="canteentime"]').html(addcanteentime.val());
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
var  addcanteenname = td.children('td[name="canteenname"]').html();
    var addcanteenremarks  = td.children('td[name="canteenremarks"]').html();
    var addcanteentime = td.children('td[name="canteentime"]').html();

    $('#addcanteenmain').modal();
    $("#addcanteenname").val(addcanteenname);//
    $("#addcanteenremarks").val(addcanteenremarks);
    $("#addcanteentime").val(addcanteentime);
}
function removeadd() {
    var addcanteenname = $("#addcanteenname");
    var addcanteenremarks = $("#addcanteenremarks");
    var addcanteentime = $("#addcanteentime");
    addcanteentime.val("");
    addcanteenname.val("");
    addcanteenremarks.val("");
}
function Confirmed () {
    $('#Confirmed').modal();
}
function submitadd() {
    $('#Confirmed').modal('hide');
   var table = tableTobean("addtable");
   var tablejson = JSON.stringify(table);

    $.ajax({
        //提交数据的类型 POST GET
        type : "POST",
        //提交的网址
        url : "/addDishesTable.do",
        //提交的数据
        data : {
      tablejson:tablejson
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
addstr+= "<tr class='success'> <td name ='selectuser'>"+tablearr[i].userId+"</td> <td name = 'selectT1' >"+tablearr[i].t1Count+"</td> <td name = 'selectT2'>"+tablearr[i].t2Count+"</td> <td></td> </tr>"

        }
            $("#selecttbody").empty();
        $("#selecttbody").append(addstr);
        },
    });
}