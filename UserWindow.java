package assignment2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class UserWindow extends JFrame {

	private JPanel contentPane;
	private JTextField userEntry;
	//static String[] array1 = {"0","1","1","1","1","1","1","1"};
	//static String[] array2 = {"3","5"};
	private JPanel panel;
	private JList list;
	private JScrollPane scrollPane;
	private JTextField tweetContent;
	private JButton tweetButton;
	private JPanel panel_1;
	private JList list_1;
	private JScrollPane scrollPane_1;
	private  DefaultMutableTreeNode root;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param root 
	 */
	public UserWindow(String[] newsFeed, String[] following, final TwtUser thisUser, DefaultMutableTreeNode root) {
		this.root = root;
		setTitle(thisUser.getID());
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 370, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton followButton = new JButton("Follow User");
		followButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisUser.follow((TwtUser)findNode(userEntry.getText()));
				
			}
		});
		
		userEntry = new JTextField();
		userEntry.setText("user name here");
		userEntry.setColumns(10);
		
		panel = new JPanel();
		
		tweetContent = new JTextField();
		tweetContent.setText("Enter what you would like to say");
		tweetContent.setColumns(10);
		
		tweetButton = new JButton("Post Tweet");
		tweetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisUser.notifyObservers(tweetContent.getText());
				
			}
		});
		
		
		panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(userEntry, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(followButton, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tweetContent, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tweetButton, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(userEntry)
						.addComponent(followButton, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tweetButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tweetContent, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
		);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		list_1 = new JList(newsFeed);
		list_1.setToolTipText("Recent Tweets");
		scrollPane_1.setViewportView(list_1);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		list = new JList(following);
		list.setToolTipText("A list of people that you are following");
		scrollPane.setViewportView(list);
		contentPane.setLayout(gl_contentPane);
	}
	public MutableTreeNode findNode(String targetID){
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
