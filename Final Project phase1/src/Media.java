
abstract class Media implements Comparable <Media> {
protected String title;
protected int copiesAvailable;
Media(String title , int copiesAvailable){
	this.title=title;
	this.copiesAvailable=copiesAvailable;
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


public int compareTo(Media e){
return this.getTitle().compareTo(e.getTitle());
}
}
