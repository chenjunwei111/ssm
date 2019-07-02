var areacode;//部门编号，唯一值
var type;//三种类型：add(添加),edit(编辑),look(查看)
var model;//模型，单选树节点模型还是复选框模型

$(function () {
    var jsobj = GetRequest();
    if (jsobj == null) {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
        return;
    }
    areacode = jsobj.id;
    type = jsobj.type;

    if (jsobj.type == 'add') {
        setData(null);
    } else if (jsobj.type == 'edit' || jsobj.type == 'select') {
        getData();
        //$('#DEPT_NAME').attr("readonly",true);
        //$('#DEPT_CODE').attr("readonly",true);
        //$('#AREA_CODE').attr("readonly",true);

        $('#DEPT_NAME').attr("disabled",true);
        $('#DEPT_CODE').attr("disabled",true);
        $('#AREA_CODE').attr("disabled",true);

        $('#DEPT_NAME').addClass('readonly');
        $('#DEPT_CODE').addClass('readonly');
        $('#AREA_CODE').addClass('readonly');
    }

    $("#btnSubmit").click(function () {
        submit();
    });
    $("#btnCancel").click(function () {
        //parent.layer.closeAll();
        //关闭本窗口
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    });
    $("#btnAddDepartment").click(function () {
        openAddDepartment();
    });
    $("#btnROOT").click(function () {
        $('#PARENT_DEPT_CODE').val('ROOT');
    });
});

function openAddDepartment() {
    $('#txtid').val('');
    //'departmenttree.html?type=edit&id=&model=simple',
    parent.layer.open({
        type: 2,
        title: ["归属级别", "font-size:16px"],
        area: ["500px", "500px"],
        anim: 2,
        skin: 'layui-layer-lan',
        maxmin: false,
        id: 'tree',
        resize: false,
        moveType: 1,
        shade: 0,
        scrollbar: false,
        content: 'departmenttree.html?type=isvalid&id=&model=simple&deptcode='+areacode,
        end: function () {
            //要判断是提交后还是取消后的操作
            var backvalue = parent.window.document.getElementById("txtid").value;
            var DEPT_NAME = parent.window.document.getElementById("DEPT_NAME").value;
            var DEPT_CODE = parent.window.document.getElementById("DEPT_CODE").value;
            var AREA_CODE = parent.window.document.getElementById("AREA_CODE").value;
            areacode = AREA_CODE;
            if (backvalue != null && backvalue != '') {
                $('#PARENT_DEPT_CODE').val(DEPT_CODE);
            }
        }
    })
}
function submit() {
    console.log($('#hISVALID').val());
    if($('#DEPT_NAME').val()==null || $('#DEPT_NAME').val()==''){
        $('#spanmessage').html('部门名称不能为空');
        return;
    }
    if( $('#DEPT_NAME').val().length>20){
        $('#spanmessage').html('部门名称长度超过20个字符');
        return;
    }

    if($('#DEPT_CODE').val()==null || $('#DEPT_CODE').val()==''){
        $('#spanmessage').html('部门编号不能为空');
        return;
    }
    if( $('#DEPT_CODE').val().length>20){
        $('#spanmessage').html('部门编号长度超过20个字符');
        return;
    }

    if($('#AREA_CODE').val()==null || $('#AREA_CODE').val()==''){
        $('#spanmessage').html('区域编号不能为空');
        return;
    }
    if( $('#AREA_CODE').val().length>20){
        $('#spanmessage').html('区域编号长度超过20个字符');
        return;
    }

    if($('#PARENT_DEPT_CODE').val()==null || $('#PARENT_DEPT_CODE').val()==''){
        $('#spanmessage').html('归属级别不能为空');
        return;
    }
    if( $('#DESCRIPTION').val()!='' && $('#DESCRIPTION').val().length>200 ){
        $('#spanmessage').html('部门描述过长或不符合规范');
        return;
    }
    var pojo = DepartmentPojo = {};

    DepartmentPojo.deptname = $('#DEPT_NAME').val();
    DepartmentPojo.areacode = $('#AREA_CODE').val();
    DepartmentPojo.deptcode = $('#DEPT_CODE').val();
    DepartmentPojo.parentdeptcode = $('#PARENT_DEPT_CODE').val();
    DepartmentPojo.description = $('#DESCRIPTION').val();
    DepartmentPojo.isvalid = $('#hISVALID').val();

    var url;
    if(type=='edit'){
        DepartmentPojo.areacode = areacode;
        url= "/contra/department/editOneDepartment?";
    }else if(type=='add'){
        url= "/contra/department/addOneDepartment?";
    }
    submitData(DepartmentPojo,url);
}
function submitData(pojo,url){
    $.ajax({
        url: url,
        data: JSON.stringify(pojo),
        method: "POST",
        contentType: 'application/json',
        success: function (res) {
            if (res == 'ok'){
                msg('提交成功');
                setTimeout(function(){
                    parent.window.document.getElementById("txtid").value = "ok";
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index); //再执行关闭
                },3000)

            }else{
                $('#spanmessage').html(res);
            }
        }
    });
}

//数据呈现
function getData() {
    var pojo = PLteSectorPojo = {cellid: areacode}
    var url = "/contra/department/getOneDepartment?";
    $.ajax({
        url: url,
        data: JSON.stringify(pojo),
        method: "POST",
        contentType: 'application/json',
        success: function (res) {
            if (res == null){
                setData(null);
            }else{
                setData(res);
            }
        }
    });
    if (type == 'select') {
        $("#btnSubmit").hide();
        $("#btnAddDepartment").hide();
    }
}
layui.use(['layer', 'form'], function () {
    var layer = layui.layer, $ = layui.jquery;
    var form = layui.form;
    form.on('switch(ISVALID)', function (data) {
        var isvalid = data.elem.checked;
        if(isvalid==true||isvalid=='true'){
            $('#hISVALID').val(1);
        }else{
            $('#hISVALID').val(0);
        }
    });
});

function setData(data) {
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer, $ = layui.jquery;
        var form = layui.form;
        if (data == null) {
            $('#DEPT_NAME').val('');
            $('#DEPT_CODE').val('');
            $('#PARENT_DEPT_CODE').val('');
            $('#AREA_CODE').val('');
            $('#hISVALID').val(1);
            $('#DESCRIPTION').val('');
        } else {
            $('#DEPT_NAME').val(data.DEPT_NAME);
            $('#DEPT_CODE').val(data.DEPT_CODE);
            $('#PARENT_DEPT_CODE').val(data.PARENT_DEPT_CODE);
            $('#AREA_CODE').val(data.AREA_CODE);
            $('#hISVALID').val(data.ISVALID);
            if (data.ISVALID == 0) {
                $('#ISVALID').removeAttr('checked');
                form.render('checkbox');//强制重绘checkbox
            }
            $('#DESCRIPTION').val(data.DESCRIPTION);
        }
    });
}


//地址获取参数
function GetRequest() {
    var url = location.search;
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        var strs = new Array();
        strs = str.split('&');
        if (strs.length < 3)return null;
        var type1 = strs[0].split('=')[1];
        var id1 = strs[1].split('=')[1];
        var model1 = strs[2].split('=')[1];
        var jsobj = {};
        jsobj.type = type1;
        jsobj.id = id1;
        jsobj.model = model1;
        return jsobj;
    }
}