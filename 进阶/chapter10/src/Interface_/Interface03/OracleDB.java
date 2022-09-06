package Interface_.Interface03;

public class OracleDB implements DBInterface
{
    @Override
    public void connect() {
        System.out.println("连接 Oracel");
    }

    @Override
    public void close() {
        System.out.println("断开 Oracel");
    }
}