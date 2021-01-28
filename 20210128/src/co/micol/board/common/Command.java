package co.micol.board.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public String execute(HttpServletRequest request, HttpServletResponse response);

	// viewPage를 String으로 받아서 넘겨줘야해서 String으로 하는거
}
