package assignment2;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class UserGroup extends DefaultMutableTreeNode implements UserComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id = "";
	ArrayList<UserComponent> userCompList = new ArrayList<UserComponent>();
	
	/*
	 * constructor takes in an ID that has been deemed unique 
	 * before this was called
	 */
	public UserGroup(String idEntry){
		setId(idEntry);
	}
	
	public String getID() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<UserComponent> getUserCompList() {
		return userCompList;
	}
	public void setUserCompList(ArrayList<UserComponent> userCompList) {
		this.userCompList = userCompList;
	}

	public void follow(TwtUser user) {
		//UNUSED

	}

	public void tweet(String string) {
		//UNUSED
	}

	public void add(UserComponent comp) {
		// TODO Auto-generated method stub
		userCompList.add(comp);
		super.add((MutableTreeNode) comp);
	}
	public int accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visitGroup((UserGroup)this);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id;
	}


}
