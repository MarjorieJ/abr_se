package abr_se;

import java.lang.Integer;
import java.util.List;

import sun.security.util.Length;

public class ABR {
	private int nbElements;
	private Noeud root;

	
	public ABR(Noeud n){	
		this.nbElements=1;
		this.root=n;

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
	
	public Noeud getRoot(){
		return this.root;
	}
	
	public void insert(Noeud n){ //on suppose que la clé de n n'est pas encore dans ABR

		if (this.isEmpty()){
			this.root=n;
			return;
		}

		Noeud parent=root;//Ce sera le parent provisoire en attendant de trouver le bon
		
		while (((parent.getChildL()!=null)&(n.getCle()<parent.getCle()))||((parent.getChildR()!=null)&(n.getCle()>parent.getCle()))){
			
			if (n.getCle()>parent.getCle()){
				parent=parent.getChildR();
			}
			else {
				parent=parent.getChildL();
			}
		}
		//en sortant de la boucle on a trouvé le bon parent
		

		n.addParent(parent); //on met à jour le parent du noeud
		if (n.getCle()>parent.getCle()){ //on met à jour les enfants du parent
			parent.addChildR(n);
		}else {parent.addChildL(n);
		}
		nbElements+=1;
	}
	
	public boolean contains(int n){
		Noeud pointeur=this.root;
		if (n==pointeur.getCle()){
			return true;
		}
		
		while (pointeur.hasChildren()){
			if (n>pointeur.getCle()){
				pointeur=pointeur.getChildR();
			}else{
				pointeur=pointeur.getChildL();
			}
			if (pointeur==null){
				return false;
			}
			if (pointeur.getCle()==n){
				return true;
			}
		}		
		return false;
	}
	
	public void toList(List<Integer> l){
		for (int i=0;i<l.size();i++){
			Noeud n=new Noeud(l[i]);
			this.insert(n);
		}
		
	}
	
	
}
