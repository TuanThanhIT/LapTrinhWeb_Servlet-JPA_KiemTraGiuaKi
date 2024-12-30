<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<table border="1" width="100%">
	<tr>
		<td><c:if test="${video.poster.substring(0 , 5)=='https'}">
				<c:url value="${video.poster}" var="imgUrl"></c:url>
			</c:if> <c:if test="${video.poster.substring(0 , 5)!='https'}">
				<c:url value="/image?fname=${video.poster}" var="imgUrl"></c:url>
			</c:if> <img id="imagess" height="150" width="200" src="${imgUrl}"
			alt="Current Image" /><br></td>
		<td>
			<p>Tiêu đề: ${video.title}</p>
			<p>Mã Video: ${video.videoId }</p>
			<p>Category name: ${video.category.categoryName}</p>
			<p>View: ${video.views}</p>
			<p>Share(${video.countShare})</p>
			<p>Like(${video.countLike})</p>
		</td>
	</tr>

	<tr>
		<td colspan="2">
			<p>Description: ${video.description}</p>
		</td>
	</tr>
</table>