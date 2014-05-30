package pizzashop;

import java.io.IOException;
import java.util.*;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class EditAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp)
					throws ServletException, IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("no url...");
	}

	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp)
					throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		long id = Long.parseLong(req.getParameter("id"));
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		Main data = (Main)manager.getObjectById(Main.class,id);
		data.setName(name);
		data.setPassword(password);
		data.setAddress(address);
		manager.close();
		resp.sendRedirect("/index_account.html");
	}
}
