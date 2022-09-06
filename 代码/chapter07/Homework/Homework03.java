package chapter07.Homework;

public class Homework03 {
    public static void main(String[] args) {
        Book book1 = new Book("特朗普自传", 155.5);
        book1.info();
        book1.updatePrice();
        book1.info();
        
        Book book2 = new Book("心若菩提", 100.5);
        book2.info();
        book2.updatePrice();
        book2.info();
    }
}

// 编写类Book,定义方法updatePrice,实现更改某本书的价格
// 具体：如果价格>150，则更改为150，如果价格>100，更改为100，否则不变
class Book {
    String name;
    double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void updatePrice() {
        if (this.price > 150)
            this.price = 150;
        else if (this.price > 100 && this.price <= 150)
            this.price = 100;
    }

    public void info() {
        System.out.println("book's name=" + this.name + "book's price=" + this.price);
    }
}