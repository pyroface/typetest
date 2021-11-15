import java.time.LocalTime;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class Main {

  //använd static så vi slipper göra ett objekt av det
  //static String[] easyWords = {"apple", "banana", "orange"};
  //static String[] hardWords = {"apple", "banana", "orange"};
  private static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) throws InterruptedException {

    boolean playing = true;

    while(playing) {
      System.out.println("--Speed typing test--");
      System.out.println("1: Easy");
      System.out.println("2: Hard");
      System.out.println("0: quit");

      String input = scan.next();
      int userChoice = 0;
      try {
        userChoice = Integer.parseInt(input);
      } catch (NumberFormatException ne) {
        System.out.println("!! Please use a number !!");
        continue;
      }

      switch(userChoice){
        case 0:
          playing = false;
          break;
        case 1:
          easyGameMode();
          break;
        case 2:
          System.out.println("not yet available");
          break;
        case 3:
          break;
      }
    }//while loop END

  }

  private static void easyGameMode() throws InterruptedException {
    String[] words = {"apple", "pear", "orange"};
    String[] strArray = new String[3];

    System.out.println("Starting soon ... ");
    TimeUnit.SECONDS.sleep(1);
    System.out.println("3");
    TimeUnit.SECONDS.sleep(1);
    System.out.println("2");
    TimeUnit.SECONDS.sleep(1);
    System.out.println("1");
    TimeUnit.SECONDS.sleep(1);
    System.out.println("GO!");

    //timer starts here. Everthing in between counts
    double start = LocalTime.now().toNanoOfDay();
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    String typedWord = "";
    for (int i = 0; i < 3; i++) {
      int x = rand.nextInt(3);
      System.out.print( words[x] + " " );
      typedWord = scan.nextLine();

      if(typedWord.equals(words[x])){
        strArray[i] = words[x];
      }else{
        System.out.println("WRONG");
      }
    }
    double end = LocalTime.now().toNanoOfDay();
    // Timer ends here

    //this block turns the strArray into a single string
    // used below in the wordspermin calculation
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < strArray.length; i++) {
      sb.append(strArray[i]);
    }
    String stringLine = sb.toString();

    double elapsedTime = end - start;
    double seconds = elapsedTime/1000000000.0;
    System.out.println("Time: " + seconds + " seconds");

    // WordsPerMinute: ( a / 5 ) / 1min = b
    // a = characters & b = words per minute
    int numbOfChars = stringLine.length();
    // i must cast with a double so it's accurate and then
    // re-cast outside with an int because of the variable type
    // remember the times 60 so it shows in minutes
    int wordsPerMin = (int) ((((double) numbOfChars / 5) / seconds) * 60 );
    System.out.println("you type on average " + wordsPerMin + " word per minute.");
  }

}
