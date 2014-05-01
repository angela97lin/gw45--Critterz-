/*****************************************************************
 * Ida Huang --- Team Critterz 
 * git@github.com:angela97lin/gw45-Critterz.git
 * APCS pd 9
 * HW35 -- GridWorld, Part 4
 * 2014-04-30
 *****************************************************************/

/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains chameleon critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class MedusaRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
	for (int i = 1; i < 6; i++){
	    MedusaCritter a = new MedusaCritter();	
	    a.setDirection(0);
	    world.add(new Location(1, i + 1), a);
	}

	Rock f = new Rock();
	f.setDirection(180);
	Bug g = new Bug();
	g.setDirection(180);
	MedusaCritter trick = new MedusaCritter();
	trick.setDirection(180);
	Flower h = new Flower();
	h.setDirection(180);
	
        world.add(new Location(0, 2), f);
        world.add(new Location(0, 3), g);
        world.add(new Location(0, 4), h);
        world.add(new Location(0, 5), trick);

        world.show();
    }
}
