<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">

            <%-- Dropdown menu --%>
                <li class="sub-menu">
                    <a href="javascript:;" class="">
                        <i class="icon_folder"></i>
                        <span> Файл </span>
                        <span class="menu-arrow arrow_carrot-right"></span>
                    </a>
                    <ul class="sub">
                        <li><a class="" href="/save"><i class="icon_folder_download"> Завантажити</i></a></li>
                        <li>
                            <a class="" href="/remove-db"
                               onclick="return confirm('Ви дійсно бажаєте вийти?')">
                                <i class="fa fa-sign-out" aria-hidden="true"> Вийти</i>
                            </a>
                        </li>
                    </ul>
                </li>

            <li class="active">
                <a class="" href="#">
                    <i class="fa fa-bar-chart" aria-hidden="true"></i>
                    <span>Статистика</span>
                </a>
            </li>

            <li class="">
                <a class="" href="/account">
                    <i class="fa fa-credit-card" aria-hidden="true"></i>
                    <span>Рахунки</span>
                </a>
            </li>

            <li class="">
                <a class="" href="#">
                    <i class="icon_desktop"></i>
                    <span>Дії</span>
                </a>
            </li>

            <li class="">
                <a class="" href="/currencies">
                    <i class="fa fa-money" aria-hidden="true"></i>
                    <span>Валюти</span>
                </a>
            </li>

            <li class="">
                <a class="" href="#">
                    <i class="icon_documents_alt"></i>
                    <span>Класифікатори</span>
                </a>
            </li>
            <li class="">
                <a class="" href="#">
                    <i class="icon_documents_alt"></i>
                    <span>Бюджет</span>
                </a>
            </li>
            <li class="">
                <a class="" href="/categories">
                    <i class="fa fa-list-alt" aria-hidden="true"></i>
                    <span>Статті</span>
                </a>
            </li>




<%-- Dropdown menu --%>
<%--            <li class="sub-menu">--%>
<%--                <a href="javascript:;" class="">--%>
<%--                    <i class="icon_documents_alt"></i>--%>
<%--                    <span>Pages</span>--%>
<%--                    <span class="menu-arrow arrow_carrot-right"></span>--%>
<%--                </a>--%>
<%--                <ul class="sub">--%>
<%--                    <li><a class="" href="#">Profile</a></li>--%>
<%--                    <li><a class="" href="#"><span>Login Page</span></a></li>--%>
<%--                    <li><a class="" href="#"><span>Contact Page</span></a></li>--%>
<%--                    <li><a class="" href="#">Blank Page</a></li>--%>
<%--                    <li><a class="" href="#">404 Error</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>

        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->

<!-- Modal -->
<%--<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>

<%--            <form method="post" action="/change-username">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="exampleModalLabel">Введіть назву яка буде завжди відображатись</h5>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>

<%--                    <label for="username" class="form-label">Назва повинна містити від 3 до 10 символів</label><br/>--%>
<%--                    <input type="text" class="form-control" required min="3" max="10" name="username" id="username" value="${user_data.login}"/>--%>

<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Вийти"/>--%>
<%--                    <input type="submit" class="btn btn-info" value="Зберегти"/>--%>
<%--                </div>--%>
<%--            </form>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>