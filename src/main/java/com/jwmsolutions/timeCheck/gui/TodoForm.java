/*
 * TodoForm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.jwmsolutions.timeCheck.gui;

import info.clearthought.layout.TableLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import org.apache.commons.lang.StringUtils;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import com.jwmsolutions.timeCheck.CoreObject;
import com.jwmsolutions.timeCheck.business.BasecampBusiness;
import com.jwmsolutions.timeCheck.model.BasecampTimeEntry;
import com.jwmsolutions.timeCheck.model.BasecampTodoItem;
import com.jwmsolutions.timeCheck.util.Constants;
import com.toedter.calendar.JDateChooser;

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
public class TodoForm extends javax.swing.JDialog {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		}
	}


	/** Creates new form TodoForm */
	public TodoForm(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		myInitComponents();
	}

	private JDateChooser initDateChooser() {
		JDateChooser dateChooser = new JDateChooser();
		return dateChooser;
	}

	private void myInitComponents() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setLocation(screenWidth-getSize().width - 20, screenHeight-getSize().height -60);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		GroupLayout layout = new GroupLayout((JComponent)getContentPane());
		getContentPane().setLayout(layout);
		layout.setVerticalGroup(layout.createSequentialGroup()
				.add(getJpnlTime(), 0, 250, Short.MAX_VALUE)
				.addContainerGap());
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.add(getJpnlTime(), 0, 337, Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		pack();
		this.setSize(340, 288);
	}// </editor-fold>
	//GEN-END:initComponents

	private void jbtnReportActionPerformed(java.awt.event.ActionEvent evt) {
		Integer id = null;
		Integer projectId = Integer.valueOf(CoreObject.getWorkingProjectId());
		Calendar cal = jDateChooser_IL.getCalendar();
		SimpleDateFormat df = new SimpleDateFormat(CoreObject.getGlobalProperties().getProperty(Constants.DATE_FORMAT_DATE));
		String date = df.format(cal.getTime());
		String hours = jtfHours.getText();
		String todoDescription = (String)jcbTodos.getSelectedItem();
		BasecampTodoItem todoItem = CoreObject.getTodoMap().get(todoDescription);
		Integer todoItemId = todoItem.getId();
		Integer personId = CoreObject.getCurrentProfile().getBasecampAccountId();
		String description = jtfDescription.getText();
		BasecampTimeEntry entry = new BasecampTimeEntry(id, projectId, personId, date, hours, description, todoItemId);
		String statusCode = BasecampBusiness.createTimeEntry(todoItemId.toString(), entry);
		if(statusCode.trim().equals("200") || statusCode.trim().equals("201")) {
			jtfHours.setText("0");
			jDateChooser_IL.setDate(new Date());
			jtfDescription.setText("");
			lblMessages.setText("Time entry has been saved!");
		} else {
			String message = "Connection with Basecamp service failed! Got status code " + statusCode;
			String title = "Error";
			int messageType = JOptionPane.ERROR_MESSAGE;
			JOptionPane.showMessageDialog(this, message, title, messageType);
		}
	}

	private JPanel getJpnlDateChooser() {
		if(jpnlDateChooser == null) {
			jpnlDateChooser = new JPanel();
			FlowLayout jpnlDateChooserLayout = new FlowLayout();
			jpnlDateChooserLayout.setAlignment(FlowLayout.LEFT);
			jpnlDateChooser.setLayout(jpnlDateChooserLayout);
			jpnlDateChooser.add(getJDateChooser_IL());
			jpnlDateChooser.add(new JDateChooser(new Date()));
		}
		return jpnlDateChooser;
	}

	private JPanel getJpnlTime() {
		if(jpnlTime == null) {
			jpnlTime = new JPanel();
			GroupLayout jpnlTimeLayout = new GroupLayout((JComponent)jpnlTime);
			jpnlTime.setLayout(jpnlTimeLayout);
			jpnlTimeLayout.setHorizontalGroup(jpnlTimeLayout.createSequentialGroup()
					.addContainerGap()
					.add(jpnlTimeLayout.createParallelGroup()
							.add(GroupLayout.LEADING, getJPanel5(), 0, 312, Short.MAX_VALUE)
							.add(GroupLayout.LEADING, getJPanel4(), 0, 312, Short.MAX_VALUE)
							.add(GroupLayout.LEADING, getJPanel3(), 0, 312, Short.MAX_VALUE)
							.add(GroupLayout.LEADING, getJPanel2(), 0, 312, Short.MAX_VALUE))
							.addContainerGap());
			jpnlTimeLayout.setVerticalGroup(jpnlTimeLayout.createSequentialGroup()
					.add(getJPanel5(), GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.add(getJPanel4(), 0, 46, Short.MAX_VALUE)
					.add(19)
					.add(getJPanel3(), GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(getJPanel2(), GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE));
		}
		return jpnlTime;
	}

	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			FlowLayout jPanel1Layout = new FlowLayout();
			jPanel1Layout.setAlignment(FlowLayout.LEFT);
			jPanel1.setLayout(jPanel1Layout);
			{
				jLabel2 = new javax.swing.JLabel();
				jPanel1.add(jLabel2);
				jLabel2.setText("Time:");
			}
			{
				jtfHours = new javax.swing.JTextField();
				jPanel1.add(jtfHours);
				jtfHours.setText("0");
				jtfHours.setPreferredSize(new java.awt.Dimension(25, 21));
				jtfHours.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				jLabel3 = new javax.swing.JLabel();
				jPanel1.add(jLabel3);
				jLabel3.setText("hours");
			}
		}
		return jPanel1;
	}

	private JTextArea getJtfDescription() {
		if(jtfDescription == null) {
			jtfDescription = new JTextArea();
			jtfDescription.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		}
		return jtfDescription;
	}

	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			TableLayout jPanel2Layout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}, {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}});
			jPanel2.setLayout(jPanel2Layout);
			jPanel2.add(getJtfDescription(), "0, 1, 2, 2");
			{
				jbtnReport = new javax.swing.JButton();
				jPanel2.add(jbtnReport, "3, 1");
				jPanel2.add(getJlblDescription(), "0,0,f,b");
				jbtnReport.setText("Report");
				jbtnReport.setFont(new java.awt.Font("Tahoma",1,11));
				jbtnReport.addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jbtnReportActionPerformed(evt);
					}
				});
			}
			jPanel2Layout.setHGap(5);
			jPanel2Layout.setVGap(5);
		}
		return jPanel2;
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jbtnReport;
	private JPanel jpnlTime;
	private JPanel jpnlDateChooser;
	private javax.swing.JComboBox jcbTodos;
	private javax.swing.JLabel jlblCurrentTime;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private JLabel jlblDescription;
	private JLabel jlblTodoList;
	private JButton jbtnRefresh;
	private JLabel lblMessages;
	private JComboBox jcbLists;
	private JLabel lblLists;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JDateChooser jDateChooser_IL;
	private JPanel jPanel3;
	private JPanel jPanel1;
	private JCheckBox jchkCompleted;
	private JPanel jPanel2;
	private JTextArea jtfDescription;
	private javax.swing.JTextField jtfHours;
	// End of variables declaration//GEN-END:variables

	public void addItemToCombo(String key) {
		this.jcbTodos.addItem(key);
	}

	public void clearTodosCombo() {
		this.jcbTodos.removeAllItems();
	}

	public void clearTodoListsCombo() {
		this.jcbLists.removeAllItems();
	}

	private JCheckBox getJchkCompleted() {
		if(jchkCompleted == null) {
			jchkCompleted = new JCheckBox();
			jchkCompleted.setText("Completed");
			jchkCompleted.setHorizontalAlignment(SwingConstants.RIGHT);
			jchkCompleted.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jchkCompletedActionPerformed(evt);
				}
			});
		}
		return jchkCompleted;
	}

	private JPanel getJPanel3() {
		if(jPanel3 == null) {
			jPanel3 = new JPanel();
			TableLayout jPanel3Layout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}, {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}});
			jPanel3Layout.setHGap(5);
			jPanel3Layout.setVGap(5);
			jPanel3.setLayout(jPanel3Layout);
			jPanel3.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			jPanel3.add(getJPanel1(), "0, 5, 1, 8, l, f");
			{
				jlblCurrentTime = new javax.swing.JLabel();
				jPanel3.add(jlblCurrentTime, "0, 0, 1, 1");
				jPanel3.add(getJpnlDateChooser(), "0, 0, 1, 4");
				jPanel3.add(getJchkCompleted(), "3, 0, 4, 2");
				jPanel3.add(getLblMessages(), "2, 6, 4, 8");
				jlblCurrentTime.setFont(new java.awt.Font("Tahoma", 1, 14));
				jlblCurrentTime.setVerticalAlignment(SwingConstants.TOP);
				jlblCurrentTime.setVisible(false);
			}
		}
		return jPanel3;
	}

	private JDateChooser getJDateChooser_IL() {
		if(jDateChooser_IL == null) {
			jDateChooser_IL = new JDateChooser(new Date());
			jDateChooser_IL.setPreferredSize(new java.awt.Dimension(97, 20));
			jDateChooser_IL.setDateFormatString(CoreObject.getGlobalProperties().getProperty(Constants.DATE_FORMAT_DATELONG));
		}
		return jDateChooser_IL;
	}

	private void jchkCompletedActionPerformed(ActionEvent evt) {
		String todoName = (String)jcbTodos.getSelectedItem();
		boolean isCompletedTodo = StringUtils.containsIgnoreCase(todoName, CoreObject.getConfig().getString(Constants.CONFIG_COMPLETED_ITEM_TAG));
		if(jchkCompleted.isSelected() && !isCompletedTodo) {
			String message = "This to-do item will be marked as completed. Are you sure to continue?";
			String title = "Complete To-Do Item";
			int optionType = JOptionPane.YES_NO_OPTION;
			int messageType = JOptionPane.QUESTION_MESSAGE;
			int selectedOption = JOptionPane.showOptionDialog(this, message, title, optionType, messageType, null, null, null);
			if(selectedOption == JOptionPane.YES_OPTION) {
				String todoDescription = (String)jcbTodos.getSelectedItem();
				BasecampTodoItem todoItem = CoreObject.getTodoMap().get(todoDescription);
				Integer todoItemId = todoItem.getId();
				String statusCode = BasecampBusiness.completeTodoItem(todoItemId.toString());
				if(statusCode.trim().equals("200") || statusCode.trim().equals("201")) {
					jtfHours.setText("0");
					jDateChooser_IL.setDate(new Date());
					jchkCompleted.setSelected(false);
					jtfDescription.setText("");
					CoreObject.reloadTodoMap();
					lblMessages.setText("ToDo has been completed!");
				} else {
					lblMessages.setText("Failed! Status: " + statusCode);
				}

			} else {
				jchkCompleted.setSelected(false);
			}
		} else {
			if(isCompletedTodo) {
				String message = "This to-do item will be marked as uncompleted. Are you sure to activate the item?";
				String title = "Activate To-Do Item";
				int optionType = JOptionPane.YES_NO_OPTION;
				int messageType = JOptionPane.QUESTION_MESSAGE;
				int selectedOption = JOptionPane.showOptionDialog(this, message, title, optionType, messageType, null, null, null);
				if(selectedOption == JOptionPane.YES_OPTION) {
					String todoDescription = (String)jcbTodos.getSelectedItem();
					BasecampTodoItem todoItem = CoreObject.getTodoMap().get(todoDescription);
					Integer todoItemId = todoItem.getId();
					String statusCode = BasecampBusiness.uncompleteTodoItem(todoItemId.toString());
					if(statusCode.trim().equals("200") || statusCode.trim().equals("201")) {
						jtfHours.setText("0");
						jDateChooser_IL.setDate(new Date());
						jchkCompleted.setSelected(false);
						jtfDescription.setText("");
						CoreObject.reloadTodoMap();
						lblMessages.setText("ToDo is now active!");
					} else {
						lblMessages.setText("Failed! Status: " + statusCode);
					}
				} else {
					jchkCompleted.setSelected(true);
				}
			}
		}
	}

	private void jcbTodosItemStateChanged(ItemEvent evt) {
		String todoName = (String)jcbTodos.getSelectedItem();
		boolean isCompletedTodo = StringUtils.containsIgnoreCase(todoName, CoreObject.getConfig().getString(Constants.CONFIG_COMPLETED_ITEM_TAG));
		jchkCompleted.setSelected(isCompletedTodo);
	}

	private JPanel getJPanel4() {
		if(jPanel4 == null) {
			jPanel4 = new JPanel();
			TableLayout jPanel4Layout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}, {TableLayout.FILL, TableLayout.FILL}});
			jPanel4Layout.setHGap(5);
			jPanel4Layout.setVGap(5);
			jPanel4.setLayout(jPanel4Layout);
			{
				jcbTodos = new javax.swing.JComboBox();
				jPanel4.add(jcbTodos, "0,1,3,1,f,f");
				jPanel4.add(getJlblTodoList(), "0,0,f,b");
				jcbTodos.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				jcbTodos.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent evt) {
						jcbTodosItemStateChanged(evt);
					}
				});
			}
		}
		return jPanel4;
	}

	private JPanel getJPanel5() {
		if(jPanel5 == null) {
			jPanel5 = new JPanel();
			TableLayout jPanel5Layout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}, {TableLayout.FILL, TableLayout.FILL}});
			jPanel5Layout.setHGap(5);
			jPanel5Layout.setVGap(5);
			jPanel5.setLayout(jPanel5Layout);
			jPanel5.add(getLblLists(), "0, 0, 1, 0, l, b");
			jPanel5.add(getJcbLists(), "0,1,5,1,f,b");
			jPanel5.add(getJbtnRefresh(), "4,0,5,0,f,b");
		}
		return jPanel5;
	}

	private JLabel getLblLists() {
		if(lblLists == null) {
			lblLists = new JLabel();
			lblLists.setText("ToDo List");
			lblLists.setLabelFor(getJcbListsObject());
		}
		return lblLists;
	}

	private JComboBox getJcbListsObject() {
		if(jcbLists == null) {
			ComboBoxModel jcbListModel =
				new DefaultComboBoxModel(
						new String[] { "Item One", "Item Two" });
			jcbListModel.setSelectedItem("");
			jcbLists = new JComboBox();
			jcbLists.setModel(jcbListModel);
			jcbLists.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			jcbLists.setAutoscrolls(true);
			jcbLists.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					jcbListsItemStateChanged(evt);
				}
			});
		}
		return jcbLists;
	}

	public void addListToCombo(String key) {
		jcbLists.addItem(key);
	}

	public JComboBox getJcbLists() {
		return this.jcbLists;
	}

	private JLabel getLblMessages() {
		if(lblMessages == null) {
			lblMessages = new JLabel();
			lblMessages.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMessages.setForeground(new java.awt.Color(0,64,128));
		}
		return lblMessages;
	}

	private JButton getJbtnRefresh() {
		if(jbtnRefresh == null) {
			jbtnRefresh = new JButton();
			jbtnRefresh.setText("Refresh Lists");
			jbtnRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					refreshActionPerformed(evt);
				}
			});
		}
		return jbtnRefresh;
	}

	protected void refreshActionPerformed(ActionEvent evt) {
		refreshCombos();
	}

	public void refreshCombos() {
		String currentSelectedList = (String)jcbLists.getSelectedItem();
		String currentSelectedItem = (String)jcbTodos.getSelectedItem();
		CoreObject.loadTodoListMap();
		jcbLists.setSelectedItem(currentSelectedList);
		jcbTodos.setSelectedItem(currentSelectedItem);
	}

	private JLabel getJlblTodoList() {
		if(jlblTodoList == null) {
			jlblTodoList = new JLabel();
			jlblTodoList.setText("ToDo item");
			jlblTodoList.setLabelFor(jcbTodos);
		}
		return jlblTodoList;
	}

	private JLabel getJlblDescription() {
		if(jlblDescription == null) {
			jlblDescription = new JLabel();
			jlblDescription.setText("Description");
			jlblDescription.setLabelFor(getJtfDescription());
		}
		return jlblDescription;
	}

	private void jcbListsItemStateChanged(ItemEvent evt) {
		String todoListSelected = (String)jcbLists.getSelectedItem();
		Integer todoListId = CoreObject.getTodoListMap().get(todoListSelected);
		if(todoListId != null) {
			CoreObject.setWorkingTodoListId(todoListId.toString());
			CoreObject.reloadTodoMap();
		}
	}
}
