<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<a href="<c:url value='/admin/category/add'></c:url>">Add category</a>
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
		<th>Images</th>
		<th>Category Name</th>
		<th>Category Code</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${listcate}" var="cate" varStatus="STT">
		<tr>
			<td>${STT.index+1 }</td>
			<c:if test="${cate.images.substring(0 , 5)=='https'}">
				<c:url value="${cate.images}" var="imgUrl"></c:url>
			</c:if>
			<c:if test="${cate.images.substring(0 , 5)!='https'}">
				<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
			</c:if>
			<td><img height="150" width="200" src="${imgUrl}" alt="${imgUrl}"/></td>
			<td>${cate.categoryName }</td>
			<td>${cate.categoryCode }</td>
			<td><c:choose>
						<c:when test="${cate.status == true}">
                            Hoạt động
                        </c:when>
						<c:when test="${cate.status == false}">
                            Khóa
                        </c:when>
					</c:choose></td>
			<td><a
				href="<c:url value='/admin/category/edit?id=${cate.categoryId }'/>">Sửa</a>
				| <a
				href="<c:url value='/admin/category/delete?id=${cate.categoryId }'/>">Xóa</a>
			</td>
		</tr>
	</c:forEach>
</table>
<div class="pagination-container">
    <c:forEach var="i" begin="1" end="${(totalCategory / pageSize) + 1}">
        <a href="?page=${i}" class="pagination-item ${i == page ? 'active' : ''}">${i}</a>
    </c:forEach>
</div>
