package ch4;

public class ForTestRunner {
    public static void main(String[] args) {
        String s1 = "java";
        String s2 = "java";
        String s3 = new String("java");
        String s4 = new String("java");


        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));


        s2 = "edited";
        s3 = new String("edited");
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));
        int[][] matrix = new int[2][3];
        System.out.println(matrix);

    }

}
