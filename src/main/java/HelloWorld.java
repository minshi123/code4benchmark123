/** Hello world */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class HelloWorld {
  void dummy() {
    // do nothing here
  }
  
 void s(){
   Strings = null;
   System.out.println(s.length());
 }

  void doesNotCauseNPE() {
    Pointers.A a = Pointers.mayReturnNull(10);
    a.method(); // ok
  }

  void mayCauseNPE() {
    Pointers.A a = Pointers.mayReturnNull(-10);
    a.method(); // defect 1
  }

  void alwaysCauseNPE() {
    String s = null;
    System.out.println(s.length()); // defect 2
  }

  void forwardInferNPE(String s) {
    if (s != null) {
      dummy();
    }
    System.out.println(s.length()); // defect 3
  }

  void reverseInferNPE(String s) {
    System.out.println(s.length()); // defect 4
    if (s != null) {
      dummy();
    }
  }

  void mayLeakResource() throws IOException {
    OutputStream stream = Resources.allocateResource();
    if (stream == null) {
      return;
    }

    try {
      stream.write(12);
    } finally {
      // FIXME: should close the stream
    }
  }

  /**
   * This method should be rewritten with nested try { ... } finally { ... } statements, or the
   * possible exception raised by fis.close() should be swallowed.
   */
  void twoResources() throws IOException {
    FileInputStream fis = null;
    FileOutputStream fos = null;
    try {
      fis = new FileInputStream(new File("whatever.txt"));
      fos = new FileOutputStream(new File("everwhat.txt"));
      fos.write(fis.read());
    } finally {
      if (fis != null) {
        fis.close();
      }
      if (fos != null) {
        fos.close();
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
