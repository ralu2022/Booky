<html>
<head>
    <title>Booky</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<style>
    body {
        background-image: url("book0.jpg");
    }
</style>

</body>
<form action="userlogin.jsp">
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">
                        <div class="mb-md-5 mt-md-4 pb-5">
                            <h2 class="fw-bold mb-2 text-uppercase">Welcome to</h2>
                            <h2 class="fw-bold mb-2 text-uppercase">~Booky~</h2>
                            <br>
                            <br>
                            <div class="form-outline form-white mb-4">
                                <input type="text" name="user_name" id="user_name" onclick="this.value=''"
                                       required="true" class="form-control form-control-lg"/>
                                <label class="form-label" for="user_name">User</label>
                            </div>
                            <div class="form-outline form-white mb-4">
                                <input type="password" name="password" id="typePasswordX" onclick="this.value=''"
                                       required="true" class="form-control form-control-lg"/>
                                <label class="form-label" for="typePasswordX">Password</label>
                            </div>
                            <div align="CENTER" class="form-outline mb-4">
                                <input class="btn btn-primary" type="submit" value="Login">
                            </div>
                            <button class="btn btn-outline-light btn-lg px-5" type="submit"><a href="amainpage.jsp"
                                                                                               class="text-blue-50 fw-bold">Entrance</a>
                            </button>
                            <div class="d-flex justify-content-center text-center mt-4 pt-1">
                                <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                                <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                                <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
                            </div>

                            <div>
                                <p class="mb-0">Don't have an account? <a href="useraddhtml.jsp"
                                                                          class="text-white-50 fw-bold">Sign
                                    Up</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</form>

</body>
</html>
