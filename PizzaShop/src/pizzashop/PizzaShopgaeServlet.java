package pizzashop;

import java.io.*;
import java.util.*;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class PizzaShopgaeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,
			HttpServletResponse resp)
					throws IOException {
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		String param1 = req.getParameter("id");
		PrintWriter out = resp.getWriter();
		List<PizzaMain> list = null;		
		if (param1 == null || param1 =="") {
			String query = "select from " + PizzaMain.class.getName();
			try {
				list = (List<PizzaMain>)manager.newQuery(query).execute();
			} catch(JDOObjectNotFoundException e){}
		} else {
			try {
				PizzaMain data = (PizzaMain)manager.getObjectById(PizzaMain.class,Long.parseLong(param1));
				list = new ArrayList();
				list.add(data);
			} catch(JDOObjectNotFoundException e){}
		}
		String res = "[";
		if (list != null) {
			for(PizzaMain data:list){
				res += "{id:" + data.getId() + ",password:'" + data.getPassword() + "',name:'" +
						data.getName() + "',date:'" + data.getDatetime() +
						"',address:'" + data.getAddress() + "'},";
			}
		}		
		res += "]";
		out.println(res);
		manager.close();
	}
}