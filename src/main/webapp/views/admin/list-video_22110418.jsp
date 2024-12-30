<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<a href="<c:url value='/admin/video/add'></c:url>">Add Video</a>
<hr>
<style>
.pagination-container {
    display: flex;
    justify-content: center;
    gap: 8px;
    margin-top: 20px;
}

<!--.pagination-item {-->
    text-decoration: none;
    padding: 8px 12px;
    border: 1px solid #ddd;
    border-radius: 5px;
    color: #007bff;
    transition: background-color 0.3s ease, color 0.3s ease;
}

.pagination-item:hover {
    background-color: #f0f0f0;
    color: #0056b3;
}

.pagination-item.active {
    background-color: #007bff;
    color: white;
    font-weight: bold;
    border: 1px solid #007bff;
}

</style>
<table border="1" width = "100%">
	<tr>
		<th>STT</th>
		<th>VideoID</th>
		<th>TiTle</th>
		<th>Images</th>
		<th>Description</th>
		<th>Views</th>
		<th>Category</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
		<c:forEach items="${listvideo}" var="video" varStatus="STT">
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
				<td><a
					href="<c:url value='/admin/video/edit?id=${video.videoId }'/>">Sửa</a>
					| <a href="<c:url value='/admin/video/delete?id=${video.videoId }'/>">Xóa</a>
					| <a href="<c:url value='/admin/video/detail?id=${video.videoId }'/>">Chi tiết</a>
				</td>
			</tr>
		</c:forEach>
</table>

<div class="pagination-container">
    <c:forEach var="i" begin="1" end="${(totalVideos / pageSize) + 1}">
        <a href="?page=${i}" class="pagination-item ${i == page ? 'active' : ''}">${i}</a>
    </c:forEach>
</div>