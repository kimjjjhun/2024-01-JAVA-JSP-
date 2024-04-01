package com.ott.controller.action;


public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		System.out.println("command>>" + command);
		Action action = null;
		
		
		if(command.equals("bulletin_write_form")) {
			action = new BulletinInsertFormAction();
		}else if(command.equals("bulletin_write")) {
			action = new BulletinInsertAction();
		}else if(command.equals("bulletin_view")) {
			action = new BulletinViewAction();
		}else if(command.equals("bulletin_update_form")) {
			action = new BulletinUpdateFormAction();
		}else if(command.equals("bulletin_update")) {
			action = new BulletinUpdateAction();
		}else if(command.equals("bulletin_delete")) {
			action = new BulletinDeleteAction();
		}else if(command.equals("comment_Insert")) {
			action = new CommentInsertAction();
		}else  if (command.equals("admin_menu")) {
			action = new AdminMenu();
		} else if (command.equals("admin_member_info")) {
			action = new AdminMemberInfoAction();
		} else if (command.equals("admin_delete_member")) {
			action = new AdminDeleteMemberAction();
		} else if (command.equals("admin_content_info")) {
			action = new AdminContentInfoAction();
		} else if (command.equals("admin_insert_content_form")) {
			action = new AdminInsertContentFormAction();
		} else if (command.equals("admin_content_detail")) {
			action = new AdminContentDetailAction();
		} else if (command.equals("admin_delete_content")) {
			action = new AdminDeleteCotentAction();
		} else if (command.equals("admin_update_content_form")) {
			action = new AdminUpdateContentFormAction();
		} else if (command.equals("admin_delete_bulletin_form")) {
			action = new AdminDeleteBulletinFormAction();
		} else if (command.equals("admin_bulletin_detail")) {
			action = new AdminBulletinDetailAction();
		} else if (command.equals("admin_delete_bulletin")) {
			action = new AdminDeleteBulletinAction();
		} else if (command.equals("qna_list")) {
			action = new QnAListFormAction();
		} else if (command.equals("qna_detail")) {
			action = new QnADetailFormAction();
		} else if (command.equals("admin_qna_reply_form")) {
			action = new AdminQnAReplyFormAction();
		} else if (command.equals("admin_qna_reply")) {
			action = new AdminQnAReplyAction();
		} else if (command.equals("update_qna_form")) {
			action = new UpdateQnAFormAction();
		} else if (command.equals("update_qna")) {
			action = new UpdateQnAAction();
		}else if (command.equals("insert_qna_form")) {
			action = new InsertQnAFormAction();
		}else if (command.equals("insert_qna")) {
			action = new InsertQnAAction();
		}else if (command.equals("changeUser_InformationForm")) {
			action = new ChangeUserInformationFormAction();
		} else if (command.equals("update_member")) {
			action = new UpdateMemberAction();
		} else if (command.equals("BulletinList_View")) {
			action = new BulletinListViewFormAction();
		} else if (command.equals("bulletinWishList_View")) {
			action = new BulletinWishListFormAction();
		} else if (command.equals("delete_User")) {
			action = new DeleteMemberAction();
		} else if (command.equals("contentWishList_View")) {
			action = new ContentWishListFormAction();
		} else if (command.equals("bulletin_content_View")) {
			action = new SelectBulletinContentViewAction();
		} else if (command.equals("myBulletin_content_View")) {
			action = new SelectMyBulletinContentViewAction();
		} else if (command.equals("Bulletin_delete")) {
			action = new DeleteBulletinAction();
		} else if (command.equals("comment_Insert")) {
			action = new CommentInsertAction();
		} else if (command.equals("comment_Update_Form")) {
			action = new CommentUpdateFormAction();
		} else if (command.equals("comment_Delete")) {
			action = new CommentDeleteAction();
		} else if (command.equals("Bulletin_Update_Form")) {
			action = new BulletinUpdateFormAction();
		} else if (command.equals("bulletin_update")) {
			action = new BulletinUpdateAction();
		} else if (command.equals("comment_Update")) {
			action = new CommentUpdateAction();
		}else if(command.equals("serach_bulletin")) {
			action = new BulletinSearchAction();
		}else if(command.equals("logout_User")) {
			action = new LogoutAction();
		} else if(command.equals("member_login_form")) {
			action = new MemberLoginActionForm();
		}else if(command.equals("member_insert_form")) {
			action = new MemberInsertActionForm();
		}else if(command.equals("member_insert")) {
			action = new MemberInsertAction();
		}else if(command.equals("member_idcheck_form")) {
			action = new MemberIdcheckFormAction();
		}else if(command.equals("idCheck")) {
			action = new MemberIdcheckAction();
		}else if(command.equals("member_login")) {
			action = new MemberLoginAction();
		}else if(command.equals("member_findid_form")) {
			action = new MemberFindidFormAction();
		}else if(command.equals("member_findid")) {
			action = new MemberFindidAction();
		}else if(command.equals("member_findpw_form")) {
			action = new MemberFindpwFormAction();
		}else if(command.equals("member_findpw")) {
			action = new MemberFindpwAction();
		}else if(command.equals("member_findid_after_form")) {
			action = new MemberFindidAfterFormAction();
		}else if(command.equals("my_page")) {
			action = new MemberMyPageFormAction();
		}else if(command.equals("content_list")) {
			action = new ContentListFormAction();
		}else if(command.equals("insert_content_wish")) {
			action = new InsertContentWishAction();
		}else if(command.equals("delete_content_wish")) {
			action = new DeleteContentWishAction();
		}else if(command.equals("delete_qna")) {
	         action = new DeleteQnAAction();
	      }else if(command.equals("insert_bulletin_wish")) {
	    	  action = new InsertBulletinWishAction();
	      }else if(command.equals("delete_bulletin_wish")) {
	    	  action = new DeleteBulletinWishAction();
	    }
		return action;
	}
}
