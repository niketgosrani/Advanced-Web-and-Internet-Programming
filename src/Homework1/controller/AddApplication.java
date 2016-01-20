package Homework1.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Homework1.model.CSGradAdmission;

@WebServlet("/AddApplication")
public class AddApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int idSeed = 103;

	public AddApplication() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher(
				"/WEB-INF/Homework1/view/AddApplication.jsp")
				.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String status = request.getParameter("isStatus");
		String dateStr = request.getParameter("date");

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		try {

			Date date = formatter.parse(dateStr);
			System.out.println(date);
			System.out.println(formatter.format(date));

			List<CSGradAdmission> entries = (List<CSGradAdmission>) getServletContext()
					.getAttribute("entries");
			if (request.getParameter("gpa").isEmpty()) {
				entries.add(new CSGradAdmission(idSeed++, name,
						formatter.parse(dateStr), null, status));
			} else {
				Double gpa = Double.parseDouble(request.getParameter("gpa"));
				entries.add(new CSGradAdmission(idSeed++, name,
						formatter.parse(dateStr), gpa, status));
			}
			
			String sort = request.getParameter("sort");
			if (sort != null) {
				if (sort.equals("date")) {
					Collections.sort(entries, Collections.reverseOrder(new sortDate()));
				}
			}
			
			getServletContext().setAttribute("entries", entries);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		response.sendRedirect("CSGradApply");
	}

}
