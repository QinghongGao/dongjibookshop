<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2xxxxxxxxxxxxxxxx</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="css/font.css">
        <link rel="stylesheet" href="css/xadmin.css">
        <script type="text/javascript" src="lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form">
                    <input type="hidden" name="id" id="id" value="${userinfo.id}">
                    <div class="layui-form-item">
                        <label for="username" class="layui-form-label">
                            <span class="x-red">*</span>用户名
                        </label>
                        <div class="layui-input-inline">
                            <input type="text"
                                   id="username"
                                   name="username"
                                   required=""
                                   lay-verify="required|admininistratorname"
                                   autocomplete="off"
                                   value="${userinfo.admininistratorname}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="nickname" class="layui-form-label">
                            <span class="x-red">*</span>昵称
                        </label>
                        <div class="layui-input-inline">
                            <input type="text"
                                   id="nickname"
                                   name="nickname"
                                   required=""
                                   lay-verify="required|nickname"
                                   autocomplete="off"
                                   value="${userinfo.nickname}"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="status" class="layui-form-label">
                            <span class="x-red">*</span>状态
                        </label>
                        <div class="layui-input-inline">
                            <select name="status" id="status">
                                <option value="1">可用</option>
                                <option value="2">禁用</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                        </label>
                        <button class="layui-btn" lay-filter="save" lay-submit>
                            保存
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </body>
    <script>layui.use(['form', 'layer'],
        function() {
            $ = layui.jquery;
            let form = layui.form,
                layer = layui.layer;

            //自定义验证规则
            form.verify({
                nikename: function(value) {
                    if (value.length < 5 && value.length >15) {
                        return '昵称长度要求5-15字符之间';
                    }
                },
                admininistratorname: [
                    /^(?!_)(?!.*?_$)[a-zA-Z0-9_]+$/,
                    '用户名只能使用英文大小写和数字下划线'
                ],
                pass: [/(.+){6,12}$/, '密码必须6到12位'],
                repass: function(value) {
                    if ($('#L_pass').val() != $('#L_repass').val()) {
                        return '两次密码不一致';
                    }
                }
            });

            //监听提交
            form.on('submit(add)', function(data) {
                $.ajax({
                    url:"/admininistrator/update",
                    data:{
                        ...data.field
                    },
                    method:"post",
                    dataType:"json",
                    success(res){
                        if (res.code === 200){
                            layer.msg('更新成功', {icon: 6}, function() {
                                xadmin.close();
                                xadmin.father_reload();
                            });
                        } else {
                            layer.alert(res.msg, {icon:5});
                        }
                    },
                    error(e) {
                        layer.alert("服务器睡着了...", {icon:5})
                    }
                });
                return false;
            });
        });
    </script>
</html>
