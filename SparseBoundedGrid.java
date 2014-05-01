import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location; 
// Why is this a more time-efficient implementation than BoundedGrid?
// This has a more effiecient OccupiedLocations method that is linear and based on number of Occupees while BoundedGrid is based off the dimensions. 
public class SparseBoundedGrid extends AbstractGrid{
    private int numCols,numRows;
    private SparseGridNode[] theGrid;
    public SparseBoundedGrid(int row, int col){
	if (row <= 0 || col <= 0){
	    System.out.println("Incorrect parameters");
	}
	else {
	    numCols = col;
	    numRows = row;
	    theGrid = new SparseGridNode[row];
	    for (int i = 0; i < theGrid.length; i++){
		SpareGridNode temp;
		for (int j = 0; j < col; j++){
		    if (j == 0){
			theGrid[i] = new SparseGridNode(null,col,null);
			temp = theGrid[i];
		    }
		    else {
			temp.setNext(new SparseGridNode(null,col,null));
		    }
		}
	    }
	}
    }
    public boolean isValid(Location B){
	int a = B.getCol();
	inb b = B.getRow();
	if (a > numRows || b > numCols){
	    return false;
	}
	return true;
    }
    public int getNumRows(){
	return numRows;
    }
    public int getNumCols(){
	return numCols;
    }
    public E put(Location loc, E x){
	if (!isValid(loc)){
	    return null;
	}
        int Row = loc.getRow();
	SparseGridNode ThisNode = theGrid[Row];
        int Col = loc.getCol();
	for (int i = 0; i < Col; i++){
	    ThisNode = ThisNode.getnext();
	}
	E Value = (E)(ThisNode.getValue());
	ThisNode.setValue(x);
	return Value;
    }
	
	
	
    public E get(Location l){
	if (!isValid(l)){
	    return null;
	}
	int Column = l.getCol();
	int Row = l.getRow();
	SparseGridNode OneanOnly = theGrid[Row];
	while (OneanOnly != null){
	    if (OneanOnly.getCol() == Column){
		return (E)(OneanOnly.getValue());
	    }
	    else {
		OneanOnly =OneanOnly.getNext();
	    }
	}
	return null;
    }
    public E remove(Location l){
	if (!isValid(l)){
	    return null;
	}
	int Column = l.getCol();
	int Row = l.getRow();
	SparseGridNode OneanOnly = theGrid[Row];
	for (int i = 0; i < Column; i++){
	    OneanOnly = OneanOnly.getNext();
	}
	E retVal = OneanOnlygetValue();
	OneanOnly.setNextValue(null);
	return retVal;
    }
    public ArrayList<Location> getOccupiedLocations(){
	ArrayList<Location> retVal = new ArrayList<Location>();
	SparseGridNode temp;
	for (int i = 0; i <theGrid.length; i++){
	    temp = theGrid[i];
	    for (int j = 0; j < numCols; j++){
		if (temp.getValue() != null){
		    retVal.add(new Location(i,j));
		}
		temp = temp.getnext();
		
	    }
	}
	return retVal;
    }

}
