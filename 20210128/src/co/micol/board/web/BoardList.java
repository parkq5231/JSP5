package co.micol.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class BoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 쿼리해와야함
		BoardDao dao = new BoardDao();
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();

		list = dao.selectList();
		request.setAttribute("list", list);

		return "views/board/boardList.jsp";
	}

}
