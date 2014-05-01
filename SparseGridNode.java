public class SparseGridNode{
    private Object Occupant;
    private SparseGridNode next;
    private int col;
    public SparseGridNode(Object Cargo, int column, SparseGridNode a){
        Occupant = Cargo;
	col = column;
	next = a;
    }
    public Object getValue(){
	return Occupant;
    }
    public SparseGridNode getNext(){
	return next;
    }
    public int getCol(){
	return col;
    }
    public void setNext(SparseGridNode x){
	next = x;
    }
    public void setValue(Object newVal){
	Occupant = newVal;
    }
}
