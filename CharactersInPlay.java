import edu.duke.*;
import java.util.*;

/**
* 
* @author: Amir Armion 
* 
* @version: V.01
* 
*/
public class CharactersInPlay 
{
    private ArrayList<String>  namesOfCharacters;
    private ArrayList<Integer> freqs;

    // Constructor
    public CharactersInPlay()
    {
        namesOfCharacters = new ArrayList<>();
        freqs             = new ArrayList<>();
    }

    public void update(String person)
    {
        if(!namesOfCharacters.contains(person))
        {
            namesOfCharacters.add(person);
            freqs.add(1);
        }
        else
        {
            for(int i = 0; i < namesOfCharacters.size(); i++)
            {
                if(namesOfCharacters.get(i).equals(person))
                {
                    int indexVal = freqs.get(i);
                    freqs.set(i, indexVal + 1);
                }
            }
        }
    }

    public void findAllCharacters()
    {
        namesOfCharacters.clear();
        freqs.clear();

        FileResource resource = new FileResource();

        for(String line: resource.lines())
        {
            int indexOfPeriod = line.indexOf(".");

            if(indexOfPeriod != -1)
            {
                String person = line.substring(0, indexOfPeriod);
                person        = person.toLowerCase();
                update(person);
            }
        }

        System.out.println("\nNumber of Names: " + namesOfCharacters.size());

        System.out.println("Number of Freqs: " + freqs.size());
    }

    public void charactersWithNumParts(int num1, int num2)
    {
        System.out.println("\nName of characters with number of part of speaking between " + num1 + " and " + num2 + ":\n");

        for(int i = 0; i < freqs.size(); i++)
        {
            if(freqs.get(i) >= num1 && freqs.get(i) <= num2)
            {
                System.out.println("Name of character: " + namesOfCharacters.get(i) + "; Speaking parts: " + freqs.get(i));
            }
        }
    }

    public void tester()
    {        
        findAllCharacters();
        System.out.println();

        int maxOccurance = 0;
        int maxIndex     = 0;

        for(int i = 0; i < namesOfCharacters.size(); i++)
        {
            if(freqs.get(i) > maxOccurance)
            {
                maxOccurance = freqs.get(i);
                maxIndex = i;
            }
        }

        System.out.println("The main character is: " + namesOfCharacters.get(maxIndex) + " with " + maxOccurance + " times occurance.");

        charactersWithNumParts(50, 200);
    }
}
