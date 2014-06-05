package pizzashop;

import java.io.IOException;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DelAccountServlet extends HttpServlet {
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
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		PizzaMain data = (PizzaMain)manager.getObjectById(PizzaMain.class,id);
		manager.deletePersistent(data);
		manager.close();
		resp.sendRedirect("/index_account.html");
	}
}