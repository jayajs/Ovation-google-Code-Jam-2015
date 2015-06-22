package ova;

import java.io.FileReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Ovation {
	public static void main(String args[]) throws IOException
	{
		BufferedReader  br = new BufferedReader(new FileReader("C:\\Users\\rj1\\workspace\\Ovation\\src\\ova\\test.in"));
		int testcases = Integer.parseInt(br.readLine());
		
		for(int i=0;i<testcases;i++)
		{
			//Main Logic Goes here//
			int clapped=0;int extras=0;
			String line = br.readLine();
			int highshy = Integer.parseInt(line.split(" ")[0]);
			String line1 = line.split(" ")[1];
			int [] shydata = new int [line1.length()];
			for(int j=0;j<shydata.length;j++)
			{
				shydata[j] = line1.charAt(j)-'0';
			}
			//System.out.println(Arrays.toString(shydata));
			if(shydata.length > 0 && shydata[0]>0) clapped+=shydata[0];
			else if(shydata.length >0 && shydata[0]==0) {clapped++;extras++;}
			for(int j=1;j<shydata.length;j++)
			{
				if(j<=clapped)
				{
					clapped+=shydata[j];
				}
				else if(j>clapped && shydata[j]!=0)
				{
					extras=extras +(j-clapped);
					clapped+=(j-clapped);
					clapped+=shydata[j];
				}
			}
			/*
			for (int j = 0; j < shydata.length; j++) {
				if (clapped < j) {
					extras++;
					clapped++;
				}
				clapped += shydata[j];
			}*/
			//System.out.println(clapped);
			System.out.println("Case #"+(i+1)+":"+" "+extras);
		}
		br.close();
		
	}
}