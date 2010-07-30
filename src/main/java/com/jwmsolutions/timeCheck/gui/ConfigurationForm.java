/*
 * ConfigurationForm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.jwmsolutions.timeCheck.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import com.jwmsolutions.timeCheck.CoreObject;
import com.jwmsolutions.timeCheck.business.BasecampBusiness;
import com.jwmsolutions.timeCheck.business.ConfigurationBusiness;
import com.jwmsolutions.timeCheck.model.BasecampPerson;
import com.jwmsolutions.timeCheck.model.Profile;
import com.jwmsolutions.timeCheck.util.Constants;
import com.jwmsolutions.timeCheck.util.RefreshListsScheduler;
import com.jwmsolutions.timeCheck.util.ReminderScheduler;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 *
 * @author  __USER__
 */
public class ConfigurationForm extends javax.swing.JDialog {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/** Creates new form ConfigurationForm */
	public ConfigurationForm(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		initialize();
	}

	private void initialize() {
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension screenSize = tk.getScreenSize();
	    int screenHeight = screenSize.height;
	    int screenWidth = screenSize.width;
	    setLocation(screenWidth-getSize().width - 20, screenHeight-getSize().height -60);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

		jPasswordField1 = new javax.swing.JPasswordField();
		GroupLayout layout = new GroupLayout((JComponent)getContentPane());
		getContentPane().setLayout(layout);
		{
			jpnlWindow = new JPanel();
		}
		jPanel2 = new javax.swing.JPanel();
		GroupLayout jPanel2Layout = new GroupLayout((JComponent)jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		layout.setVerticalGroup(layout.createSequentialGroup()
				.add(jPanel2, 0, 253, Short.MAX_VALUE));
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.add(jPanel2, 0, 270, Short.MAX_VALUE));
		jPanel1 = new javax.swing.JPanel();
		jchkAutoLogin = new javax.swing.JCheckBox();
		jchkRemPassword = new javax.swing.JCheckBox();
		jchkRemAccount = new javax.swing.JCheckBox();

		jPasswordField1.setText("jPasswordField1");

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings
		.createAutoBinding(
				org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE,
				jtfUsername, org.jdesktop.beansbinding.ObjectProperty
				.create(), jlblUsername,
				org.jdesktop.beansbinding.BeanProperty
				.create("labelFor"));
		bindingGroup.addBinding(binding);

		binding = org.jdesktop.beansbinding.Bindings
		.createAutoBinding(
				org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE,
				jpfPassword, org.jdesktop.beansbinding.ObjectProperty
				.create(), jlblPassword,
				org.jdesktop.beansbinding.BeanProperty
				.create("labelFor"));
		bindingGroup.addBinding(binding);

		binding = org.jdesktop.beansbinding.Bindings
		.createAutoBinding(
				org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE,
				jtfBasecampUrl,
				org.jdesktop.beansbinding.ObjectProperty.create(),
				jlblBasecampUrl, org.jdesktop.beansbinding.BeanProperty
				.create("labelFor"));
		bindingGroup.addBinding(binding);

		jchkAutoLogin.setText("Automatic Sign-In");
		jchkAutoLogin.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		{
			jlblInterval = new JLabel();
			jlblInterval.setText("Reminder time interval");
		}
		{
			jtxtInterval = new JTextField();
			jtxtInterval.setText("60");
		}
		{
			min = new JLabel();
			min.setText("min");
		}
		jchkAutoLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jchkAutoLoginActionPerformed(evt);
			}
		});

		jchkRemPassword.setText("Remember my password");
		jchkRemPassword.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		jchkRemPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jchkRemPasswordActionPerformed(evt);
			}
		});

		jchkRemAccount.setText("Remember account");
		jchkRemAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jchkRemAccountActionPerformed(evt);
			}
		});

		org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
			.addContainerGap()
			.add(jchkRemAccount, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.RELATED)
			.add(jchkRemPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.RELATED)
			.add(jchkAutoLogin, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.RELATED)
			.add(jPanel1Layout.createParallelGroup(GroupLayout.BASELINE)
			    .add(GroupLayout.BASELINE, jtxtInterval, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .add(GroupLayout.BASELINE, jlblInterval, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .add(GroupLayout.BASELINE, min, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
			.addContainerGap());
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
			.addContainerGap()
			.add(jPanel1Layout.createParallelGroup()
			    .add(GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
			        .add(0, 0, Short.MAX_VALUE)
			        .add(jlblInterval, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
			        .add(jtxtInterval, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
			    .add(GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
			        .add(jchkRemAccount, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
			        .add(0, 6, Short.MAX_VALUE))
			    .add(GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
			        .add(jchkRemPassword, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
			        .add(0, 6, Short.MAX_VALUE))
			    .add(GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
			        .add(jchkAutoLogin, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
			        .add(0, 6, Short.MAX_VALUE)))
			.addPreferredGap(LayoutStyle.RELATED)
			.add(min, 0, 32, Short.MAX_VALUE)
			.addContainerGap(14, 14));
		jPanel1.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		{
			jbtnLogin = new javax.swing.JButton();
			jbtnLogin.setText("Login");
			jbtnLogin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jbtnLoginActionPerformed(evt);
				}
			});
		}
		{
			jLabel4 = new javax.swing.JLabel();
			jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel4.setText("TimeCheck");
			jLabel4.setFont(new java.awt.Font("Tahoma",1,14));
		}
		{
			jPanel3 = new JPanel();
			GroupLayout jPanel3Layout = new GroupLayout((JComponent)jPanel3);
			jPanel3.setLayout(jPanel3Layout);
			{
				jlblUsername = new javax.swing.JLabel();
				jlblUsername.setText("Username");
			}
			{
				jtfUsername = new javax.swing.JTextField();
				jtfUsername.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				jpfPassword = new javax.swing.JPasswordField();
				jpfPassword.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				jlblPassword = new javax.swing.JLabel();
				jlblPassword.setText("Password");
			}
			{
				jtfBasecampUrl = new javax.swing.JTextField();
				jtfBasecampUrl.setEnabled(false);
				jtfBasecampUrl.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				jlblBasecampUrl = new javax.swing.JLabel();
				jlblBasecampUrl.setText("Basecamp URL");
			}
			jPanel3Layout.setHorizontalGroup(jPanel3Layout.createSequentialGroup()
					.addContainerGap()
					.add(jPanel3Layout.createParallelGroup()
							.add(GroupLayout.LEADING, jPanel3Layout.createSequentialGroup()
									.add(jlblUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
									.add(22))
									.add(GroupLayout.LEADING, jPanel3Layout.createSequentialGroup()
											.add(jlblPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
											.add(24))
											.add(GroupLayout.LEADING, jlblBasecampUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(LayoutStyle.RELATED)
											.add(jPanel3Layout.createParallelGroup()
													.add(GroupLayout.LEADING, jtfUsername, 0, 172, Short.MAX_VALUE)
													.add(GroupLayout.LEADING, jpfPassword, 0, 172, Short.MAX_VALUE)
													.add(GroupLayout.LEADING, jtfBasecampUrl, 0, 172, Short.MAX_VALUE))
													.addContainerGap());
			jPanel3Layout.setVerticalGroup(jPanel3Layout.createSequentialGroup()
					.addContainerGap()
					.add(jPanel3Layout.createParallelGroup(GroupLayout.BASELINE)
							.add(GroupLayout.BASELINE, jtfUsername, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.add(GroupLayout.BASELINE, jlblUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(jPanel3Layout.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE, jpfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE, jlblPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(LayoutStyle.RELATED)
									.add(jPanel3Layout.createParallelGroup(GroupLayout.BASELINE)
											.add(GroupLayout.BASELINE, jtfBasecampUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
											.add(GroupLayout.BASELINE, jlblBasecampUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
											.addContainerGap());
		}
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createSequentialGroup()
			.add(jLabel4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
			.add(jPanel3, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
			.add(jPanel1, 0, 113, Short.MAX_VALUE)
			.addPreferredGap(LayoutStyle.RELATED)
			.add(jbtnLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			.addContainerGap());
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup()
			.add(GroupLayout.LEADING, jPanel2Layout.createParallelGroup()
			    .add(GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
			        .add(jLabel4, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
			        .add(0, 6, Short.MAX_VALUE))
			    .add(GroupLayout.LEADING, jPanel3, 0, 272, Short.MAX_VALUE))
			.add(jPanel2Layout.createSequentialGroup()
			    .add(25)
			    .add(jPanel2Layout.createParallelGroup()
			        .add(GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
			            .add(jPanel1, 0, 221, Short.MAX_VALUE)
			            .add(16))
			        .add(GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
			            .add(0, 178, Short.MAX_VALUE)
			            .add(jbtnLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
			    .addContainerGap()));

		this.setResizable(false);
		this.setDefaultLookAndFeelDecorated(true);

		bindingGroup.bind();

		pack();
		this.setSize(278, 294);
	}// </editor-fold>
	//GEN-END:initComponents

	private void jbtnLoginActionPerformed(java.awt.event.ActionEvent evt) {
		String username = jtfUsername.getText();
		String password = new String(jpfPassword.getPassword());
		String basecampUrl = jtfBasecampUrl.getText();
		boolean storeAccount = jchkRemAccount.isSelected();
		boolean storePassword = jchkRemPassword.isSelected();
		boolean isAutoLogin = jchkAutoLogin.isSelected();

		ConfigurationBusiness.saveConfiguration(username, password, basecampUrl, storeAccount, storePassword, isAutoLogin);
		//		ConfigurationBusiness.loadStoredProfile();

		if(CoreObject.testConnection()) {
			CoreObject.loadProjectMap(null);
			this.setVisible(false);
			CoreObject.getTodoForm().setVisible(true);

			Long interval = Long.valueOf(jtxtInterval.getText());
			long intervalInMiliseconds = Math.abs(interval.longValue()) * 60 * 1000;
			CoreObject.getConfig().setProperty(Constants.QUARTZ_REMINDER_REPEAT_INTERVAL, intervalInMiliseconds);

			BasecampPerson person = BasecampBusiness.getCurrentPerson();
			CoreObject.getCurrentProfile().setBasecampAccountId(person.getId());

			ReminderScheduler reminderScheduler = new ReminderScheduler();
			reminderScheduler.startScheduler();

			RefreshListsScheduler refreshScheduler = new RefreshListsScheduler();
			refreshScheduler.startScheduler();

			jbtnLogin.setEnabled(false);
		} else {
			String message = "Connection failed. \nYour username and password are correct?";
			String title = "Connection failed";
			int messageType = JOptionPane.WARNING_MESSAGE;
			JOptionPane.showMessageDialog(this, message, title, messageType);
		}
	}

	public void showForm() {
		Profile p = CoreObject.getCurrentProfile();
		this.jtfBasecampUrl.setText(p.getBasecampUrl());
		if(p.isRememberAccount()) {
			this.jtfUsername.setText(p.getUsername());
			this.jchkRemAccount.setSelected(true);
		}
		if(p.isRememberPassword()) {
			this.jpfPassword.setText(p.getPassword());
			this.jchkRemPassword.setSelected(true);
		}
		if(p.isAutoLogin()) {
			this.jtfUsername.setText(p.getUsername());
			this.jpfPassword.setText(p.getPassword());
			this.jchkAutoLogin.setSelected(true);
			this.setVisible(false);
			this.jbtnLogin.doClick();
		} else {
			this.setVisible(true);
		}
	}

	private void jchkRemAccountActionPerformed(ActionEvent evt) {
		System.out.println("jchkRemAccount.actionPerformed, event="+evt);
		if(!jchkRemAccount.isSelected()) {
			jchkRemPassword.setSelected(false);
			jchkAutoLogin.setSelected(false);
		}
	}

	private void jchkRemPasswordActionPerformed(ActionEvent evt) {
		System.out.println("jchkRemPassword.actionPerformed, event="+evt);
		if(jchkRemPassword.isSelected()) {
			jchkRemAccount.setSelected(true);
		} else {
			jchkAutoLogin.setSelected(false);
		}
	}

	private void jchkAutoLoginActionPerformed(ActionEvent evt) {
		System.out.println("jchkAutoLogin.actionPerformed, event="+evt);
		if(jchkAutoLogin.isSelected()) {
			jchkRemAccount.setSelected(true);
			jchkRemPassword.setSelected(true);
		}
	}

	/**
	 * @param args the command line arguments
	 */
	//	public static void main(String args[]) {
	//		java.awt.EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				ConfigurationForm dialog = new ConfigurationForm(
	//						new javax.swing.JFrame(), true);
	//				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
	//					public void windowClosing(java.awt.event.WindowEvent e) {
	//						System.exit(0);
	//					}
	//				});
	//				dialog.setVisible(true);
	//			}
	//		});
	//	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel4;
	private JLabel min;
	private JTextField jtxtInterval;
	private JLabel jlblInterval;
	private JPanel jPanel3;
	private JPanel jpnlWindow;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JButton jbtnLogin;
	private javax.swing.JCheckBox jchkAutoLogin;
	private javax.swing.JCheckBox jchkRemAccount;
	private javax.swing.JCheckBox jchkRemPassword;
	private javax.swing.JLabel jlblBasecampUrl;
	private javax.swing.JLabel jlblPassword;
	private javax.swing.JLabel jlblUsername;
	private javax.swing.JPasswordField jpfPassword;
	private javax.swing.JTextField jtfBasecampUrl;
	private javax.swing.JTextField jtfUsername;
	private org.jdesktop.beansbinding.BindingGroup bindingGroup;
	// End of variables declaration//GEN-END:variables

}