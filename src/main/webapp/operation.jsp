<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="resources/img/favicon.png">

    <title>Cash | Operations</title>

    <!-- Bootstrap CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="resources/css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="resources/css/elegant-icons-style.css" rel="stylesheet" />
    <link href="resources/css/font-awesome.min.css" rel="stylesheet" />
    <!-- full calendar css-->
    <link href="resources/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
    <link href="resources/assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
    <!-- easy pie chart-->
    <link href="resources/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
    <!-- owl carousel -->
    <link rel="stylesheet" href="resources/css/owl.carousel.css" type="text/css">
    <link href="resources/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
    <!-- Custom styles -->
    <link rel="stylesheet" href="resources/css/fullcalendar.css">
    <link href="resources/css/widgets.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
    <link href="resources/css/style-responsive.css" rel="stylesheet" />
    <link href="resources/css/xcharts.min.css" rel=" stylesheet">
    <link href="resources/css/jquery-ui-1.10.4.min.css" rel="stylesheet">

</head>

<body>
<section id="container" class="">
    <c:import url="parts/header.jsp"/>
    <c:import url="parts/sidebar.jsp"/>

    <section id="main-content">
        <section class="wrapper">

            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header"><i class="icon_desktop"></i> Операції</h3>
                    <section class="panel">
                        <div class="panel-body">

                            <button type="button" class="btn btn-default popovers" data-toggle="modal" data-target="#operation_income">
                                <i class="fa fa-plus" aria-hidden="true"></i> Прихід
                            </button>

                            <button type="button" class="btn btn-default popovers" data-toggle="modal" data-target="#operation_outcome">
                                <i class="fa fa-minus" aria-hidden="true"></i> Витрата
                            </button>

                            <button type="button" class="btn btn-default popovers" data-toggle="modal" data-target="#operation_transfer">
                                <i class="fa fa-retweet" aria-hidden="true"></i> Переказ
                            </button>

                        </div>
                    </section>
                </div>
            </div>

<%--            <div class="row">--%>
<%--                <div class="col-lg-12">--%>
<%--                    <section class="panel">--%>
<%--                        <table class="table table-striped table-advance table-hover">--%>
<%--                            <tbody>--%>
<%--                            <tr>--%>
<%--                                <th><i class="icon_book"></i> Назва рахунку</th>--%>
<%--                                <th><i class="icon_calculator_alt"></i> Залишок</th>--%>
<%--                                <th><i class="icon_currency"></i> Валюта</th>--%>
<%--                                <th><i class="icon_comment"></i> Примітка</th>--%>
<%--                                <th><i class="icon_cogs"></i> Action</th>--%>
<%--                            </tr>--%>
<%--                            <c:forEach items="${accounts}" var="e">--%>
<%--                                <tr>--%>
<%--                                    <td>--%>
<%--                                        <c:if test="${'1'.equals(e.locked)}">--%>
<%--                                            <i class="fa fa-lock" aria-hidden="true"></i> ${e.name}--%>
<%--                                        </c:if>--%>
<%--                                        <c:if test="${'0'.equals(e.locked)}">--%>
<%--                                            ${e.name}--%>
<%--                                        </c:if>--%>
<%--                                    </td>--%>
<%--                                    <td>${e.startingBalance}</td>--%>
<%--                                    <td>${e.currency}</td>--%>
<%--                                    <td>${e.comment}</td>--%>
<%--                                    <td>--%>
<%--                                        <div class="btn-group">--%>

<%--                                            <c:if test="${'1'.equals(e.locked)}">--%>
<%--                                                <form action="/account-unlock?account_id=${e.id}" method="post">--%>
<%--                                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_${e.id}">--%>
<%--                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>--%>
<%--                                                    </button>--%>
<%--                                                    <button type="submit" class="btn btn-warning"--%>
<%--                                                            onclick="return confirm('Ви впевнені що хочете розблокувати цей рахунок?')">--%>
<%--                                                        <i class="fa fa-lock" aria-hidden="true"></i>--%>
<%--                                                    </button>--%>
<%--                                                </form>--%>
<%--                                            </c:if>--%>
<%--                                            <c:if test="${'0'.equals(e.locked)}">--%>
<%--                                                <form action="/account-lock?account_id=${e.id}" method="post">--%>
<%--                                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_${e.id}">--%>
<%--                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>--%>
<%--                                                    </button>--%>
<%--                                                    <button type="submit" class="btn btn-warning"--%>
<%--                                                            onclick="return confirm('Ви впевнені що хочете заблокувати цей рахунок?')">--%>
<%--                                                        <i class="fa fa-lock" aria-hidden="true"></i>--%>
<%--                                                    </button>--%>
<%--                                                </form>--%>
<%--                                            </c:if>--%>

<%--                                            <!-- Modal -->--%>
<%--                                            <div class="modal fade" id="modal_${e.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--                                                <div class="modal-dialog" role="document">--%>
<%--                                                    <div class="modal-content">--%>

<%--                                                        <form method="post" action="/account-edit?account_id=${e.id}">--%>
<%--                                                            <div class="modal-header">--%>
<%--                                                                <h5 class="modal-title" id="exampleModalLabel">Редагувати рахунок - ${e.name}</h5>--%>
<%--                                                            </div>--%>
<%--                                                            <div class="modal-body">--%>

<%--                                                                <label for="account_name" class="form-label">Назва рахунку </label>--%>
<%--                                                                <input type="text" class="form-control" min="3" name="name" id="account_name" value="${e.name}"/>--%>

<%--                                                                <label for="currency" class="form-label">Валюта </label>--%>
<%--                                                                <select required class="custom-select form-control" id="currency" name="a_currency">--%>
<%--                                                                    <c:forEach items="${currencies}" var="c_e">--%>
<%--                                                                        <option value="${c_e.id}">${c_e.code}   ${c_e.name}</option>--%>
<%--                                                                    </c:forEach>--%>
<%--                                                                </select>--%>

<%--                                                                <label for="account_balance" class="form-label">Залишок </label>--%>
<%--                                                                <input type="number" class="form-control" name="balance" id="account_balance" value="${e.startingBalance}"/>--%>

<%--                                                                <label for="account_comment" class="form-label">Примітка </label>--%>
<%--                                                                <input type="text" class="form-control" min="3" name="comment" id="account_comment" value="${e.comment}"/>--%>

<%--                                                            </div>--%>
<%--                                                            <div class="modal-footer">--%>
<%--                                                                <a type="button" class="btn btn-danger" href="/account-remove?account_id=${e.id}"--%>
<%--                                                                   onclick="return confirm('Ви дійсно бажаєте видалити цей рахунок?')">--%>
<%--                                                                    Видалити рахунок</a>--%>
<%--                                                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Вийти"/>--%>
<%--                                                                <input type="submit" class="btn btn-info" value="Зберегти"/>--%>
<%--                                                            </div>--%>
<%--                                                        </form>--%>

<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                            </div>--%>

<%--                                        </div>--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
<%--                            </c:forEach>--%>

<%--                            </tbody>--%>
<%--                        </table>--%>
<%--                    </section>--%>
<%--                </div>--%>
<%--            </div>--%>


        </section>
    </section>

</section>

</div>





<!-- INCOME / Прихід -->
<div class="modal fade" id="operation_income" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <form method="post" action="/operation/income">
                <div class="modal-header">
                    <h5 class="modal-title">Прихід</h5>
                </div>
                <div class="modal-body">

                    <div class="form-group row">
                        <label for="income_accounts" class="col-form-label col-sm-2">Рахунок </label>
                        <div class="col-sm-10">
                            <select required class="custom-select form-control" id="income_accounts" name="income_accounts">
                                <c:forEach items="${accounts}" var="acc">
                                    <option value="${acc.id}">${acc.currency} - ${acc.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="income_state" class="col-form-label col-sm-2">Стан операції </label>
                        <div class="col-sm-10">
                            <select required class="custom-select form-control" id="income_state" name="income_state">
                                <option value="1">Виконана</option>
                                <option value="2">Виконана і заблокована</option>
                                <option value="3">Не виконана</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="income_date" class="form-label col-sm-2">Дата </label>
                        <div class="col-sm-10">
                            <input required type="datetime-local" class="form-control" name="income_date" id="income_date"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="income_category" class="form-label col-sm-2">Стаття доходу </label>
                        <div class="col-sm-10">
                            <select required class="custom-select form-control" id="income_category" name="income_category">
                                <c:forEach items="${operations_income}" var="_income">
                                    <option value="${_income.id}">${_income.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="income_balance" class="form-label col-sm-2">Сума доходу </label>
                        <div class="col-sm-10">
                            <input required type="number" class="form-control" name="income_balance" id="income_balance" value="0"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="income_comment" class="form-label col-sm-2">Примітка </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" maxlength="100" name="income_comment" id="income_comment"/>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Вийти"/>
                    <input type="submit" class="btn btn-info" value="Зберегти"/>
                </div>
            </form>

        </div>
    </div>
</div>

<!-- OUTCOME -->
<div class="modal fade" id="operation_outcome" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <form method="post" action="/operation/expense">
                <div class="modal-header">
                    <h5 class="modal-title">Витрата</h5>
                </div>
                <div class="modal-body">

                    <div class="form-group row">
                        <label for="outcome_accounts" class="col-form-label col-sm-2">Рахунок </label>
                        <div class="col-sm-10">
                            <select required class="custom-select form-control" id="outcome_accounts" name="outcome_accounts">
                                <c:forEach items="${accounts}" var="_acc">
                                    <option value="${_acc.id}">${_acc.currency} - ${_acc.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="outcome_state" class="col-form-label col-sm-2">Стан операції </label>
                        <div class="col-sm-10">
                            <select required class="custom-select form-control" id="outcome_state" name="outcome_state">
                                <option value="1">Виконана</option>
                                <option value="2">Виконана і заблокована</option>
                                <option value="3">Не виконана</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="outcome_date" class="form-label col-sm-2">Дата </label>
                        <div class="col-sm-10">
                            <input required type="datetime-local" class="form-control" name="outcome_date" id="outcome_date"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="outcome_category" class="form-label col-sm-2">Стаття доходу </label>
                        <div class="col-sm-10">
                            <select required class="custom-select form-control" id="outcome_category" name="outcome_category">
                                <c:forEach items="${operations_income}" var="_outcome">
                                    <option value="${_outcome.id}">${_outcome.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="outcome_balance" class="form-label col-sm-2">Сума витрати </label>
                        <div class="col-sm-10">
                            <input required type="number" class="form-control" name="outcome_balance" id="outcome_balance" value="0"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="outcome_comment" class="form-label col-sm-2">Примітка </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" maxlength="100" name="outcome_comment" id="outcome_comment"/>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Вийти"/>
                    <input type="submit" class="btn btn-info" value="Зберегти"/>
                </div>
            </form>

        </div>
    </div>
</div>

<!-- TRANSFER -->
<div class="modal fade" id="operation_transfer" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <form method="post" action="/operation/transfer">
                <div class="modal-header">
                    <h5 class="modal-title">Переказ</h5>
                </div>
                <div class="modal-body">

                    <div class="form-group row">
                        <label for="transfer_outcome_account" class="col-form-label col-sm-2">Із рахунку </label>
                        <div class="col-sm-10">
                            <select required class="custom-select form-control" id="transfer_outcome_account" name="transfer_outcome_account">
                                <c:forEach items="${accounts}" var="_acc1">
                                    <option value="${_acc1.id}">${_acc1.currency} - ${_acc1.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="transfer_income_account" class="col-form-label col-sm-2">На рахунок </label>
                        <div class="col-sm-10">
                            <select required class="custom-select form-control" id="transfer_income_account" name="transfer_income_account">
                                <c:forEach items="${accounts}" var="_acc2">
                                    <option value="${_acc2.id}">${_acc2.currency} - ${_acc2.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="transfer_state" class="col-form-label col-sm-2">Стан операції </label>
                        <div class="col-sm-10">
                            <select required class="custom-select form-control" id="transfer_state" name="transfer_state">
                                <option value="1">Виконана</option>
                                <option value="2">Виконана і заблокована</option>
                                <option value="3">Не виконана</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="transfer_date" class="form-label col-sm-2">Дата </label>
                        <div class="col-sm-10">
                            <input required type="datetime-local" class="form-control" name="transfer_date" id="transfer_date"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="transfer_balance" class="form-label col-sm-2">Сума витрати </label>
                        <div class="col-sm-10">
                            <input required type="number" class="form-control" name="transfer_balance" id="transfer_balance" value="0"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="transfer_comment" class="form-label col-sm-2">Примітка </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" maxlength="100" name="transfer_comment" id="transfer_comment"/>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Вийти"/>
                    <input type="submit" class="btn btn-info" value="Зберегти"/>
                </div>
            </form>

        </div>
    </div>
</div>


<!-- javascripts -->
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui-1.10.4.min.js"></script>
<script src="resources/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.9.2.custom.min.js"></script>
<!-- bootstrap -->
<script src="resources/js/bootstrap.min.js"></script>
<!-- nice scroll -->
<script src="resources/js/jquery.scrollTo.min.js"></script>
<script src="resources/js/jquery.nicescroll.js" type="text/javascript"></script>
<!-- charts scripts -->
<script src="resources/assets/jquery-knob/js/jquery.knob.js"></script>
<script src="resources/js/jquery.sparkline.js" type="text/javascript"></script>
<script src="resources/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
<script src="resources/js/owl.carousel.js"></script>
<!-- jQuery full calendar -->
<<script src="resources/js/fullcalendar.min.js"></script>
<!-- Full Google Calendar - Calendar -->
<script src="resources/assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
<!--script for this page only-->
<script src="resources/js/calendar-custom.js"></script>
<script src="resources/js/jquery.rateit.min.js"></script>
<!-- custom select -->
<script src="resources/js/jquery.customSelect.min.js"></script>
<script src="resources/assets/chart-master/Chart.js"></script>

<!--custome script for all page-->
<script src="resources/js/scripts.js"></script>
<!-- custom script for this page-->
<script src="resources/js/sparkline-chart.js"></script>
<script src="resources/js/easy-pie-chart.js"></script>
<script src="resources/js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="resources/js/jquery-jvectormap-world-mill-en.js"></script>
<script src="resources/js/xcharts.min.js"></script>
<script src="resources/js/jquery.autosize.min.js"></script>
<script src="resources/js/jquery.placeholder.min.js"></script>
<script src="resources/js/gdp-data.js"></script>
<script src="resources/js/morris.min.js"></script>
<script src="resources/js/sparklines.js"></script>
<script src="resources/js/charts.js"></script>
<script src="resources/js/jquery.slimscroll.min.js"></script>
<script src="resources/js/custom-knob-carousel.js"></script>

</body>
</html>
