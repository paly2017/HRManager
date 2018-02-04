
$(document).ready(function () {
    $(".J_menuItem").click(function () {
        var url = $(this).attr("href");
        $("#J_iframe").attr("src",url)
        return false;
    })
});