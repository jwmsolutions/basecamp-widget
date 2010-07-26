package com.jwmsolutions.timeCheck.business;

import static com.jwmsolutions.timeCheck.CoreObject.getCurrentProfile;
import static com.jwmsolutions.timeCheck.CoreObject.getGlobalProperties;
import static com.jwmsolutions.timeCheck.CoreObject.getProperty;
import static com.jwmsolutions.timeCheck.util.Constants.BASECAMP_API_COMPLETE_ITEM;
import static com.jwmsolutions.timeCheck.util.Constants.BASECAMP_API_CREATE_ENTRY_FOR_A_TODO_ITEM;
import static com.jwmsolutions.timeCheck.util.Constants.BASECAMP_API_GET_ACCOUNT;
import static com.jwmsolutions.timeCheck.util.Constants.BASECAMP_API_GET_ALL_ITEMS;
import static com.jwmsolutions.timeCheck.util.Constants.BASECAMP_API_GET_ALL_LISTS;
import static com.jwmsolutions.timeCheck.util.Constants.BASECAMP_API_GET_ALL_PROJECTS;
import static com.jwmsolutions.timeCheck.util.Constants.BASECAMP_API_GET_LIST;
import static com.jwmsolutions.timeCheck.util.Constants.METHOD_GET;
import static com.jwmsolutions.timeCheck.util.Constants.METHOD_POST;
import static com.jwmsolutions.timeCheck.util.Constants.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.digester.Digester;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.xerces.jaxp.DocumentBuilderFactoryImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import sun.misc.BASE64Encoder;

import com.jwmsolutions.timeCheck.CoreObject;
import com.jwmsolutions.timeCheck.model.BaseObject;
import com.jwmsolutions.timeCheck.model.BasecampAccount;
import com.jwmsolutions.timeCheck.model.BasecampCompany;
import com.jwmsolutions.timeCheck.model.BasecampProject;
import com.jwmsolutions.timeCheck.model.BasecampProjects;
import com.jwmsolutions.timeCheck.model.BasecampTimeEntry;
import com.jwmsolutions.timeCheck.model.BasecampTodoItem;
import com.jwmsolutions.timeCheck.model.BasecampTodoItems;
import com.jwmsolutions.timeCheck.model.BasecampTodoList;
import com.jwmsolutions.timeCheck.model.BasecampTodoLists;
import com.jwmsolutions.timeCheck.model.Profile;
import com.jwmsolutions.timeCheck.util.LogFilter;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class BasecampBusiness {
	private final static Logger log = LogFilter.getLoggerInstance();
	private static HttpURLConnection con;

	private static String execute(Profile profile, String urlRequest, String xmlRequest, String method) {
		URL urlObj;
		String response = null;
		try {
			urlObj = new URL( profile.getBasecampUrl() + urlRequest );
			con = (HttpURLConnection) urlObj.openConnection();
			con.setRequestMethod( method );
			con.setDoInput( true );
			con.setDoOutput(true);

			String credentials = profile.getUsername() + ":" + profile.getPassword();
			byte[] encodedPassword = ( credentials ).getBytes();
			BASE64Encoder encoder = new BASE64Encoder();
			con.setRequestProperty( "Authorization", "Basic " + encoder.encode( encodedPassword ) );
			con.setRequestProperty( "Accept", "application/xml");
			con.setRequestProperty( "Content-Type", "application/xml");
			con.setRequestProperty( "Content-Length", "0");

			if(xmlRequest != null && !xmlRequest.equals("")) {
				con.setRequestProperty( "Content-Length", Integer.toString(xmlRequest.getBytes().length));
				OutputStream os = con.getOutputStream();
				os.write(xmlRequest.getBytes());
				os.flush();
				os.close();
			}

			InputStream is = con.getInputStream();
			StringBuffer buf = new StringBuffer();
			int c;
			while( ( c = is.read() ) != -1 ) {
				buf.append( (char) c );
			}
			con.disconnect();
			response = buf.toString().trim();
			if(response.length() == 0) {
				response = ""+con.getResponseCode();
			}

		} catch (MalformedURLException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		} catch (ProtocolException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	public static String createTimeEntry(String todoItemId, BasecampTimeEntry entry) {
		String xmlRequest = parseObjectToXmlDocument(entry, BasecampTimeEntry.class);
		String response = execute(
				getCurrentProfile(),
				getProperty(getGlobalProperties(), BASECAMP_API_CREATE_ENTRY_FOR_A_TODO_ITEM, todoItemId),
				xmlRequest,
				METHOD_POST
		);
		CoreObject.newLog(BasecampBusiness.class).debug(xmlRequest);
		CoreObject.newLog(BasecampBusiness.class).debug(response);
		return response;
	}

	public static String completeTodoItem(String todoItemId) {
		String response = execute(
				getCurrentProfile(),
				getProperty(getGlobalProperties(), BASECAMP_API_COMPLETE_ITEM, todoItemId),
				null,
				METHOD_PUT
		);
		CoreObject.newLog(BasecampBusiness.class).debug(response);
		return response;
	}

	public static String uncompleteTodoItem(String todoItemId) {
		String response = execute(
				getCurrentProfile(),
				getProperty(getGlobalProperties(), BASECAMP_API_UNCOMPLETE_ITEM, todoItemId),
				null,
				METHOD_PUT
		);
		CoreObject.newLog(BasecampBusiness.class).debug(response);
		return response;
	}

	public static BasecampProjects getProjects() {
		String response = execute(
				getCurrentProfile(),
				getGlobalProperties().getProperty(BASECAMP_API_GET_ALL_PROJECTS),
				null,
				METHOD_GET
		);
		CoreObject.newLog(BasecampBusiness.class).debug(response);

		Digester digester = new Digester();
		digester.setValidating( false );
		String pattern = "projects";
		digester.addObjectCreate(pattern, BasecampProjects.class);
		setProjectsRules(digester, pattern);

		BasecampProjects obj = null;
		try {
			obj = (BasecampProjects)digester.parse(new StringReader(response));
		} catch (IOException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}

	public static BasecampTodoLists getAllListsWithinProject(String projectId, String filter) {
		if(filter == null)
			filter = "";

		String response = execute(
				getCurrentProfile(),
				getProperty(getGlobalProperties(), BASECAMP_API_GET_ALL_LISTS_WITHIN_PROJECT, projectId, filter),
				null,
				METHOD_GET
		);
		CoreObject.newLog(BasecampBusiness.class).debug(response);

		Digester digester = new Digester();
		digester.setValidating( false );
		String pattern = "todo-lists";
		digester.addObjectCreate(pattern, BasecampTodoLists.class);
		setTodoListsRules(digester, pattern);

		BasecampTodoLists obj = null;
		try {
			obj = (BasecampTodoLists)digester.parse(new StringReader(response));
		} catch (IOException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		}
		return obj;

	}

	public static BasecampTodoLists getAllToDoList() {
		String response = execute(
				getCurrentProfile(),
				getGlobalProperties().getProperty(BASECAMP_API_GET_ALL_LISTS),
				null,
				METHOD_GET
		);
		CoreObject.newLog(BasecampBusiness.class).debug(response);

		Digester digester = new Digester();
		digester.setValidating( false );
		String pattern = "todo-lists";
		digester.addObjectCreate(pattern, BasecampTodoLists.class);
		setTodoListsRules(digester, pattern);

		BasecampTodoLists obj = null;
		try {
			obj = (BasecampTodoLists)digester.parse(new StringReader(response));
		} catch (IOException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}

	public static BasecampTodoList getToDoList(String listId) {
		String response = execute(
				getCurrentProfile(),
				getProperty(getGlobalProperties(), BASECAMP_API_GET_LIST, listId),
				null,
				METHOD_GET
		);
		CoreObject.newLog(BasecampBusiness.class).debug(response);

		Digester digester = new Digester();
		digester.setValidating( false );
		String pattern = "todo-list";
		digester.addObjectCreate(pattern, BasecampTodoList.class);
		setTodoListRules(digester, pattern);

		BasecampTodoList obj = null;
		try {
			obj = (BasecampTodoList)digester.parse(new StringReader(response));
		} catch (IOException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}

	public static BasecampTodoItems getAllTodoItems(String todoListId) {
		String response = execute(
				getCurrentProfile(),
				getProperty(getGlobalProperties(), BASECAMP_API_GET_ALL_ITEMS, todoListId),
				null,
				METHOD_GET
		);
		CoreObject.newLog(BasecampBusiness.class).debug(response);

		Digester digester = new Digester();
		digester.setValidating( false );
		String pattern = "todo-items";
		digester.addObjectCreate(pattern, BasecampTodoItems.class);
		setTodoItemsRules(digester, pattern);

		BasecampTodoItems obj = null;
		try {
			obj = (BasecampTodoItems)digester.parse(new StringReader(response));
		} catch (IOException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}

	public static BasecampAccount getAccount() {
		String response = execute(
				getCurrentProfile(),
				getProperty(getGlobalProperties(), BASECAMP_API_GET_ACCOUNT),
				null,
				METHOD_GET
		);
		CoreObject.newLog(BasecampBusiness.class).debug(response);

		Digester digester = new Digester();
		digester.setValidating( false );

		String pattern = "account";
		digester.addObjectCreate(pattern, BasecampAccount.class);
		setAccountRules(digester, pattern);

		BasecampAccount account = null;
		try {
			account = (BasecampAccount)digester.parse(new StringReader(response));
		} catch (IOException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		}
		return account;
	}

	private static void setProjectsRules(Digester digester, String pattern) {
		for(Field field : BasecampProjects.class.getDeclaredFields()) {
			String fieldName = field.getName();
			String tagName = convertStringToTagName(fieldName);
			String newPattern = new String(pattern + "/" + tagName);

			Class fieldType = field.getType();
			if(fieldType.getSimpleName().equals("ProjectArrayList")) {
				digester.addObjectCreate(newPattern, BasecampProject.class);
				setProjectRules(digester, newPattern);
				digester.addSetNext(newPattern, "add"+StringUtils.capitalize(fieldName));
			} else {
				digester.addBeanPropertySetter(newPattern, fieldName);
			}
		}
	}

	private static void setProjectRules(Digester digester, String pattern) {
		for(Field field : BasecampTodoList.class.getDeclaredFields()) {
			String fieldName = field.getName();
			String tagName = convertStringToTagName(fieldName);
			String newPattern = new String(pattern + "/" + tagName);

			Class fieldType = field.getType();
			if(fieldType.getSimpleName().equals("BasecampCompany")) {
				digester.addObjectCreate(newPattern, BasecampCompany.class);
				setCompanyRules(digester, newPattern);
				digester.addSetNext(newPattern, "set"+StringUtils.capitalize(fieldName));
			} else {
				digester.addBeanPropertySetter(newPattern, fieldName);
			}
		}
	}

	private static void setCompanyRules(Digester digester, String pattern) {
		for(Field field : BasecampCompany.class.getDeclaredFields()) {
			String fieldName = field.getName();
			String tagName = convertStringToTagName(fieldName);
			String newPattern = new String(pattern + "/" + tagName);
			digester.addBeanPropertySetter(newPattern, fieldName);
		}
	}

	private static void setTodoListsRules(Digester digester, String pattern) {
		for(Field field : BasecampTodoLists.class.getDeclaredFields()) {
			String fieldName = field.getName();
			String tagName = convertStringToTagName(fieldName);
			String newPattern = new String(pattern + "/" + tagName);

			Class fieldType = field.getType();
			if(fieldType.getSimpleName().equals("TodoListArrayList")) {
				digester.addObjectCreate(newPattern, BasecampTodoList.class);
				setTodoListRules(digester, newPattern);
				digester.addSetNext(newPattern, "add"+StringUtils.capitalize(fieldName));
			} else {
				digester.addBeanPropertySetter(newPattern, fieldName);
			}
		}
	}

	private static void setTodoListRules(Digester digester, String pattern) {
		for(Field field : BasecampTodoList.class.getDeclaredFields()) {
			String fieldName = field.getName();
			String tagName = convertStringToTagName(fieldName);
			String newPattern = new String(pattern + "/" + tagName);

			Class fieldType = field.getType();
			if(fieldType.getSimpleName().equals("BasecampTodoItems")) {
				digester.addObjectCreate(newPattern, BasecampTodoItems.class);
				setTodoItemsRules(digester, newPattern);
				digester.addSetNext(newPattern, "set"+StringUtils.capitalize(fieldName));
			} else {
				digester.addBeanPropertySetter(newPattern, fieldName);
			}

		}
	}

	private static void setTodoItemsRules(Digester digester, String pattern) {
		for(Field field : BasecampTodoItems.class.getDeclaredFields()) {
			String fieldName = field.getName();
			String tagName = convertStringToTagName(fieldName);
			String newPattern = new String(pattern + "/" + tagName);
			digester.addObjectCreate(newPattern, BasecampTodoItem.class);
			setTodoItemRules(digester, newPattern);
			digester.addSetNext(newPattern, "add" + StringUtils.capitalize(fieldName));
		}
	}

	private static void setTodoItemRules(Digester digester, String pattern) {
		for(Field field : BasecampTodoItem.class.getDeclaredFields()) {
			String fieldName = field.getName();
			String tagName = convertStringToTagName(fieldName);
			String newPattern = new String(pattern + "/" + tagName);
			digester.addBeanPropertySetter(newPattern, fieldName);
		}
	}

	private static void setAccountRules(Digester digester, String pattern) {
		for(Field field : BasecampAccount.class.getDeclaredFields()) {
			String fieldName = field.getName();
			String tagName = convertStringToTagName(fieldName);
			String newPattern = new String(pattern + "/" + tagName);
			digester.addBeanPropertySetter(newPattern, fieldName);
		}
	}

	private static String convertStringToTagName(String fieldName) {
		for(int j='A'; j<='Z'; j++) {
			char letter = (char)j;
			String character = Character.toString(letter);
			fieldName = StringUtils.replace(fieldName, character, "-"+character.toLowerCase());
		}
		if(fieldName.charAt(0) == '-' || fieldName.charAt(0) == '_')
			fieldName = fieldName.substring(1);
		return fieldName;
	}

	public static String parseObjectToXmlDocument(BaseObject object, Class clazz) {
		Document doc = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactoryImpl.newInstance();
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
		} catch (Exception e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		}

		String objectName = StringUtils.replace(clazz.getSimpleName(), "Basecamp", "");

		Element root = doc.createElement( convertStringToTagName(objectName) );
		doc.appendChild(root);

		parseObjectToXmlElement(object, clazz, doc, root);

		//set up a transformer
        TransformerFactory transfac = TransformerFactory.newInstance();
        Transformer trans;
		try {
			trans = transfac.newTransformer();
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");

			//create string from xml tree
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			trans.transform(source, result);
			String xmlString = sw.toString();
			return xmlString;
		} catch (TransformerConfigurationException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		} catch (TransformerException e) {
			CoreObject.getLog().error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	private static void parseObjectToXmlElement(Object object, Class clazz, Document doc, Element element) {
		for(Field field : clazz.getDeclaredFields()) {
			String fieldName = field.getName();
			String getMethodName = "get" + StringUtils.capitalize(fieldName);
			Class fieldType = field.getType();
			Method getMethod;
			try {
				getMethod = clazz.getMethod(getMethodName);
				if(fieldType.getSuperclass().getSimpleName().equals("BaseObject")) {
					// TODO hacer el código para que soporte más objetos
					//que formen parte de las propiedades el objeto que se está recorriendo
				} else {
					Object value = fieldType.cast(getMethod.invoke(object));
					Element item = doc.createElement(convertStringToTagName(fieldName));
					element.appendChild(item);
					item.appendChild(doc.createTextNode((value != null)?value.toString():""));
				}
			} catch (SecurityException e) {
				CoreObject.getLog().error(e.getMessage());
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				CoreObject.getLog().error(e.getMessage());
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				CoreObject.getLog().error(e.getMessage());
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				CoreObject.getLog().error(e.getMessage());
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				CoreObject.getLog().error(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	//    public static String getCompanies() { }

	//    public static String getProjects() {}

	//	public static String getAllProjects() {}
	//	public static String getProject() {}
	//
	//	public static String getCurrentPerson() {}
	//	public static String getPeopleAcrossProjects() {}
	//	public static String getPeopleWithinProject() {}
	//	public static String getPeopleWithinCompany() {}
	//	public static String getPerson() {}
	//
	//	public static String getCompanies() {}
	//	public static String getCompaniesWithinProjects() {}
	//	public static String getCompany() {}
	//
	//	public static String getCategories() {}
	//	public static String getCategoriesType() {}
	//	public static String getCategory() {}
	//	public static String createCategory() {}
	//	public static String updateCategory() {}
	//	public static String destroyCategory() {}
	//
	//	public static String getMessages() {}
	//	public static String getMessage() {}
	//	public static String getMessagesByCategory() {}
	//	public static String getArchivedMessages() {}
	//	public static String getArchivedMessagesByCategory() {}
	//	public static String newMessage() {}
	//	public static String createMessage() {}
	//	public static String editMessage() {}
	//	public static String updateMessage() {}
	//	public static String destroyMessage() {}
	//
	//	public static String getRecentComments() {}
	//	public static String getComment() {}
	//	public static String newComment() {}
	//	public static String createComment() {}
	//	public static String editComment() {}
	//	public static String updateComment() {}
	//	public static String destroyComment() {}
	//
	//	public static String getAllListsAcrossProjects() {}
	//	public static String getAllListsWithinProject() {}
	//	public static String getList() {}
	//	public static String editList() {}
	//	public static String updateList() {}
	//	public static String newList() {}
	//	public static String createList() {}
	//	public static String destroyList() {}
	//	public static String reorderLists() {}
	//
	//	public static String getAllItems() {}
	//	public static String getItem() {}
	//	public static String CompleteItem() {}
	//	public static String UncompleteItem() {}
	//	public static String newItem() {}
	//	public static String createItem() {}
	//	public static String updateItem() {}
	//	public static String editItem() {}
	//	public static String destroyItem() {}
	//	public static String reorderItems() {}
	//
	//	public static String list() {}
	//	public static String complete() {}
	//	public static String uncomplete() {}
	//	public static String create() {}
	//	public static String createBatch() {}
	//	public static String update() {}
	//	public static String delete() {}
	//
	//	public static String getAllEntriesForAProject() {}
	//	public static String getAllEntriesForATodoItem() {}
	//	public static String createEntry() {}
	//	public static String createEntryForATodoItem() {}
	//	public static String newEntry() {}
	//	public static String getEntry() {}
	//	public static String editEntry() {}
	//	public static String updateEntry() {}
	//	public static String destroyEntry() {}
	//	public static String report() {}

}
