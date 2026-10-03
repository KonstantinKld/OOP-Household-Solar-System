class SolarPanel {

private double yearlyEnergyProduction;

    /**
     * Constructor that creates a SolarPanel object with a yearly energy production attribute.
     * @param inputValue is the parameter which receives the production value to create the object.
     */

public SolarPanel(double inputValue) {

    this.yearlyEnergyProduction = inputValue;

}

    /**
     * Getter-method which retrieves the encapsulated value of the attribute of yearlyEnergyProduction.
     * @return - by retrieving the value of yearlyEnergyProduction, its value is returned.
     */

    public double getYearlyEnergyProduction() {

    return yearlyEnergyProduction;
}

    /**
     * Setter-method that updates the value of the private variable yearlyEnergyProduction.
     * @param newYearlyEnergyProduction is the parameter that the setter-method receives and places it into the object's variable.
     */

    public void setYearlyEnergyProduction(double newYearlyEnergyProduction) {
    this.yearlyEnergyProduction = newYearlyEnergyProduction;
}

}