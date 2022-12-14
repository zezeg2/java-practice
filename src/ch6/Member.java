package ch6;

public class Member {
    private String id;
    private int password;
    private String name;

    private int age;

    public Member() {
    }
    public void insert(String id, int password, String name, int age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public void login(String id, int password){
        if (!id.equals(this.id)) {
            System.out.println("Not Found Id");
            return;
        }
        if (password != this.password) {
            System.out.println("Not Found Password");
            return;
        }
        System.out.println("Login Success");
    }

    public void getMyInfo(){
        String info = """
                ID       : %s
                Password : %d
                Name     : %s
                Age      : %d
                """.formatted(id,password,name,age);
        System.out.println(info);
    }

    public String logout(){
        System.out.println("Successfully Logout");
        id = null;
        password = -1;
        name = null;
        age = -1;
        return id;
    }
}
