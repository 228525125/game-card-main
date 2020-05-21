package org.cx.game.card.exception;

import org.cx.game.tools.I18n;

public class LoginException extends DataException {

	public LoginException() {
		// TODO Auto-generated constructor stub
		super(I18n.getMessage("org.cx.game.dao.exception.LoginException"));
	}
	
	public LoginException(String description) {
		// TODO Auto-generated constructor stub
		super(I18n.getMessage(description));
	}
}
