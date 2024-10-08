package web.servlet.http;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;

public class BookListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "error/error.jsp";
		
		try {
			ArrayList<Book> list = BookDAOImpl.getInstance().showAllBook();
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			path = "book/showBooks.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ModelAndView(path);
	}
}
