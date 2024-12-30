<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

  <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 20px;
        }
        .form-container {
            max-width: 600px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #4CAF50;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"],
        input[type="file"],
        select,
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="radio"] {
            margin-right: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            margin-top: 10px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        #imagess {
            display: block;
            margin: 10px auto;
            max-width: 100%;
            height: auto;
        }
    </style>
    <div class="form-container">
        <h2>Add Video</h2>
        <form action="<c:url value='/admin/video/insert'></c:url>" method="post" enctype="multipart/form-data">
            <img height="150" width="200" src="" id="imagess" alt="Preview Image" /><br>
            <label for="images">Upload Video:</label>
            <input type="file" onchange="chooseFile(this)" id="images" name="images"><br>
            
            <label for="videoid">Video ID:</label>
            <input type="text" id="videoid" name="videoid"><br>
            
            <label for="videotitle">Video Title:</label>
            <input type="text" id="videotitle" name="videotitle"><br>
            
            <label for="videocount">Video Count:</label>
            <input type="text" id="videocount" name="videocount" value="0"><br>
            
            <label for="category">Category:</label>
            <select id="category" name="categoryId">
                <c:forEach items="${categories}" var="category">
                    <option value="${category.categoryId}">${category.categoryName}</option>
                </c:forEach>
            </select><br>
            
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4"></textarea><br>
            
            <label>Status:</label>
            <input type="radio" id="ston" name="status" value= "1" checked>
            <label for="ston">Đang hoạt động</label>
            <input type="radio" id="stoff" name="status" value= "0"> 
            <label for="stoff">Khóa</label><br>
            
            <input type="submit" value="Create">
        </form>
    </div>

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