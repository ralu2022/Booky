<html>
<head>
    <style>
        body {
            background-image: url("books.jpg");
        }
    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Booky</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        img {
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>

<body>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" href="index.jsp">LOGOUT</a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">BOOKS</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="bookaddhtml.jsp" target="_self">Create book</a>
            <a class="dropdown-item" href="bookupdatehtml.jsp">Update book</a>
            <a class="dropdown-item" href="bookdeletehtml.jsp">Delete book</a>
            <a class="dropdown-item" href="bookallhtml.jsp">All books</a>
            <a class="dropdown-item" href="bookcounthtml.jsp">Calculator</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">AUTHORS</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="authoraddhtml.jsp">Create author</a>
            <a class="dropdown-item" href="authorupdatehtml.jsp">Update author</a>
            <a class="dropdown-item" href="authordeletehtml.jsp">Delete author</a>
            <a class="dropdown-item" href="authorallhtml.jsp">All authors</a>
            <a class="dropdown-item" href="authorcounthtml.jsp">Calculator</a>
        </div>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">PUBLISHING HOUSES</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="publishinghouseaddhtml.jsp">Create publishing house</a>
            <a class="dropdown-item" href="publishingHouseUpdateHtml.jsp">Update publishing house</a>
            <a class="dropdown-item" href="publishinghousedeletehtml.jsp">Delete publishing house</a>
            <a class="dropdown-item" href="publishinghouseallhtml.jsp">All publishing houses</a>
            <a class="dropdown-item" href="publishinghousecounthtml.jsp">Calculator</a>
        </div>
    </li>
</ul>
<br>
<br>
<br>
<img src="book8.jpg" alt="Books" width="800" height="400" vertical-align>
<br>
<br>
<p style ="color: darkcyan;"><em> <b> A room without books is like a body without a soul... </b></em></p>
<p style ="color: darkcyan;"> <b>  ~ Cicero</b></p>
<br>
<style>
    p{
        font-family: Castellar;
        text-align: center;
    }
</style>

</body>


</html>