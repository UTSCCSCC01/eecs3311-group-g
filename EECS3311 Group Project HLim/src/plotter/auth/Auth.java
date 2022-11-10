package plotter.auth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a class implementing the Singleton pattern.
 * @author 
 *
 */
public class Auth {
	private static File file;
	private static Auth instance;
	private static ArrayList<String> users = new ArrayList<String>(); // Temporary credentials db

	private Auth() {
//		file = new File(this.getClass().getResource("/authy.txt").getFile());
		// Let's add some dummy users, for now.
		users.add("user1 password1");
		users.add("user2 password2");
		users.add("user3 password3");
		users.add("user4 password4");
	}

	public static Auth getInstance() {
		if (instance == null) {
			instance = new Auth();
		}

		return instance;
	}

//	public boolean authenticate(String username, String password) throws FileNotFoundException {
//		Scanner in = new Scanner(file);
//
//		while (in.hasNext()) {
//			String[] parts = in.nextLine().trim().split(" ");
//
//			if (username == parts[0]) {
//				in.close();
//				return password == parts[1];
//			}
//		}
//
//		in.close();
//		return false;
//	}

	public boolean authenticate(String username, String password) {
		for (String user : users) {
			String[] parts = user.split(" ");

			if (username.equals(parts[0])) {
				return password.equals(parts[1]);
			}
		}

		return false; // we din't find a user
	}
}
