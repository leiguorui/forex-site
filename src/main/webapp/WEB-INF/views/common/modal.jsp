<%--
  Created by IntelliJ IDEA.
  User: lei
  Date: 16-1-10
  Time: 下午5:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-- sign-in modal -->
<!-- Modal -->
<div id="signin" class="modal" tabindex="-1" role="dialog" aria-labelledby="signin-title" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="signin-title"><i class="fa fa-sign-in"></i> 登陆</h4>
            </div>
            <div class="modal-body">
                <form action="/user/signin.json" method="post" class="separated clearfix">
                    <div class="modal-section modal-padding col-md-6">
                        <h5> 用户登陆</h5>
                        <div class="control-group">
                            <label class="control-label" for="email">邮箱</label>
                            <div class="controls">
                                <input name="e" type="text" class="form-control" id="email" placeholder="Email" required>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="password">密码</label>
                            <div class="controls">
                                <input name="p" type="password" class="form-control" id="password" placeholder="Password" required>
                            </div>
                        </div>
                        <div class="control-group">
                            <button type="button" class="btn btn-success"> 立即登陆</button>
                        </div>
                    </div>
                    <div class="col-md-6 social-login">
                        <h5> 其他账号登陆</h5>
                        <ul>
                            <li>
                                <a href="" class="btn facebook form-control no-border-radius"><i class="fa fa-facebook"></i> sign in with Facebook</a>
                            </li>
                            <li>
                                <a href="" class="btn twitter form-control no-border-radius"><i class="fa fa-twitter"></i> sign in with Twitter</a>
                            </li>
                            <li>
                                <a href="" class="btn google-plus form-control no-border-radius"><i class="fa fa-google-plus"></i> sign in with Google</a>
                            </li>
                        </ul>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                还没有账号? <a href="#" class="btn btn-xs btn-primary"> 注册新用户</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- ./sign-in modal -->

<!-- register modal -->
<!-- Modal -->
<div id="register" class="modal" tabindex="-1" role="dialog" aria-labelledby="register-title" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="register-title"><i class="fa fa-user"></i> 注册新用户</h4>
            </div>
            <div class="modal-body">
                <form action="/user/register.json" method="post" id="regist" class="clearfix">
                    <h5>New Account</h5>
                    <div class="alert alert-simple"><i class="fa fa-info"></i> 请填写所有空格</div>
                    <div class="row">
                        <div class="control-group col-md-6">
                            <label class="control-label" for="username">昵称</label>
                            <div class="controls">
                                <input name="n" type="text" class="form-control" id="username" placeholder="Username" required>
                            </div>
                        </div>
                        <div class="control-group col-md-6">
                            <label class="control-label" for="email">邮箱</label>
                            <div class="controls">
                                <input name="e" type="text" class="form-control" id="email" placeholder="Email" required>
                            </div>
                        </div>
                        <div class="control-group col-md-6">
                            <label class="control-label" for="password">密码</label>
                            <div class="controls">
                                <input name="p" type="password" class="form-control" id="password" placeholder="Password" required>
                            </div>
                        </div>
                        <div class="control-group col-md-6">
                            <label class="control-label" for="repeat-password">确认密码</label>
                            <div class="controls">
                                <input type="password" class="form-control" id="repeat-password" placeholder="Password" required>
                            </div>
                        </div>
                        <div class="control-group col-md-12">
                            <div class="checkbox check-default no-padding no-margin">
                                <input type="checkbox" id="checkbox" checked="checked">
                                <label for="checkbox"> 同意用户协议.</label>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary"> 免费注册</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- ./register modal -->
