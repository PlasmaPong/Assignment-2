package assignment2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class TwtAdmin {
	/*
	 * Administrator for the twitter system
	 * manages users and groups
	 * limited tweet analysis in addition to other user
	 * and group info analysis
	 */
	private DefaultMutableTreeNode root = new UserGroup("@root");
	private static TwtAdmin instance = null;
	//private ArrayList<UserGroup> userGroupList = new ArrayList<UserGroup>();
	private AdminWindow adminWindow;



	private TwtAdmin(){
		
	}
	public static TwtAdmin getInstance(){
		if(instance==null){
			instance = new TwtAdmin();
		}
		return instance;
	}
	/*
	 * window generation block
	 */

	/*
	 * method to apply the necessary visitor to retrieve the 
	 * information requested
	 */
	public int getTotal(Visitor visitor){
		return ((UserGroup) root).accept(visitor);
	}
	public double getPercentPositive(){
		MsgTotalVisitor msg = new MsgTotalVisitor();
		PositiveVisitor pos = new PositiveVisitor();
		int mTotal = ((UserGroup) root).accept(msg);
		int pTotal = ((UserGroup) root).accept(pos);
		double percent = pTotal/(double)mTotal;
		return percent;
	}
	public void addUser(String text, JTree tree) {
		// TODO Auto-generated method stub
		((UserGroup)tree.getLastSelectedPathComponent()).add((UserComponent)(new TwtUser(text)));
		
	}	
	public void addGroup(String string, JTree tree){
		/*((DefaultMutableTreeNode)findNode(((UserComponent)tree
				.getLastSelectedPathComponent()).getID())
				*/
				((UserGroup)tree.getLastSelectedPathComponent()).add((UserComponent)(new UserGroup(string)));
				
	}
	public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                adminWindow = new AdminWindow(root);
                adminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminWindow.setVisible(true);
            }
        });
    }
	public void viewUserWindow(UserComponent user) {
		final TwtUser tempUser = (TwtUser)user;
		final String[] folArray = ((TwtUser)user).getFollowing()
				.toArray(new String[((TwtUser)user).getFollowing().size()]);
		final String[] newsArray = ((TwtUser)user).getNewsFeed()
				.toArray(new String[((TwtUser)user).getNewsFeed().size()]);
		// TODO Auto-generated method stub
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                UserWindow userWindow = new UserWindow(folArray, newsArray, tempUser, root);
	                userWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                userWindow.setVisible(true);
	            }
	        });
	}
	public MutableTreeNode findNode(String targetID){//Useless now I think
		
		Enumeration en = root.breadthFirstEnumeration();
		MutableTreeNode temp = (MutableTreeNode)en.nextElement();
		while(en.hasMoreElements()){			
			if(((UserComponent)temp).getID().equals(targetID)){
				break;
			}
			temp = (MutableTreeNode)en.nextElement();

		}
		return temp;
		
	}
}
