package domain;

public class House {
    private int id; // 编号
    private String name; // 房主姓名
    private String phone; // 房主手机号
    private String address; // 地址
    private double rent; // 租金
    private String state; // 状态（已出租 / 未出租）

    // 全参构造器
    public House(int id, String name, String phone, String address, double rent, String state) {
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
        this.setAddress(address);
        this.setRent(rent);
        this.setState(state);
    }

    // 无ID构造器
    public House(String name, String phone, String address, double rent, String state) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // 为了方便输出对象信息，我们实现一个 toString 方法


    // 输出 House 对象时默认调用 toString 方法
    @Override
    public String toString() {
        return id +
                " \t\t" + name +
                " \t\t" + phone +
                " \t" + address +
                " \t\t" + rent +
                " \t\t" + state;
    }
}
