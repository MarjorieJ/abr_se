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
		Noeud parent=root;//Ce sera le parent provisoire en attendant de trouver le bon
		
		while (parent.hasChildren()){
			if (n.getCle()>parent.getCle()){
				parent=parent.getChildR();
			}else {
				parent=parent.getChildL();
			}
		}
		//en sortant de la boucle on a trouvé le bon parent
		

		n.addParent(parent); //on met à jour le parent du noeud
		if (n.getCle()>parent.getCle()){ //on met à jour les enfants du parent
			parent.addChildR(n);
		}else {parent.addChildL(n);
		}
	}
	
	
}
