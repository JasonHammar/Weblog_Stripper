import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.*;

import java.io.*;

public class WeblogStripper {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// PrintWriter object for Final.txt
		PrintWriter pw = new PrintWriter("final");// Printwriter for final document
		pw.close();
		Scanner month = new Scanner(System.in);
		boolean userFound = false;
		boolean insOrDel = true;
		File users = new File("C:\\Weblog Stripper\\usernames.txt");
		Scanner userbots = new Scanner(users);
		Scanner userNames = new Scanner(users);
		Scanner botsAndUsers = new Scanner(users);
		BST deletes = new BST();
		BST names = new BST();
		File file1 = new File("users2.txt");
		File file3 = new File("C:\\Weblog Stripper\\moreusernames.txt");
		File file4 = new File("Users3.txt");
		botsAndUsers = new Scanner(users);

		PrintWriter writing = new PrintWriter(file1);

		while (botsAndUsers.hasNextLine()) {// This while loop will help clean out empty lines.
			String line = botsAndUsers.nextLine();
			// clean out empty lines
			if (deletes.search(line) == false) {// Checks for empty strings.

				if (!line.isEmpty()) {// If the string is not empty, the line is copied into a temporary file.
					writing.write(line);
					writing.write("\n");
				}

			}

		}

		writing.close();
		botsAndUsers.close();

		botsAndUsers = new Scanner(file3);
		PrintWriter writ = new PrintWriter(file4);

		while (botsAndUsers.hasNextLine()) {// This while loop will help clean out empty lines.
			String line = botsAndUsers.nextLine();
			// clean out empty lines
			if (deletes.search(line) == false) {// Checks for empty strings.

				if (!line.isEmpty()) {// If the string is not empty, the line is copied into a temporary file.
					writ.write(line);
					writ.write("\n");
				}

			}

		}

		botsAndUsers.close();
		writ.close();

		botsAndUsers = new Scanner(file4);
		PrintWriter reWrit = new PrintWriter(file3);

		while (botsAndUsers.hasNextLine()) {// This while loop will help clean out empty lines.
			String line = botsAndUsers.nextLine();
			// clean out empty lines
			if (deletes.search(line) == false) {// Checks for empty strings.

				if (!line.isEmpty()) {// If the string is not empty, the line is copied into a temporary file.
					reWrit.write(line);
					reWrit.write("\n");
				}

			}

		}

		botsAndUsers.close();
		reWrit.close();

		// The code below will recopy everything in the temporary file and put it in the
		// actual user file.
		botsAndUsers = new Scanner(file1);
		PrintWriter reWriting = new PrintWriter(users);

		while (botsAndUsers.hasNextLine()) {// Checks for empty strings.
			String line = botsAndUsers.nextLine();

			// clean out empty lines
			if (deletes.search(line) == false) {// If none are found, line from temp file is pated into original file

				if (!line.isEmpty()) {
					reWriting.write(line);
					reWriting.write("\n");
				}

			}

		}
		reWriting.close();
		botsAndUsers = new Scanner(users);

		while (botsAndUsers.hasNextLine()) {// Puts names into a Binary Search Tree
			String line = botsAndUsers.nextLine();
			names.insert(line);
		}

		botsAndUsers = new Scanner(users);

		System.out.println("Here are all of the usernames and bots: ");
		names.inOrderPrint();
		Scanner addOrRem = new Scanner(System.in);
		Scanner bots = new Scanner(System.in);
		BufferedWriter writes = new BufferedWriter(new FileWriter("Users", true));
		BufferedReader reads = new BufferedReader(new FileReader("Users"));
		BufferedWriter specWrites = new BufferedWriter(new FileWriter(file3, true));
		Scanner files = new Scanner(users);
		BST specNames = new BST();
		botsAndUsers = new Scanner(file3);

		while (botsAndUsers.hasNextLine()) {// Puts names into a Binary Search Tree
			String line = botsAndUsers.nextLine();
			specNames.insert(line);
		}

		System.out.println("Here are all of the special usernames and bots: ");
		specNames.inOrderPrint();
		reads.close();

		while (insOrDel) {// Asks the user for five different options:
			// add a username or bot
			// add a special username or bot
			// remove a username or bot
			// remove a special username or bot.
			// list all special usernames or bots.
			// list all usernames or bots
			// run weblog sifter.
			System.out.println("press 1 to add username or bot.\n" + "Press 2 to add a special bot or username.\n"
					+ "press 3 to remove a user or bot." + "\nPress 4 to remove a special user or bot."
					+ "\nPress 5 to show special users and bots." + "\npress 6 to show users and bots.\n"
					+ "to run weblogsifter, press 7.\n");
			int addOrRemove = addOrRem.nextInt();
			if (addOrRemove == 1) {// Adds a name or bot to document
				System.out.println("Are you sure you want to add a bot? 1 for yes, 2 for no.");
				Scanner choice = new Scanner(System.in);
				int yesOrNo = choice.nextInt();
				if (yesOrNo == 1) {// checks if user actually wants to proceed with this course of action.
					System.out.println("Please type name or bot to add.");
					String name = bots.nextLine();
					names.insert(name);
					writes.write("\r\n" + name);
				}

			} else if (addOrRemove == 2) {// Adds name or bot to list of special bots
				System.out.println("Are you sure you want to add a special bot? 1 for yes, 2 for no.");

				Scanner choice = new Scanner(System.in);
				int yesOrNo = choice.nextInt();
				if (yesOrNo == 1) {// Determines whether or not the user actually wants to add a special bot.
					System.out.println("Please type name or bot to add.");
					String name = bots.nextLine();
					specNames.insert(name);
					specWrites.write("\r\n" + name);
				}
			} else if (addOrRemove == 3) {// Removes a name or bot from the document
				System.out.println("Are you sure you want remove a bot? 1 for yes, 2 for no.");

				Scanner choice = new Scanner(System.in);
				int yesOrNo = choice.nextInt();
				if (yesOrNo == 1) {// checks if user actually wants to proceed with this course of action.
					System.out.println("Please type name or bot to remove.");
					String name = bots.nextLine();
					names.remove(name);
					deletes.insert(name);
				}
			} else if (addOrRemove == 4) {// Removes a special name or bot from the document
				System.out.println("Are you sure you want remove a special bot? 1 for yes, 2 for no.");

				Scanner choice = new Scanner(System.in);
				int yesOrNo = choice.nextInt();
				if (yesOrNo == 1) {// checks if user actually wants to proceed with this course of action.
					System.out.println("Please type name or bot to remove.");
					String name = bots.nextLine();
					specNames.remove(name);
					deletes.insert(name);
				}
			} else if (addOrRemove == 5) {// Lists all current special names and bots
				System.out.println("Are you sure you want to list the special bots? 1 for yes, 2 for no.");

				Scanner choice = new Scanner(System.in);
				int yesOrNo = choice.nextInt();
				if (yesOrNo == 1) {// checks if user actually wants to proceed with this course of action.
					System.out.println("Here are the special bots and users: ");
					specNames.inOrderPrint();
				}
			} else if (addOrRemove == 6) {// Lists all current names and bots
				System.out.println("Are you sure you want to list the bots? 1 for yes, 2 for no.");

				Scanner choice = new Scanner(System.in);
				int yesOrNo = choice.nextInt();
				if (yesOrNo == 1) {// checks if user actually wants to proceed with this course of action.
					System.out.println("Here are the bots and users: ");
					names.inOrderPrint();
				}
			} else if (addOrRemove == 7) {// Runs weblogSifter
				System.out.println("Are you sure you want to run weblog sifter? 1 for yes, 2 for no.");

				Scanner choice = new Scanner(System.in);
				int yesOrNo = choice.nextInt();
				if (yesOrNo == 1) {// checks if user actually wants to proceed with this course of action.
					System.out.println("Running Weblog Sifter");
					writes.close();
					specWrites.close();
					break;
				}
			} else {// If any other number is given, the user will be prompted to try again.
				System.out.println("Error, invalid input, please try again.");
			}
		}

		// This is the delete things from the users file
		botsAndUsers = new Scanner(users);
		reWriting = new PrintWriter(file1);
		while (botsAndUsers.hasNextLine()) {// This code will help delete unnecessary items from the user/bot list
			String line = botsAndUsers.nextLine();

			// clean out empty lines
			if (deletes.search(line) == false) {// If a name or bot is not part of the deletes BST, then it will be put
												// on the list.

				if (!line.isEmpty()) {// If the line is not empty, it will be included.
					reWriting.write(line);
					reWriting.write("\n");
				}

			}

		}
		reWriting.close();

		// This is the delete things from the users file
		botsAndUsers = new Scanner(file3);
		reWriting = new PrintWriter(file4);
		while (botsAndUsers.hasNextLine()) {// This code will help delete unnecessary items from the user/bot list
			String line = botsAndUsers.nextLine();

			// clean out empty lines
			if (deletes.search(line) == false) {// If a name or bot is not part of the deletes BST, then it will be put
												// on the list.

				if (!line.isEmpty()) {// If the line is not empty, it will be included.
					reWriting.write(line);
					reWriting.write("\n");
				}

			}

		}
		reWriting.close();

		FileInputStream in = new FileInputStream(file1);
		FileOutputStream out = new FileOutputStream(users);

		try {// This portion of code will help clean up the file if there are any spaces.

			int n;

			// read() function to read the
			// byte of data
			while ((n = in.read()) != -1) {
				// write() function to write
				// the byte of data
				out.write(n);
			}
		} finally {
			if (in != null) {

				// close() function to close the
				// stream
				in.close();
			}
			// close() function to close
			// the stream
			if (out != null) {
				out.close();
			}
		}

		FileInputStream ins = new FileInputStream(file4);
		FileOutputStream outs = new FileOutputStream(file3);

		try {// This portion of code will help clean up the file if there are any spaces.

			int n;

			// read() function to read the
			// byte of data
			while ((n = ins.read()) != -1) {
				// write() function to write
				// the byte of data
				outs.write(n);
			}
		} finally {
			if (ins != null) {

				// close() function to close the
				// stream
				ins.close();
			}
			// close() function to close
			// the stream
			if (outs != null) {
				outs.close();
			}
		}

		int numUsers = 0;
		while (userNames.hasNextLine()) {// Counts the number of users and bots.
			String line = userNames.nextLine();
			numUsers++;
		}

		List<String> specUsers = new ArrayList<String>();
		userNames = new Scanner(file3);
		while (userNames.hasNextLine()) {// adds usaers and bots to array list.
			String line = userNames.nextLine();

			if (line != "") {
				specUsers.add(line);
				// System.out.println(user[numUsers]);

			}
		}

		List<String> user = new ArrayList<String>();
		userNames = new Scanner(users);
		numUsers = 0;// array is here
		while (userNames.hasNextLine()) {// adds usaers and bots to array list.
			String line = userNames.nextLine();

			if (line != "") {
				user.add(line);
				// System.out.println(user[numUsers]);

			}

			numUsers++;

		}

		Collections.sort(user, String.CASE_INSENSITIVE_ORDER);// sorts array list alphabetically.
		PrintWriter sorted = new PrintWriter(users);
		// userNames = new Scanner(users);
		for (int i = 0; i < user.size(); i++) {// prints sorted list to file.
			sorted.write(user.get(i) + "\n");
		}
		sorted.close();
		userbots.close();

		Collections.sort(specUsers, String.CASE_INSENSITIVE_ORDER);
		sorted = new PrintWriter(file3);
		for (int i = 0; i < specUsers.size(); i++) {// prints sorted list to file.
			sorted.write(specUsers.get(i) + "\n");
		}
		sorted.close();
		userbots.close();

		System.out.println("Which month do you want to sift through?");// Determines which month the user wants to sift
																		// through.
		int months = month.nextInt();

		for (int dayint = 1; dayint < 31; dayint++) { // start with first filenumber then the less than value is one
														// more than the highest day of the month. So 32 for August.
			String daystring = String.valueOf(dayint);
			if (dayint < 10) {
				daystring = "0" + daystring;
			}
			String monthString = String.valueOf(months);
			String filename = "u_ex210" + monthString + daystring + ".log"; // File name for the original file
			String filename2 = "readfile" + daystring;// File name for the updated file
			File file = new File(filename);

			String directory = "C:\\done\\";// Where the raw log files will be located

			File dir = new File(directory);

			File[] matches = dir.listFiles(new FilenameFilter()// This will find file matches in the directory that it
																// should be located in.
			{
				public boolean accept(File dir, String name) {
					return name.startsWith("u_ex") && name.endsWith(".log");
				}
			});

			File file2 = new File(filename2);
			try {// Try catch block to try and read the file, if an exception is caught, the
					// program will stop.

				Scanner inp = new Scanner(matches[dayint - 1]);// A scanner to read the file
				PrintWriter output = new PrintWriter(file2);// A printWriter to write to the updated file.
				while (inp.hasNextLine()) {// This while loop will go through the entire file reading it, and will check
					userFound = false;
					String line = inp.nextLine();// This string will be a line in the file.

					for (int i = 0; i < user.size(); i++) {// Checks to see if the line contains any of these usernames
															// or bots, if so, the line is deleted.
						if (line.contains(user.get(i)) && !line.isEmpty() && user.get(i).length() > 0) {// also checks
																										// if line is
																										// empty.
							line = "";
							userFound = true;
						}
					}
					if (userFound == false) {
						for (int i = 0; i < specUsers.size(); i++) {// Checks to see if the line contains any of these
																	// usernames
							// or bots, if so, the line is deleted.

							if (line.contains(specUsers.get(i)) && !line.isEmpty() && specUsers.get(i).length() > 0) {// also
																														// checks
								// if line is
								// empty.
								String str[] = line.split("\\s", 7);
								//System.out.println(str[6]);
								if (str[6].contains(specUsers.get(i))) {
									line = "";
									userFound = true;
								}

							}
						}
					}
					if (userFound == false) {
						if (line.contains("#Software")) {
							// This if statement will check if the line of text in the text file has the
							// string: "#Software".
							// If it does, it will be deleted.
							line = "";
						} else if (line.contains("#Version")) {
							// This if statement will check if the line of text in the text file has the
							// string: "#Version".
							// If it does, it will be deleted.
							line = "";
						} else if (line.contains("#Date")) {
							// This if statement will check if the line of text in the text file has the
							// string: "#Date".
							// If it does, it will be deleted.
							line = "";
						} else if (line.contains("#Fields")) {
							// This if statement will check if the line of text in the text file has the
							// string: "#Fields".
							// If it does, it will be deleted.
							line = "";
						} else if (line.contains("W_ValsPublicSurvey3point0")) {
							// This if statement will check if the line of text in the text file has the
							// string: "/4daction/W_ValsPublicSurvey3point0".
							// If it does, it will be deleted.
							line = "";

						} else if (line.contains("vals/results")) {
							// This if statement will check if the line of text in the text file has the
							// string: "vals/results".
							// If it does, it will be deleted.
							line = "";

						} else if (line.contains("208.184.71.")) {
							// This if statement will check if the current line of text contains:
							// 208.184.71.
							// If any part of the line contains 208.184.71. it will be deleted.
							line = "";
						} else if (line.contains("66.104.253.")) {
							// This if statement will check if the current line of text contains:
							// 66.104.253.
							// If any part of the line contains 66.104.253. it will be deleted.
							line = "";
						} else if (line.contains("70.90.166.")) {
							// This if statement will check if the current line of text contains: 70.90.166.
							// If any part of the line contains 70.90.166. it will be deleted.
							line = "";
						} else if (line.contains("96.253.71.12.")) {
							// This if statement will check if the current line of text contains:
							// 96.253.71.12.
							// If any part of the line contains 96.253.71.12. it will be deleted.
							line = "";
						} else if (line.contains("172.20.1.")) {
							// This if statement will check if the current line of text contains: 172.20.1.
							// If any part of the line contains 172.20.1. it will be deleted.
							line = "";
						} else if (line.contains("81.174.142.107")) {
							// This if statement will check if the current line of text contains:
							// 81.174.142.107
							// If any part of the line contains 81.174.142.107 it will be deleted.
							line = "";
						} else if (line.contains("211.9.36.241")) {
							// This if statement will check if the current line of text contains:
							// 211.9.36.241
							// If any part of the line contains 211.9.36.241 it will be deleted.
							line = "";
						} else if (line.contains("67.188.137.20")) {
							// This if statement will check if the current line of text contains:
							// 67.188.137.20
							// If any part of the line contains 67.188.137.20 it will be deleted.
							line = "";

						} else if (line.contains(".js")) {
							// This if statement will check if the line contains ".js"
							// If it does, then it will split the string into 5 parts and check
							// after the second tab if it contains /theme/, if it does,
							// Then the line will be deleted.
							String str[] = line.split("\\s", 5);

							if (str[2].contains(".js"))
								line = "";

						} else if (line.contains(" 404 ")) {
							// This if statement will check if has no file found 404 and if no user or
							// cookie
							// If it does, then it will split the string into 5 parts and check
							// after the second tab if it contains /theme/, if it does,
							// Then the line will be deleted.
							String str[] = line.split("\\s", 11);

							if (str[4].contains("-")) {
								if (str[7].contains("-")) {
									line = "";
								}
							}
						} else if (line.contains("/theme/")) {
							// This if statement will check if the line contains "/theme/"
							// If it does, then it will split the string into 5 parts and check
							// after the second tab if it contains /theme/, if it does,
							// Then the line will be deleted.
							String str[] = line.split("\\s", 5);

							if (str[2].contains("/theme/"))
								line = "";

						} else if (line.contains("loginfailed.asp")) {
							// This if statement will check if the line contains "loginfailed.asp"
							// If it does, then it will split the string into 5 parts and check
							// after the second tab if it contains loginfailed.asp, if it does,
							// Then the line will be deleted.
							String str[] = line.split("\\s", 5);

							if (str[2].contains("loginfailed.asp"))
								line = "";

						} else if (line.contains("/media/")) {
							// This if statement will check if the line contains "\\s/media/"
							// If it does, then it will split the string into 5 parts and check
							// after the second tab if it contains /media/, if it does,
							// Then the line will be deleted.
							String str[] = line.split("\\s", 5);

							if (str[2].contains("/media/"))
								line = "";
						} else if (line.contains("/about/")) {
							// This if statement will check if the line contains "\\s/about/"
							// If it does, then it will split the string into 5 parts and check
							// after the second tab if it contains /about/, if it does,
							// Then the line will be deleted.
							String str[] = line.split("\\s", 5);

							if (str[2].contains("/about/"))
								line = "";
						} else if (line.contains("/ads.txt")) {
							// This if statement will check if the line contains "\\s/ads.txt/"
							// If it does, then it will split the string into 5 parts and check
							// after the second tab if it contains /ads.txt, if it does,
							// Then the line will be deleted.
							String str[] = line.split("\\s", 5);

							if (str[2].contains("/ads.txt"))
								line = "";
						//}

						//else if (line.contains("Linespider")) {
							// This if statement will check if the program has Linespider between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("Linespider"))
								//line = "";

						//} else if (line.contains("MJ12bot")) {
							// This if statement will check if the program has MJ12bot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("MJ12bot"))
								//line = "";

						//} else if (line.contains("SeznamBot")) {
							// This if statement will check if the program has SeznamBot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("Seznambot"))
								//line = "";

						//} else if (line.contains("strutbot")) {
							// This if statement will check if the program has strutbot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("strutbot"))
								//line = "";

						//} else if (line.contains("AccompanyBot")) {
							// This if statement will check if the program has AccompanyBot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("AccompanyBot"))
								//line = "";

						} else if (line.contains("MojeekBot")) {
							// This if statement will check if the program has MojeekBot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							String str[] = line.split("\\s", 7);

							if (str[4].contains("MojeekBot"))
								line = "";

						//} else if (line.contains("ZoominfoBot")) {
							// This if statement will check if the program has ZoominfoBot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("ZoominfoBot"))
								//line = "";

						//} else if (line.contains("Adsbot")) {
							// This if statement will check if the program has Adsbot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("Adsbot"))
								//line = "";

						//} else if (line.contains("BLEXBot")) {
							// This if statement will check if the program has BLEXBot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("BLEXBot"))
								//line = "";

						//} else if (line.contains("bingbot")) {
							// This if statement will check if the program has Bingbot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("bingbot"))
								//line = "";

						//} else if (line.contains("AhrefsBot")) {
							// This if statement will check if the program has AhrefsBot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("AhrefsBot"))
								line = "";

						//} else if (line.contains("Googlebot")) {
							// This if statement will check if the program has Googlebot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("Googlebot"))
								//line = "";

						//} else if (line.contains("applebot")) {
							// This if statement will check if the program has applebot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("applebot"))
								//line = "";

						//} else if (line.contains("Seekport+Crawler")) {
							// This if statement will check if the program has Seekport+Crawler between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("Seekport+Crawler"))
								//line = "";

						//} else if (line.contains("8LEGS")) {
							// This if statement will check if the program has Tbot-nutch between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("8LEGS"))
								//line = "";
						//} else if (line.contains("Vagabondo")) {
							// This if statement will check if the program has Vagabondo between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("Vagabondo"))
								//line = "";

						//} else if (line.contains("PetalBot")) {
							// This if statement will check if the program has PetalBot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("PetalBot"))
								//line = "";
						//} else if (line.contains("SemrushBot")) {
							// This if statement will check if the program has SemrushBot between the
							// 6th and 7th tab. If it does, then the line is deleted.
							// To do this, the string is split into seven parts, and the string in between
							// the 6th and 7th space is checked
							//String str[] = line.split("\\s", 7);

							//if (str[5].contains("SemrushBot"))
								//line = "";

						} else if (line.contains("/vals/")) {
							// This if statement will check if the line contains "\\s/vals/"
							// If it does, then it will split the string into 5 parts and check
							// after the second tab if it contains \\sheme/, if it does,
							// Then the line will be deleted. Otherwise, the date format will change.
							// Changing the format for the date is explained at the end.
							// However, if the line contains: "/vals/international.shtml",
							// "/vals/international/", "/vals/store/free.shtml", "/vals/store/free/lens/",
							// Then the format of the date will change and the line will remain the same.
							if (line.contains("/vals/international.shtml") || line.contains("/vals/international/")
									|| line.contains("/vals/store/free.shtml")
									|| line.contains("/vals/store/free/lens/") || line.contains("/vals/clients/")) {
								String str[] = line.split(" ", 11);

								if (line.contains("200 25009")) {
									// If the current line contains the error code 200 25009, The string is then
									// split into 10 parts, and the last part of the string is then changed to 403
									// 25009. The date format is also modified.
									String str2[] = line.split("\\s", 10);

									str2[9] = "403\t25009";

									if (str2[0].contains("2021-")) {
										String altStr[] = str2[0].split("-", 2);
										str2[0] = altStr[1] + "-" + altStr[0];
									}
									for (int i = 0; i < 9; i++)
										output.print(str2[i] + "\t");
									output.print(str2[9]);
									output.println();

								}

								else if (str[0].contains("2021-")) {// Checks if it contains a 2021-.
									String altStr[] = str[0].split("-", 2);// Splits the date at the first -.
									str[0] = altStr[1] + "-" + altStr[0];// Rearranges the date by putting the year in
																			// the
									// back and the day and month first.

									if (line.contains("200 25009")) {
										// If the current line contains the error code 200 25009, The string is then
										// split into 10 parts, and the last part of the string is then changed to 403
										// 25009. The date format is also modified.
										String str2[] = line.split("\\s", 10);

										str2[9] = "403\t25009";

										for (int i = 0; i < 9; i++)
											output.print(str2[i] + "\t");
										output.print(str2[9]);
										output.println();

									}

									else {
										for (int i = 0; i < 10; i++)
											output.print(str[i] + "\t");
										output.print(str[10]);
										output.println();

									}
								}
							} else {
								String str[] = line.split("\\s", 11); // split into 11 parts

								if (str[2].contains("/vals/"))
									line = "";
								else {// Changing the format of the date.

									if (str[0].contains("2021-")) {// Checks if it contains a 2021-.
										String altStr[] = str[0].split("-", 2);// Splits the date at the first -.
										str[0] = altStr[1] + "-" + altStr[0];// Rearranges the date by putting the year
																				// in
																				// the
										// back and the day and month first.

										if (line.contains("200 25009")) {
											// If the current line contains the error code 200 25009, The string is then
											// split into 10 parts, and the last part of the string is then changed to
											// 403
											// 25009. The date format is also modified.
											String str2[] = line.split("\\s", 10);

											str2[9] = "403\t25009";

											for (int i = 0; i < 9; i++)
												output.print(str2[i] + "\t");
											output.print(str2[9]);
											output.println();

										}

										else
											for (int i = 0; i < 10; i++)
												output.print(str[i] + "\t");
										output.print(str[10]);
										output.println();
									}
								}
							}

						} else if (line.contains("200 25009")) {
							// If the current line contains the error code 200 25009, The string is then
							// split into 10 parts, and the last part of the string is then changed to 403
							// 25009. The date format is also modified.
							String str[] = line.split("\\s", 10);

							str[9] = "403\t25009";

							if (str[0].contains("2021-")) {
								String altStr[] = str[0].split("-", 2);
								str[0] = altStr[1] + "-" + altStr[0];
							}
							for (int i = 0; i < 9; i++)
								output.print(str[i] + "\t");
							output.print(str[9]);
							output.println();

						} else if (line.contains("200 8087")) {
							// If the current line contains the error code 200 8087, The string is then
							// split into 10 parts, and the last part of the string is then changed to 403
							// 8087. The date format is also modified.
							String str[] = line.split("\\s", 10);

							str[9] = "403\t8087";
							if (str[0].contains("2021-")) {
								String altStr[] = str[0].split("-", 2);
								str[0] = altStr[1] + "-" + altStr[0];
							}
							for (int i = 0; i < 9; i++)
								output.print(str[i] + "\t");
							output.print(str[9]);
							output.println();

						} else {
							// This last part of the program will modify the format of the date and write
							// back the line into the file. To do this, the line must be split in two.
							// Then, you take the first part of the line, which contains the date, and you
							// split the date at the '-' symbol. Then, you take the second part of the
							// string and put it in the front, then add a '-', then add in the 2021.
							// OLD String str[] = line.split(" ", 2);// Splits the string in two.
							String str[] = line.split(" ", 11); // split into 10 parts

							if (str[0].contains("2021-")) {// Checks if it contains a 2021-.
								String altStr[] = str[0].split("-", 2);// Splits the date at the first -.
								str[0] = altStr[1] + "-" + altStr[0];// Rearranges the date by putting the year in the
								// back and the day and month first.

								for (int i = 0; i < 7; i++)
									output.print(str[i] + "\t");
								output.print(str[6]);
								output.println();

							}

							// OLD for (int i = 0; i < str.length; i++)// Prints the string back into the
							// file with the updated date.
							// OLD output.print(str[i]);
							// OLDoutput.println();
						}

					}
				}

				output.close();// Closes the file.

				// Set true for append mode
				BufferedWriter writer = new BufferedWriter(new FileWriter("final", true));

				// BufferedReader object for file to read
				BufferedReader br = new BufferedReader(new FileReader(filename2));

				String line = br.readLine();

				// loop to copy each line of

				while (line != null) {
					writer.write(line + "\r\n");
					line = br.readLine();
				}

				writer.flush();

				// closing resources
				br.close();
				writer.close();

				System.out.println("Merged" + filename2 + " into final.txt");

			} catch (FileNotFoundException e) {// If an exception is caught, an error message is displayed.
				BufferedWriter writer = new BufferedWriter(new FileWriter("final", true));
				writer.write("File not Found!\r\n");
				writer.close();
			}
		}

	}

}
