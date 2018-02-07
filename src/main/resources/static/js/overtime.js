//控制部门循环次数
var count=0;
//控制部门人员信息显示次数
function departmentshow() {
    $.ajax({
        type:"post",
        url:"/showalldepartment",
        success:function (msg) {
         var msginfo = jQuery.parseJSON(msg);
         var num=msginfo.length;
         msginfo.forEach(function (value) {
             count++;
             if (count<=num){
                 $("#department").last().append("<option value='"+value.departmentNumber+"'>"+value.name+"</option>")
             }
         })
        },
        error:function () {
            alert("网络故障")
        }
    })
}
//部门人员信息请求处理
function departmentname() {
    var nameNo= $("#department").val();
    $.ajax({
        type:"post",
        url:"/empinfo",
        data:{empNum:nameNo},
        success:function (msg) {
            $("#employee").empty();
            $("#employee").append("<option value=\"\">--请选择员工--</option>")
            var nameinfo=jQuery.parseJSON(msg);
            var num = nameinfo.length;
            nameinfo.forEach(function (value,index) {
                    $("#employee").last().append("<option value="+value.employeeNumber+">"+value.name+"</option>")
            })
        }
    })
}