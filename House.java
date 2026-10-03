class House {

    private double energyConsumption;

    /**
     * Constructor that creates a House object with energyConsumption attribute.
     * @param inputValue is the parameter which receives the consumption value to create the object.
     */

    public House(double inputValue) {

        this.energyConsumption = inputValue;
    }

    /**
     * Getter-method which retrieves the encapsulated value of the attribute of energyConsumption.
     * @return - by retrieving the value of energyConsumption, its value is returned.
     */

    public double getEnergyConsumption() {

        return energyConsumption;
    }

    /**
     * Setter-method that updates the value of the private variable energyConsumption.
     * @param newEnergyConsumption is the parameter that the setter-method receives and places it into the object's variable.
     */

    public void setEnergyConsumption(double newEnergyConsumption) {
        this.energyConsumption = newEnergyConsumption;
    }

}