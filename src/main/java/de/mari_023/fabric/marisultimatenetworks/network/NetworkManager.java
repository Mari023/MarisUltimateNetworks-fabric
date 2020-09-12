package de.mari_023.fabric.marisultimatenetworks.network;

import java.util.HashMap;
import java.util.UUID;

public class NetworkManager {

    private static final HashMap<UUID, NetworkPlayer> networks = new HashMap<>();

    public static NetworkPlayer getNetworkPlayer(UUID uuid) {
        if (networks.containsKey(uuid)) return networks.get(uuid);
        else {
            return createNetworkPlayer(uuid);
        }
    }

    private static NetworkPlayer createNetworkPlayer(UUID uuid) {
        NetworkPlayer result;
        result = new NetworkPlayer(uuid, 0);
        networks.put(uuid, result);
        return result;
    }
}
