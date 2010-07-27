package com.jwmsolutions.timeCheck.business;

import static com.jwmsolutions.timeCheck.CoreObject.*;
import static com.jwmsolutions.timeCheck.CoreObject.getCurrentProfile;
import static com.jwmsolutions.timeCheck.util.Constants.CONFIG_BASECAMP_URL;
import static com.jwmsolutions.timeCheck.util.Constants.CONFIG_IS_AUTO_LOGIN;
import static com.jwmsolutions.timeCheck.util.Constants.CONFIG_PASSWORD;
import static com.jwmsolutions.timeCheck.util.Constants.CONFIG_STORED_ACCOUNT;
import static com.jwmsolutions.timeCheck.util.Constants.CONFIG_STORED_PASSWORD;
import static com.jwmsolutions.timeCheck.util.Constants.CONFIG_USERNAME;
import static com.jwmsolutions.timeCheck.util.Constants.*;

import org.apache.commons.configuration.ConfigurationException;

import com.jwmsolutions.timeCheck.CoreObject;
import com.jwmsolutions.timeCheck.model.Profile;

public class ConfigurationBusiness {
	public static void saveConfiguration(String username, String password, String basecampUrl,
			boolean storeAccount, boolean storePassword, boolean isAutoLogin) {
		getCurrentProfile().setUsername(username);
		getCurrentProfile().setPassword(password);
		getCurrentProfile().setBasecampUrl(basecampUrl);
		getCurrentProfile().setRememberAccount(storeAccount);
		getCurrentProfile().setRememberPassword(storePassword);
		getCurrentProfile().setAutoLogin(isAutoLogin);

		if(storeAccount || isAutoLogin)
			getConfig().setProperty(CONFIG_USERNAME, username);
		if(storePassword || isAutoLogin)
			getConfig().setProperty(CONFIG_PASSWORD, password);
		getConfig().setProperty(CONFIG_BASECAMP_URL, basecampUrl);
		getConfig().setProperty(CONFIG_STORED_ACCOUNT, storeAccount);
		getConfig().setProperty(CONFIG_STORED_PASSWORD, storePassword);
		getConfig().setProperty(CONFIG_IS_AUTO_LOGIN, isAutoLogin);
		if(!getConfig().isAutoSave()) {
			try {
				getConfig().save();
			} catch (ConfigurationException e) {
				CoreObject.getLog().error(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void loadStoredProfile() {
		getCurrentProfile().setUsername(getConfig().getString(CONFIG_USERNAME));
		getCurrentProfile().setPassword(getConfig().getString(CONFIG_PASSWORD));
		getCurrentProfile().setBasecampUrl(getConfig().getString(CONFIG_BASECAMP_URL));
		getCurrentProfile().setRememberAccount(getConfig().getBoolean(CONFIG_STORED_ACCOUNT));
		getCurrentProfile().setRememberPassword(getConfig().getBoolean(CONFIG_STORED_PASSWORD));
		getCurrentProfile().setAutoLogin(getConfig().getBoolean(CONFIG_IS_AUTO_LOGIN));
	}

	public static void saveWorkingProjectId(Integer projectId) {
		if(getCurrentProfile().isAutoLogin())
			getConfig().setProperty(CONFIG_WORKING_PROJECT_ID, projectId.toString());
	}

	public static void loadWorkingProjectId() {
		String wpId = getConfig().getString(CONFIG_WORKING_PROJECT_ID);
		setWorkingProjectId(wpId);
	}

	public static void saveWorkingTodoListId(Integer todoListId) {
		if(getCurrentProfile().isAutoLogin())
			getConfig().setProperty(CONFIG_WORKING_TODO_LIST_ID, todoListId.toString());
	}

	public static void loadWorkingTodoListId() {
		String wtlId = getConfig().getString(CONFIG_WORKING_TODO_LIST_ID);
		setWorkingTodoListId(wtlId);
	}
}
