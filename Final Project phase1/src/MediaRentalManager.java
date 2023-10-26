import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaRentalManager implements MediaRentInt {
	ArrayList<Customer> List1 = new ArrayList<>();
	ArrayList<Media> List2 = new ArrayList<>();
	int i = 0;

	public void addCustomer(String name, String address, String plan) {
		try {
			List1.add(new Customer(name, address, plan));//adding name and address and plan to the arraylist
		     
			}
		 catch(IllegalAccessException ex) {
		 System.out.println(ex.getMessage());
			
		 }

	}

	public void addMovie(String title, int copiesAvailable, String rating) {
		
	 try {
		List2.add(new Moviee(title, copiesAvailable, rating));//adding title ,copiesavailbe,rating to media arraylist
	     
		}
	 catch(IllegalAccessException ex) {
		 System.out.println(ex.getMessage());
		
	 }
	
	
	}

	public void addGame(String title, int copiesAvailable, double weight) {
		List2.add(new Game(title, copiesAvailable, weight));
	}

	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		List2.add(new Album(title, copiesAvailable, artist, songs));
	}

	public String getAllCustomersInfo() {
		Collections.sort(List1); // it will go to the customer arraylist and find compareto method so it will order the arraylist according to names in ascending order
		String w = "";
		for (int i = 0; i < List1.size(); ++i) {
			w = w + List1.get(i).toString() + "\n";
		}
		return w;

	}

	public String getAllMediaInfo() {
		Collections.sort(List2); // it will order the media arraylist according to mediatitle in ascending order
		String w = "";
		for (int i = 0; i < List2.size(); ++i) {
			w = w + List2.get(i).toString() + "\n";
		}
		return w;

	}

	public void setLimitedPlanLimit(int value) {
		for (int f = 0; f < List1.size(); ++f) {
			if (List1.get(f).plan.compareToIgnoreCase("limit") == 0) {
				List1.get(f).setValue(value);// if the plan of the user equal limit the user can change the limit by any value
			}
		}
	}

	public boolean addToCart(String customerName, String mediaTitle) {
		for (int j = 0; j < List1.size(); ++j) {

			if (customerName.compareTo(List1.get(j).name) == 0) {
				if (List1.get(j).List.contains(mediaTitle) == false) { // it will check if the name the user enter is in customer arraylist
					                                                   //if it true it will add the media title to list arraylist which belongs to the customer 
					List1.get(j).List.add(mediaTitle);
					System.out.print("it is successfully added to the cart");
					return true;

				}
			}
		}
		return false;
	}

	public boolean removeFromCart(String customerName, String mediaTitle) {
		for (int j = 0; j < List1.size(); ++j) {

			if (customerName.compareTo(List1.get(j).name) == 0) {
				if (List1.get(j).List.contains(mediaTitle) == true) {//the user will remove the media title he added by adding the customer name then the mediatitle
	// first it will check if the user name is in a customer list ,if it is true it will check if media title he added is in list array in order to remove it
					List1.get(j).List.remove(mediaTitle);
					System.out.print("it is successfully removed from the cart");
					return true;

				}
			}
		}
		return false;
		
	}

	public String processRequests() {
		String res="";
		Collections.sort(List1);
		int p;
		int a;
		int j;
		for (int i = 0; i < List1.size(); ++i) {
			p = 0;
			for (int m = 0; m < List1.get(i).List.size(); ++m) {
				for ( j = 0; j < List2.size(); ++j) {
					if ((List1.get(i).List.get(m).compareTo(List2.get(j).getTitle()) == 0)
							&& (List2.get(j).getCopiesAvailable() > 0) && List1.get(i).getPlan().compareToIgnoreCase("limit")==0 && p<List1.get(i).getValue()) {
						List1.get(i).Rented.add(List1.get(i).List.get(m));
						res=res+"Sending"+" "+List1.get(i).Rented.get(p)+" "+"To"+" "+List1.get(i).getName()+"\n";
						a = List2.get(j).getCopiesAvailable();
						List2.get(j).setCopiesAvailable(--a);
						++p;
						}
/*first it will go to customer array in order to get the list(medias each customer chose) then we will get the first media the customer
 * chose in order to check if the media is in media arraylist and we will check each plan for each customer if the plan is limited it will reserved only two places 
 * in rented array ,if it is unlimited it will take all medias in list array after they are checked and added to rented array 
 * if the user reserved a media the number of copies will be decreased 			
 */
					if(List1.get(i).List.get(m).compareTo(List2.get(j).getTitle()) == 0
							&& (List2.get(j).getCopiesAvailable() != 0) && List1.get(i).getPlan().compareToIgnoreCase("unlimit")==0){
						List1.get(i).Rented.add(List1.get(i).List.get(m));
						res=res+"Sending"+" "+List1.get(i).Rented.get(p)+" "+"To"+" "+List1.get(i).getName()+"\n";
						a = List2.get(j).getCopiesAvailable();
						List2.get(j).setCopiesAvailable(--a);
						++p;

				}
				}
			}
		}
		return res;
	}

	public boolean returnMedia(String customerName, String mediaTitle) {
        int c;
		for (int i = 0; i< List1.size(); ++i) {

			if (customerName.compareTo(List1.get(i).getName()) == 0) {
				for (int m = 0; m < List1.get(i).Rented.size(); ++m) {
						if ((List1.get(i).Rented.get(m).compareTo(mediaTitle)) == 0) {
							List1.get(i).Rented.remove(mediaTitle);

							for (int j = 0; j < List2.size(); ++j) {
							if(List1.get(i).Rented.get(m).compareTo(List2.get(j).getTitle())==0) {
							c=List2.get(j).getCopiesAvailable();
							List2.get(j).setCopiesAvailable(++c);
							
						}
							
							}
							System.out.print("it is successfully returned to media ");
							return true;

					}
				}
			}
		}
		return false;
	}
	public ArrayList<String> searchMedia(String title,String rating, String artist,String songs) { 
		 ArrayList<String>media=new ArrayList<>(); 
		 int f=0;
		 for(int j=0;j<List2.size();++j) {
			 
			 
		if(List2.get(j).getTitle().compareToIgnoreCase(title)==0) {
		  media.add(title); 
		  f=1;
		  } 
		if(List2.get(j) instanceof Moviee) {
		  if(((Moviee)List2.get(j)).getRating().compareToIgnoreCase(rating)==0){
		  media.add(List2.get(j).title);
		  f=1;
		  }
		  }
		 if(List2.get(j) instanceof Album) {
		 if(((Album)List2.get(j)).getArtist().compareToIgnoreCase(artist)==0) {
		 media.add(List2.get(j).getTitle()); 
		 } 
		 f=1;
		 } 
		 if(List2.get(j) instanceof Album) {
		 String [] n=((Album)List2.get(j)).getSongs().split(",");
		 String [] b =songs.split(",");
		for(int i=0;i<b.length; ++i) {
			for(int k=0;k<n.length;++k) {
				if(b[i].compareToIgnoreCase(n[k])==0) {
					media.add(List2.get(j).getTitle());
				}
			}
		}
		f=1;
	  } 
		 }
		 if(f==1) {
		 for(int p=0;p<media.size();++p) {
			 for(int x=p+1;x<media.size();++x) {
				 if(media.get(p).compareTo(media.get(x))==0) {
					media.remove(p) ;
				 }
			 }
		 }
		 }
		 else if(f==0) {
			 for(int z=0;z<List2.size();++z) {
				 media.add(List2.get(z).getTitle());
			 }
		 }
		 Collections.sort(media);	
	return media;
	}

}

/*search media the user will enter some description for example the user will enter any title any artist any song any rating
 * then we will check if the title he entered is in media title if it is true it will be added to media array  if the user enter any
 * of the previous parameter and the flag stayed zero which mean the conditions didnt achieve then we will print all the media title 
 * the list2 contain(movies,albums,games) , if the user add media title and rating for the same class for example then the mediatitle 
 * will be added twice to solve this problem we will check if the media contain the same mediatitle twice if it is true we will remove one of these mediatitle,then we will
 * order the media title in ascending ording using collections.sort */





