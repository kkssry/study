package java_study.desing_pattern.template;

public class Main {
    public static void main(String[] args) {
        AbstGameConnectHelper helper = new DafaultGameConnectHelper();
        helper.requestConnection("아이디 암호 등 접속 정보");
    }
}
