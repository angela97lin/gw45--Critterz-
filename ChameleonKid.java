import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
public class ChameleonKid extends ChameleonCritter{
    public ArrayList<Actor> getActors(){
	ArrayList<Actor> Eligable = new ArrayList<Actor>();
        Location A = getLocation();
	Actor front = getGrid().get(A.getAdjacentLocation(getDirection()));
	Actor back = getGrid().get(A.getAdjacentLocation(getDirection()+180));
	Eligable.add(front);
	Eligable.add(back);
	return Eligable;
    }
}
    
