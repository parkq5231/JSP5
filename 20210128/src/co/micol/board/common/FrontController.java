package co.micol.board.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.web.BoardDelete;
import co.micol.board.web.BoardForm;
import co.micol.board.web.BoardInsert;
import co.micol.board.web.BoardList;
import co.micol.board.web.BoardUpdate;
import co.micol.board.web.BoardView;
import co.micol.board.web.MainCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// haspMap만들어주자
	private HashMap<String, Command> map = new HashMap<String, Command>();

	// value는 interface가 되는것
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); // 메인페이지
		map.put("/boardList.do", new BoardList()); // 게시글 목록
		map.put("/boardForm.do", new BoardForm()); // 글작성 폼
		map.put("/boardInsert.do", new BoardInsert());// Insert
		map.put("/boardView.do", new BoardView()); // 글상세보기
		map.put("/boardDelete.do", new BoardDelete());//글 삭제
		map.put("/boardUpdate.do",new BoardUpdate());//글 수정
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 실제적으로 처리되어야할 내용
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length()); // 실제 요청 (페이지)

		Command command = map.get(path); // 요청한 것을 처리하는 command를 찾아준다. map에 key값을 던져주는거
		String viewPage = command.execute(request, response); // 처리한 후 결과를 돌려줄 page값을 받음

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
