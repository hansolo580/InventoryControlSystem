package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class InHouse extends Part{

    private final IntegerProperty machineID;

    public InHouse() {
        super();
        machineID = new SimpleIntegerProperty();
    }

    public void setMachineID(int machineID) {
        this.machineID.set(machineID);
    }

    public int getMachineID() {
        return this.machineID.get();
    }

}
