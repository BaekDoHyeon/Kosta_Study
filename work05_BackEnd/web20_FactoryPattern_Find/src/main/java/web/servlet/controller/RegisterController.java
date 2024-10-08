package web.servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

/*
 * Component란?
 * 인터페이스 기반으로 작성된 재사용성 강한 자바 클래스
 * 폼값 받아서
 * DAO 리턴받고 비지니스 로직 호출... 데이터 반환
 * 바인딩
 * 네비게이션
 */
public class RegisterController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		Member vo = null;
		if(name.equals("") && addr.equals(""))
			vo = new Member(id, pwd);
		else 
			vo = new Member(id, pwd, name, addr);
		
		String path = "index.html";
		
		try  	{
			if (vo != null) {
				MemberDAOImpl.getInstance().registerMember(vo);
				request.setAttribute("vo", vo);
				path = "register_result.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ModelAndView(path);
	}
}
