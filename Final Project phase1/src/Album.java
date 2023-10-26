public class Album extends Media  {
String artist;
String songs;
Album (String title, int copiesAvailable,String artist,String songs){
	super(title,copiesAvailable);
	this.artist=artist;  // constructors with parameters
	this.songs=songs;
}
public String getArtist() {
	return artist;
}
public void setArtist(String artist) {
	this.artist = artist;
}
public String getSongs() {
	return songs;
}
public void setSongs(String songs) {
	this.songs = songs;
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
	return ""+title+" "+copiesAvailable+" "+artist+" "+songs+"";
}



}

