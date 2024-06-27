<html>

    <head>
        <title>Login</title>
        <%@include file="include/head.jsp" %>
    </head>
    <style>
        body, html{
            height: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        body::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: url('img/login_BG.jpg') no-repeat center center/cover;
            z-index: -2;
        }

        body::after {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: #F2A4FF;
            opacity: 0.5;
            z-index: -1;
        }

        .login-form-container {
            background-color: white;
            padding: 20px;
            z-index: 1;
            width: 100%;
            max-width: fit-content;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .social-buttons {
            text-align: center;
            margin-top: 20px;
        }

        .social-buttons a {
            margin: 0 5px;
            width: 80px;
            height: auto;
        }
        .img-container {
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .img-container img {
            width: 100%;
            height: auto;
            max-width: 900px;
            display: flex;
        }

        @media (max-width: 767px) {
            .login-form-container {

            }

            .login-form,
            .img-container {
                width: 100%;
                padding: 0;
            }

            .login-form {
                margin-bottom: 20px;
            }
        }
    </style>
    <body  style="height: 100%;
           margin: 0;
           display: flex;
           justify-content: center;
           align-items: center;">
        <div class="login-form-container">
            <div class="row">
                <div class="login-form col-md-6">
                    <form action="./login" method="POST" class="form-signin form-horizontal">
                        <h1 style="font-weight: bold;" class="form-signin-heading text-center font-weight-bold" style="font-size: 50px;">LOGIN</h1>
                        <% String error = (String) request.getAttribute("error"); %>
                        <% if (error != null) {%>
                        <h3> <%= error%> </h3>
                        <% }%>
                        <% String signup = (String) request.getAttribute("messageSignup"); %>
                        <% if (signup != null) {%>
                        <h3> <%= signup%> </h3>
                        <% }%>
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">Username</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="username" placeholder="Username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">Password</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="password" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <a href="#">Forgot Password?</a>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Remember me
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row pull-right">
                            <input style="height: 50px; width: 100px; font-size: 20px; font-weight: bold; background-color: blue; color: white; border-radius: 8px;" type="submit" name="action" value="Login">
                            <a href="signup.jsp">
                                <input style="height: 50px; width: 100px; font-size: 20px; font-weight: bold; background-color: blue; color: white; border-radius: 8px;" type="submit" name="action" value="Sign-up">

                            </a>
                        </div>
                        <br>
                        <div class="social-buttons">
                            <label for="btn">Or login with: </label>
                            <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-facebook"></i> Facebook</a>
                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-google"></i> Google</a>
                        </div>
                    </form>
                </div>
                <div class="login-form col-md-6 img-container">
                    <img src="img/login.jpg" alt="shoes login picture" class="img-responsive center-block">
                </div>
            </div>
        </div>
    </body>
</html>