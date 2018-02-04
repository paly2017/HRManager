/****
 * 上班签到request
 */
var myObj;
function upWork(UserId) {
    $.ajax({
        type:"post",
        url:"/upwork",
        data:{employeeNumber:UserId},
        success:function (msg) {
            if (msg==="no"){
                alert("签到失败")
            }
           myObj = jQuery.parseJSON(msg);
            alert("签到成功")
        },
        error:function () {
            alert("签到失败")
        }
    })
}

/***
 * 下班签到
 */
function downWork() {
    var workid=myObj.id;
    $.ajax({
        type:"post",
        url:"/downwork",
        data:{attendanceid:workid},
        success:function (msg) {
            alert(msg)
        }
    })
}