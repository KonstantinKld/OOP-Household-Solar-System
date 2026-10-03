import java.util.ArrayList;

class EnergySystem implements SolarProductionCalculator {
   private ArrayList<SolarPanel> solarPanels = new ArrayList<SolarPanel>();

    private House house;

    /**
     * Constructor that creates an EnergySystem object.
     * @param house - with house as parameter that it receives, a new EnergySystem object can be created.
     */

    public EnergySystem(House house) {

        this.house = house;
    }

    /**
     * The method addSolarPanel is responsible for adding new solar panels to the solar panel array list.
     * @param panel - the method receives a parameter of a SolarPanel object and adds it to the solar panel array list.
     */

    public void addSolarPanel(SolarPanel panel){

        solarPanels.add(panel);
    }

    /**
     * The method removeSolarPanel removes a SolarPanel object.
     * @param panel - the method receives a parameter of a SolarPanel object and removes it from the solar panel array list.
     */

    public void removeSolarPanel(SolarPanel panel){
        solarPanels.remove(panel);
    }

    /**
     * The method calculateSolarProduction calculates total solar production by going through the loop of all added solar panels and adding together their yearly production.
     * @return - the method returns the total sum as a double.
     */

    public double calculateSolarProduction() {

        double totalSum = 0;

        for (SolarPanel panel : solarPanels) {

            totalSum = totalSum + panel.getYearlyEnergyProduction();

        }

        return totalSum;

    }

    /**
     * The boolean method compareProductionAndConsumption checks whether the house-object's energy consumption is less than or equal to the solar production.
     * @return - thus, the method returns "true" if consumption is less than or equal to production. Conversely, it returns "false".
     */

    public boolean compareProductionAndConsumption(){

        double solarProduction = calculateSolarProduction();

        if (
                house.getEnergyConsumption() <= solarProduction
        )
            return true;
        else
            return false;
    }

    /**
     * Method that calculates the additional amount of solar panels needed
     * in order to cover the house's yearly energy consumption if the current solar production is not sufficient.
     * @param panelProduction is the production value of one solar panel which is used to calculate how many additional solar panels are needed.
     * @return - the calculated amount of additional solar panels needed is returned as a rounded-up number value.
     */
    public int calculateAdditionalPanelsNeeded(double panelProduction) {

        double missingEnergy =
                house.getEnergyConsumption() - calculateSolarProduction();

        double additionalPanels =
                missingEnergy / panelProduction;

        return (int) Math.ceil(additionalPanels);

    }

}