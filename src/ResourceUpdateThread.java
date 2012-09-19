import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;



/**
 * This is the thread for updating resources on the fly to the GUI
 * This thread runs every 10 seconds
 */
public class ResourceUpdateThread implements Runnable {

    ResourceUpdateThread() {

        //create the new thread
        Thread resourceThread = new Thread(this);

        //start the new thread
        resourceThread.start();
    }


    public void run() {
        try {
            while(true) {

                //////update current resources and population///////
                Village.setClayResource();
                Village.setIronResource();
                Village.setWoodResource();
                Village.setPopulation();

                ////////convert current population and resources to ints so they can be compared
                Village.currentPopulation = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"pop_current_label\"]")).getText());
                Village.maxPopulation = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"pop_max_label\"]")).getText());
                Village.currentWood = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"wood\"]")).getText());
                Village.currentClay = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"stone\"]")).getText());
                Village.currentIron = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"iron\"]")).getText());

                //make the thread sleep
                Thread.sleep(10000);
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