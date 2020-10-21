/*Project Developed by 
Alessandro Sclafani 298779 & 
Martina Caffagnini 294520 for 
Ingegneria del Software*/

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The {@code Club} class is a container class. It contains:
 * <ul>
 * <li>{@code People} class</li>
 * <li>{@code Activity} class</li>
 * </ul>
 * In the Club class there are three {@code ArrayList}:
 * <ul>
 * <li>{@code users} arraylist which contains all the people subscribed and the admins of the sport club </li>
 * <li>{@code lessons} arraylist which contains all the lessons activated by the sport club</li>
 * <li>{@code races} arraylist which contains all the races planned by the sport club</li>
 * </ul>
 * This class acts as an abstraction of a sport club.
 * @see ArrayList
 * @see Lesson
 * @see Race
 * @see User
 */
public class Club {

	protected List<Lesson> lessons = new ArrayList<Lesson>();
	protected List<Race> races = new ArrayList<Race>();
	protected List<User> users = new ArrayList<User>();

	/**
	 * Class {@code People} is a class that should never be instantiated.
	 * This class is used as a container for Class {@code User} and
	 * its subclass {@code Admin}.
	 * @see User
	 * @see Admin
	 */
	public class People {
		
		protected String name;
		protected String surname;
		protected String email;
		protected String password;

		/**
		 * {@code People} Class constructor. This constructor should NEVER
		 * be called.
		 */
		protected People() {
			this.name = "";
			this.surname = "";
			this.email = "";
			this.password = "";
		}

		/**
		 * {@code People} Class constructor. 
		 * This constructor should NEVER be called.
		 * @param name name of the new user [String]
		 * @param sur surname(lastname) of the new user [String]
		 * @param email email of the new user [String]
		 * @param passwd password of the new user [String]
		 */
		protected People(final String name, final String sur, final String email, final String passwd) {
			this.name = name;
			this.surname = sur;
			this.email = email;
			this.password = passwd;
		}

	}

	/**
	 * The {@code User} class is a container class. 
	 * It contains all the people subscribed and the admins of the sport club.
	 * It is a subclass of {@code People} and it is extended by the class {@code Admin}.
	 * @see People
	 * @see Admin
	 */
	public class User extends People {

		/**
		 * {@code User} Class Constructor. User is an extension of class {@code People}.
		 * @see People
		 */
		public User() {
			super();
		}

		/**
		 * {@code User} Class constructor. User is an extension of class {@code People}.
		 * @param name name of the new user [String]
		 * @param sur surname(lastname) of the new user [String]
		 * @param email email of the new user [String]
		 * @param passwd password of the new user [String]
		 * @see People
		 */
		public User(final String name, final String sur, final String email, final String passwd) {
			super(name, sur, email, passwd);
		}

		/**
		 * Gets the name of the {@code User}.
		 * @return The name of the user [String].
		 * @see User
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * Gets the surname (last name) of the {@code User}.
		 * @return The surname of the user [String].
		 * @see User
		 */
		public String getSurname() {
			return this.surname;
		}

		/**
		 * Gets the email of the {@code User}.
		 * @return The email of the user [String].
		 * @see User
		 */
		public String getEmail() {
			return this.email;
		}

		/**
		 * Adds the current {@code User} to the List of  
		 * partecipants of the specified {@code Race}. 
		 * @param race The {@code Race} the {@code User} wants to subscribe to. [Race]
		 * @see Race
		 * @see User
		 */
		public void subscribeRace(Race race) {
			race.addPartecipant(this);
		}

		/**
		 * Adds the current {@code User} to the List of 
		 * partecipants of the specified {@code Lesson}.
		 * @param less The {@code Lesson} the {@code User} wants to subscribe to. [Lesson]
		 * @see Lesson
		 * @see User
		 */
		public void subscribeLesson(Lesson less) {
			less.addPartecipant(this);
		}
		
		/**
		 * Removes the current {@code User} from the List of 
		 * partecipants of the specified {@code Race}. 
		 * @param race The {@code Race} the {@code User} wants to subscribe to. [Race]
		 * @see Race
		 */
		public void unsubscribeRace(Race race) {
			race.removePartecipant(this);
		}

		/**
		 * Removes the current {@code User} from the List of 
		 * partecipants of the specified {@code Lesson}.
		 * @param less The {@code Lesson} the {@code User} wants to subscribe to. [Lesson]
		 * @see Lesson
		 */
		public void unsubscribeLesson(Lesson less) {
			less.removePartecipant(this);
		}

	}

	/**
	 * The {@code Admin} class is an extension of class {@code User}.
	 * An admin can access all the methods contained in {@code User},
	 * but it also has the priviledge to operate on the ArrayLists
	 * contained in {@code Club}.
	 * @see User
	 * @see People
	 * @see ArrayList
	 * @see Club
	 */
	public class Admin extends User {
		
		/**
		 * {@code Admin} Class constructor. Admin extends class {@code User}.
		 * @see User
		 */
		public Admin() {
			super();
		}
		
		/**
		 * {@code Admin} Class constructor. Admin extends class {@code User}.
		 * 
		 * @param n name of the new admin
		 * @param s surname(last name) of the new admin
		 * @param e email of the new admin
		 * @param p password of the new admin
		 * @see User
		 */
		public Admin(final String n, final String s, final String e, final String p) {
			super(n, s, e, p);
		}

		/**
		 * Sets the {@code name} for the specified {@code User},
		 * overwriting the existing one
		 * @param user the specified User. [User]
		 * @param name new name. [String]
		 * @see User
		 */
		public void setName(User user, String name) {
			user.name = name;
		}

		/**
		 * Sets the {@code surname} for the specified {@code User}, 
		 * overwriting the existing one
		 * @param user the specified User. [User]
		 * @param sur new surname. [String]
		 * @see User
		 */
		public void setSurname(User user, String sur) {
			user.surname = sur;
		}

		/**
		 * Sets the {@code email} for the specified {@code User}, 
		 * overwriting the existing one
		 * @param user the specified User. [User]
		 * @param email new email. [String]
		 * @see User
		 */
		public void setEmail(User user, String email) {
			user.email = email;
		}

		/**
		 * Sets the {@code password} for the specified {@code User}, 
		 * overwriting the existing one
		 * @param user the specified User. [User]
		 * @param passwd new password. [String]
		 * @see User
		 */
		public void setPassword(User user, String passwd) {
			user.password = passwd;
		}

		/**
		 * Adds a new {@code User} to the ArrayList {@code users}, 
		 * contained in the {@code Club} Class.
		 * @param club the entire club. [Club]
		 * @param name name of the new user. [String]
		 * @param sur surname of the new user. [String]
		 * @param email email of the new user. [String]
		 * @param passwd password of the new user. [String]
		 * @see User
		 * @see ArrayList
		 * @see Club
		 */
		public void addUser(Club club, String name, String sur, String email, String passwd) {
			Club.User new_user = new Club.User(name, sur, email, passwd);
			club.users.add(new_user);
		}

		/**
		 * Adds a new {@code Admin} to the ArrayList {@code users}, 
		 * contained in the {@code Club} Class.
		 * @param club the entire club. [Club]
		 * @param name name of the new admin. [String]
		 * @param sur surname of the new admin. [String]
		 * @param email email of the new admin. [String]
		 * @param passwd password of the new admin. [String]
		 * @see Admin
		 * @see ArrayList
		 * @see Club
		 */
		public void addAdmin(Club club, String name, String sur, String email, String passwd) {
			Club.Admin new_admin = new Club.Admin(name, sur, email, passwd);
			club.users.add(new_admin);
		}
		
		/**
		 * Removes the selected {@code User} from the 
		 * {@code users} ArrayList, contained in Class {@code Club}.
		 * This method also removes the selected {@code User} from
		 * the {@code races} and {@code lessons} ArrayLists.
		 * @param club the entire club. [Club]
		 * @param toBeRemoved the user that has to be removed. [User]
		 * @see Club
		 * @see ArrayList
		 * @see User
		 */
		public void removePeople(Club club, User toBeRemoved){
			club.users.remove(toBeRemoved);

			//removing the user from every Race and Lesson
			for(Lesson less : club.lessons){
				less.removePartecipant(toBeRemoved);
			}

			for(Race race : club.races){
				race.removePartecipant(toBeRemoved);
			}
		}

		/**
		 * Adds a new {@code Race} to the ArrayList 
		 * {@code races}, contained in the {@code Club} Class.
		 * @param club the entire club. [Club]
		 * @param race_name name of the new Race. [String]
		 * @see ArrayList
		 * @see Club
		 */
		public void addRace(Club club, String race_name) {
			Club.Race new_race = new Club.Race(race_name);
			club.races.add(new_race);
		}

		/**
		 * Adds a new {code Lesson} to the ArrayList 
		 * {@code lessons}, contained in the {@code Club} Class.
		 * @param club the entire club. [Club]
		 * @param lesson_name name of the new Lesson. [String]
		 * @see ArrayList
		 * @see Club
		 */
		public void addLesson(Club club, String lesson_name) {
			Club.Lesson new_lesson = new Club.Lesson(lesson_name);
			club.lessons.add(new_lesson);
		}
		
		/**
		 * Removes the selected {@code Lesson} from the 
		 * {@code lessons} ArrayList, contained in Class {@code Club}.
		 * @param club the entire club. [Club]
		 * @param toBeRemoved the Lesson that has to be removed. [Lesson]
		 * @see ArrayList
		 * @see Lesson
		 * @see Club
		 */
		public void removeLesson(Club club, Lesson toBeRemoved){
			club.lessons.remove(toBeRemoved);
		}

		/**
		 * Removes the selected {@code Race} from the 
		 * {@code races} ArrayList, contained in Class {@code Club}. 
		 * @param club the entire club. [Club]
		 * @param toBeRemoved the Race that has to be removed. [Race]
		 * @see ArrayList
		 * @see Race
		 * @see Club
		 */
		public void removeRace(Club club, Race toBeRemoved){
			club.races.remove(toBeRemoved);
		}

		/**
		 * sets the {@code name} for the selected {@code Activity},
		 * overwriting the existing one.
		 * @param act the activity that has to be modified. [Activity]
		 * @param name new name. [String]
		 * @see Activity
		 */
		public void setActivityName(Activity act, String name) {
			act.name = name;
		}
	}

	/**
	 * Class {@code Activity} is a class that should never be called.
	 * This class is used as a container for Class {@code Race} and
	 * Class {@code Lesson}.
	 * @see Race
	 * @see Lesson
	 */
	public class Activity {

		protected String name;
		protected List<User> people = new ArrayList<User>();

		/**
		 * {@code Activity} Class constructor. This constructor should NEVER
		 * be called.
		 */
		protected Activity() {
			this.name = "";
		}
		
		/**
		 * {@code Activity} Class constructor. This constructor should NEVER
		 * be called.
		 * @param name name of the new activity. [String]
		 */
		protected Activity(final String name) {
			this.name = name;
		}

		/**
		 * This method prints all the partecipants of the current activity.
		 * @see print
		 */
		public void print_partecipants() {

			print(String.format("	The partecipants are: \n", this.getName()));
			for (Club.User user : people) {
				print(String.format("	Name: %s %s, Email: %s \n", user.getName(), user.getSurname(), user.getEmail()));
			}
		}

		/**
		 * Returns the name of the current activity.
		 * @return
		 * The name of the activity. [String]
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * Adds a partecipant to the ArrayList of the selected Activity.
		 * @param user The user that has to be added. [User]
		 */
		public void addPartecipant(User user){
			this.people.add(user);
		}

		/**
		 * Removes a partecipant from the ArrayList of the selected Activity.
		 * @param user the user that has to be removed. [User]
		 */
		public void removePartecipant(User user){
			this.people.remove(user);
		}

	}

	/**
	 * A Race is a competition between users.
	 * It is an extension of {@code Activity}.
	 * @see Activity
	 */
	public class Race extends Activity {

		/**
		 * {@code Race} Class Constructor. Race extends Class {@code Activity}.
		 * @see Activity
		 */
		public Race(){
			super();
		}

		/**
		 * {@code Race} Class Constructor. Race extends Class {@code Activity}.
		 * @param name name of the Race. [String]
		 * @see Activity
		 */
		public Race(final String name) {
			super(name);
		}


	}

	/**
	 * A Lesson is a course, aimed to train the users in a
	 * selected discipline.
	 * It is an extension of {@code Activity}.
	 * @see Activity
	 */
	public class Lesson extends Activity {

		/**
		 * {@code Lesson} Class Constructor. Lesson extends Class {@code Activity}.
		 * @see Activity
		 */
		public Lesson(){
			super();
		}
		
		/**
		 * {@code Lesson} Class Constructor. Lesson extends Class {@code Activity}.
		 * @param name name of the Lesson. [String]
		 * @see Activity
		 */
		public Lesson(final String name){
			super(name);
		}
		

	}

	//* Utility functions

	/**
	 * Simple method that prints the specified String both 
	 * on console and in file {@code club.log}. If the file
	 * is not present in the current directory, it will be 
	 * created by this method.
	 * @param arg the string that has to be printed. [String]
	 */
	public void print(String arg) {

		// console print
		System.out.println(arg);

		// file write. Creates club.log and writes arg to it.
		try {

			File log = new File("club.log");
			if (log.createNewFile()) {
				System.out.println("Created log file in the current directory.");
			}
			// * The "true" flag in FileWriter indicates the append mode.
			FileWriter out = new FileWriter(log, true);
			out.write(arg + '\n');
			out.close();

		} catch (IOException e) {
			System.out.println("An error occured during the writing process.");
			e.printStackTrace();
		} catch (SecurityException e){
			System.out.println("Cannot create file. Access denied.");
			e.printStackTrace();
		} catch (NullPointerException e){
			System.out.println("This is an odd error...");
			e.printStackTrace();
		}
	}

	/**
	 * Prints the ArrayList of {@code Users} currently
	 * subscribed to the {@code Club}.
	 * @param club the entire club. [Club]
	 * @see ArrayList
	 * @see User
	 * @see Club
	 */
	public void printUsers(Club club) { 

		print("The users subscribed to the club are:\n");
		for (User user : club.users){
			String name = user.getName();
			String sur = user.getSurname();
			String email = user.getEmail();
			String toBePrinted = String.format("Name: %s %s - Email: %s", name, sur, email);
			print(toBePrinted);
		}
		print("\n");

	}

	/**
	 * Prints the ArrayList of {@code Races} currently
	 * available in the {@code Club}.
	 * @param club the entire club. [Club]
	 * @see ArrayList
	 * @see Race
	 * @see Club
	 */
	public void printRaces(Club club) { 

		print("The current races available in the club are:");
		for (Race race : club.races){
			String name = race.getName();
			String toBePrinted = String.format("Race name: %s", name);
			print(toBePrinted);
			race.print_partecipants();
		}
		print("\n");

	}

	/**
	 * Prints the ArrayList of {@code Lessons} currently
	 * available in the {@code Club}.
	 * @param club the entire club. [Club]
	 * @see ArrayList
	 * @see Lesson
	 * @see Club
	 */
	public void printLessons(Club club) { 

		print("The current lessons available in the club are: \n");
		for (Lesson less : club.lessons){
			String name = less.getName();
			String toBePrinted = String.format("Lesson name: %s", name);
			print(toBePrinted);
			less.print_partecipants();
		}
		print("\n");

	}

	/**
	 * Main method. This method is called automatically 
	 * when the program is executed.
	 * @param args main arguments
	 */
	public static void main(String[] args) {
		Club club = new Club();
		club.test_main(club);
	}

	/**
	 * Actual main method, invoked by {@code main} method.
	 * This method is used because the {@code main} method needs
	 * to be static.
	 * @param club the entire club. [Club]
	 * @see main
	 */
	public void test_main(Club club) {

		//1) Adding an admin, some users and some activities
		Admin owner = new Admin("Jeff","Bezos","info@club.com","unaPasswordMoltoStrong");
		
		owner.addUser(club, "Francesco", "Petrarca", "frapetra@poeta.com","canzoniereRules");
		owner.addUser(club, "Jean Baptiste Joseph", "Fourier", "trasformata@pigrecone.com","iLoveDirac");
		owner.addUser(club, "Dmitrij Ivanovic", "Mendeleev", "info@periodictable.com", "atomicNumbersRules");
		owner.addUser(club, "tmp", "tmp", "tmp@unipr.it", "passwd");
		owner.addLesson(club, "Pallavolo");
		owner.addLesson(club, "Pilates");
		owner.addRace(club, "Tiro con l'arco");
		owner.addRace(club, "Karate");
		
		//2) modifing&removing users
		owner.setEmail(club.users.get(3), "new_mail@email.com");
		owner.setName(club.users.get(3), "new_name");
		owner.setSurname(club.users.get(3), "new_surname");
		owner.removePeople(club, club.users.get(3));
		
		//3) choosing a random user
		Random rand = new Random();
		User rand_user = club.users.get(rand.nextInt(club.users.size()));

		//4.1) the user subscribes to a race and a lesson
		Lesson rand_less = club.lessons.get(rand.nextInt(club.lessons.size()));
		Race rand_race = club.races.get(rand.nextInt(club.races.size()));
		rand_user.subscribeLesson(rand_less);
		rand_user.subscribeRace(rand_race);

		//4.2) unsubscribing from random activity
		if(rand.nextInt(2) == 1){
			rand_user.unsubscribeLesson(rand_less);
		} else {
			rand_user.unsubscribeRace(rand_race);
		}
		
		//5)presenting data
		printLessons(club);
		printRaces(club);
		printUsers(club);
	}
}