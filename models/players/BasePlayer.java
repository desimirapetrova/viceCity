package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;

import static viceCity.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player{
    private String name;
    private int lifePoints;
    private Repository<Gun>gunRepository;
    protected BasePlayer(String name,int lifePoints){
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository=new GunRepository();
        //todo
    }
    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name==null||name.trim().isEmpty()){
            throw new NullPointerException(NAME_NULL);
        }
        this.name = name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        if(lifePoints<0){
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public boolean isAlive() {
        return lifePoints > 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {

        return this.gunRepository;
        //TODO
    }

    @Override
    public void takeLifePoints(int points) {

        if(points<=lifePoints) {
            this.lifePoints -= points;
        }else
        {
            lifePoints=0;
        }
    }
}
