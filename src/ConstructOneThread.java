/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/16/12
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

/**
 *This thread runs every 10 seconds and determines if the
 * current user village is under attack.
 */
public class ConstructOneThread implements Runnable {
   public static boolean constructionFlagOne = false;


    ConstructOneThread() {
        //create the new thread
        Thread constructOne = new Thread(this);


        //start the thread
        constructOne.start();
    }

    public void run() {
        while(true) {
            try {
                if(Village.totalOne == 0) {
                    constructionFlagOne = false;
                    Thread.sleep(10000);
                }
                while(constructionFlagOne) {

                    Village.constructionOneTimer();
                    //Thread.sleep(10000);
                }
            }
            catch(NoSuchElementException e) {
            }
            catch (InterruptedException e) {
            }
            catch(StaleElementReferenceException e) {
            }
        }
    }
}