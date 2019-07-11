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
        a.method(); // ok
    }

    void mayCauseNPE(){
        Pointers.A a = Pointers.mayReturnNull(-10);
        a.method(); // defect 1 
    }

    void alwaysCauseNPE(){
        String s = null;
        System.out.println(s.length()); // defect 2
    }

    void forwardInferNPE(String s){
        if (s != null){
            dummy();
        }
        System.out.println(s.length()); // defect 3
    }

    void reverseInferNPE(String s){
        System.out.println(s.length()); // defect 4
        if (s != null){
            dummy();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

}
