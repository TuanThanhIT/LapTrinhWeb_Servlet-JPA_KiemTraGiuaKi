<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<c:if test="${alert != null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>
<h1>Chào mừng bạn đến với trang web của chúng tôi</h1>