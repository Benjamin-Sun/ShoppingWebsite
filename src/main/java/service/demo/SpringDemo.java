package service.demo;

public class SpringDemo {
    private int no;
    private String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpringDemo(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void say(){
        System.out.println("hellp spring");
    }
}