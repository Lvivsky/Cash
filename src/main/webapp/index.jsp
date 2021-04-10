<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="resources/img/favicon.png">

    <title>Cash</title>

    <!-- Bootstrap CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="resources/css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="resources/css/elegant-icons-style.css" rel="stylesheet" />
    <link href="resources/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="resources/css/style.css" rel="stylesheet">
    <link href="resources/css/style-responsive.css" rel="stylesheet" />

    <%-- HTML5 shim and Respond.js IE8 support of HTML5 --%>
    <script src="resources/js/html5shiv.js"></script>
    <script src="resources/js/respond.min.js"></script>

</head>

<body class="login-img3-body">
<div class="container">

        <form method="post" action="/upload-database" class="login-form" enctype="multipart/form-data">
            <div class="login-wrap">
                <p class="login-img"><i class="icon_lock_alt"></i></p>

                <div class="input-group">
                    <span class="input-group-addon"><i class="icon_profile"></i></span>
                    <input required name="database" type="file" class="form-control" id="db" accept=".cash">
                </div>

                <button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>

                <a href="/generate-template-database" class="btn btn-info btn-lg btn-block" type="submit">Empty template</a>
            </div>
        </form>

    </div>

</div>
</body>
</html>
