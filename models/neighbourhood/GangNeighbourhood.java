package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Collection<Gun> guns = mainPlayer.getGunRepository().getModels();
        while((!mainPlayer.isAlive())||civilPlayers.isEmpty()) {
           for (Player civilPlayer : civilPlayers) {
                civilPlayer.takeLifePoints(mainPlayer.getGunRepository().find(this.getClass().getSimpleName()).fire());
           }
       }
    }
}
