import ch1.*;
import ch2.*;

public class Main {
  
  public static void main(String[] args) {
    //  runCh1();
    
    runCh2();    
  }
  
  public static void runCh2() {
    new RemoveDuplicates().run();
  }
  
  public static void runCh1() {
    new AllUnique().run();
    
    new Permutations().run();
    
    new ReplaceSpaces().run();
    
    new Compress().run();
    
    new RotateMatrix().run();
    
    new BlankMatrix().run();
    
    new IsRotation().run();    
  }
}