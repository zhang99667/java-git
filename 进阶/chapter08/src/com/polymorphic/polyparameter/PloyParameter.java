package com.polymorphic.polyparameter;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

public class PloyParameter {
    public static void main(String[] args) {
        Test test = new Test();
        Worker tom = new Worker("tom", 2500);
        Manager mark_zhang = new Manager("mark zhang", 30000, 100000);
        test.showEmpAnnual(tom);
        test.showEmpAnnual(mark_zhang);
        test.testWork(tom);
        test.testWork(mark_zhang);
    }
}

class Test {
    // 实现获取任何员工对象的年工资
    public void showEmpAnnual(Employee e) {
        System.out.println(e.getAnnual());
    }

    public void testWork(Employee e) {
        if (e instanceof Worker)
            ((Worker) e).work();// 向下转型
        else if (e instanceof Manager)
            ((Manager) e).manage(); // 向下转型
    }
}
