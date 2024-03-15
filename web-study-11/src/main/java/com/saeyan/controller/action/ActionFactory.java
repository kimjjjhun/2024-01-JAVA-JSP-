package com.saeyan.controller.action;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
							//Board_list
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory :" + command);
		
		//조건식 나열 --> Action 구현 클래스
		
		//command=board_list
		if(command.equals("board_list")) {
			action = new BoardListAction();
		//command=board_write_form
		}else if(command.equals("board_write_form")) {
			action = new BoardWriteActionForm();
		//command=board_write
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}
		
		return action;
	}
}
