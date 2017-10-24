// 20171021  Jiao Feng (Evan)  Data Mining 
// this program takes input file paper.txt and vocab.txt 
// and outputs title.txt

import java.util.Scanner; 
import java.io.File; 
import java.io.IOException; 
import java.io.PrintStream;

public class TextMining
{
	public static void main(String[] args) throws IOException
	{		
		Scanner console = new Scanner(System.in);

		System.out.print("Please type the paper file name(paper.txt): ");
		Scanner f1 = new Scanner(new File(console.nextLine())); // load paper.txt into f1

		System.out.print("Please type the vocabulary file name(vocab.txt): "); // load vocab.txt into f2
		String fileVocab = console.nextLine();

		PrintStream output = new PrintStream(new File("title.txt"));

		System.out.println("A text file named \"title.txt\" has been generated.");

		while(f1.hasNextLine()) 
		{
			String lineTemp1 = f1.nextLine();
			Scanner parseLine1 = new Scanner(lineTemp1);

			String[] titlePiece = new String [30];

			String foo = parseLine1.next();  // skip the first token: the index
			
			int i = 0;
			while(parseLine1.hasNext())			
				titlePiece[i++] = parseLine1.next();
			   // now we have a line stored			

			int[] pieceIndex = new int[30];				
			int vocabularyIndex = 0;

			Scanner f2 = new Scanner(new File(fileVocab));

			while(f2.hasNextLine() )  // vocab.txt should be scanned only once
			{
				String vocabulary = f2.nextLine();			

				for(int j = 0; j < i; j++)
					if( titlePiece[j].equals(vocabulary) ) 			
						pieceIndex[j] = vocabularyIndex;	
								 	
				vocabularyIndex++;					
			}
			f2.close();

			int pieceCount[] = new int[30];

			for(int a = 0; a < i; a++)
				for(int b = 0; b < i; b++)				
					if(pieceIndex[a] == pieceIndex[b])  pieceCount[a]++;				
			
			output.print(i + " ");	

			for(int k = 0; k < i; k++)			
				output.print(" " + pieceIndex[k] + ":" + pieceCount[k]);
			
			output.println();
		}
	}
}
















