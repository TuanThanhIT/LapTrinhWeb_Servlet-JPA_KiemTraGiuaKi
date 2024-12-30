package vn.iotstar.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Videos;
import vn.iotstar.services.ICategoryService_22110418;
import vn.iotstar.services.IFavoriteService_22110418;
import vn.iotstar.services.IShareService_22110418;
import vn.iotstar.services.IVideoService_22110418;
import vn.iotstar.services.impl.CategoryService_22110418;
import vn.iotstar.services.impl.FavoriteServiceImpl_22110418;
import vn.iotstar.services.impl.ShareServiceImpl_22110418;
import vn.iotstar.services.impl.VideoService_22110418;
import vn.iotstar.utils.Constant;


@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/videos", "/admin/video/edit", "/admin/video/update", "/admin/video/insert",
		"/admin/video/add", "/admin/video/delete", "/admin/video/detail", "/admin/video/category-video"})
public class VideoController_22110418 extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	IVideoService_22110418 videoService = new VideoService_22110418();
	ICategoryService_22110418 cateService = new CategoryService_22110418();
	IShareService_22110418 shareService = new ShareServiceImpl_22110418();
	IFavoriteService_22110418 favoriteService = new FavoriteServiceImpl_22110418();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = request.getRequestURI();
		if (url.contains("videos")) {
			int page = 1;
            int pageSize = 6;
            String pageParam = request.getParameter("page");
            if (pageParam != null) {
                page = Integer.parseInt(pageParam);
            }

            List<Videos> videos = videoService.findAll(page, pageSize);
            long totalVideos = videoService.getVideoCount();

            request.setAttribute("listvideo", videos);
            request.setAttribute("totalVideos", totalVideos);
            request.setAttribute("page", page);
            request.setAttribute("pageSize", pageSize);
			request.getRequestDispatcher("/views/admin/list-video_22110418.jsp").forward(request, response);
		} else if(url.contains("/admin/video/add")){
			List<Category> categories = cateService.findAll();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/views/admin/video-add_22110418.jsp").forward(request, response);
		}
		else if (url.contains("/admin/video/edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Videos video = videoService.findById(id);
			List<Category> categories = cateService.findAll();
			request.setAttribute("categories", categories);
			request.setAttribute("video", video);
			request.getRequestDispatcher("/views/admin/video-edit_22110418.jsp").forward(request, response);
		}else if (url.contains("/admin/video/delete")) {
			String id = request.getParameter("id");
			try {
				videoService.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath() + "/admin/videos");
		}
		else if(url.contains("detail"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			int countShare = shareService.CountShareVideo(id);
			int countLike = favoriteService.CountLikeVideo(id);
			Videos video = videoService.findById(id);
			video.setCountShare(countShare);
			video.setCountLike(countLike);
			request.setAttribute("video", video);
			request.getRequestDispatcher("/views/admin/video-detail_22110418.jsp").forward(request, response);
		}
		else if(url.contains("category-video"))
		{
			List<Category> listCate = cateService.findAllCategory();
			request.setAttribute("listcate", listCate);
			request.getRequestDispatcher("/views/admin/video-category_22110418.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String url = request.getRequestURI();

		if (url.contains("/admin/video/insert")) {
			Videos video = new Videos();
			String videotitle = request.getParameter("videotitle");
			String description = request.getParameter("description");
			String categoryId = request.getParameter("categoryId");
			String active = request.getParameter("status");
			String views = request.getParameter("videocount");

			// Gán giá trị cho đối tượng video
			video.setTitle(videotitle);
			video.setViews(0); // Chuyển đổi kiểu nếu cần
			video.setDescription(description);
			video.setActive(Boolean.parseBoolean(active));
			video.setViews(Integer.parseInt(views));
			Category category = cateService.findById(Integer.parseInt(categoryId));
			video.setCategory(category);
			String fname = "";
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = request.getPart("images");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// đổi tên file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					// up load file
					part.write(uploadPath + "/" + fname);
					// ghi tên file vào data
					video.setPoster(fname);
				} else {
					video.setPoster("avata.png");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Gọi phương thức insert
			videoService.insert(video);

			response.sendRedirect(request.getContextPath() + "/admin/videos");
		} else if (url.contains("/admin/video/update")) {
			int videoid = Integer.parseInt(request.getParameter("videoid"));
			Boolean status = Boolean.parseBoolean(request.getParameter("status"));
			Videos video = new Videos();
			video.setVideoId(videoid);
			String videotitle = request.getParameter("videotitle");
			video.setTitle(videotitle);
			String videocount = request.getParameter("videocount");
			video.setViews(Integer.parseInt(videocount));
			String description = request.getParameter("description");
			video.setDescription(description);
			
			String categoryId = request.getParameter("categoryId");
			Category category = cateService.findById(Integer.parseInt(categoryId));
			video.setCategory(category);
			
			video.setActive(status);
			// lưu hình cũ
			Videos cateold = videoService.findById(videoid);
			String fileold = cateold.getPoster();
			// xử lý image
			String fname = "";
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {

				Part part = request.getPart("images");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// đổi tên file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					// up load file
					part.write(uploadPath + "/" + fname);
					// ghi tên file vào data
					video.setPoster(fname);
				} else {
					video.setPoster(fileold);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			videoService.update(video);
			response.sendRedirect(request.getContextPath() + "/admin/videos");
		}
	}

}
