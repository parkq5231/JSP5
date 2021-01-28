package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class BoardDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 삭제
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		// HTML에서 넘어오니 String이였던 것
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		int n = dao.delete(vo);
		String viewPage = "boardList.do";

		if (n == 0) {
			viewPage = "views/board/boardDeleteFail.jsp";
		}
		return viewPage;
	}

}
