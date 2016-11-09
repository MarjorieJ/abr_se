package abr_se;

public class Noeud {
	private int cle;
	private Noeud parent;
	private Noeud childLeft;
	private Noeud childRight;

	
	public Noeud(int cle){
		this.cle=cle;
		this.parent=null;
		this.childLeft= null;
		this.childRight= null;
	}
	
	public void addParent(Noeud n){
		this.parent=n;
	}
	
	public void addChildL(Noeud n){
		this.childLeft=n;
	}
	
	public void addChildR(Noeud n){
		this.childRight=n;
	}
	
	public boolean hasChildren(){
		return ((this.childRight!=null)||(this.childLeft!=null));
		
	}
	
	public int getCle(){
		return this.cle;
	}
	
	public Noeud getChildL(){
		return this.childLeft;
	}
	public Noeud getChildR(){
		return this.childRight;
	}
	
	public Noeud getParent(){
		return this.parent;
	}
}

