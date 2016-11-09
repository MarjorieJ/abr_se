package abr_se;

import java.util.List;

public class ABR {
	private int nbElements;
	private Noeud root;
	private List<Noeud> tree;
	
	public ABR(Noeud n, int nbElem){	
		this.nbElements=nbElem;
		this.root=n;
		tree.add(this.root);
	}
	
	public ABR(){
		this.nbElements=0;
		this.root=null;
	}
	
	public int nbElements(){
		return this.nbElements;
	}
	
	public boolean isEmpty(){
		return (this.nbElements==0);
	}
	
	public void insert(Noeud n){

		if (this.isEmpty()){
			this.root=n;
			return;
		}
		n.addParent(root);
		while (root.hasChildren()){
			
		}
			
		
	}
	
	
}
