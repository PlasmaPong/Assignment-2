package assignment2;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class TwtUser extends Observable implements UserComponent, Observer, MutableTreeNode {

	private String id;
	private ArrayList<String> newsFeed = new ArrayList<String>();
	private ArrayList<String> followers = new ArrayList<String>();
	private ArrayList<String> following = new ArrayList<String>();
	private MutableTreeNode parent;
	
	public ArrayList<String> getFollowing() {
		return following;
	}
	public void setFollowing(ArrayList<String> following) {
		this.following = following;
	}
	public String getId() {
		return id;
	}
	public void setNewsFeed(ArrayList<String> newsFeed) {
		this.newsFeed = newsFeed;
	}
	
	
	public TwtUser(String idEntry){
		setId(idEntry);
	}
	@Override
	public void notifyObservers(Object arg0) {
		// TODO Auto-generated method stub
		super.notifyObservers((String)arg0);
	}
	public ArrayList<String> getNewsFeed() {
		return newsFeed;
	}
	public String getID() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void tweet(String string) {
		string = " - " +id+ ": " +string; 
		update(this, string);
		notifyObservers(string);
	}

	public void follow(TwtUser user) {
		following.add(user.getID());
		user.addObserver(this);
	}
	@Override
	public synchronized void addObserver(Observer arg0) {
		// TODO Auto-generated method stub
		followers.add(((TwtUser)arg0).getID());
		super.addObserver(arg0);
	}
	public int accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visitUser(this);
	}
	/*
	 * updates the newsfeed upon getting a tweet
	 * 
	 */
	
	public void update(Observable arg0, Object arg1) {
		newsFeed.add((((TwtUser)arg0).getID())+(String)arg1);
	}
    public int getChildCount() {
        return 0;
    }

    public TreeNode getParent() {
        return parent;
    }

    public int getIndex(TreeNode node) {
        return -1;
    }

    public boolean getAllowsChildren() {
        return false;
    }
    public boolean isLeaf() {
        return true;
    }
    public Enumeration children() {
        return null;
    }
    public void insert(MutableTreeNode child, int index) {
        throw new UnsupportedOperationException("This is a Leaf");
    }
    public void remove(int index) {
        throw new UnsupportedOperationException("This is a Leaf");
    }
    public void remove(MutableTreeNode node) {
        throw new UnsupportedOperationException("This is a Leaf");
    }
    public void setUserObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    public void removeFromParent() {
         throw new UnsupportedOperationException("Not supported yet."); 
        
    }
    public void setParent(MutableTreeNode newParent) {
        parent = newParent; 
    }
    public TreeNode getChildAt(int childIndex) {
        return null;
    }
    public String toString(){
    	return id;
    }
}