package Abstract_;
/*

    编写一个Employee类，声明为抽象类，包含如下三个属性：name,id,salary
    提供必要的构造器和抽象方法：work()。
    对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
    请使用继承的思想，设计CommonEmployee类和Manager类
    要求类中提供必要的方法进行属性访问，实现work()
    提示：经理/普通员工名字工作中…
 */

public class AbstractExercise01 {
    public static void main(String[] args) {
        Manage jack = new Manage("jack", 1, 50000, 8000);
        jack.work();

        CommonEmployee tom = new CommonEmployee("tom", 2, 20000);
        tom.work();
    }
}

// 员工类
abstract class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.setName(name);
        this.setId(id);
        this.setSalary(salary);
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

// 普通员工
class CommonEmployee extends Employee {
    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("普通员工 " + this.getName() + " 工作中...");
    }
}

// 经理
class Manage extends Employee {
    private double bonus;

    public Manage(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.setBonus(bonus);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理 " + this.getName() + " 工作中..."+"奖金 "+this.getBonus());
    }
}