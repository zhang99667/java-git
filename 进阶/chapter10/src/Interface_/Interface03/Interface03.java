package Interface_.Interface03;

public class Interface03 {
    public static void main(String[] args) {
        MySQLDB mySQLDB = new MySQLDB();
        OracleDB oracleDB = new OracleDB();

        t(mySQLDB);
        t(oracleDB);
    }

    public static void t(DBInterface db){
        db.connect();
        db.close();
    }
}