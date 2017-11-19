/**
 * Created by decide on 2017/9/29.
 */
var updatatarget ;
//

// function init() {
//     // $("#membername").select2({
//     //     ajax: {
//     //         url: "../selectmember.do",
//     //         dataType: 'post',
//     //         delay: 250,
//     //         data: function (params) {
//     //
//     //             return {
//     //                 q: params.term,
//     //                 page: params.page
//     //             };
//     //         },
//     //         results : function (data, params) {//processResults
//     //             params.page = params.page || 1;
//     //             alert("123321");
//     //             return {
//     //                 results:""[{id:1,text:'text'},{id:2,text:'text'}] ,//data.items,//itemList
//     //                 pagination: {
//     //                     more: (params.page * 30) < data.total_count
//     //                 }
//     //             };
//     //
//     //
//     //         },
//     //         cache: true
//     //     },
//     //     placeholder:'请选择',//默认文字提示
//     //     language: "zh-CN",
//     //     tags: true,//允许手动添加
//     //     allowClear: true,//允许清空
//     //     escapeMarkup: function (markup) { return markup; }, // 自定义格式化防止xss注入
//     //     minimumInputLength: 1,//最少输入多少个字符后开始查询
//     //     templateResult: function formatRepo(repo){ return repo.text;}, // 函数用来渲染结果
//     //     templateSelection: function formatRepoSelection(repo){return repo.text;} // 函数用于呈现当前的选择
//     // });
//
//     $("#membername").select2({
//         ajax: {
//             url: "../selectmember.do",
//             dataType: 'json',
//             delay: 250,
//             data: function (params) {
//                 return {
//                     q: params.term, // search term
//                    // page: params.page
//                 };
//             },
//             processResults: function (data) {
//                 // parse the results into the format expected by Select2
//                 // since we are using custom formatting functions we do not need to
//                 // alter the remote JSON data, except to indicate that infinite
//                 // scrolling can be used
//                // params.page = params.page || 1;
//
//                 return {
//                     results: data,//.items,
//                     // pagination: {
//                     //     more: (params.page * 30) < data.total_count
//                     // }
//                 };
//             },
//             cache: true
//         },
//         placeholder: 'Search for a repository',
//         escapeMarkup: function (markup) { return markup; }, // let our custom formatter work
//         minimumInputLength: 1,
//         templateResult: formatRepo,
//         templateSelection: formatRepoSelection
//     });
//
//     function formatRepo (repo) {
//        var markup  = "";
//
//         return markup;
//     }
//
//     function formatRepoSelection (repo) {
//         return repo.full_name || repo.text;
//     }
//
//
// }
// function formatRepoProvince(repo) {
//     if (repo.loading) return repo.text;
//     var markup = "<div>"+repo.name+"</div>";
//     return markup;
// }

// function init() {
//     $(window).on('load', function () {
//
//         $('.selectpicker').selectpicker({
//             'selectedText': 'cat'
//         });
//
//         // $('.selectpicker').selectpicker('hide');
//     });
//
// }
function selectmember(obj) {
var text =  obj.val();

    $.ajax({
        //提交数据的类型 POST GET
        type : "POST",
        //提交的网址
        url : "../selectmember.do",
        //提交的数据
        data : {
          text:text,

            // type:subtype
        },
        beforeSend:function(){


        },
        success : function(data) {

       var jsonarr =  JSON.parse(data);
       var sl = $("#namelist");
      sl .empty();

            for (var i = 0;i<jsonarr.length;i++){
            sl.append("<option onclick='inputsub($(this))'>"+jsonarr[i].name+"</option >")

            }


        },
    });
}
function inputsub(text) {
    $("#membername").val(text.val());
}
function xy() {
   return $("#membername").val().replace(/\s/g, "") !="";
}
function save() {
    var iftext =  $("#addcanteeLabel").html();
    if("添加"==iftext){
        var membername = $("#membername");
        var canteentype = $("#canteentype");
        var eattype = $("#eattype");
        var timetype  =$("#timetype");
        var typename =  $("#bigen").val();

        var text = $("#"+typename).attr("name");

        var addstr ="<tr class='success'> <td name ='membername'>"+membername.val()+"</td> <td name ='subtype'>"+text+"</td> <td name = 'canteentype' >"+canteentype.val()+"</td> <td name = 'eattype'>"+eattype.val()+"</td><td name = 'timetype'>"+timetype.val()+"</td> <td><button type='button'class='btn btn-primary' onclick='updatethis($(this))' >修改</button> <button type='button'class='btn btn-primary' onclick='deletethis($(this))'>删除</button> </td> </tr>";
        $("#canteenbody"+typename).append(addstr);
        $('#addcanteenmain').modal('hide');
        removeadd();
    }else if("修改"==iftext) {
        var membername = $("#membername");
        var canteentype = $("#canteentype");
        var eattype = $("#eattype");
        var timetype  =$("#timetype");
        updatatarget.children('td[name="membername"]').html(membername.val());
        updatatarget.children('td[name="canteentype"]').html(canteentype.val());
        updatatarget.children('td[name="eattype"]').html(eattype.val());
        updatatarget.children('td[name="timetype"]').html(timetype.val());
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
    canteentype.val("食堂一");
    eattype.val("米饭");
    $("#bigen").val("");
    $("#timetype").val("午餐");
    $("#namelist").empty();
}
function Confirmed () {
    $('#Confirmed').modal();
}
function submitadd() {
    $('#Confirmed').modal('hide');
    var TC1 = tableTobean("addusertableByTC1");
    var TC2 = tableTobean("addusertableByTC2");
    var TC3 = tableTobean("addusertableByTC3");

    var tablejsonTC1 = JSON.stringify(TC1);
    var tablejsonTC2 = JSON.stringify(TC2);
    var tablejsonTC3 = JSON.stringify(TC3);
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
            tablejsonTC3:tablejsonTC3,
            time:suttime,
            // type:subtype
        },
        beforeSend:function(){


        },
        success : function(data) {
            alert("提交成功！");
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

    if( checktotime(time)){

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
    });}




}
function exit() {
    window.location.href = "../login.jsp";
}
function checktotime(time) {
    var is = false;
    $("#dishes1H").html("");
    $("#dishes1info").html("");
    $("#dishes2H").html("");
    $("#dishes2info").html("");

   if(towday(time)){

       $.ajax({
           //提交数据的类型 POST GET
           type : "GET",
           //提交的网址
           url : "../checktodate.do",
           //设置异步请求
           async: false,
           //提交的数据
           data : {
               time:time
           },
           beforeSend:function(){


           },
           success : function(data) {

               if(data=="F"){
                   alert("未查询到当前选择日期的套餐详情,不可预定！");
                    nosub();

               }else if(data=="T"){

                yessub();
                  is = true;
               }

           },
       });

   }else {
       alert("只可预定两天之后的套餐！")
       $("#suttime").val("");
nosub();

   }
    return is;
}
function towday(time) {
    var thistime = show();
    var inputtime = time;

  if(daysBetween(thistime,inputtime)>=2){
      return true;

  }else {
      return false;
  }
}
function show(){
    var mydate = new Date();
    var str = "" + mydate.getFullYear() + "-";
    str += (mydate.getMonth()+1) + "-";
    str += mydate.getDate() ;
    return str;
}
/**
 * 根据两个日期，判断相差天数
 * @param sDate1 开始日期 如：2016-11-01
 * @param sDate2 结束日期 如：2016-11-02
 * @returns {number} 返回相差天数
 */
function daysBetween(sDate1,sDate2){

    //Date.parse() 解析一个日期时间字符串，并返回1970/1/1 午夜距离该日期时间的毫秒数
    var time1 = Date.parse(new Date(sDate1));
    var time2 = Date.parse(new Date(sDate2));

    var nDays = Math.abs(parseInt((time2 - time1)/1000/3600/24));

    return  nDays;
};
function nosub() {
//$("#sub").addClass("disabled");
   $("#suttime").val("");
} function yessub() {
  //  $("#sub").removeClass("disabled");
}