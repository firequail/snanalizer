package snanalizer.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 2684507539088661637L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		String fileName = request.getParameter("fileName");

		try {
			List<FileItem> items = upload.parseRequest(request);

			for (FileItem item : items) {
				if (item.getName() != null) {
					byte[] data = item.get();
					FileOutputStream fileOutSt;
					try {
						fileOutSt = new FileOutputStream(request.getSession()
								.getServletContext().getRealPath("")
								+ "/resourcespics/" + fileName + ".jpg");
					} catch (FileNotFoundException e) {
						fileOutSt = new FileOutputStream(request.getSession()
								.getServletContext().getRealPath("")
								+ "/sna/resourcespics/" + fileName + ".jpg");
					}
					fileOutSt.write(data);
					fileOutSt.close();
				}
			}

		} catch (FileUploadException e) {
			throw new ServletException(e);
		}
	}
}
