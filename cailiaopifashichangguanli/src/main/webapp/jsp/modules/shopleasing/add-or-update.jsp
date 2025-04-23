



<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑商铺租赁</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">商铺租赁管理</li>
                        <li class="breadcrumb-item active">编辑商铺租赁</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">商铺租赁信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa shanghu">
                                        <label>商户</label>
                                        <div>
                                            <select id="shanghuSelect" name="shanghuSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 shanghu">
                                        <label>商户姓名</label>
                                        <input id="shanghuName" name="shanghuName" class="form-control"
                                               placeholder="商户姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6 shanghu">
                                        <label>身份证号</label>
                                        <input id="shanghuIdNumber" name="shanghuIdNumber" class="form-control"
                                               placeholder="身份证号" readonly>
                                    </div>
                                    <div class="form-group col-md-6 shanghu">
                                        <label>手机号</label>
                                        <input id="shanghuPhone" name="shanghuPhone" class="form-control"
                                               placeholder="手机号" readonly>
                                    </div>
                                    <div class="form-group col-md-6 shanghu">
                                        <label>邮箱</label>
                                        <input id="shanghuEmail" name="shanghuEmail" class="form-control"
                                               placeholder="邮箱" readonly>
                                    </div>
                                    <div class="form-group col-md-6 shanghu">
                                        <label>照片</label>
                                        <img id="shanghuPhotoImg" src="" width="100" height="100">
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                    <div class="form-group col-md-6 shopleasingNameDiv">
                                        <label>商铺名称</label>
                                        <input id="shopleasingName" name="shopleasingName" class="form-control"
                                               placeholder="商铺名称">
                                    </div>
                                    <div class="form-group col-md-6 shopleasingAddressDiv">
                                        <label>商铺地址</label>
                                        <input id="shopleasingAddress" name="shopleasingAddress" class="form-control"
                                               placeholder="商铺地址">
                                    </div>
                                    <div class="form-group col-md-6 shangpuTypesDiv">
                                        <label>商铺状态</label>
                                        <select id="shangpuTypesSelect" name="shangpuTypes" class="form-control">
                                        </select>
                                    </div>
                                    <div class="form-group col-md-6 shopTypesDiv">
                                        <label>商铺类型</label>
                                        <select id="shopTypesSelect" name="shopTypes" class="form-control">
                                        </select>
                                    </div>
                                    <div class="form-group col-md-6 shangpuNewMoneyDiv">
                                        <label>租金（月）</label>
                                        <input style="width: 450px" id="shangpuNewMoney" name="shangpuNewMoney" class="form-control"
                                               onchange="shangpuNewMoneyChickValue(this)" placeholder="租金（月）">
                                    </div>
                                <input id="shanghuId" name="shanghuId" type="hidden">
                                    <div class="form-group col-md-6 leasingTimeDiv">
                                        <label>租赁日期</label>
                                        <input id="leasingTime-input" name="leasingTime" type="text" class="form-control layui-input">
                                    </div>
                                    <div class="form-group col-md-6 leasingDateDiv">
                                        <label>租赁时间（月）</label>
                                        <input id="leasingDate" name="leasingDate" class="form-control"
                                               onchange="leasingDateChickValue(this)"  placeholder="租赁时间（月）">
                                    </div>

                                    <div class="form-group col-md-12 mb-3">
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                        <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                    </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "shopleasing";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var shangpuTypesOptions = [];
    var shopTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var shanghuOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
            if(window.sessionStorage.getItem('role') != '商户'){//当前登录用户不为这个
                if($("#shanghuId") !=null){
                    var shanghuId = $("#shanghuId").val();
                    if(shanghuId == null || shanghuId =='' || shanghuId == 'null'){
                        alert("租赁商户不能为空");
                        return;
                    }
                }
            }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });

            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';

            }
            httpJson("shopleasing/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addshopleasing');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function shangpuTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=shangpu_types", "GET", {}, (res) => {
                if(res.code == 0){
                    shangpuTypesOptions = res.data.list;
                }
            });
        }
        function shopTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=shop_types", "GET", {}, (res) => {
                if(res.code == 0){
                    shopTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function shanghuSelect() {
            //填充下拉框选项
            http("shanghu/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    shanghuOptions = res.data.list;
                }
            });
        }

        function shanghuSelectOne(id) {
            http("shanghu/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                shanghuShowImg();
                shanghuShowVideo();
                shanghuDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationShangputypesSelect(){
            var shangpuTypesSelect = document.getElementById('shangpuTypesSelect');
            if(shangpuTypesSelect != null && shangpuTypesOptions != null  && shangpuTypesOptions.length > 0 ){
                for (var i = 0; i < shangpuTypesOptions.length; i++) {
                    shangpuTypesSelect.add(new Option(shangpuTypesOptions[i].indexName,shangpuTypesOptions[i].codeIndex));
                }
            }
        }
        function initializationShoptypesSelect(){
            var shopTypesSelect = document.getElementById('shopTypesSelect');
            if(shopTypesSelect != null && shopTypesOptions != null  && shopTypesOptions.length > 0 ){
                for (var i = 0; i < shopTypesOptions.length; i++) {
                    shopTypesSelect.add(new Option(shopTypesOptions[i].indexName,shopTypesOptions[i].codeIndex));
                }
            }
        }

        function initializationshanghuSelect() {
            var shanghuSelect = document.getElementById('shanghuSelect');
            if(shanghuSelect != null && shanghuOptions != null  && shanghuOptions.length > 0 ) {
                for (var i = 0; i < shanghuOptions.length; i++) {
                        shanghuSelect.add(new Option(shanghuOptions[i].shanghuName, shanghuOptions[i].id));
                }

                $("#shanghuSelect").change(function(e) {
                        shanghuSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var shangpuTypesSelect = document.getElementById("shangpuTypesSelect");
        if(shangpuTypesSelect != null && shangpuTypesOptions != null  && shangpuTypesOptions.length > 0 ) {
            for (var i = 0; i < shangpuTypesOptions.length; i++) {
                if (shangpuTypesOptions[i].codeIndex == ruleForm.shangpuTypes) {//下拉框value对比,如果一致就赋值汉字
                        shangpuTypesSelect.options[i].selected = true;
                }
            }
        }

        var shopTypesSelect = document.getElementById("shopTypesSelect");
        if(shopTypesSelect != null && shopTypesOptions != null  && shopTypesOptions.length > 0 ) {
            for (var i = 0; i < shopTypesOptions.length; i++) {
                if (shopTypesOptions[i].codeIndex == ruleForm.shopTypes) {//下拉框value对比,如果一致就赋值汉字
                        shopTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var shanghuSelect = document.getElementById("shanghuSelect");
            if(shanghuSelect != null && shanghuOptions != null  && shanghuOptions.length > 0 ) {
                for (var i = 0; i < shanghuOptions.length; i++) {
                    if (shanghuOptions[i].id == ruleForm.shanghuId) {//下拉框value对比,如果一致就赋值汉字
                        shanghuSelect.options[i+1].selected = true;
                        $("#shanghuSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
    }
    //数字检查
        <!-- 当前表的数字检查 -->
        function shangpuNewMoneyChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]{0,6}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }
        function leasingDateChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addshopleasing');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                shopleasingName: "required",
                shopleasingAddress: "required",
                shangpuTypes: "required",
                shopTypes: "required",
                shangpuNewMoney: "required",
                shanghuId: "required",
                leasingTime: "required",
                leasingDate: "required",
            },
            messages: {
                shopleasingName: "商铺名称不能为空",
                shopleasingAddress: "商铺地址不能为空",
                shangpuTypes: "商铺状态不能为空",
                shopTypes: "商铺类型不能为空",
                shangpuNewMoney: "租金（月）不能为空",
                shanghuId: "租赁商户不能为空",
                leasingTime: "租赁日期不能为空",
                leasingDate: "租赁时间（月）不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addshopleasing = window.sessionStorage.getItem("addshopleasing");
        if (addshopleasing != null && addshopleasing != "" && addshopleasing != "null") {
            //注册表单验证
            $(validform());

            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("shopleasing/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
        var leasingTime = laydate.render({
            elem: '#leasingTime-input'
            ,type: 'datetime'
        });
        var insertTime = laydate.render({
            elem: '#insertTime-input'
            ,type: 'datetime'
        });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        shanghuDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#shopleasingName").val(ruleForm.shopleasingName);
        $("#shopleasingAddress").val(ruleForm.shopleasingAddress);
        $("#shangpuNewMoney").val(ruleForm.shangpuNewMoney);
        $("#shanghuId").val(ruleForm.shanghuId);
        $("#leasingTime-input").val(ruleForm.leasingTime);
        $("#leasingDate").val(ruleForm.leasingDate);

    }
    <!--  级联表的数据回显  -->
    function shanghuDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#shanghuId").val(ruleForm.id);

        $("#shanghuName").val(ruleForm.shanghuName);
        $("#shanghuIdNumber").val(ruleForm.shanghuIdNumber);
        $("#shanghuPhone").val(ruleForm.shanghuPhone);
        $("#shanghuEmail").val(ruleForm.shanghuEmail);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        shanghuShowImg();
    }


    <!--  级联表的图片  -->

    function shanghuShowImg() {
        $("#shanghuPhotoImg").attr("src",ruleForm.shanghuPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        shanghuShowVideo();
    }


    <!--  级联表的视频  -->

    function shanghuShowVideo() {
        $("#shanghuPhotoV").attr("src",ruleForm.shanghuPhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            shangpuTypesSelect();
            shopTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            shanghuSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationShangputypesSelect();
            initializationShoptypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationshanghuSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
        window.sessionStorage.removeItem('addshopleasing');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events: none;');
        }
		else if (window.sessionStorage.getItem('role') == '商户') {
            // $(".aaaaaa").remove();
            $(".shanghu").remove();//删除当前用户的信息
            // 租金（月）设置不可选
            $('#shangpuNewMoney').attr('readonly', 'readonly');
        }
		else if (window.sessionStorage.getItem('role') == '员工') {
            // $(".aaaaaa").remove();
            $(".yuangong").remove();//删除当前用户的信息
            // 租金（月）设置不可选
            $('#shangpuNewMoney').attr('readonly', 'readonly');
        }
        else{
            // alert("未知情况.......");
            // var replyTextUeditor = UE.getEditor('replyTextEditor');
            // replyTextUeditor.ready(function () {
            //     replyTextUeditor.setDisabled('fullscreen');
            // });
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>
