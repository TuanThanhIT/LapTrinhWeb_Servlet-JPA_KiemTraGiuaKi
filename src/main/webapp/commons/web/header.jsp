<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!-- Header (Navbar) -->


<nav class="navbar navbar-expand-lg navbar-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Web Book</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarNav" aria-controls="navbarNav"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/web/home">Trang Chủ</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/web/book">Sản phẩm</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Đăng nhập</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/register">Đăng ký</a></li>
                
            </ul>
        </div>
    </div>
</nav>
