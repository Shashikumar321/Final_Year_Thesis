package com.action.admin;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

public class ParserTest 
{

	 static Set<String> nounPhrases = new HashSet<>();
	 static Set<String> adjectivePhrases = new HashSet<>();
	 static Set<String> verbPhrases = new HashSet<>();
	
	/*private static String line = "The Moon is a barren, rocky world without air and water. It has dark lava plain on its surface. " +
			"The Moon is filled wit craters. It has no light of its own. It gets its light from the Sun. The Moo keeps changing its " +
			"shape as it moves round the Earth. It spins on its axis in 27.3 days stars were named after the Edwin Aldrin were the " +
			"first ones to set their foot on the Moon on 21 July 1969 They reached the Moon in their space craft named Apollo II";*/
	
private static String line="Sony?s high-end LED TVs are really good options for people who love watching TV and movies in a dark room."+ 
"They have great contrast and uniform blacks, and they also have the ability to display a wider range of colors than most TVs."+ 
"While they?re not the very best TVs for gaming, they?re certainly good enough to get the job done."
;
	public static  void getNounPhrases(Parse p) 
	  {
	    if (p.getType().equals("NN") || p.getType().equals("NNS") || p.getType().equals("NNP") || p.getType().equals("NNPS")) 
	    {
	         nounPhrases.add(p.getCoveredText());
	         System.out.println(p.getCoveredText());
	    }
	    
	    if (p.getType().equals("JJ") || p.getType().equals("JJR") || p.getType().equals("JJS")) 
	    {
	    	adjectivePhrases.add(p.getCoveredText());
	         System.out.println(p.getCoveredText());
	    }
	    
	    if (p.getType().equals("VB") || p.getType().equals("VBP") || p.getType().equals("VBG")|| p.getType().equals("VBD") || p.getType().equals("VBN"))
	    {
	    	verbPhrases.add(p.getCoveredText());
	         System.out.println(p.getCoveredText());
	    }
	    
	    for (Parse child : p.getChildren())
	    {
	         getNounPhrases(child);
	    }
	}
	
	
	public static  void parserAction(String ss,String path) throws Exception 
	{
		/* String line="Sony?s high-end LED TVs are really good options for people who love watching TV and movies in a dark room."+ 
				"They have great contrast and uniform blacks, and they also have the ability to display a wider range of colors than most TVs."+ 
				"While they?re not the very best TVs for gaming, they?re certainly good enough to get the job done."
				;*/
		/* String t="\"+".replace("+", "");
		 path.replace("\", ");*/
		/* path.replace(t.trim(), "//");*/
		// System.out.println("==============PARSER ACTION================================"+path);
		System.out.println("==============STRING IN PARSERTEST+++++++++++++++++"+ss);
		InputStream is = new FileInputStream(path);
	    ParserModel model = new ParserModel(is);
	    Parser parser = ParserFactory.create(model);
	    Parse topParses[] = ParserTool.parseLine(ss, parser, 1);
	    for (Parse p : topParses)
	    {
	    	//p.show();
	    	getNounPhrases(p);
	    }
	   show();
	}
	
	public static  void show() throws Exception
	{
		System.out.println("List of Noun Parse : "+nounPhrases);
		System.out.println("List of Adjective Parse : "+adjectivePhrases);
		System.out.println("List of Verb Parse : "+verbPhrases);
	}
	public static void ParsingMethod(String ss, String path) throws Exception
	{
		new ParserTest().parserAction(ss,path);
	}
	public static void main(String[] args) throws Exception
	{
		//new ParserTest().parserAction();
		/*System.out.println("List of Noun Parse : "+nounPhrases);
		System.out.println("List of Adjective Parse : "+adjectivePhrases);
		System.out.println("List of Verb Parse : "+verbPhrases);*/
	}

}
