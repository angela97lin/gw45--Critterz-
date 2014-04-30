import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import java.awt.Color;
import java.util.ArrayList;
public class BlusterCritter extends Critter{
    private int Courage;
    private static final int COLOR_CHANGE = 0.05;
    public BlusterCritter(int c){
	Courage = c;
    }
    public ArrayList<Actor> getActors(){
	ArrayList<Actor> Square = new ArrayList<Actor>();
	Location Bob = getLocation();
	for (int i = Bob.getRow()-2; i <Bob.getRow()+2; i++){
	    for (int j = Bob.getCol()-2; j< Bob.getCol()+2; j++){
		Location temp = new Location(i,j);
		if (getGrid().isValid(temp)){
		    Actor temp2 = getGrid().get(temp);
		    if (temp2 != null && temp2 != this){
			Square.add(temp2);
		    }
		}
	    }
	}
	return Square;
    }
    public void processActors(ArrayList<Actor> Bob){
	int CritterCount;
	for (Actor a: Bob){
	    if (a instanceof Critter){
		CritterCount += 1;
	    }
	}
	if (CritterCount >= Courage){
	    Darken();
	}
	else{
	    Lighten();
	}
    }
    public void Darken(){
	Color a = getColor();
	int red = (int)(getRed() * (1-COLOR_CHANGE));
	int green = (int)(getGreen() *( 1-COLOR_CHANGE));
	int blue = (int)(getBlue() * (1-COLOR_CHANGE));
	setColor(new Color(red,green,blue));
    }
    public void Lighten(){
	Color a = getColor();
	int red = (int)(getRed() * (1-COLOR_CHANGE));
	int green = (int)(getGreen() *( 1-COLOR_CHANGE));
	int blue = (int)(getBlue() * (1-COLOR_CHANGE));
	if (red > 255){
	    red = 255;
	}
	if (green > 255){
	    green = 255;
	}
	if (blue > 255){
	    blue = 255;
	}
	setColor(new Color(red,green,blue));
    }
}
