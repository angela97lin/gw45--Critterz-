import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import java.util.ArrayList;
public class RockHound extends Critter{
    public void processActors(ArrayList<Actor> neighbors){
	for (Actor a : neighbors){
	    if (a instanceof Rock){
		a.removeSelfFromGrid();
	    }
	}
    }
}
