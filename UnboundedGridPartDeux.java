import info.gridworld.grid.*;
import java.util.ArrayList;
// What is the efficiency of the put method when the row and column index values are within the current array bounds?
// O(1)
// What is the efficiency when the array needs to be resized?
// O(n2)
public class UnboundedGridPartDeux<E>{
    private Object[][] DaGrid;
    public UnboundedGridPartDeux(){
	DaGrid = new Object[16][16];
    }
    public int getNumRows(){
	return 0;
    }
    public int getNumCols(){
	return 0;
    }
    public boolean isValid(Location l){
	if (l.getCol() >= 0 && l.getRow() >=0)
	    return true;
	return false;
    }
    public ArrayList<Location> getOccupiedLocations(){
	ArrayList<Location> retVal = new ArrayList<Location>();
	for (int i = 0; i < DaGrid.length; i++){
	    for (int j = 0; j < DaGrid.length; j++){
		if (DaGrid[i][j] != null){
		    retVal.add(new Location(i,j));
		}
	    }
	}
	return retVal;
    }
    public E get(Location l){
	if (!isValid(l))
	    return null;
	else if ( l.getRow() > DaGrid.length || l.getCol() > DaGrid.length)
	    return null;
	else 
	    return (E)(DaGrid[l.getRow()][l.getCol()]);
    }
    public void resize(){
	Object [][] newGrid = new Object[DaGrid.length * 2][DaGrid.length * 2];
	for (int i = 0; i < DaGrid.length; i++){
	    for (int j = 0; j < DaGrid.length; j++){
		newGrid[i][j] = DaGrid[i][j];
	    }
	}
	DaGrid = newGrid;
    }
    public E put(E x, Location loc){
	if (loc.getRow() >= DaGrid.length || loc.getCol() >= DaGrid.length){
	    resize();
	    return put(x,loc);
	}
	else {
	    E returnVal = (E)(DaGrid[loc.getRow()][loc.getCol()]);
	    DaGrid[loc.getRow()][loc.getCol()] = x;
	    return returnVal;
	}
    }
    public E remove(Location loc){
	if (!isValid(loc)){
	    return null;
	}
	int row = loc.getRow();
	int col = loc.getCol();
	E x = (E)(DaGrid[row][col]);
	DaGrid[row][col] = null;
	return x;
    }
}
	    
	    
