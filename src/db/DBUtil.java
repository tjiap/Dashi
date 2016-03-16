package db;

public class DBUtil {
	private static final String HOSTNAME = "localhost";
    private static final String PORT_NUM = "3306";
    private static final String DB_NAME = "laiproject";//the database created in MAMP
    private static final String USERNAME = "root";//MAMP默认
    private static final String PASSWORD = "root";//MAMP
    public static final String URL; //static可直接访问URL（DBUtil.URL）,不需要新建一个DBUtil再访问；final不可更改变量值
    static {
   	 URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT_NUM + "/" + DB_NAME
   			 + "?user=" + USERNAME + "&password=" + PASSWORD;
    }//connect URL string

}
