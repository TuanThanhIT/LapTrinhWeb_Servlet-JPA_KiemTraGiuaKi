<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<c:forEach items="${listcate}" var="cate">
	<div class="author-section">
		<h6>Category: ${cate.categoryName}</h6>

		<table class="book-table" border="1" width="100%">
			<thead>
				<tr>
					<th>STT</th>
					<th>VideoID</th>
					<th>TiTle</th>
					<th>Images</th>
					<th>Description</th>
					<th>Views</th>
					<th>Category</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cate.videos}" var="video" varStatus="STT">
			<tr>
				<td>${STT.index + 1}</td>
				<td>${video.videoId}</td>
				<td>${video.title}</td>
				<c:if test="${video.poster.substring(0 , 5)=='https'}">
					<c:url value="${video.poster}" var="imgUrl"></c:url>
				</c:if>
				<c:if test="${video.poster.substring(0 , 5)!='https'}">
					<c:url value="/image?fname=${video.poster}" var="imgUrl"></c:url>
				</c:if>
				<td><img height="150" width="200" src="${imgUrl}" alt="${imgUrl}" /></td>
				<td>${video.description}</td>
				<td>${video.views}</td>
				<td>${video.category.categoryName}</td>
				<td><c:choose>
						<c:when test="${video.active == true}">
                            Hoạt động
                        </c:when>
						<c:when test="${video.active == false}">
                            Khóa
                        </c:when>
						<c:otherwise>
                            Không xác định
                        </c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
			</tbody>
		</table>
	</div>
	<hr>
</c:forEach>


