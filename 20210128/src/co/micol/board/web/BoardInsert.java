package co.micol.board.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;
import co.micol.board.dao.BoardDao;

public class BoardInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 등록

		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo.setbName(request.getParameter("bName"));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		vo.setbDate(Date.valueOf(request.getParameter("bDate")));

		int n = dao.insert(vo);
		String viewPage = "boardList.do";
		if (n == 0) {
			viewPage = "views/board/boardInsertFail.jsp";
		}

		return viewPage;
	}

}
