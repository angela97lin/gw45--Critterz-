/*****************************************************************
 * Ida Huang --- Team Critterz 
 * git@github.com:angela97lin/gw45-Critterz.git
 * APCS pd 9
 * HW35 -- GridWorld, Part 4
 * 2014-04-30
 *
 * class MedusaCritter
 *
 * BEACUASE:
 * We choose MedusaCritter because we thought the specifications
 * sounded both clever and interesting. It follows the myth that
 * if you are gazing directly at her then she would turn you into stone! 
 *
 * SPECIFICATIONS:
 * The Medusa Critter processes neighboring actors by eating them 
 * and replacing them with a rock if they are facing each other.
 * -Class MedusaCritter inherits all methods and variables/constants 
 * of superclasses Critter and Actor.
 * -processActors(Actor a){//Overwrites processActors() of superclass 
 * Critter
 * If the actor's direction is the direction of the medusa's + 180 and
 * the actor is directly in front of the medusa (basically, eye contact 
 * and one space away), the actor in front will be removed and replaced 
 * by a rock UNLESS it is a Critter or Rock/ }
 * -ArrayList getActors(){//Overwrites getActors() of superclass Critter
 * /Only obtains critter directly in front for processing. Dependent on 
 * direction of MedusaCritter executing code. Returns ArrayList consisting 
 * of all objects one space ahead/
 * }
 * 
 * 
 * TEST CASES:
 * T1-There is a non-rock-non-critter actor on the tile ahead facing 
 * the MedusaCritter: act() will remove that actor and replace it with a 
 * rock. The MedusaCritter will then move as specified by the Critter class
 * T2-There is a non-rock-non-critter actor on the tile ahead but not 
 * facing the MedusaCritter: act() will not do anything to the actor. The 
 * MedusaCritter will then move as specified by the Critter class
 * T3-There is a non-rock-non-critter actor on the tile to the right
 * but not facing the MedusaCritter: act() will not do anything to 
 * the actor. The MedusaCritter will then move as specified by the 
 * Critter class
 * T4-There is a rock/critter actor on the tile ahead: act() will not
 * do anything to the actor. The MedusaCritter will then move as 
 * specified by the Critter class
 * T5-All other scenarios: MedusaCritter will behave as a normal 
 * Critter
 *
 * ERRATA:
 * The specs said that to determine if the actor is facing medusa 
 * you check by adding 180 to medusa's direction. However, the Location
 * direction only goes from 0 to 359 so sometimes you will need to check
 * by adding 180 and other times by subtracting 180. 
 *****************************************************************/
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

public class MedusaCritter extends Critter {
    /**
     * A medusa gets the actors in the location immediately in front
     * @return return a list with the actor occupying these locations
     */
    public ArrayList<Actor> getActors() {
	Grid gr = getGrid();
	Location loc = getLocation();

	ArrayList<Actor> actors = new ArrayList<Actor>();
 	int d = Location.AHEAD;
	Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
	if (gr.isValid(neighborLoc)) {
	    Actor a = getGrid().get(neighborLoc);
	    int direc = this.getDirection();
	    // only add if they are making eye contact with each other
	    if (a != null){
		if ( a.getDirection() == direc + 180 || a.getDirection() == direc - 180)
		    actors.add(a);
	    }
	}

	    return actors;
    }

    /**
     * Selects an actor and changes makes it a rock
     * If there are no neighbors, no action is taken.
     */
    public void processActors(ArrayList<Actor> actors)
    {
	//obtain the solo actor there
	int n = actors.size();
	if (n == 0)
	    return;
	for (Actor a: actors) {
	
	    //check if the actor is a critter or rock
	    if (a instanceof Critter ||
		a instanceof Rock) 
		return;
	    // if not then continue to rock-ify the actor
	    else {
		//take the location of it
		Location removable = a.getLocation();

		//replace it with a rock
		Rock dontlookatme = new Rock();
		dontlookatme.putSelfInGrid(getGrid(), removable);

	    }
	}
    } // end processActors


} //end Medusa class

