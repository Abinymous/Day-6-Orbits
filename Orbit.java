import java.util.*; import java.io.*;
public class Orbit
{
	static ArrayList<String> orbits;
	static ArrayList<ArrayList<String>> orbits2;
	public static void main(String[] args) throws IOException
	{
		File input = new File("input.txt");
		Scanner scan = new Scanner(input);
		String s[];
		int lines = 0, totalLines = 0, numDirect = 0, numIndirect = 0;
		
		FileReader fr = new FileReader(input);
		LineNumberReader lnr = new LineNumberReader(fr);
		
		while (lnr.readLine() != null) {totalLines++;}
		
		orbits = new ArrayList<String>();
		
		orbits2 = new ArrayList<ArrayList<String>>();
		while (lines < totalLines)
		{
			s = scan.nextLine().split("\\)");
			
			if (orbits.indexOf(s[0]) == -1)
			{
				orbits.add(s[0]);
				
				ArrayList<String> newOrbit = new ArrayList<String>();
				newOrbit.add(s[1]);
				
				orbits2.add(newOrbit);
			}
			else {orbits2.get(orbits.indexOf(s[0])).add(s[1]);}
			
			lines++;
		}
		
		for(ArrayList<String> orbit : orbits2) {numDirect += orbit.size();}
		for (String orbit : orbits) {numIndirect += indirect(orbit);}
		System.out.println(numDirect + " " + numIndirect + " " + (numDirect + numIndirect));
	}
	
	public static int indirect(String orbit)
	{
		int index = orbits.indexOf(orbit);
		
		if (index == -1)
		{
			System.out.println("oop");
			return 0;
		}
		else if (orbits2.size() < index)
		{
			System.out.println("and i oop");
			return 0;
		}
		else
		{
			ArrayList<String> children = orbits2.get(index);
			
			int count = 1;
			for (String child : children)
			{
				count += indirect(child);
			}
			
			return count;
		}
	}
}