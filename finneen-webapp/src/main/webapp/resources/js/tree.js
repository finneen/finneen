
$(document).ready(function(){

    var menuSelectSetting = {
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false
        },
        data: {
            simpleData: {
                enable:true,
                idKey: "id",
                pIdKey: "pid",
                rootPId: ""
            }
        }
    };

    $.getJSON(ctx + '/resource/tree?pid=0', function(data) {

        var tree_data = data;

        console.log(JSON.stringify(tree_data));

        $.fn.zTree.init($("#tree"), menuSelectSetting, data);

    });

});
