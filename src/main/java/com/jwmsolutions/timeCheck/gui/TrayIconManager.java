package com.jwmsolutions.timeCheck.gui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jwmsolutions.timeCheck.CoreObject;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class TrayIconManager {
	public TrayIconManager() {//se declara el objeto tipo icono
		final TrayIcon iconoSystemTray;
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//se verifica que el SystemTray sea soportado
		if (SystemTray.isSupported()) {

			//se obtiene una instancia est�tica de la clase SystemTray
			SystemTray tray = SystemTray.getSystemTray();

			//esta es la imagen de icono
			Image imagenIcono = Toolkit.getDefaultToolkit().getImage(TrayIconManager.class.getResource("images/timer.png"));

			//menu que aparece al hacer click derecho
			final JPopupMenu popup = new JPopupMenu();

			//aniadir un menu con icono (swing)
			JMenuItem menuItem = new JMenuItem("Close this contextual menu");
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					popup.setVisible(false);
				}
			});
			popup.add(menuItem);
			popup.addSeparator();

			menuItem = new JMenuItem("Login form",  new ImageIcon(TrayIconManager.class.getResource("images/key16px.png")));
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CoreObject.getTodoForm().dispose();
					CoreObject.getProjectSelectorForm().dispose();
					CoreObject.getConfigForm().setVisible(true);
				}
			});
			popup.add(menuItem);

			menuItem = new JMenuItem("Project selector form",  new ImageIcon(TrayIconManager.class.getResource("images/settings16px.png")));
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CoreObject.getTodoForm().dispose();
					CoreObject.getConfigForm().dispose();
					CoreObject.getProjectSelectorForm().setVisible(true);
				}
			});
			popup.add(menuItem);

			menuItem = new JMenuItem("To-do form",  new ImageIcon(TrayIconManager.class.getResource("images/todo16px.png")));
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CoreObject.getProjectSelectorForm().dispose();
					CoreObject.getConfigForm().dispose();
					CoreObject.getTodoForm().setVisible(true);
				}
			});
			popup.add(menuItem);

			//aniadir el item de salir
			popup.addSeparator();
			JMenuItem item = new JMenuItem("Quit", new ImageIcon(TrayIconManager.class.getResource("images/quit16px.png")));
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO imprimir System.out.println("Saliendo...");
					System.exit(0);
				}
			});
			popup.add(item);

			//iniciamos el objeto TrayIcon
			iconoSystemTray = new TrayIcon(imagenIcono, "Time Check", null);
			iconoSystemTray.setImageAutoSize(true);

			//iconoSystemTray.addMouseListener(mouseListener);
			iconoSystemTray.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					if (e.isPopupTrigger()) {
						popup.setLocation(e.getX(), e.getY()-50);
						popup.setInvoker(popup);
						popup.setVisible(true);
					} else {
						CoreObject.getTodoForm().setVisible(true);
						popup.setVisible(false);
					}
				}
			});

			//se debe capturar una excepci�n en caso que falle la adicion de un icono
			try {
				tray.add(iconoSystemTray);
			} catch (AWTException e) {
				CoreObject.getLog().error("No es posible agregar el icono al System Tray");
			}
		}
		else {
			CoreObject.getLog().error("Tu sistema no soporta la caracter�stica System Tray");
		}
	}
	public static void main(String[] args) {
		new TrayIconManager();
	}
}
