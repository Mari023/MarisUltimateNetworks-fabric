package de.mari_023.fabric.marisultimatenetworks.network;

import java.util.UUID;

public class NetworkPlayer {
    private final UUID owner;
    private double Energy;

    public NetworkPlayer(UUID owner, double Energy) {
        this.owner = owner;
        this.Energy = Energy;
    }

    public double getEnergy() {
        return Energy;
    }

    public void setEnergy(double energy) {
        Energy = energy;
    }

    public UUID getOwner() {
        return owner;
    }
}
