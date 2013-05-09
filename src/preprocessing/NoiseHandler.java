package preprocessing;

import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import base.PdfConverter;


public class NoiseHandler {
	
	int frequencyThreshold;
	Vector<String> knownNoise; 
	boolean curruptedStream = false;
	
	PdfConverter pdfConverter = null;
	
	public NoiseHandler(int frqTh, Vector<String> noise)
	{
		frequencyThreshold = frqTh;	
		knownNoise = noise;
	}
	
	public void setPdfConverterInstance (PdfConverter pdf) {
		if (pdf != null) {
			pdfConverter = pdf;
		}
			
	}
	

        
	public Vector<String> deNoisify(Vector<String> inpStream) {
		Vector<String> noiseFreeStream = new Vector<String>();
		/* Create Frequency map first*/
		HashMap<String, Integer > frqMap = new HashMap<String, Integer >();
		
		for(int i=0;i<inpStream.size();i++)
		{
			int count = 0;
			if (frqMap.containsKey(inpStream.get(i)))
				count = frqMap.get(inpStream.get(i));
			frqMap.put(inpStream.get(i), count + 1);
		}
		
		int noiseLines = 0;
		
		for(int i=0;i<inpStream.size();i++)
		{
			String curLine = inpStream.get(i);
			
			if (curLine.contains(". wx") || curLine.contains("x .")) {
				curruptedStream = true;
				break;
			}
			
			int count = frqMap.containsKey(inpStream.get(i)) ? frqMap.get(inpStream.get(i)) : 0;
			
			if(count < frequencyThreshold && knownNoise.contains(curLine)==false && curLine.length()>=3)
				noiseFreeStream.add(curLine);
			else {
				System.out.println("INFO : Removing NOISE - "+curLine);
				noiseLines++;
				}
			
			
			
		}
		
		if (curruptedStream) {
			
			noiseFreeStream.clear();
			
			if (pdfConverter != null) {
				pdfConverter.setPdfStreamCorruptionAlert(true);
			}
			
			for(int i=0;i<inpStream.size();i++)
			{
				String curLine = inpStream.get(i);			
				
				int count = frqMap.containsKey(inpStream.get(i)) ? frqMap.get(inpStream.get(i)) : 0;
				
				if(count < frequencyThreshold && knownNoise.contains(curLine)==false && curLine.length()>=3) {
					curLine = curLine.replaceAll("\\P{Print}", "");
					
					curLine = curLine.replaceAll("\\s+", " ");
					curLine = curLine.replaceAll("[\n\r\\(\\)\"]", "");
					curLine = curLine.replaceAll("(?i)(?<!dr|mr|mrs|ms|jr|sr|\\s\\w)(\\s*[\\.\\?\\!\\;](?:\\s+|$))","\r\n");
					curLine = curLine.replace("wx", "");
					curLine = curLine.replace("-x", "");
					curLine = curLine.trim();
					
					if (curLine.isEmpty())
				    	continue;
					
					if(curLine.contains("70"))
						System.out.println();
					
					Pattern r = Pattern.compile("[0-9]+[\\s]*s[\\s]*[\\w]*");
					Matcher m = r.matcher(curLine);
					
					 while(m.find())
					  {
						  
							  String str = m.group().trim();
							  String str2 = str.replaceAll("\\s", "");
							  int idx = str2.indexOf('s');
							  StringBuilder new_str = new StringBuilder(str2);
							  new_str.setCharAt(idx, '=');
							  curLine = curLine.replace(str, new_str);
							  							 
					  }
					 
					 
					 
					
					if ((""+curLine.charAt(curLine.length() - 1)).matches("[0-9]+")) {
						curLine+=" ";
					}
					else {
						curLine+='\r';
						curLine+='\n';
					}
					
				    if (!noiseFreeStream.contains(curLine))
				    	noiseFreeStream.add(curLine);
				}
			    else {
					System.out.println("INFO : Removing NOISE - "+curLine);
					noiseLines++;
				}
				
				
				
			}
			
			PostProcessing pp = new PostProcessing();
			noiseFreeStream = pp.reFilterStream(noiseFreeStream);
		}
		
		System.out.println("---------------------- Removed "+noiseLines+" noise lines ------------------");	
		return noiseFreeStream;
	}	

}
