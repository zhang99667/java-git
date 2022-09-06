package Interface_.Interface03;

// A 程序员连接 MySQL
public class MySQLDB implements DBInterface {
    @Override
    public void connect() {
        System.out.println("连接 MySQL");
    }

    @Override
    public void close() {
        System.out.println("断开 MySQL");
    }
}