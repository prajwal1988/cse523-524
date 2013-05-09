package preprocessing;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.util.TempFile;


public class PostProcessing 
{
	Vector<String> lines;
	public Vector<String> reFilterStream(Vector<String> lines2) 
	{
		
		String outString = "";
		int prev_index = 0;
		int curr_index = 0;
		
		String myStr = "";
		Pattern pt = Pattern.compile("[0-9]+");
		Matcher m;
		
		File tempFile = new File("temp.bak");
		if (lines2 != null)
		{
			
			try {
								
				Iterator<String> itr = lines2.iterator();
				BufferedWriter bw2 = new BufferedWriter(new FileWriter(tempFile));
				while (itr.hasNext())
				{
					bw2.write(itr.next());
				}
				bw2.close();
				
				BufferedReader br = new BufferedReader(new FileReader(tempFile));
				lines = new Vector<String>();
				
				String temp;
				while ((temp = br.readLine()) != null) {
					lines.add(temp);
				}
				
				int i=0;
				int count_removed = 0;
				lines.removeAll(Arrays.asList("", null));
				for (i=0; i< lines.size(); i++) {
					String next = lines.get(i);
					if (next.equalsIgnoreCase("") || next.equalsIgnoreCase("x") || next.equalsIgnoreCase("w") || next.length() == 1 || next.matches("\\s.") || next.matches(".\\s") || next.length() == 0){
						System.out.println("Removed line no : "+i+" value is : "+ next);
						lines.remove(i);
						count_removed ++;
					}
					else if (next.hashCode() == 0)
					{
						lines.remove(i);
						count_removed ++;
					}
					else {
						//next.replaceAll("[\r\r\n]", " ");					
						
						lines.set(i, next.trim());
					}
					
				}
				lines.removeAll(Arrays.asList("", null));
				System.out.println ("Removed no of lines : "+count_removed);
				
				//System.out.println("\r\n........Second round filtering.. .........\r\n");
				String tokens[];
				//StringBuilder sbr = new StringBuilder();
				for (i=0; i< lines.size(); i++) {
					String out = lines.get(i);
					
					tokens = out.split("\\s");
					if (tokens != null)
						out = cleanup_local(tokens);	
					
					
					if (!out.isEmpty()) {
						prev_index = outString.length();
						if (out.matches("[0-9]+[\\w\\s\\d,:;@.=\\-']*")) {
							if (out.matches("[0-9]+[=][\\w\\s\\d,:;@.=\\-']*")) {
								
								outString+=" "+out;
							}
							else {
								outString+=".\r\n"+out;
								prev_index = outString.length() - out.length();
							}
						}				
						else	
							outString+= out;
						
						curr_index = outString.length();
						
						myStr = outString.substring(prev_index, curr_index);
						String newmyStr = "";
						if (myStr != null)
						{
							m = pt.matcher(myStr);
							if (m.find())
							{
								int idx = myStr.indexOf(m.group());
								
								if (myStr.length() >= (idx+1) && myStr.charAt(idx + 1)!='=') {
									newmyStr = myStr.replace(m.group().trim(), m.group().trim()+".");
									outString = outString.replace(myStr, newmyStr);
									myStr = newmyStr;
								}
							}
						    
						}
						
						System.out.println("CurrLine added is : "+myStr);
						
						//ystem.out.println("..................................");
						System.out.println(out);
						System.out.println("..................................");
					}
				}
				
				System.out.println ("Inserting ending period !");
				outString+=".";
				
				System.out.println ("Final text is : ...........................................");
				
				System.out.println(outString);
				
				
				lines.clear();
				
				outString = processFinalString(outString,lines);
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File("E:\\results\\out2.txt")));
				bw.write(outString);
				bw.close();
				br.close();
				
				
				
				//br.close();	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if (tempFile.exists())
			tempFile.delete();
		
		return lines;
	}
	
	public String processFinalString (String finString, Vector<String> outVect) 
	{
		String outStr = "";
		Pattern pt2 = Pattern.compile("[0-9]+=[\\w\\s]*");
		Matcher m;
		String temp;
		String newline = System.getProperty("line.separator");
		if (finString != null)
		{
			String tokens[] = finString.split("\\n");
			//System.out.println("......................PROCESSFINSTRING..................");
			if (tokens != null) {
				for (int i=0;i<tokens.length;i++) {
					tokens[i] = tokens[i].trim();
					if (tokens[i].length() > 1) {
						m = pt2.matcher(tokens[i]);
						if (m.find()) {
							temp = m.group().trim();
							tokens[i] = tokens[i].replace(temp, ": "+temp);
							tokens[i] = tokens[i].replaceAll(",", ";");
							tokens[i] = tokens[i].replaceAll("]","-");
						}
						outStr+=tokens[i]+newline;
						if (outVect != null) {
							outVect.add(tokens[i]+newline);
						}
						System.out.println(tokens[i]);
						System.out.println("___________________________________________________");
					}
				}
			}
			//System.out.println("......................PROCESSFINSTRING..................");
		}
		System.out.println ("OutString is : ......................................");
		System.out.println(outStr);
		System.out.println("................................................................");
		return outStr;
	}
	
	static String cleanup_local (String tokens[])
	{
		String out = "";
		for (int i=0;i<tokens.length;i++)
		{
			if (tokens[i].isEmpty())
				continue;
			
			if (tokens[i].equalsIgnoreCase("w"))
				continue;
			
			if (tokens[i].length() <= 2)
				if (tokens[i].equalsIgnoreCase(".") || tokens[i].contains("x"))
					continue;
			if(tokens[i].matches("[0-9]+"))
				tokens[i] = tokens[i];
			
			if (i==tokens.length - 1)
				out += tokens[i];
			else
				out += tokens[i]+" ";
		}
		
		return out;
	}

}
