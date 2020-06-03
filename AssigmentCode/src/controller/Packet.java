package controller;

import java.io.Serializable;


public class Packet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5059817243216020235L;
	public static enum actions {
		login,singup,massage
	};
	

	private actions action;
	private Object obj;
	
	public Packet(actions action , Object obj) {
		this.action=action;
		this.obj=obj;
	}
	public Object GetObj()
	{
		return obj;
	}
	public actions getActions() {
		return action;
	}
}
