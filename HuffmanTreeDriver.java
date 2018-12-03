/**
 * Name: Izzy Hurley
 * Lab Name: HuffmanTreeDriver
 * Lab Purpose: The goal of HuffmanTreeDriver is to create a program
 * Date: 11/30/18
 * Collaborators: None
 * ON MY HONOR: IH
 */
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class HuffmanTreeDriver {
    public static void main(String[] args) throws FileNotFoundException{
    Scanner s = new Scanner(new File("sample.txt"));
        String string = s.nextLine();
        System.out.println(string);
        HuffmanTree hf = new HuffmanTree(string);

        System.out.println(hf.size);
        System.out.println(hf);




    }
}
