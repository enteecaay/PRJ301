
<%@page import="com.shoesshopaka.User.UserDTO"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div style="background-color: #CCDDFF;" class="container-fluid">
        <div class="navbar-header">
            <a href="index.jsp" class="nav navbar-brand">
                <img src="./img/logo_text.png" height="60px" alt="AKA Shoes Logo">
            </a>
        </div>
        <div class="collapse navbar-collapse  pull-left">
            <ul class="nav navbar-nav" style="font-size: 20px; font-weight: bold; padding-top: 25px;">
                <li>

                </li>
                <li><a class="nav-link" href="index.jsp">HOME</a></li>
                <li><a class="nav-link" href="#">SHOP</a></li>
                <li><a class="nav-link" href="#">ABOUT</a></li>
                <li><a class="nav-link" href="#">CONTACT</a></li>
            </ul>
        </div>

        <ul style="padding: 20px 0 0 0;" class="nav navbar-nav navbar-right">
            <li>
                <form class="navbar-form">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search...">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-search"></span>
                        </span>
                    </div>
                </form>
            </li>
            <li class="nav-item"><a class="nav-link" href="cart.jsp">Cart <span class="glyphicon glyphicon-shopping-cart"></span> </a></li>
            <% 
                UserDTO user = (session != null) ? (UserDTO) session.getAttribute("usersession") : null;
                if (user != null) {
            %>
                <li class="nav-item"><a class="nav-link" href="#">Welcome, <%= user.getUsername() %></a></li>
                <li class="nav-item"><a class="nav-link" href="login?action=logout">Logout <span class="glyphicon glyphicon-log-out"></span></a></li>
            <% } else { %>
                <li class="nav-item"><a class="nav-link" href="login.jsp">Login <span class="glyphicon glyphicon-user"></span></a></li>
            <% } %>
        </ul>
    </div>
</nav>
