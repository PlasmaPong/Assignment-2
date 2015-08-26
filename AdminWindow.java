package assignment2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTree;

import java.awt.GridBagConstraints;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class AdminWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField usrTextField = new JTextField();
	private static JTextField grpTextField = new JTextField();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AdminWindow(DefaultMutableTreeNode rootNode) {
		// TODO Auto-generated constructor stub

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		final JTree tree = new JTree(rootNode);

		JButton addUsrButton = new JButton("Add User");
		addUsrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwtAdmin.getInstance().addUser(usrTextField.getText(), tree);
			}
		});
		JButton addGrpButton = new JButton("Add Group");
		addGrpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwtAdmin.getInstance().addGroup("@"+(grpTextField.getText()), tree);

			}
		});
		usrTextField.setColumns(10);
		grpTextField.setColumns(10);
		JButton usrViewButton = new JButton("Open User View");
		usrViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwtUser temp = (TwtUser)tree.getLastSelectedPathComponent();
				if(temp != null){
					TwtAdmin.getInstance().viewUserWindow(temp);
				}
			}
		});

		JButton usrTotButton = new JButton("User Total");
		usrTotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visitor visitor = new UserTotalVisitor();
				System.out.println(TwtAdmin.getInstance().getTotal(visitor)-1);

			}
		});

		JButton grpTotButton = new JButton("Group Total");
		grpTotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visitor visitor = new GroupTotalVisitor();
				System.out.println( TwtAdmin.getInstance().getTotal(visitor)-1);

			}
		});

		JButton msgTotButton = new JButton("Message Total");
		msgTotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visitor visitor = new GroupTotalVisitor();
				System.out.println( TwtAdmin.getInstance().getTotal(visitor)-1);

			}
		});

		JButton posPercButton = new JButton("Positive Percentage");
		posPercButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(TwtAdmin.getInstance().getPercentPositive());
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(tree, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(usrTextField, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
																.addComponent(grpTextField, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																		.addComponent(addUsrButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
																		.addComponent(addGrpButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
																		.addComponent(usrViewButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
																		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
																				.addGap(10)
																				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
																						.addGroup(gl_contentPane.createSequentialGroup()
																								.addComponent(msgTotButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																								.addComponent(posPercButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
																								.addGroup(gl_contentPane.createSequentialGroup()
																										.addComponent(usrTotButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
																										.addGap(40)
																										.addComponent(grpTotButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))))
																										.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tree, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(11)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(usrTextField, Alignment.LEADING)
								.addComponent(addUsrButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(addGrpButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
										.addComponent(grpTextField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(usrViewButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addGap(38)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(grpTotButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
												.addComponent(usrTotButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(msgTotButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
														.addComponent(posPercButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
														.addGap(30))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
