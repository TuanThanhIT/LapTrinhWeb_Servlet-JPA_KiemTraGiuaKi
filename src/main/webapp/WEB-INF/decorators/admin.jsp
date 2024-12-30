<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Web - Admin</title>
    <!-- Liên kết tới CSS của Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Custom styles for header and footer */
        .navbar {
            background-color: #007bff;
        }
        .navbar-brand {
            color: white !important;
        }
        .navbar-nav .nav-link {
            color: white !important;
            font-weight: bold;
        }
        .navbar-nav .nav-link:hover {
            color: #ffd700 !important;
        }
        footer {
            background-color: #f8f9fa;
            padding: 20px 0;
            color: #343a40;
        }
        footer p {
            margin: 5px 0;
        }
        .content-header {
            margin-top: 50px;
            font-size: 1.8rem;
            font-weight: bold;
            text-align: center;
        }
        .admin-content {
            background-color: #f1f1f1;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>

    <!-- Header (Navbar) -->
   		<%@include file="/commons/admin/header.jsp"%>
    <!-- Nội dung quản trị -->
    <div class="container mt-4">
     <sitemesh:write property="body" />
    </div>

    <!-- Footer -->
	<%@include file="/commons/admin/footer.jsp"%>
    <!-- Liên kết tới JavaScript của Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>


	
	