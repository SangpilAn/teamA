package com.mypt.dto;

import java.sql.Timestamp;

public class CommentDto {
	private int  c_num, boardNum;
	private String c_nick, c_content;
	private Timestamp c_date;
	int c_ref;
	
	private Paging paging;
		
	public CommentDto() 
	{
		paging= new Paging();
	}
	
	public CommentDto(Paging paging) 
	{
		this.paging = paging;
	}
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public String getC_nick() {
		return c_nick;
	}
	public void setC_nick(String c_nick) {
		this.c_nick = c_nick;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public Timestamp getC_date() {
		return c_date;
	}
	public void setC_date(Timestamp c_date) {
		this.c_date = c_date;
	}
	public int getC_ref() {
		return c_ref;
	}
	public void setC_ref(int c_ref) {
		this.c_ref = c_ref;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
	
	
	
	

	
	

}
