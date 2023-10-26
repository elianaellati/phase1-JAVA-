import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Driverr {
	public static void main(String args[]) throws Exception {
		int b = 0; // the customer will press a number to chose what he need from the menu

		MediaRentalManager o = new MediaRentalManager(); // create an object from mediarentalmanger
		File output = new File("output.txt");// create a file called output.txt for customers data
		File output1 = new File("Moviee.txt");// create a file called moviee.txt in order to print the informations
												// about movies
		File output2 = new File("Gamee.txt");
		File output3 = new File("Albumm.txt");
		if (!output.exists()) { // if the file does not exist it will print the following
			System.out.print("file does not exist");
			System.exit(2);
		}
		if (!output1.exists()) { // if the file does not exist it will print the following
			System.out.print("file does not exist");
			System.exit(2);
		}
		if (!output2.exists()) { // if the file does not exist it will print the following
			System.out.print("file does not exist");
			System.exit(2);
		}
		if (!output3.exists()) { // if the file does not exist it will print the following
			System.out.print("file does not exist");
			System.exit(2);
		}
		Scanner sc = new Scanner(output);// to read what is written on the files
		Scanner sc1 = new Scanner(output1);
		Scanner sc2 = new Scanner(output2);
		Scanner sc3 = new Scanner(output3);
		if ("output.txt".length() != 0) {

			while (sc.hasNext()) {
				String namee = sc.next();

				 String address = sc.next();
				 String plan = sc.next();
				o.addCustomer(namee, address, plan);
				 String rented = sc.nextLine();
				String[] tokens = rented.split(" ");
				for (int i = 0; i < tokens.length; ++i) {// adding the rented
					o.addToCart(namee, tokens[i]);
				}
			}
		}
		PrintWriter out = new PrintWriter(output);
		if ("Moviee.txt".length() != 0) {
			while (sc1.hasNext()) { // it will check if the file is empty or not if it is not it will enter the if
									// statement

				String title1 = sc1.next(); // it will add the title and numberofcopies and rating to the arraylist of
											// media
				String y = sc1.next(); // in order when we do run again the informations of the previous users will be
										// added to
										// to the next users
				int copies = Integer.parseInt(y);
				String Rating = sc1.next();
				o.addMovie(title1, copies, Rating);
			}
		}
		PrintWriter out1 = new PrintWriter(output1);
		if ("Gamee.txt".length() != 0) {
			while (sc2.hasNext()) {
				String title = sc2.next();
				int copies1 = Integer.parseInt(sc2.next());
				double weight = Double.parseDouble(sc2.next());
				o.addGame(title, copies1, weight);
			}
		}

		PrintWriter out2 = new PrintWriter(output2);
		if ("Albumm".length() != 0) {
			while (sc3.hasNext()) {
				String title = sc3.next();
				int copiess = Integer.parseInt(sc3.next());
				String artistt = sc3.next();
				String songss = sc3.nextLine();
				o.addAlbum(title, copiess, artistt, songss);

			}
		}
		PrintWriter out3 = new PrintWriter(output3);

		Scanner input = new Scanner(System.in);

		System.out.println("please press a number");
		System.out.println("press 1 for adding a customer");
		System.out.println("press 2 for adding a media");
		System.out.println("press 3 for adding media to a cart");
		System.out.println("press 4 for removing media from a cart");
		System.out.println("press 5 for processing");
		System.out.println("press 6 for return a media");
		System.out.println("press 7 for search media");
		System.out.println("8 for Exit");

		try {// if the user enter a string value in int value an exception will be throw
				// (input mismatch)
			while (b != 8) {
				System.out.print("please enter your choice");
				b = input.nextInt();
				if (b == 1) {
					System.out.println("please enter your name");
					String name = input.next();
					System.out.println("please enter your address");
					String addresss = input.next();
					System.out.println("please enter your plan");
					String plann = input.next();
					testAddingCustomers(name, addresss, plann, o);
				} else if (b == 2) {
					System.out.println("please enter your favorite media");
					System.out.println("press 1 for adding a Movie");
					System.out.println("press 2 for adding a Game");
					System.out.println("press 3 for adding an Album");
					int d = input.nextInt();
					testAddingMedia(d, o);
				}

				else if (b == 3) {
					System.out.println("please enter the customer name");
					String name = input.next();
					System.out.println("please enter the title you want to add");
					String title = input.next();
					testingAddingToCart(name, title, o);

				} else if (b == 4) {
					System.out.println("please enter the customer name");
					String name = input.next();
					System.out.println("please enter the title you want to remove from cart");
					String title = input.next();
					testingRemovingFromCart(name, title, o);
				} else if (b == 5) {
					System.out.println("in progress");
					o.processRequests();
					
				} else if (b == 6) {
					System.out.println("please enter the customer name");
					String name = input.next();
					System.out.println("please enter the title you want to remove from rented");
					String title = input.next();
					testReturnMedia(name, title, o);
				} else if (b == 7) {
					System.out.println("please enter the title name you are looking for");
					String title = input.next();
					System.out.println("please enter the rating of movie you are looking for");
					String rating = input.next();
					System.out.println("please enter your favorite artist");
					String artist = input.next();
					System.out.println("please enter your favorite songs");
					String song = input.next();
					testSearchMedia(title, rating, artist, song, o);
				}
				System.out.println("please press a number");
				System.out.println("press 1 for adding a customer");
				System.out.println("press 2 for adding a media");
				System.out.println("press 3 for adding media to a cart");
				System.out.println("press 4 for removing media from a cart");
				System.out.println("press 5 for processing");
				System.out.println("press 6 for return a media");
				System.out.println("press 7 for search media");
				System.out.println("8 for Exit");
				
			}
		} catch (InputMismatchException ex) {
			System.out.print("invalid ");
		}

		for (int i = 0; i < o.List1.size(); ++i) {
			out.print(o.List1.get(i).toString());
			for (int k = 0; k < o.List1.get(i).Rented.size(); ++k) {
				out.print(" ");
				out.print(o.List1.get(i).Rented.get(k));
				out.print(" ");
			}
			out.println();
		}

		for (int m = 0; m < o.List2.size(); ++m) {
			if (o.List2.get(m) instanceof Moviee) {
				out1.println(o.List2.get(m));
			}
			if (o.List2.get(m) instanceof Game) {
				out2.println(o.List2.get(m));
			}
			if (o.List2.get(m) instanceof Album) {
				out3.println(o.List2.get(m));
			}
		}
		out.close();
		out1.close();
		out2.close();
		out3.close();
	}

	public static void testAddingCustomers(String title, String address, String plan, MediaRentalManager o) {
		o.addCustomer(title, address, plan);
	}

	public static void testAddingMedia(int d, MediaRentalManager o) {
		Scanner input = new Scanner(System.in);
		if (d == 1) {
			System.out.print("please enter the movie title");
			String title = input.next();
			System.out.print("please enter the number of copies");
			int m = input.nextInt();
			System.out.print("please enter the rating");
			String rating = input.next();
			o.addMovie(title, m, rating);
		}
		if (d == 2) {
			System.out.print("please enter the game title");
			String title = input.next();
			System.out.print("please enter the number of copies");
			int f = input.nextInt();
			System.out.print("please enter the weigth of the game");
			double p = input.nextDouble();
			o.addGame(title, f, p);
		}
		if (d == 3) {
			System.out.print("please enter the title of the album");
			String title = input.next();
			System.out.print("please enter the number of copies");
			int numberofcopies = input.nextInt();
			System.out.print("please enter the artist");
			String artist = input.next();
			System.out.print("please enter the songs ");
			String songs = input.next();
			o.addAlbum(title, numberofcopies, artist, songs);
		}

	}

	public static void testingAddingToCart(String name, String title, MediaRentalManager o) {
		o.addToCart(name, title);
	}

	public static void testingRemovingFromCart(String name, String title, MediaRentalManager o) {
		o.removeFromCart(name, title);
	}

	public static void testProcessingRequest(MediaRentalManager o) {
		o.processRequests();
	}

	public static void testReturnMedia(String name, String title, MediaRentalManager o) {
		o.returnMedia(name, title);
	}

	public static void testSearchMedia(String title, String rating, String artist, String songs, MediaRentalManager o) {
		o.searchMedia(title, rating, artist, songs);
		System.out.print(o.searchMedia(title, rating, artist, songs));
	}
}
