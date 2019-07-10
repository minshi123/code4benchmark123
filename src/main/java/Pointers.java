/**
 * Created by supremeGoodness on 10/7/2019.
 */
public class Pointers {
    public static class A{
        public void method(){
        }
    }

    public static A mayReturnNull(int i){
        if (i > 0){
            return new A();
        }
        return null;
    }
}
