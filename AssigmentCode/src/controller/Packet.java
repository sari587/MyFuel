package controller;

import java.io.Serializable;


public class Packet implements Serializable {
	public static enum actions {
		login,singup,massage
	};
	/**
	 * 
	 */
	private static final long serialVersionUID = 308370729595755759L;
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
