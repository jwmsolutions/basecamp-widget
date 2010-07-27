package com.jwmsolutions.timeCheck.gui;
import info.clearthought.layout.TableLayout;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import org.apache.commons.collections.map.LinkedMap;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import com.jwmsolutions.timeCheck.CoreObject;
import com.jwmsolutions.timeCheck.business.BasecampBusiness;
import com.jwmsolutions.timeCheck.business.ConfigurationBusiness;
import com.jwmsolutions.timeCheck.model.BasecampTodoList;
import com.jwmsolutions.timeCheck.model.BasecampTodoLists;
import com.jwmsolutions.timeCheck.util.Constants;


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
public class ProjectSelectorForm extends javax.swing.JDialog {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel jPanel1;
	private JPanel jPanel2;
	private JButton jbtnCancel;
	private JButton jbtnOk;
	private JComboBox jcbProjects;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ProjectSelectorForm inst = new ProjectSelectorForm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ProjectSelectorForm() {
		super();
		initGUI();
		initComponents();
	}

	private void initComponents() {
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension screenSize = tk.getScreenSize();
	    int screenHeight = screenSize.height;
	    int screenWidth = screenSize.width;
	    setLocation(screenWidth-getSize().width - 20, screenHeight-getSize().height -60);
	}

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel2 = new JPanel();
				GroupLayout jPanel2Layout = new GroupLayout((JComponent)jPanel2);
				jPanel2.setLayout(jPanel2Layout);
				{
					jbtnCancel = new JButton();
					jbtnCancel.setText("Cancel");
					jbtnCancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jbtnCancelActionPerformed(evt);
						}
					});
				}
				{
					jbtnOk = new JButton();
					jbtnOk.setText("Acept");
					jbtnOk.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jbtnOkActionPerformed(evt);
						}
					});
				}
				{
					jPanel1 = new JPanel();
					TableLayout jPanel1Layout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}, {TableLayout.FILL}});
					jPanel1Layout.setHGap(5);
					jPanel1Layout.setVGap(5);
					jPanel1.setLayout(jPanel1Layout);
					{
						ComboBoxModel jcbProjectsModel =
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
						jcbProjects = new JComboBox();
						jPanel1.add(jcbProjects, "0, 0, 3, 0");
						jcbProjects.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						jcbProjects.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent evt) {
								jcbProjectsItemStateChanged(evt);
							}
						});
					}
				}
				jPanel2Layout.setHorizontalGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap()
					.add(jPanel2Layout.createParallelGroup()
					    .add(GroupLayout.LEADING, jPanel1, 0, 345, Short.MAX_VALUE)
					    .add(GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
					        .add(0, 209, Short.MAX_VALUE)
					        .add(jbtnOk, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addPreferredGap(LayoutStyle.RELATED, 0, GroupLayout.PREFERRED_SIZE)
					        .add(jbtnCancel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap());
				jPanel2Layout.setVerticalGroup(jPanel2Layout.createSequentialGroup()
					.add(6)
					.add(jPanel1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.add(29)
					.add(jPanel2Layout.createParallelGroup(GroupLayout.BASELINE)
					    .add(GroupLayout.BASELINE, jbtnOk, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .add(GroupLayout.BASELINE, jbtnCancel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(125, 125));
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
					.add(jPanel2, 0, 202, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
					.add(jPanel2, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE));
			pack();
			this.setSize(373, 114);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	public void clearProjectsCombo() {
		this.jcbProjects.removeAllItems();
	}

	public void addProjectToCombo(String key) {
		jcbProjects.addItem(key);
	}

	private void jcbProjectsItemStateChanged(ItemEvent evt) {
	}

	private void jbtnCancelActionPerformed(ActionEvent evt) {
		setVisible(false);
	}

	private void jbtnOkActionPerformed(ActionEvent evt) {
		String projectSelected = (String)jcbProjects.getSelectedItem();
		Integer projectId = CoreObject.getProjectMap().get(projectSelected);
		CoreObject.setWorkingProjectId(projectId.toString());
		if(CoreObject.getCurrentProfile().isAutoLogin()) {
			ConfigurationBusiness.saveWorkingProjectId(projectId);
		}
		CoreObject.loadTodoListMap();
		setVisible(false);
		CoreObject.getTodoForm().setVisible(true);
	}
}
