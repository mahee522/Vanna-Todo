package com.transaction;

import java.util.Random;

public class UniqueIdTest
{
	public static String uniquId()
	  {
		  char[] chars = "abcdefghijklmnopqrstuvwxyzABSDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
		  Random r = new Random(System.currentTimeMillis());
		  char[] id = new char[8];
		  for (int i = 0;  i < 8;  i++) 
		  {
			  id[i] = chars[r.nextInt(chars.length)];
		  }
		  return new String(id);
	  }

}