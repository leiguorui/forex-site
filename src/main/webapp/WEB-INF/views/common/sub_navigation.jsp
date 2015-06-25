<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/6/25
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container">
  <ul id="user-interface">
    <li>
      <a href="#signin" data-toggle="modal">Login</a>
    </li>
    <li>
      <a href="#register" data-toggle="modal">Create Account</a>
    </li>
  </ul>
  <div id="top-social">
    <span>Receive daily updates:</span>
    <ul>
      <li><a href="#" class="tip facebook" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook"></i></a></li>
      <li><a href="#" class="tip twitter" data-toggle="tooltip" data-placement="bottom" title="Twitter"><i class="fa fa-twitter"></i></a></li>
      <li><a href="#" class="tip youtube" data-toggle="tooltip" data-placement="bottom" title="Youtube"><i class="fa fa-youtube"></i></a></li>
    </ul>
  </div>
  <div class="to-top display-none"><a href="#"><i class="fa fa-chevron-up"></i></a></div>
</div>

<!-- sign-in modal -->
<!-- Modal -->
<div id="signin" class="modal" tabindex="-1" role="dialog" aria-labelledby="signin-title" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="signin-title"><i class="fa fa-sign-in"></i> Sign In</h4>
      </div>
      <div class="modal-body">
        <form action="#" method="post" class="separated clearfix">
          <div class="modal-section modal-padding col-md-6">
            <h5>Login to account</h5>
            <div class="control-group">
              <label class="control-label" for="email">Email</label>
              <div class="controls">
                <input type="text" class="form-control" id="email" placeholder="Email" required>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="password">Password</label>
              <div class="controls">
                <input type="password" class="form-control" id="password" placeholder="Password" required>
              </div>
            </div>
            <div class="control-group">
              <button type="button" class="btn btn-success">Sign In</button>
            </div>
          </div>
          <div class="col-md-6 social-login">
            <h5>Social Login</h5>
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
        Don鈥檛 have an account? <a href="#" class="btn btn-xs btn-primary">Register</a>
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
        <h4 class="modal-title" id="register-title"><i class="fa fa-user"></i> Create Account</h4>
      </div>
      <div class="modal-body">
        <form action="#" method="post" class="clearfix">
          <h5>New Account</h5>
          <div class="alert alert-simple"><i class="fa fa-info"></i> All fields are required</div>
          <div class="row">
            <div class="control-group col-md-6">
              <label class="control-label" for="username">Username</label>
              <div class="controls">
                <input type="text" class="form-control" id="username" placeholder="Username" required>
              </div>
            </div>
            <div class="control-group col-md-6">
              <label class="control-label" for="email">Email</label>
              <div class="controls">
                <input type="text" class="form-control" id="email" placeholder="Email" required>
              </div>
            </div>
            <div class="control-group col-md-6">
              <label class="control-label" for="password">Password</label>
              <div class="controls">
                <input type="password" class="form-control" id="password" placeholder="Password" required>
              </div>
            </div>
            <div class="control-group col-md-6">
              <label class="control-label" for="repeat-password">Repeat Password</label>
              <div class="controls">
                <input type="password" class="form-control" id="repeat-password" placeholder="Password" required>
              </div>
            </div>
            <div class="control-group col-md-12">
              <label class="control-label" for="repeat-password">Repeat Password</label>
              <div class="controls">
                <input type="password" class="form-control" id="repeat-password" placeholder="Password" required>
              </div>
            </div>
            <div class="control-group col-md-12">
              <div class="checkbox check-default no-padding no-margin">
                <input type="checkbox" id="checkbox" checked="checked">
                <label for="checkbox">Accept terms and service.</label>
              </div>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Create Account</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- ./register modal -->
