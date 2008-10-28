package snanalizer.services;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class DownloadXlsServlet extends HttpServlet {

	private static final long serialVersionUID = -7855490174498240517L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doDownload(request, response);

	}

	private void doDownload(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		ServletOutputStream op = resp.getOutputStream();
		ServletContext context = getServletConfig().getServletContext();

		int redId = Integer.parseInt(req.getParameter("red"));
		String filename = req.getParameter("filename");

		getExcelExporter().export(redId, op);

		String mimetype = context.getMimeType(filename);
		resp.setContentType((mimetype != null) ? mimetype
				: "application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment; filename=\""
				+ filename + "\"");

		op.flush();
	}

	private ExcelExporter getExcelExporter() {
		ApplicationContext beans = WebApplicationContextUtils
				.getWebApplicationContext(getServletConfig()
						.getServletContext());
		return (ExcelExporter) beans.getBean("excelExporter");
	}

}
