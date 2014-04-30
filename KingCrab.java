import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
public class KingCrab extends CrabCritter{
     public int distanceFrom(Location loc1, Location loc2)
    {
	int x1 = loc1.getRow();
	int y1 = loc1.getCol();
	int x2 = loc2.getRow();
	int y2 = loc2.getCol();
	double dist = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)) + .5;
	return (int)Math.floor(dist);
    } 
    public boolean CanIgiveSpace(Actor a){
	for (Location b: getGrid.getEmptyAdjacentLocations(a.getLocation())){
	    if (distanceFrom(getLocation(), b) > 1){
		    a.moveTo(b);
		    return true;
		}
	}
	return false;
    }
    public void processActors(ArrayList<Actor> Bobb){
	for (Actor a : Bobb){
	    if (!(CanIgiveSpace(a))){
		a.removeSelfFromGrid();
	    }
	}
    }
}
		
