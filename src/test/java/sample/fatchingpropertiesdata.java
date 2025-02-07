package sample;

import genericUtility.propertiesUtility;

public class fatchingpropertiesdata {
	public static void main(String[] args) throws Exception {
		propertiesUtility putil=new propertiesUtility();
		String URL=putil.getDataFromProperties("url");
		String username=putil.getDataFromProperties("username");
		String password=putil.getDataFromProperties("password");
		System.out.println(URL);
		System.out.println(username);
		System.out.println(password);
		
	}

}
