package com.jwmsolutions.timeCheck;

import static com.jwmsolutions.timeCheck.util.Constants.FILE_CONFIG_PROPERTIES;
import static com.jwmsolutions.timeCheck.util.Constants.FILE_GLOBAL_PROPERTIES;
import static com.jwmsolutions.timeCheck.util.Constants.FILE_LOG4J_CONFIG;
import static com.jwmsolutions.timeCheck.util.Constants.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.jwmsolutions.timeCheck.business.BasecampBusiness;
import com.jwmsolutions.timeCheck.business.ConfigurationBusiness;
import com.jwmsolutions.timeCheck.gui.ConfigurationForm;
import com.jwmsolutions.timeCheck.gui.ProjectSelectorForm;
import com.jwmsolutions.timeCheck.gui.TodoForm;
import com.jwmsolutions.timeCheck.model.BasecampProject;
import com.jwmsolutions.timeCheck.model.BasecampProjects;
import com.jwmsolutions.timeCheck.model.BasecampTodoItem;
import com.jwmsolutions.timeCheck.model.BasecampTodoItems;
import com.jwmsolutions.timeCheck.model.BasecampTodoList;
import com.jwmsolutions.timeCheck.model.BasecampTodoLists;
import com.jwmsolutions.timeCheck.model.Profile;
import com.jwmsolutions.timeCheck.util.LogFilter;
import com.jwmsolutions.timeCheck.util.ReminderScheduler;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 * Clase base que contendrá imports y funcionalidades
 * generales que aplicarán a todas las demás clases
 */
public class CoreObject {
	private static final org.apache.log4j.Logger log = LogFilter.getLoggerInstance();
	private static Properties globalProperties;
	private static Properties resourcesProperties;
	private static PropertiesConfiguration config;
	private static Profile currentProfile;
	private static ConfigurationForm configForm;
	private static TodoForm todoForm;
	private static ProjectSelectorForm projectSelectorForm;
	private static Map<String, BasecampTodoItem> todoMap = new LinkedMap();
	private static Map<String, Integer> projectMap = new LinkedMap();
	private static Map<String, Integer> todoListMap = new LinkedMap();
	private static String workingProjectId;
	private static String workingTodoListId;

	public CoreObject() {
		loadGlobalProperties();
		loadResourcesProperties();

		enableLog4jConfigFile();
		DOMConfigurator.configure(FILE_LOG4J_CONFIG);
		boolean successfulLoadConfiguration = loadConfiguration();

		currentProfile = new Profile();
		ConfigurationBusiness.loadStoredProfile();
		projectSelectorForm = new ProjectSelectorForm();
		todoForm = new TodoForm(null, false);
		configForm = new ConfigurationForm(null, false);

		if(successfulLoadConfiguration && testConnection()) {
			ConfigurationBusiness.loadWorkingProjectId();
			ConfigurationBusiness.loadWorkingTodoListId();
			loadProjectMap();
			if(workingProjectId != null && !workingProjectId.equals("-1"))
				loadTodoListMap();
			if(workingTodoListId != null && !workingTodoListId.equals("-1"))
				reloadTodoMap();
		}
	}

	public static void reloadTodoMap() {
		BasecampTodoList list = BasecampBusiness.getToDoList(workingTodoListId);
		getTodoForm().clearTodosCombo();
		todoMap.clear();
		BasecampTodoItems todoItems = list.getTodoItems();
		for(BasecampTodoItem todoItem : todoItems.getTodoItems()) {
			String key = todoItem.getContent();
			if(todoItem.getCompleted())
				key = config.getString(CONFIG_COMPLETED_ITEM_TAG) + " " + key;
			todoMap.put(key, todoItem);
			getTodoForm().addItemToCombo(key);
		}
	}

	public static boolean testConnection() {
		try {
			if(BasecampBusiness.getAccount() != null) {
				return true;
			}
		} catch(Exception e) {
		}
		return false;
	}

	public static org.apache.log4j.Logger getLog() {
		return log;
	}
	public static org.apache.log4j.Logger newLog(Class clazz) {
		return Logger.getLogger(clazz);
	}
	public static Properties getGlobalProperties() {
		return globalProperties;
	}
	public static Properties getResourcesProperties() {
		return resourcesProperties;
	}
	public static PropertiesConfiguration getConfig() {
		return config;
	}
	public static Profile getCurrentProfile() {
		return currentProfile;
	}
	public static ConfigurationForm getConfigForm() {
		return configForm;
	}
	public static ProjectSelectorForm getProjectSelectorForm() {
		return projectSelectorForm;
	}

	public static TodoForm getTodoForm() {
		return todoForm;
	}
	public static Map<String, BasecampTodoItem> getTodoMap() {
		return todoMap;
	}

	public static Map<String, Integer> getProjectMap() {
		return projectMap;
	}
	public static void setProjectMap(Map<String, Integer> projectMap) {
		CoreObject.projectMap = projectMap;
	}
	public static void loadProjectMap() {
		projectMap.clear();
		getProjectSelectorForm().clearProjectsCombo();
		BasecampProjects bcProjects = BasecampBusiness.getProjects();
		for(BasecampProject p : bcProjects.getProject()) {
			projectMap.put(p.getName(), p.getId());
			getProjectSelectorForm().addProjectToCombo(p.getName());
		}
	}

	public static Map<String, Integer> getTodoListMap() {
		return todoListMap;
	}
	public static void setTodoListMap(Map<String, Integer> todoListMap) {
		CoreObject.todoListMap = todoListMap;
	}
	public static void loadTodoListMap() {
		todoListMap.clear();
		getTodoForm().clearTodoListsCombo();
		BasecampTodoLists bcTodoLists = BasecampBusiness.getAllListsWithinProject(workingProjectId, PROJECTS_FILTER_PENDING);
		for(BasecampTodoList tdList : bcTodoLists.getTodoLists()) {
			todoListMap.put(tdList.getName(), tdList.getId());
			getTodoForm().addListToCombo(tdList.getName());
		}
		if(getTodoForm().getJcbLists().getItemCount() > 0) {
			getTodoForm().getJcbLists().setSelectedIndex(0);
		}

		String todoListSelected = (String)getTodoForm().getJcbLists().getSelectedItem();
		Integer todoListId = todoListMap.get(todoListSelected);
		setWorkingTodoListId(todoListId.toString());
		reloadTodoMap();

		if(getCurrentProfile().isAutoLogin()) {
			ConfigurationBusiness.saveWorkingTodoListId(todoListId);
		}
	}

	public static String getWorkingProjectId() {
		return workingProjectId;
	}
	public static void setWorkingProjectId(String workingProjectId) {
		CoreObject.workingProjectId = workingProjectId;
	}

	public static String getWorkingTodoListId() {
		return workingTodoListId;
	}
	public static void setWorkingTodoListId(String workingListId) {
		CoreObject.workingTodoListId = workingListId;
	}

	public static String getProperty(Properties properties, String key, Object... params) {
		String message = (String)properties.getProperty(key);
		if (params != null) {
			message = MessageFormat.format(message, params);
		}
		return message;
	}

	private void enableLog4jConfigFile() {
		try {
			File configDir = new File(APPLICATION_CONFIG_DIR);
			File configFile = new File(APPLICATION_CONFIG_DIR + FILE_LOG4J_CONFIG);
			if(!configFile.exists()) {
				if(!configDir.exists())
					configDir.mkdirs();
				if(!configFile.exists()) {
					InputStream defaultConfig = CoreObject.class.getResourceAsStream(FILE_LOG4J_CONFIG);

					OutputStream output = new FileOutputStream(configFile);
					int bytesCopied = IOUtils.copy(defaultConfig, output);

					IOUtils.closeQuietly(defaultConfig);
					IOUtils.closeQuietly(output);

					System.out.println("Copiados " + bytesCopied + " bytes.");
					System.out.println("Se ha guardado el archivo log4j.xml por defecto...");
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private boolean loadConfiguration() {
		boolean isNewConfiguration = false;
		try {
			File configDir = new File(APPLICATION_CONFIG_DIR);
			File configFile = new File(APPLICATION_CONFIG_DIR + FILE_CONFIG_PROPERTIES);
			if(!configFile.exists()) {
				if(!configDir.exists())
					configDir.mkdirs();
				if(!configFile.exists()) {
					isNewConfiguration = true;
					InputStream defaultConfig = CoreObject.class.getResourceAsStream(FILE_CONFIG_PROPERTIES);

					OutputStream output = new FileOutputStream(configFile);
					int bytesCopied = IOUtils.copy(defaultConfig, output);

					IOUtils.closeQuietly(defaultConfig);
					IOUtils.closeQuietly(output);

					System.out.println("Copiados " + bytesCopied + " bytes.");
					System.out.println("Se ha guardado el archivo de configuracion por defecto...");
				}
			}
			config = new PropertiesConfiguration(APPLICATION_CONFIG_DIR + FILE_CONFIG_PROPERTIES);
			config.setAutoSave(true);
		} catch (ConfigurationException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return !isNewConfiguration;
	}

	private void loadGlobalProperties() {
		try {
			globalProperties = new Properties();
			globalProperties.load(CoreObject.class.getResourceAsStream(FILE_GLOBAL_PROPERTIES));
		} catch (IOException e) {
			this.log.error(e.getMessage());
		}
	}

	private void loadResourcesProperties() {
		try {
			resourcesProperties = new Properties();
			resourcesProperties.load(CoreObject.class.getResourceAsStream(FILE_RESOURCES_PROPERTIES));
		} catch (IOException e) {
			this.log.error(e.getMessage());
		}
	}
}
