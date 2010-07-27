/**
 *
 */
package com.jwmsolutions.timeCheck.util;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class Constants {
	public final static String LOG_GLOBAL_NAME = "com.jwmsolutions.logs.Global";
	public final static String DATE_FORMAT_DATETIME = "basecamp.api.dateformat.datetime";
	public final static String DATE_FORMAT_DATELONG = "basecamp.api.dateformat.datelong";
	public final static String DATE_FORMAT_DATE = "basecamp.api.dateformat.date";

	/*
	 * Constantes que definen los nombres de archivos usados por la app
	 */
	public final static String APPLICATION_CONFIG_DIR = System.getProperty("user.home") + "/timeCheck/";
	public final static String FILE_LOG4J_CONFIG = "log4j.xml";
	public final static String FILE_CONFIG_PROPERTIES = "config.properties";
	public final static String FILE_GLOBAL_PROPERTIES = "global.properties";
	public final static String FILE_RESOURCES_PROPERTIES = "resources.properties";

	public final static String METHOD_GET = "GET";
	public final static String METHOD_POST = "POST";
	public final static String METHOD_PUT = "PUT";
	public final static String METHOD_DELETE = "DELETE";

	/*
	 * Constantes para administrar los datos de perfil y configuración
	 */
	public final static String CONFIG_USERNAME = "username";
	public final static String CONFIG_PASSWORD = "password";
	public final static String CONFIG_BASECAMP_TOKEN = "basecampToken";
	public final static String CONFIG_BASECAMP_URL = "basecampUrl";
	public final static String CONFIG_STORED_ACCOUNT = "storedAccount";
	public final static String CONFIG_STORED_PASSWORD = "storedPassword";
	public final static String CONFIG_IS_AUTO_LOGIN = "isAutoLogin";
	public final static String CONFIG_WORKING_PROJECT_ID = "workingProjectId";
	public final static String CONFIG_WORKING_TODO_LIST_ID = "workingTodoListId";
	public final static String CONFIG_COMPLETED_ITEM_TAG= "completedTodoItem";

	/*
	 * Constantes que guardan el nombre de una llave en el archivo .properties para quartz
	 */
	public final static String QUARTZ_REMINDER_REPEAT_INTERVAL = "quartz.reminder.repeat.interval";
	public final static String QUARTZ_REMINDER_START_TIME = "quartz.reminder.start.time";
	public final static String QUARTZ_REFRESH_REPEAT_INTERVAL = "quartz.refresh.repeat.interval";
	public final static String QUARTZ_REFRESH_START_TIME = "quartz.refresh.start.time";
	public final static Long QUARTZ_MAX_REPEAT_INTERVAL_TIME = 6 * 60 * 60 * 1000L;

	/* CONSTANT PARAMETERS */
	public final static String PROJECTS_FILTER_ALL = "all";
	public final static String PROJECTS_FILTER_PENDING = "pending";
	public final static String PROJECTS_FILTER_FINISHED = "finished";

	/* ACCOUNT */
	public final static String BASECAMP_API_GET_ACCOUNT = "basecamp.api.get.account";

	/* PROJECTS */
	public final static String BASECAMP_API_GET_ALL_PROJECTS = "basecamp.api.get.all.projects";
	public final static String BASECAMP_API_GET_PROJECT = "basecamp.api.get.project";

	/* PEOPLE */
	public final static String BASECAMP_API_GET_CURRENT_PERSON = "basecamp.api.get.current.person";
	public final static String BASECAMP_API_GET_PEOPLE_ACROSS_PROJECTS = "basecamp.api.get.people.across.projects";
	public final static String BASECAMP_API_GET_PEOPLE_WITHIN_PROJECT = "basecamp.api.get.people.within.project";
	public final static String BASECAMP_API_GET_PEOPLE_WITHIN_COMPANY = "basecamp.api.get.people.within.company";
	public final static String BASECAMP_API_GET_PERSON = "basecamp.api.get.person";

	/* COMPANIES */
	public final static String BASECAMP_API_GET_COMPANIES = "basecamp.api.get.companies";
	public final static String BASECAMP_API_GET_COMPANIES_WITHIN_PROJECTS = "basecamp.api.get.companies.within.projects";
	public final static String BASECAMP_API_GET_COMPANY = "basecamp.api.get.company";

	/* CATEGORIES */
	public final static String BASECAMP_API_GET_CATEGORIES = "basecamp.api.get.categories";
	public final static String BASECAMP_API_GET_CATEGORIES_TYPE = "basecamp.api.get.categories.type";
	public final static String BASECAMP_API_GET_CATEGORY = "basecamp.api.get.category";
	public final static String BASECAMP_API_CREATE_CATEGORY = "basecamp.api.create.category";
	public final static String BASECAMP_API_UPDATE_CATEGORY = "basecamp.api.update.category";
	public final static String BASECAMP_API_DESTROY_CATEGORY = "basecamp.api.destroy.category";

	/* MESSAGES */
	public final static String BASECAMP_API_GET_MESSAGES = "basecamp.api.get.messages";
	public final static String BASECAMP_API_GET_MESSAGE = "basecamp.api.get.message";
	public final static String BASECAMP_API_GET_MESSAGES_BY_CATEGORY = "basecamp.api.get.messages.by.category";
	public final static String BASECAMP_API_GET_ARCHIVED_MESSAGES = "basecamp.api.get.archived.messages";
	public final static String BASECAMP_API_GET_ARCHIVED_MESSAGES_BY_CATEGORY = "basecamp.api.get.archived.messages.by.category";
	public final static String BASECAMP_API_NEW_MESSAGE = "basecamp.api.new.message";
	public final static String BASECAMP_API_CREATE_MESSAGE = "basecamp.api.create.message";
	public final static String BASECAMP_API_EDIT_MESSAGE = "basecamp.api.edit.message";
	public final static String BASECAMP_API_UPDATE_MESSAGE = "basecamp.api.update.message";
	public final static String BASECAMP_API_DESTROY_MESSAGE = "basecamp.api.destroy.message";

	/* COMMENTS */
	public final static String BASECAMP_API_GET_RECENT_COMMENTS = "basecamp.api.get.recent.comments";
	public final static String BASECAMP_API_GET_COMMENT = "basecamp.api.get.comment";
	public final static String BASECAMP_API_NEW_COMMENT = "basecamp.api.new.comment";
	public final static String BASECAMP_API_CREATE_COMMENT = "basecamp.api.create.comment";
	public final static String BASECAMP_API_EDIT_COMMENT = "basecamp.api.edit.comment";
	public final static String BASECAMP_API_UPDATE_COMMENT = "basecamp.api.update.comment";
	public final static String BASECAMP_API_DESTROY_COMMENT = "basecamp.api.destroy.comment";

	/* TO DO LISTS */
	public final static String BASECAMP_API_GET_ALL_LISTS = "basecamp.api.get.all.lists";
	public final static String BASECAMP_API_GET_ALL_LISTS_ACROSS_PROJECTS = "basecamp.api.get.all.lists.across.projects";
	public final static String BASECAMP_API_GET_ALL_LISTS_WITHIN_PROJECT = "basecamp.api.get.all.lists.within.project";
	public final static String BASECAMP_API_GET_LIST = "basecamp.api.get.list";
	public final static String BASECAMP_API_EDIT_LIST = "basecamp.api.edit.list";
	public final static String BASECAMP_API_UPDATE_LIST = "basecamp.api.update.list";
	public final static String BASECAMP_API_NEW_LIST = "basecamp.api.new.list";
	public final static String BASECAMP_API_CREATE_LIST = "basecamp.api.create.list";
	public final static String BASECAMP_API_DESTROY_LIST = "basecamp.api.destroy.list";
	public final static String BASECAMP_API_REORDER_LISTS = "basecamp.api.reorder.lists";

	/* TO DO LIST ITEMS */
	public final static String BASECAMP_API_GET_ALL_ITEMS = "basecamp.api.get.all.items";
	public final static String BASECAMP_API_GET_ITEM = "basecamp.api.get.item";
	public final static String BASECAMP_API_COMPLETE_ITEM = "basecamp.api.complete.item";
	public final static String BASECAMP_API_UNCOMPLETE_ITEM = "basecamp.api.uncomplete.item";
	public final static String BASECAMP_API_NEW_ITEM = "basecamp.api.new.item";
	public final static String BASECAMP_API_CREATE_ITEM = "basecamp.api.create.item";
	public final static String BASECAMP_API_UPDATE_ITEM = "basecamp.api.update.item";
	public final static String BASECAMP_API_EDIT_ITEM = "basecamp.api.edit.item";
	public final static String BASECAMP_API_DESTROY_ITEM = "basecamp.api.destroy.item";
	public final static String BASECAMP_API_REORDER_ITEMS = "basecamp.api.reorder.items";

	/* MILESTONES */
	public final static String BASECAMP_API_LIST = "basecamp.api.list";
	public final static String BASECAMP_API_COMPLETE = "basecamp.api.complete";
	public final static String BASECAMP_API_UNCOMPLETE = "basecamp.api.uncomplete";
	public final static String BASECAMP_API_CREATE = "basecamp.api.create";
	public final static String BASECAMP_API_CREATE_BATCH = "basecamp.api.create.batch";
	public final static String BASECAMP_API_UPDATE = "basecamp.api.update";
	public final static String BASECAMP_API_DELETE = "basecamp.api.delete";

	/* TIME TRACKING */
	public final static String BASECAMP_API_GET_ALL_ENTRIES_FOR_A_PROJECT = "basecamp.api.get.all.entries.for.a.project";
	public final static String BASECAMP_API_GET_ALL_ENTRIES_FOR_A_TODO_ITEM = "basecamp.api.get.all.entries.for.a.todo.item";
	public final static String BASECAMP_API_CREATE_ENTRY = "basecamp.api.create.entry";
	public final static String BASECAMP_API_CREATE_ENTRY_FOR_A_TODO_ITEM = "basecamp.api.create.entry.for.a.todo.item";
	public final static String BASECAMP_API_NEW_ENTRY = "basecamp.api.new.entry";
	public final static String BASECAMP_API_GET_ENTRY = "basecamp.api.get.entry";
	public final static String BASECAMP_API_EDIT_ENTRY = "basecamp.api.edit.entry";
	public final static String BASECAMP_API_UPDATE_ENTRY = "basecamp.api.update.entry";
	public final static String BASECAMP_API_DESTROY_ENTRY = "basecamp.api.destroy.entry";
	public final static String BASECAMP_API_REPORT = "basecamp.api.report";
}
