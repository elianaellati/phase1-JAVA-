
public class Game extends Media  {
double weight;

Game (String title, int copiesAvailable,double weight){
	super(title,copiesAvailable);
	this.weight=weight;      //constructor with parameters
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}
public int getCopiesAvailable() {
	return copiesAvailable;
}


public void setCopiesAvailable(int copiesAvailable) {
	this.copiesAvailable = copiesAvailable;
}
@Override
public String toString() {
	return ""+title+" "+copiesAvailable+" "+weight+"";
}



}
