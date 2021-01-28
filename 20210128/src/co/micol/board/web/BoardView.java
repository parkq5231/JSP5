package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class BoardView implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 상세보기(DAO를 갔다와야함)
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo(); // 1개의 값을 가져올 땐 BoardVo가 필요함
		vo.setbId(Integer.parseInt(request.getParameter("bId")));// boardList.jsp참조
		vo = dao.select(vo);

		request.setAttribute("vo", vo);

		return "views/board/boardView.jsp";
	}

}
