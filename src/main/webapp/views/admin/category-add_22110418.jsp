<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<form action="<c:url value='/admin/category/insert'></c:url>"
	method="post" enctype="multipart/form-data">
	<label for="fname">Category name:</label><br> 
	<input type="text" id="categoryname" name="categoryname"><br> 
	<label for="fname">Category code:</label><br> 
	<input type="text" id="categorycode" name="categorycode"><br> 
	<label for="lname">Images:</label><br> 
	<img height="150" width="200" src="" id="imagess" /><br>
	<input type="file" onchange="chooseFile(this)" id="images" name="images"><br>
	<label for="status">Status:</label><br> 
	<input type="radio" id="ston" name="status" value="1" checked>
	<label for="html">Đang hoạt động</label><br> 
	<input type="radio" id="stoff" name="status" value="0"> 
	<label for="css">Khóa</label><br>
	<input type="submit" value="insert">
</form>
<script>
        // Hàm JavaScript để hiển thị hình ảnh sau khi chọn
        function chooseFile(input) {
            var file = input.files[0];
            if (file) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    document.getElementById('imagess').src = e.target.result;
                }
                reader.readAsDataURL(file);
            }
        }
    </script>
