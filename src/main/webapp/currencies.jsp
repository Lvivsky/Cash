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

    <title>Cash | Currency</title>

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
            <!--overview start-->
            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header"><i class="fa fa-money"></i> Валюти</h3>
                    <section class="panel">
                        <div class="panel-body">
                            <a href="/currency-upload" data-original-title="Завантажити валюту"
                               data-content="Завантаження даних про валюти із інтернету" onclick="return confirm('Завантажити валюти із інтернету?')"
                               data-placement="bottom" data-trigger="hover" class="btn btn-default popovers">Завантажити валюту</a>
<%--                            <a href="#" data-original-title="Додати валюту"--%>
<%--                               data-content="Додати власну валюту, для налаштуванняя рейтингу перейдіть у розділ 'Курс валют та введіть потрібні значення відносно інших валют"--%>
<%--                               data-placement="bottom" data-trigger="hover" class="btn btn-default popovers">Добавити валюту</a>--%>
                        </div>
                    </section>
                </div>
            </div>

            <div class="row">

                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading tab-bg-info ">
                            <ul class="nav nav-tabs">
                                <li class="active"><a data-toggle="tab" href="#currencies">Валюти</a></li>
                                <li class=""><a data-toggle="tab" href="#currencies-rate">Курси валют</a></li>
                            </ul>
                        </header>
                        <div class="panel-body">
                            <div class="tab-content">

                                <div id="currencies" class="tab-pane active">
                                        <section class="panel">
                                            <table class="table table-striped table-advance table-sm table-hover">
                                                <tbody>
                                                <tr>
                                                    <th><i class="icon_calculator_alt"></i> Код валюти</th>
                                                    <th><i class="icon_book"></i> Назва валюти</th>
                                                    <th><i class="icon_cogs"></i> Action</th>
                                                </tr>
                                                <c:forEach items="${curr}" var="e">
                                                    <tr>
                                                        <td>${e.code}</td>
                                                        <td>${e.name}</td>
                                                        <td>
                                                            <div class="btn-group">
                                                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_${e.id}">
                                                                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                                </button>
                                                            </div>

                                                                <!-- Modal -->
                                                                <div class="modal fade" id="modal_${e.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                    <div class="modal-dialog" role="document">
                                                                        <div class="modal-content">

                                                                            <form method="post" action="/currency-edit?currency_id=${e.id}">
                                                                                <div class="modal-header">
                                                                                    <h5 class="modal-title" id="exampleModalLabel">Редагувати валюту - ${e.name}</h5>
                                                                                </div>
                                                                                <div class="modal-body">

                                                                                    <label for="account_name" class="form-label">Назва валюти </label>
                                                                                    <input type="text" class="form-control" minlength="3" maxlength="16" name="name" id="account_name" value="${e.name}"/>

                                                                                    <label for="account_balance" class="form-label">Код валюти </label>
                                                                                    <input type="text" class="form-control" minlength="3" maxlength="3" name="code" id="account_balance" value="${e.code}"/>

                                                                                </div>
                                                                                <div class="modal-footer">
<%--                                                                                    <a type="button" class="btn btn-danger" href="/currency-remove?currency_id=${e.id}"--%>
<%--                                                                                       onclick="return confirm('Ви дійсно бажаєте видалити цю валюту?')">--%>
<%--                                                                                        Видалити валюту</a>--%>
                                                                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Вийти"/>
                                                                                    <input type="submit" class="btn btn-info" value="Зберегти"/>
                                                                                </div>
                                                                            </form>

                                                                        </div>
                                                                    </div>
                                                                </div>


                                                        </td>
                                                    </tr>
                                                </c:forEach>

                                                </tbody>
                                            </table>
                                        </section>
                                </div>

                                <div id="currencies-rate" class="tab-pane">



                                </div>
                            </div>
                        </div>
                    </section>
                </div>



<%--                <div class="col-lg-12">--%>
<%--                    <section class="panel">--%>
<%--                        <table class="table table-striped table-advance table-hover">--%>
<%--                            <tbody>--%>
<%--                            <tr>--%>
<%--                                <th><i class="icon_book"></i> Назва категорії</th>--%>
<%--                                <th><i class="icon_calculator_alt"></i> Примітка</th>--%>
<%--                                <th><i class="icon_currency"></i> Parent</th>--%>
<%--                                <th><i class="icon_cogs"></i> Action</th>--%>
<%--                            </tr>--%>
<%--                            <c:forEach items="${categories}" var="e">--%>
<%--                                <tr>--%>
<%--                                    <td>${e.name}</td>--%>
<%--                                    <td>${e.comment}</td>--%>
<%--                                    <td>${e.parent}</td>--%>
<%--                                    <td>--%>
<%--                                        <div class="btn-group">--%>
<%--                                            <a class="btn btn-primary" href="#"><i class="icon_plus_alt2"></i></a>--%>
<%--                                            <a class="btn btn-success" href="#"><i class="icon_check_alt2"></i></a>--%>
<%--                                            <a class="btn btn-danger" href="#"><i class="icon_close_alt2"></i></a>--%>
<%--                                        </div>--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
<%--                            </c:forEach>--%>

<%--                            </tbody>--%>
<%--                        </table>--%>
<%--                    </section>--%>
<%--                </div>--%>


            </div>
        </section>
    </section>

</section>

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
