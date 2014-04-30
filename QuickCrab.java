import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
public class QuickCrab extends CrabCritter{
    public ArrayList<Locations> getMoveLocations(){
	ArrayList<Locations> Locate = new ArrayList<Locations>();
	TwoSpacesAway(Locate, 0);
	TwoSpacesAway(Locate, 180);
	if (Locate.size() == 0){
	    return super.getMoveLocations();
	}
	else {
	    return locs;
	}
    }
    public void TwoSpacesAway(ArrayList<Locations> Locate, int direction){
	Grid need = getGrid();
	Location Bob = getLocation().getAdjacentLocation(direction);
	if (need.isValid(Bob) && need.get(Bob) == null){
	    Location Bobv2 = Bob.getAdjacentLocation(direction);
	    if (need.isValid(Bobv2) && need.get(Bobv2) == null){
		Locate.add(Bobv2);
	    }
	}
    }
}
