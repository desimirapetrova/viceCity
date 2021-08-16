package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class PlayerRepository  implements Repository<Player> {
    private Collection<Player>models;
    public PlayerRepository(){
        this.models=new LinkedHashSet<>();
    }
    @Override
    public Collection<Player> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Player model) {
        if(!models.contains(model)){
            this.models.add(model);
        }

    }

    @Override
    public boolean remove(Player model) {
        return this.models.remove(model);
    }

    @Override
    public Player find(String name) {
        Player player = null;
        for (Player model : models) {
            if (model.getName().equals(name)) {
                player=model;
            }
        }
        return player;
    }
}
