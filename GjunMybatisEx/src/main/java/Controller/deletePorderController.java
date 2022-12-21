package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.porder.implPorder;

public class deletePorderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public deletePorderController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int ID = Integer.parseInt(request.getParameter("id"));
		new implPorder().delete(ID);
		
		response.sendRedirect("porder/delete.jsp");
	}

}
