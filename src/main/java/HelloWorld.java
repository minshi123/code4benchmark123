/**
 * Hello world
 *
 */

public class HelloWorld {
    void dummy(){
        // do nothing here
    }

    void doesNotCauseNPE(){
        Pointers.A a = Pointers.mayReturnNull(10);
        a.method();
    }

    void mayCauseNPE(){
        Pointers.A a = Pointers.mayReturnNull(-10);
        a.method();
    }

    void alwaysCauseNPE(){
        String s = null;
        System.out.println(s.length());
    }

    void forwardInferNPE(String s){
        if (s != null){
            dummy();
        }
        System.out.println(s.length());
    }

    void reverseInferNPE(String s){
        System.out.println(s.length());
        if (s != null){
            dummy();
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

}
