package com.mypt.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.CboardDao;
import com.mypt.dao.QboardDao;
import com.mypt.dto.CboardDto;
import com.mypt.dto.QboardDto;

public class WriteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String board = session.getAttribute("board").toString();
		//커뮤니티 write
		if(board.equals("cboard")) {
			CboardDto dto = new CboardDto();
			System.out.println(request.getParameter("writeHead"));
			dto.setHead(request.getParameter("writeHead"));			
				
			dto.setWriter(session.getAttribute("nick").toString());
//			if(dto.getWriter()==""|dto.getWriter()==null) {
//				dto.setWriter("길동이"); 
//			}
			
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			
			CboardDao dao = CboardDao.getInstance();
			dao.insertBoard(dto);
			
			
			return "redirect:moveCommunity.do";
			
			// 다른 게시판 write
		}else if(board.equals("qboard")) {
			QboardDto dto = new QboardDto();				
				
			dto.setWriter(session.getAttribute("nick").toString());
//			if(dto.getWriter()==""|dto.getWriter()==null) {
//				dto.setWriter("길동이");
//			}
			
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			
			QboardDao dao = QboardDao.getInstance();
			dao.insertBoard(dto);			
			
			return "redirect:moveQuestion.do";
		}else {
			return null;
		}
	}

}
