<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head
    <title></title>
    <%@include file="include/head.jsp" %>
</head>
<style>
    body,
    html {
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

    .sign-up-form-container {
        background-color: white;
        padding: 20px;
        z-index: 1;
        width: 100%;
        height: auto;
        max-height: flex 1 1 auto;
        display: flex;
        justify-content: center;
        align-items: center;
        border-radius: 8px;
    }

    @media (max-width: 767px) {
        body,html{
                display: block;
                justify-content: center;
                align-content: center;
            }
            body::before, body::after{
                display: none;
            }
            .sign-up-form-container {
                height: 100%;
                border-radius: 0;
                display: flex;
                justify-content: center;
                align-content: center;
            }

            .sign-up-form {
                padding: 20px;
                width: 100%;
                display: block;
                justify-content: center;
                align-content: center;
            }
        }
</style>

<body>
    <br>
    <div class="sign-up-form-container">
        <div class="sign-up-form">
            <form action="CreateAccountServlet" method="POST" class="form sign-up form-horizontal row">
                <h3 style="margin-top: 10px; text-align: center;">Sign Up Now</h3>
                <p style="text-align: center;">Please fill out this to register</p>
                <div class="form-group">
                    <label for="newUsername" class="col-sm-2 control-label">Username</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="username" placeholder="Username" required> 
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password" placeholder="Password" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" name="email" placeholder="Email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">Phone</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="phone" placeholder="phone" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="form-group col-md-6">
                        <label for="firstname" class="col-sm-5 control-label">First Name</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="firstname" placeholder="First Name" required>
                        </div>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="lastName" class="col-sm-5 control-label">Last Name</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="lastname" placeholder="Last Name" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="sex" class="col-sm-2 control-label">Sex</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="sex" placeholder="sex">
                    </div>
                </div>
                <div class="form-group">
                    <label for="birth_date" class="col-sm-2 control-label">Birth Date</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" name="birthdate" placeholder="Birth Date" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="province" class="col-sm-2 control-label">Province</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="province" placeholder="Province">
                    </div>
                </div>
                <div class="form-group">
                    <label for="district_town" class="col-sm-2 control-label">District/Town</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="districttown" placeholder="District/Town">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputAddress" class="col-sm-2 control-label">Address</label>
                    <div class="col-sm-10">
                        <textarea class="form-control form-control-lg" rows="2" placeholder="Enter Your Address"
                            name="address"></textarea>
                    </div>
                </div>
                            <input type="submit" class="btn btn-lg btn-primary btn-block text-uppercase"  name="action" value="Create">
            </form>
        </div>
    </div>
</body>

</html>