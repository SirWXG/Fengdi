$(".delProblem").on("click", function() {
    var obj = $(this);
    if (confirm("你确定要删除ID为【" + obj.attr("proid") + "】及其所有的信息吗？")) {
        $.ajax( {
            type : "GET",
            url : "delProblem.json",
            data : {
                id : obj.attr("proid")
            },
            dataType : "json",
            success : function(data) {
                if (data.delResult == "true") {// 删除成功：移除删除行
                    alert("删除成功");
                    obj.parents("tr").remove();
                } else if (data.delResult == "false") {// 删除失败
                    alert("对不起，删除【" + obj.attr("proID") + "】信息失败");
                } else if (data.delResult == "notexist") {
                    alert("对不起，【" + obj.attr("proID") + "】不存在");
                }
            },
            error : function(data) {
                alert("对不起，删除失败");
            }
        });
    }
});