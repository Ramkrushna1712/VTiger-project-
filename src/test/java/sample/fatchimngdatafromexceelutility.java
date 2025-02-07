package sample;

import genericUtility.excelutility;

public class fatchimngdatafromexceelutility {
		public static void main(String[] args) throws Exception {
			excelutility eutil=new excelutility();
			String DATA=eutil.getDataFromExcel("contacts", 1, 1);
			System.out.println(DATA);
		}


}
