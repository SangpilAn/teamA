package com.mypt.controller;

import java.util.HashMap;
import java.util.Map;

import com.mypt.action.check.EmailCheckAction;
import com.mypt.action.check.NickCheckAction;
import com.mypt.action.inbody.UserInbodyResultAction;
import com.mypt.action.list.AdminTrainerListViewAction;
import com.mypt.action.list.AdminUserListViewAction;
import com.mypt.action.list.TrainerUserListViewAction;
import com.mypt.action.login.TrainerLoginAction;
import com.mypt.action.login.UserLoginAction;
import com.mypt.action.move.MoveInbody;
import com.mypt.action.move.MoveIntroAction;
import com.mypt.action.move.MoveUserList;
import com.mypt.action.move.MoveUserMain;
import com.mypt.action.move.MoveUserRegister;
import com.mypt.action.register.AdminUserRegisterAction;


public class ActionFactory 
{
	
	//싱글톤
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() 
	{
		return instance;
	}
	
	private ActionFactory()
	{

		//userList
		map.put("/userList", new AdminUserListViewAction());
		//trainerList
		map.put("/trainerList", new AdminTrainerListViewAction());
		//ptUserList
		map.put("/ptUserList", new TrainerUserListViewAction());
		
		// 인트로 화면
		map.put("/moveIntro", new MoveIntroAction());
		map.put("/moveInbody", new MoveInbody());
		//userLogin
		map.put("/userLogin", new UserLoginAction());
		map.put("/userMain", new MoveUserMain());
		map.put("/getInbodyResult", new UserInbodyResultAction());
		
		
		
		//trainerLogin
		map.put("/trainerLogin", new TrainerLoginAction());
		
		//회원가입
		map.put("/moveUserRegister", new MoveUserRegister());
		map.put("/moveUserList", new MoveUserList());

		map.put("/userInsertAction", new AdminUserRegisterAction());
		map.put("/nickCheck", new NickCheckAction());
		map.put("/emailCheck", new EmailCheckAction());
		
	}
	
	private Map<String, Action> map = new HashMap< >();	
	
	
	public Action getAction(String command)
	{
		Action action = null;
		
		action = map.get(command);
		
		return action;
	}
	
}
