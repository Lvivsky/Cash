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

    <title>Cash | Categories</title>

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
                    <h3 class="page-header"><i class="fa fa-list-alt" aria-hidden="true"></i> Статті</h3>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <table class="table table-striped table-advance table-hover">
                            <tbody>
                            <tr>
                                <th><i class="icon_book"></i> Назва категорії</th>
                                <th><i class="icon_calculator_alt"></i> Примітка</th>
                                <th><i class="icon_cogs"></i> </th>
                            </tr>
                            <c:forEach items="${categories}" var="e">
                                <tr>
                                    <td>${e.name}</td>
                                    <td>${e.comment}</td>
                                    <td>
                                        <div class="btn-group">
                                            <a class="btn btn-primary" href="#" data-toggle="modal" data-target="#category_add_${e.id}"><i class="icon_plus_alt2"></i></a>
                                            <a class="btn btn-warning" href="#" data-toggle="modal" data-target="#category_edit_${e.id}"><i class="icon_pencil-edit"></i></a>
                                            <a class="btn btn-danger" href="#"><i class="icon_close_alt2"></i></a>


                                            <div class="modal fade" id="category_add_${e.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">

                                                        <form method="post" action="/categories/add?category_id=${e.id}">
                                                            <div class="modal-header"><h5 class="modal-title">Додати статтю до - ${e.name}</h5></div>
                                                            <div class="modal-body">

                                                                <div class="form-group row">
                                                                    <label for="add_name" class="form-label col-sm-2">Назва статті </label>
                                                                    <div class="col-sm-10">
                                                                        <input type="text" required minlength="3" class="form-control" maxlength="100" name="add_name" id="add_name"/>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group row">
                                                                    <label for="add_comment" class="form-label col-sm-2">Примітка </label>
                                                                    <div class="col-sm-10">
                                                                        <input type="text" class="form-control" maxlength="100" name="add_comment" id="add_comment"/>
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
                                            <div class="modal fade" id="category_edit_${e.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">

                                                        <form method="post" action="/categories/edit?category_id=${e.id}">
                                                            <div class="modal-header"><h5 class="modal-title">Змінити статтю - ${e.name}</h5></div>
                                                            <div class="modal-body">

                                                                <div class="form-group row">
                                                                    <label for="edit_name" class="form-label col-sm-2">Назва статті </label>
                                                                    <div class="col-sm-10">
                                                                        <input type="text" value="${e.name}" required minlength="3" class="form-control" maxlength="100" name="edit_name" id="edit_name"/>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group row">
                                                                    <label for="edit_comment" class="form-label col-sm-2">Примітка </label>
                                                                    <div class="col-sm-10">
                                                                        <input type="text" class="form-control" maxlength="100" name="edit_comment" id="edit_comment" value="${e.comment}"/>
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

                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </section>
                </div>
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
