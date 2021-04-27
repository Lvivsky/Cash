<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="header dark-bg">
    <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
    </div>

    <!--logo start-->
    <a href="/" class="logo">Ca<span class="lite">s</span>h</a>
    <!--logo end-->

    <div class="top-nav notification-row">

        <ul class="nav pull-right top-menu">

            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <i class="icon-task-l"></i>
                            </span>
                    <span class="username"> File </span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu extended logout">
                    <div class="log-arrow-up"></div>
                    <li class="eborder-top"><a href="/save"><i class="icon_profile"></i> Save </a></li>
                    <li><a href="/remove-db"><i class="icon_clock_alt"></i> Out</a></li>
                    <%--                            <li><a href="#"><i class="icon_chat_alt"></i> Chats</a></li>--%>
                </ul>
            </li>
        </ul>
    </div>

</header>
<!--header end-->