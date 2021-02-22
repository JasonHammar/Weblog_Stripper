
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.*;

import java.io.*;

public class WeblogStripper {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// PrintWriter object for Final.txt
		PrintWriter pw = new PrintWriter("final");
		pw.close();

		for (int dayint = 2; dayint < 32; dayint++) { // start with
//first filenumber then the less than value is one more than the highest
//day of the month.  So 32 for August.
			String daystring = String.valueOf(dayint);
			if (dayint < 10) {
				daystring = "0" + daystring;
			}
			String filename = "u_ex2008" + daystring + ".log"; // File name
//for the original file
			String filename2 = "readfile" + daystring;// File name for
//the updated file
			File file = new File(filename);
			File file2 = new File(filename2);
			try {// Try catch block to try and read the file, if an
//exception is caught, the
				// program will stop.

				Scanner inp = new Scanner(file);// A scanner to read the file
				PrintWriter output = new PrintWriter(file2);// A
//printWriter to write to the updated file.
				while (inp.hasNextLine()) {// This while loop will go
//through the entire file reading it, and will check
					// for the various conditions
//along the way.
					String line = inp.nextLine();// This string will be a
//line in the file.
					if (line.contains("#Software")) {
						// This if statement will check if the line of text
//in the text file has the
						// string: "#Software".
						// If it does, it will be deleted.
						line = "";
					} else if (line.contains("#Version")) {
						// This if statement will check if the line of text
//in the text file has the
						// string: "#Version".
						// If it does, it will be deleted.
						line = "";
					} else if (line.contains("#Date")) {
						// This if statement will check if the line of text
//in the text file has the
						// string: "#Date".
						// If it does, it will be deleted.
						line = "";
					} else if (line.contains("#Fields")) {
						// This if statement will check if the line of text
//in the text file has the
						// string: "#Fields".
						// If it does, it will be deleted.
						line = "";
					} else if (line.contains("W_ValsPublicSurvey3point0")) {
						// This if statement will check if the line of text
//in the text file has the
						// string: "/4daction/W_ValsPublicSurvey3point0".
						// If it does, it will be deleted.
						line = "";

					} else if (line.contains("208.184.71.")) {
						// This if statement will check if the current line
//of text contains:
						// 208.184.71.
						// If any part of the line contains 208.184.71. it
//will be deleted.
						line = "";
					} else if (line.contains("66.104.253.")) {
						// This if statement will check if the current line
//of text contains:
						// 66.104.253.
						// If any part of the line contains 66.104.253. it
//will be deleted.
						line = "";
					} else if (line.contains("70.90.166.")) {
						// This if statement will check if the current line
//of text contains: 70.90.166.
						// If any part of the line contains 70.90.166. it
//will be deleted.
						line = "";
					} else if (line.contains("96.253.71.12.")) {
						// This if statement will check if the current line
//of text contains:
						// 96.253.71.12.
						// If any part of the line contains 96.253.71.12.
//it will be deleted.
						line = "";
					} else if (line.contains("172.20.1.")) {
						// This if statement will check if the current line
//of text contains: 172.20.1.
						// If any part of the line contains 172.20.1. it
//will be deleted.
						line = "";
					} else if (line.contains("81.174.142.107")) {
						// This if statement will check if the current line
//of text contains:
						// 81.174.142.107
						// If any part of the line contains 81.174.142.107
//it will be deleted.
						line = "";
					} else if (line.contains("211.9.36.241")) {
						// This if statement will check if the current line
//of text contains:
						// 211.9.36.241
						// If any part of the line contains 211.9.36.241 it
//will be deleted.
						line = "";
					} else if (line.contains("67.188.137.20")) {
						// This if statement will check if the current line
//of text contains:
						// 67.188.137.20
						// If any part of the line contains 67.188.137.20
//it will be deleted.
						line = "";
					} else if (line.contains("/theme/")) {
						// This if statement will check if the line
						//contains "/t/theme/"
						// If it does, then it will split the string into 5
						//parts and check
						// after the second tab if it contains /theme/, if
						//it does,
						// Then the line will be deleted.
						String str[] = line.split("\\s", 5);

						if (str[2].contains("/theme/"))
							line = "";
					} else if (line.contains("/media/")) {
						// This if statement will check if the line
						//contains "/t/media/"
						// If it does, then it will split the string into 5
						//parts and check
						// after the second tab if it contains /media/, if
						//it does,
						// Then the line will be deleted.
						String str[] = line.split("\\s", 5);

						if (str[2].contains("/media/"))
							line = "";
					} else if (line.contains("/about/")) {
						// This if statement will check if the line
//contains "/t/about/"
						// If it does, then it will split the string into 5
//parts and check
						// after the second tab if it contains /about/, if
//it does,
						// Then the line will be deleted.
						String str[] = line.split("\\s", 5);

						if (str[2].contains("/about/"))
							line = "";
					} else if (line.contains("/ads.txt")) {
						// This if statement will check if the line
//contains "/t/ads.txt/"
						// If it does, then it will split the string into 5
//parts and check
						// after the second tab if it contains /about/, if
//it does,
						// Then the line will be deleted.
						String str[] = line.split("\\s", 5);

						if (str[2].contains("/ads.txt"))
							line = "";

					} else if (line.contains(".gif")) {
						// This if statement checks if any part of the line
//contains .gif
						// If the line contains .gif, the line is deleted.
						line = "";
					} else if (line.contains(".jpg")) {
						// This if statement checks if any part of the line
//contains .jpg
						// If the line contains .jpg, the line is deleted.
						line = "";
					} else if (line.contains(".jpeg")) {
						// This if statement checks if any part of the line
//contains .jpeg
						// If the line contains .jpeg, the line is deleted.
						line = "";
					} else if (line.contains(".php")) {
						// This if statement checks if any part of the line
//contains .php
						// If the line contains .php, the line is deleted.
						line = "";
					} else if (line.contains(".png")) {
						// This if statement checks if any part of the line
//contains .png
						// If the line contains .png, the line is deleted.
						line = "";
					} else if (line.contains(".aspx")) {
						// This if statement checks if any part of the line contains .aspx
						// If the line contains .aspx, the line is deleted.
						line = "";
					} else if (line.contains(".xml")) {
						// This if statement checks if any part of the lineb contains .xml
						// If the line contains .xnk, the line is deleted.
						line = "";
					} else if (line.contains("wp-admin")) {
						// This if statement checks if any part of the line contains wp-admin
						// If the line contains wp-admin, the line is deleted.
						line = "";
					} else if (line.contains("wp-includes")) {
						// This if statement checks if any part of the line contains wp-includes
						// If the line contains wp-includes, the line is deleted.
						line = "";
					} else if (line.contains("erroraccess.shtml")) {
						// This if statement checks if any part of the line contains erroraccess.shtml
						// If the line contains erroraccess.shtml, the line is deleted.
						line = "";
					} else if (line.contains("errornouser.shtml")) {
						// This if statement checks if any part of the line contains errornouser.shtml
						// If the line contains errornouser.shtml, the line is deleted.
						line = "";
					} else if (line.contains("/about/newsletter/sbinews.shtml")) {
						// This if statement checks if any part of the linen contains
						// /about/newsletter/sbinews.shtml
						// If the line contains /about/newsletter/sbinews.shtml, the line is deleted.
						line = "";
					} else if (line.contains("/logout.asp")) {
						// This if statement checks if any part of the line contains /logout.asp
						// If the line contains /logout.asp, the line is deleted.
						line = "";
					} else if (line.contains("/search.shtml")) {
						// This if statement checks if any part of the line contains /search.shtml
						// If the line contains /search.shtml, the line is deleted.
						line = "";
					} else if (line.contains("/index.shtml")) {
						// This if statement checks if any part of the line contains /index.shtml
						// If the line contains /index.shtml, the line is deleted.
						line = "";
					} else if (line.contains("OpenLinkProfiler")) {
						// This if statement will check if the program has OpenLinkProfiler between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("OpenLinkProfiler"))
							line = "";
					} else if (line.contains("Tbot-nutch")) {
						// This if statement will check if the program has Tbot-nutch between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("Tbot-nutch"))
							line = "";

					} else if (line.contains("Linespider")) {
						// This if statement will check if the program has Linespider between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("Linespider"))
							line = "";

					} else if (line.contains("MJ12bot")) {
						// This if statement will check if the program has MJ12bot between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("MJ12bot"))
							line = "";

					} else if (line.contains("ZoominfoBot")) {
						// This if statement will check if the program has ZoominfoBot between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("ZoominfoBot"))
							line = "";

					} else if (line.contains("Adsbot")) {
						// This if statement will check if the program has Adsbot between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("Adsbot"))
							line = "";

					} else if (line.contains("BLEXBot")) {
						// This if statement will check if the program has BLEXBot between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("BLEXBot"))
							line = "";

					} else if (line.contains("bingbot")) {
						// This if statement will check if the program has Bingbot between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("bingbot"))
							line = "";

					} else if (line.contains("AhrefsBot")) {
						// This if statement will check if the program has AhrefsBot between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("AhrefsBot"))
							line = "";

					} else if (line.contains("Googlebot")) {
						// This if statement will check if the program has Googlebot between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("Googlebot"))
							line = "";
					} else if (line.contains("Seekport+Crawler")) {
						// This if statement will check if the program has Seekport+Crawler between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("Seekport+Crawler"))
							line = "";

					} else if (line.contains("8LEGS")) {
						// This if statement will check if the program has Tbot-nutch between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("8LEGS"))
							line = "";
					} else if (line.contains("Vagabondo")) {
						// This if statement will check if the program has Vagabondo between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("Vagabondo"))
							line = "";

					} else if (line.contains("PetalBot")) {
						// This if statement will check if the program has PetalBot between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("PetalBot"))
							line = "";
					} else if (line.contains("SemrushBot")) {
						// This if statement will check if the program has SemrushBot between the
						// 6th and 7th tab. If it does, then the line is deleted.
						// To do this, the string is split into seven parts, and the string in between
						// the 6th and 7th space is checked
						String str[] = line.split("\\s", 7);

						if (str[5].contains("SemrushBot"))
							line = "";

					} else if (line.contains("jhammar")) {
						// This if statement will check if any part of this line contains the username
						// jhammar. If it does, the line is deleted.
						line = "";
					} else if (line.contains("signe")) {
						// This if statement will check if any part of this line contains the username
						// signe. If it does, the line is deleted.
						line = "";
					} else if (line.contains("ysakata")) {
						// This if statement will check if any part of this line contains the username
						// ysakata. If it does, the line is deleted.
						line = "";
					} else if (line.contains("kyamamoto")) {
						// This if statement will check if any part of this line contains the username
						// kyamamoto. If it does, the line is deleted.
						line = "";
					} else if (line.contains("msico")) {
						// This if statement will check if any part of this line contains the username
						// msico. If it does, the line is deleted.
						line = "";
					} else if (line.contains("atakauchi")) {
						// This if statement will check if any part of this line contains the username
						// atakauchi. If it does, the line is deleted.
						line = "";
					} else if (line.contains("thunderstone")) {
						// This if statement will check if any part of this
//line contains the username
						// thunderstone. If it does, the line is deleted.
						line = "";
					} else if (line.contains("mschwirn")) {
						// This if statement will check if any part of this
//line contains the username
						// mschwirn. If it does, the line is deleted.
						line = "";
					} else if (line.contains("kwhitman")) {
						// This if statement will check if any part of this
//line contains the username
						// kwhitman. If it does, the line is deleted.
						line = "";
					} else if (line.contains("sbarulich")) {
						// This if statement will check if any part of this
//line contains the username
						// sbarulich. If it does, the line is deleted.
						line = "";
					} else if (line.contains("/favicon.ico")) {
						// This if statement will check if any part of this
//line contains the
						// /favicon.ico. If it does, the line is deleted.
						line = "";
					} else if (line.contains("/login.asp")) {
						// This if statement will check if any part of this
//line contains the
						// /login.asp. If it does, the line is deleted.
						line = "";
					} else if (line.contains("/robots.txt")) {
						// This if statement will check if any part of this
//line contains the
						// /robots.txt. If it does, the line is deleted.
						line = "";
					} else if (line.contains(".css")) {
						// This if statement will check if any part of this
//line contains the
						// .css. If it does, the line is deleted.
						line = "";
					} else if (line.contains("/vals/")) {
						// This if statement will check if the line
//contains "/t/vals/"
						// If it does, then it will split the string into 5
//parts and check
						// after the second tab if it contains /theme/, if
//it does,
						// Then the line will be deleted. Otherwise, the
//date format will change.
						// Changing the format for the date is explained at
//the end.
						// However, if the line contains:
//"/vals/international.shtml",
						// "/vals/international/",
//"/vals/store/free.shtml", "/vals/store/free/lens/",
						// Then the format of the date will change and the
//line will remain the same.
						if (line.contains("/vals/international.shtml") || line.contains("/vals/international/")
								|| line.contains("/vals/store/free.shtml") || line.contains("/vals/store/free/lens/")) {
							String str[] = line.split("\\s", 2);
							if (str[0].contains("2020-")) {
								String altStr[] = str[0].split("-", 2);
								str[0] = altStr[1] + "-" + altStr[0] + "\t";

							}

							for (int i = 0; i < str.length; i++)
								output.print(str[i]);
							output.println();

						} else {
							String str[] = line.split("\\s", 5);

							if (str[2].contains("/vals/"))
								line = "";
							else {// Changing the format of the date.
								if (str[0].contains("2020-")) {
									String altStr[] = str[0].split("-", 2);
									str[0] = altStr[1] + "-" + altStr[0] + "\t";
								}
								for (int i = 0; i < str.length; i++)
									output.print(str[i]);
								output.println();
							}
						}

					} else if (line.contains("200") && line.contains("25009")) {// line.contains("200" + "\t" +
																				// "25009")) {
						// If the current line contains the error code 200
						// 25009, The string is then
						// split into 10 parts, and the last part of the
						// string is then changed to 403
						// 25009. The date format is also modified.
						String str[] = line.split("\\s", 10);

						str[9] = "\t403\t25009 ";
						if (str[0].contains("2020-")) {
							String altStr[] = str[0].split("-", 2);
							str[0] = altStr[1] + "-" + altStr[0] + "\t";
						}
						for (int i = 0; i < str.length; i++)
							output.print(str[i]);
						output.println();

					} else if (line.contains("200") && line.contains("8087")) {
						// If the current line contains the error code 200
//8087, The string is then
						// split into 10 parts, and the last part of the
//string is then changed to 403
						// 8087. The date format is also modified.
						String str[] = line.split("\\s", 10);

						str[9] = "\t403\t8087 ";
						if (str[0].contains("2020-")) {
							String altStr[] = str[0].split("-", 2);
							str[0] = altStr[1] + "-" + altStr[0] + "\t";
						}
						for (int i = 0; i < str.length; i++)
							output.print(str[i]);
						output.println();

					} else {
						// This last part of the program will modify the
//format of the date and write
						// back the line into the file. To do this, the
//line must be split in two.
						// Then, you take the first part of the line, which
//contains the date, and you
						// split the date at the '-' symbol. Then, you take
//the second part of the
						// string and put it in the front, then add a '-',
//then add in the 2020.
						String str[] = line.split("\\s", 2);// Splits the
//string in two.

						if (str[0].contains("2020-")) {// Checks if it
//contains a 2020-.
							String altStr[] = str[0].split("-", 2);//
//Splits the date at the first -.
							str[0] = altStr[1] + "-" + altStr[0] + "\t";//
//Rearranges the date by putting the year in the
// back and the day and month first.

						}

						for (int i = 0; i < str.length; i++)// Prints the
//string back into the file with the updated date.
							output.print(str[i]);
						output.println();
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

				System.out.println("Merged" + filename2 + " intofinal.txt");

			} catch (FileNotFoundException e) {// If an exception is
//caught, an error message is displayed.
				System.out.println("File not Found!");
			}
		}

	}

}