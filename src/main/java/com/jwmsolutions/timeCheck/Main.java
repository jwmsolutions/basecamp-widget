package com.jwmsolutions.timeCheck;

import com.jwmsolutions.timeCheck.gui.TrayIconManager;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CoreObject();
		new TrayIconManager();
		CoreObject.getConfigForm().showForm();
	}
}
