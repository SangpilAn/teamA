package com.mypt.action.board.comment;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.CboardDao;
import com.mypt.dao.CommentDao;
import com.mypt.dto.CboardDto;
import com.mypt.dto.CommentDto;

public class CommentDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		HttpSession session = request.getSession();
		String board = session.getAttribute("board").toString();		
		
		int c_num= Integer.parseInt(request.getParameter("c_num"));
		CommentDao cdao = CommentDao.getInstance();
		
		int result = 0;
		
		if(board.equals("cboard")) 
		{		
			result= cdao.commentDelete("ccomment", c_num);			
		}
		request.setAttribute("result", result);
		
		return "callback";
	}

}
