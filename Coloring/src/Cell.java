
public class Cell {
int type;
boolean visited;
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public boolean isVisited() {
	return visited;
}
public void setVisited(boolean visited) {
	this.visited = visited;
}
public Cell(int type) {
	super();
	this.type = type;
	this.visited = false;
}

}
