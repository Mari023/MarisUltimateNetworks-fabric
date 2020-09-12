package de.mari_023.fabric.marisultimatenetworks.blockentity;

import de.mari_023.fabric.marisultimatenetworks.MarisUltimateNetworks;
import team.reborn.energy.EnergySide;

public class EnergyInputBlockEntity extends BlockEntityBasic {
    public EnergyInputBlockEntity() {
        super(MarisUltimateNetworks.EnergyInputBlockEntity);
    }

    public double getStored(EnergySide energySide) {
        return 0;
    }
}