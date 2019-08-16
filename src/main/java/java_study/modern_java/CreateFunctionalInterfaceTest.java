package java_study.modern_java;

public class CreateFunctionalInterfaceTest {
    public static void main(String[] args) {
        println(1L, "Kevin", "test@email.com", (id, name, email) -> "User info: ID= " + id + ", Name= " + name + ", email= " + email);
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
        System.out.println(function.apply(t1, t2, t3));
    }
}

@FunctionalInterface
interface Function3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}




