import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

/**
 * This thread runs every 5 seconds. The purpose of this thread
 * is to use information gathered when the user logs in or
 * selects another village that they own to determine if the user
 * has the required resources (wood, clay, iron) to construct
 * a building.
 *
 * If the user has the required resources the build button
 * for a building will be lit up, if the user does not have
 * the required resources then the button will be greyed out.
 *
 * The buttons will automatically turn grey or light up if the
 * user doesn't have enough resources or gains the right amount
 * of resources.
 */
public class BuildingResourceCostThread implements Runnable {


    BuildingResourceCostThread() {

        //make a new thread
        Thread buildingResourceCostThread = new Thread(this);

        //start the new thread
        buildingResourceCostThread.start();
    }

    public void run() {
        try {
            while(true) {

                //if the village HQ wood cost is > 0 then set hasCost flag as true
                if(Village.villageHQWoodCost > 0) {
                    Village.villageHQHasCost = true;

                    //determines if the user has enough resources to build the village HQ
                    //if not then the button is greyed
                    if(Village.villageHQWoodCost > Village.currentWood || Village.villageHQClayCost > Village.currentClay || Village.villageHQIronCost > Village.currentIron) {
                        BuildPanel.setVillageHQButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setVillageHQButtonTrueOrFalse(false);
                }


                //if the barracks wood cost is > 0 then set hasCost flag as true
                if(Village.barracksWoodCost > 0) {
                    Village.barracksHasCost = true;

                    //determines if the user has enough resources to build the barracks
                    //if not then the button is greyed
                    if(Village.barracksWoodCost > Village.currentWood || Village.barracksClayCost > Village.currentClay || Village.barracksIronCost > Village.currentIron) {
                        BuildPanel.setBarracksButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setBarracksButtonTrueOrFalse(false);
                }


                //if the stable wood cost is > 0 then set hasCost flag as true
                if(Village.stableWoodCost > 0) {
                    Village.stableHasCost = true;

                    //determines if the user has enough resources to build the stable
                    //if not then the button is greyed
                    if(Village.stableWoodCost > Village.currentWood || Village.stableClayCost > Village.currentClay || Village.stableIronCost > Village.currentIron) {
                        BuildPanel.setStableButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setStableButtonTrueOrFalse(false);
                }


                //if the WorkShop wood cost is > 0 then set hasCost flag as true
                if(Village.workShopWoodCost > 0) {
                    Village.workShopHasCost = true;

                    //determines if the user has enough resources to build the workshop
                    //if not then the button is greyed
                    if(Village.workShopWoodCost > Village.currentWood || Village.workShopClayCost > Village.currentClay || Village.workShopIronCost > Village.currentIron) {
                        BuildPanel.setWorkShopButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setWorkShopButtonTrueOrFalse(false);
                }


                //if the smithy wood cost is > 0 then set the hasCost flag as true
                if(Village.smithyWoodCost > 0) {
                    Village.smithyHasCost = true;

                    //determines if the user has enough resources to build the smithy
                    //if not then the button is greyed
                    if(Village.smithyWoodCost > Village.currentWood || Village.smithyClayCost > Village.currentClay || Village.smithyIronCost > Village.currentIron) {
                        BuildPanel.setSmithyButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setSmithyButtonTrueOrFalse(false);
                }


                //if the market wood cost is > 0 then set the hasCost flag as true
                if(Village.marketWoodCost > 0) {
                    Village.marketHasCost = true;

                    //determines if the user has enough resources to build the market
                    //if not then the button is greyed
                    if(Village.marketWoodCost > Village.currentWood || Village.marketClayCost > Village.currentClay || Village.marketIronCost > Village.currentIron) {
                        BuildPanel.setMarketButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setMarketButtonTrueOrFalse(false);
                }


                //if the timber wood cost is > 0 then set the hasCost flag as true
                if(Village.timberWoodCost > 0) {
                    Village.timberHasCost = true;

                    //determines if the user has enough resources to build the timber
                    //if not then the button is greyed
                    if(Village.timberWoodCost > Village.currentWood || Village.timberClayCost > Village.currentClay || Village.timberIronCost > Village.currentIron) {
                        BuildPanel.setTimberButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setTimberButtonTrueOrFalse(false);
                }


                //if the clay wood cost is > 0 then set the hasCost flag as true
                if(Village.clayWoodCost > 0) {
                    Village.clayHasCost = true;

                    //determines if the user has enough resources to build the clay
                    //if not then grey the button
                    if(Village.clayWoodCost > Village.currentWood || Village.clayClayCost > Village.currentClay || Village.clayIronCost > Village.currentIron) {
                        BuildPanel.setClayButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setClayButtonTrueOrFalse(false);
                }


                //if the iron wood cost is > 0 then set the hasCost flag as true
                if(Village.ironWoodCost > 0) {
                    Village.ironHasCost = true;

                    //determines if the user has enough resources to build the iron
                    //if not then grey the button
                    if(Village.ironWoodCost > Village.currentWood || Village.ironClayCost > Village.currentClay || Village.ironIronCost > Village.currentIron) {
                        BuildPanel.setIronButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setIronButtonTrueOrFalse(false);
                }


                //if the farm wood cost is > 0 then set the hasCost flag as true
                if(Village.farmWoodCost > 0) {
                    Village.farmHasCost = true;

                    //determines if the user has enough resources to build the farm
                    //if not then grey the button
                    if(Village.farmWoodCost > Village.currentWood || Village.farmClayCost > Village.currentClay || Village.farmIronCost > Village.currentIron) {
                        BuildPanel.setFarmButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setFarmButtonTrueOrFalse(false);
                }


                //if the warehouse wood cost is > 0 then set the hasCOst flag as true
                if(Village.wareHouseWoodCost > 0) {
                    Village.wareHouseHasCost = true;

                    //determines if the user has enough resources to build the warehouse
                    //if not then grey the button
                    if(Village.wareHouseWoodCost > Village.currentWood || Village.wareHouseClayCost > Village.currentClay || Village.wareHouseIronCost > Village.currentIron) {
                        BuildPanel.setWareHouseButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setWareHouseButtonTrueOrFalse(false);
                }


                //if the wall wood cost > 0 then set the hasCost flag as true
                if(Village.wallWoodCost > 0) {
                    Village.wallHasCost = true;

                    //determines if the user has enough resources to build the wall
                    //if not then grey the button
                    if(Village.wallWoodCost > Village.currentWood || Village.wallClayCost > Village.currentClay || Village.wallIronCost > Village.currentIron) {
                        BuildPanel.setWallButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setWallButtonTrueOrFalse(false);
                }


                //if the academy wood cost > 0 then set the hasCost flag as true
                if(Village.academyWoodCost > 0) {
                    Village.academyHasCost = true;

                    //determines if the user has enough resources to build the academy
                    //if not then grey the button
                    if(Village.academyWoodCost > Village.currentWood || Village.academyClayCost > Village.currentClay || Village.academyIronCost > Village.currentIron) {
                        BuildPanel.setAcademyButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setAcademyButtonTrueOrFalse(false);
                }


                //if the hidingplace wood cost  > 0 then set the hasCost flag as true
                if(Village.hidingPlaceWoodCost > 0) {
                    Village.hidingPlaceHasCost = true;

                    //determines if the user has enough resources to build the hidingplace
                    //if not then grey the button
                    if(Village.hidingPlaceWoodCost > Village.currentWood || Village.hidingPlaceClayCost > Village.currentClay || Village.hidingPlaceIronCost > Village.currentIron) {
                        BuildPanel.setHidingPlaceButtonTrueOrFalse(false);
                    }
                }
                //just grey the button here so that the button
                //will grey faster by not having to run through the whole loop
                else {
                    BuildPanel.setHidingPlaceButtonTrueOrFalse(false);
                }



                //check if the village HQ costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.villageHQWoodCost <= Village.currentWood && Village.villageHQClayCost <= Village.currentClay && Village.villageHQIronCost <= Village.currentIron
                && Village.villageHQHasCost == true) {
                    BuildPanel.setVillageHQButtonTrueOrFalse(true);
                }
                //sets the button to grey otherwise
                else {
                    BuildPanel.setVillageHQButtonTrueOrFalse(false);
                }


                //check if the barracks costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.barracksWoodCost <= Village.currentWood && Village.barracksClayCost <= Village.currentClay && Village.barracksIronCost <= Village.currentIron
                && Village.barracksHasCost == true) {
                    BuildPanel.setBarracksButtonTrueOrFalse(true);
                }
                //sets the button to grey otherwise
                else {
                    BuildPanel.setBarracksButtonTrueOrFalse(false);
                }


                //check if the stable costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.stableWoodCost <= Village.currentWood && Village.stableClayCost <= Village.currentClay && Village.stableIronCost <= Village.currentIron
                && Village.stableHasCost == true) {
                    BuildPanel.setStableButtonTrueOrFalse(true);
                }
                //sets the button to grey otherwise
                else {
                    BuildPanel.setStableButtonTrueOrFalse(false);
                }


                //check if the workshop costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.workShopWoodCost <= Village.currentWood && Village.workShopClayCost <= Village.currentClay && Village.workShopIronCost <= Village.currentIron
                && Village.workShopHasCost == true) {
                    BuildPanel.setWorkShopButtonTrueOrFalse(true);
                }
                //sets the button to grey otherwise
                else {
                    BuildPanel.setWorkShopButtonTrueOrFalse(false);
                }


                //check if the smithy costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.smithyWoodCost <= Village.currentWood && Village.smithyClayCost <= Village.currentClay && Village.smithyIronCost <= Village.currentIron
                && Village.smithyHasCost == true) {
                    BuildPanel.setSmithyButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setSmithyButtonTrueOrFalse(false);
                }


                //check if the market costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.marketWoodCost <= Village.currentWood && Village.marketClayCost <= Village.currentClay && Village.marketIronCost <= Village.currentIron
                && Village.marketHasCost == true) {
                    BuildPanel.setMarketButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setMarketButtonTrueOrFalse(false);
                }


                //check if the timber costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.timberWoodCost <= Village.currentWood && Village.timberClayCost <= Village.currentClay && Village.timberIronCost <= Village.currentIron
                && Village.timberHasCost == true) {
                    BuildPanel.setTimberButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setTimberButtonTrueOrFalse(false);
                }


                //check if the clay costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.clayWoodCost <= Village.currentWood && Village.clayClayCost <= Village.currentClay && Village.clayIronCost <= Village.currentIron
                && Village.clayHasCost == true) {
                    BuildPanel.setClayButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setClayButtonTrueOrFalse(false);
                }


                //check if the iron costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.ironWoodCost <= Village.currentWood && Village.ironClayCost <= Village.currentClay && Village.ironIronCost <= Village.currentIron
                && Village.ironHasCost == true) {
                    BuildPanel.setIronButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setIronButtonTrueOrFalse(false);
                }


                //check if the farm costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.farmWoodCost <= Village.currentWood && Village.farmClayCost <= Village.currentClay && Village.farmIronCost <= Village.currentIron
                && Village.farmHasCost == true) {
                    BuildPanel.setFarmButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setFarmButtonTrueOrFalse(false);
                }


                //check if the warehouse costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.wareHouseWoodCost <= Village.currentWood && Village.wareHouseClayCost <= Village.currentClay && Village.wareHouseIronCost <= Village.currentIron
                && Village.wareHouseHasCost == true) {
                    BuildPanel.setWareHouseButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setWareHouseButtonTrueOrFalse(false);
                }


                //check if the wall costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.wallWoodCost <= Village.currentWood && Village.wallClayCost <= Village.currentClay && Village.wallIronCost <= Village.currentIron
                && Village.wallHasCost == true) {
                    BuildPanel.setWallButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setWallButtonTrueOrFalse(false);
                }


                //check if the academy costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.academyWoodCost <= Village.currentWood && Village.academyClayCost <= Village.currentClay && Village.academyIronCost <= Village.currentIron
                && Village.academyHasCost == true) {
                    BuildPanel.setAcademyButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setAcademyButtonTrueOrFalse(false);
                }


                //check if the hidingplace costs are lower than current village resource levels
                //if they are then the button is lit up
                if(Village.hidingPlaceWoodCost <= Village.currentWood && Village.hidingPlaceClayCost <= Village.currentClay && Village.hidingPlaceIronCost <= Village.currentIron
                && Village.hidingPlaceHasCost == true) {
                    BuildPanel.setHidingPlaceButtonTrueOrFalse(true);
                }
                //sets the button grey otherwise
                else {
                    BuildPanel.setHidingPlaceButtonTrueOrFalse(false);
                }

                //make the thread sleep for 5 seconds
                Thread.sleep(5000);
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
