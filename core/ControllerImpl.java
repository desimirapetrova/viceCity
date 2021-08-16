package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;
import viceCity.repositories.PlayerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    PlayerRepository players;
    GunRepository guns;
    public ControllerImpl(){
        this.players=new PlayerRepository();
        Player player=new MainPlayer();
        players.add(player);
        this.guns=new GunRepository();
    }
    @Override
    public String addPlayer(String name) {
        CivilPlayer civilPlayer=new CivilPlayer(name);
        players.add(civilPlayer);
        return String.format(PLAYER_ADDED,name);
    }

    @Override
    public String addGun(String type, String name) {

        if(type.equals("Rifle")){
           this.guns.add(new Rifle(name));
        }else if(type.equals("Pistol")){
            this.guns.add(new Pistol(name));
        }else{
            return GUN_TYPE_INVALID;
        }
        return String.format(GUN_ADDED,name,type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if(guns.getModels().isEmpty()){
            return GUN_QUEUE_IS_EMPTY;

        }
       Gun gun=guns.getModels().iterator().next();

       Player player=this.players.find(name);
        if(name.equals("Vercetti")){
            player=this.players.find("Tommy Vercetti");
        }
       if(player==null){

           return CIVIL_PLAYER_DOES_NOT_EXIST;
       }
       if(name.equals("Vercetti")){
           String nameee="Tommy Vercetti";
           player.getGunRepository().add(gun);
           guns.remove(gun);
           return String.format(GUN_ADDED_TO_MAIN_PLAYER,gun.getName(),nameee);
       }
       player.getGunRepository().add(gun);
        guns.remove(gun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER,gun.getName(),name);
    }

    @Override
    public String fight() {
        return null;
    }
}
