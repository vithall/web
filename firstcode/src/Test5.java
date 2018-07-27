public class Test5 {
    public static void main(String[] args) {
        invoke(null);
    }
    private static void invoke(Object obj) {
        System.out.println("Object");
    }
    private static void invoke(int[] nums) {
        System.out.println("Arrays");
    }
}