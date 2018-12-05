/**
 * Name: Izzy Hurley
 * Lab Name: HuffmanTree
 * Lab Purpose: The goal of HuffmanTree is to create a program
 * Date: 11/27/18
 * Collaborators: None
 * ON MY HONOR: IH
 */

import java.nio.charset.*;

import java.lang.Object;
import java.util.*;

public class HuffmanTree {

  private Node root;
  public int size;
  private String s;
  public HuffmanTree(String s){
      this.s = s;
      size = 0;
        PriorityQueue <Node> q = new PriorityQueue();
        String contain = "";
        int count;


        for (int i = 0; i < s.length(); i++) {
            //iterate through the string and find the chars one at a time
            char im = s.charAt(i);
            String ims = "" +im;
            //see if the current char has already been added to queue or not
            if (contain.contains(ims) == false) {
                //if the queue hadn't had the char so far then the count is O
                //we need the count to be 1 as we just found one of that char
                count = 1;
                //add to string tracking all different chars appearing in the string
                contain += im;
                //loop through the rest of the string to see if there are more of that char
                for (int j = i; j < s.length(); j++) {
                    //if we find a match of the char increase the count
                    if (s.charAt(j) == im) {
                        count++;
                    }
                }
                //create a node with key value (char and it's count/occurence)
                Node a = new Node(im,count);
                //enqueue
                q.add(a);
            size = q.size();
            }

        }
        while (q.size()>=2){
            Node rem1 = q.peek();
            q.remove(rem1);
            Node rem2 = q.peek();
            q.remove(rem2);
            Node placeholder = new Node('*',rem1.freq+rem2.freq);//keep star as the placeholder

                placeholder.left= rem2;
                placeholder.right = rem1;

            q.add(placeholder);
            size++;
    }
    Node root =  q.peek();
    this.root = root;
    }

    private Node [] recursiveArray(Node n, int i, Node [] a){

        if(n.isLeaf()){
            a[i] = n;
            return a;
        }
        if(n.right == null && n.left != null){
            a[i] = n;
            return recursiveArray(n.left, 2*i+1, a);
        }
        if(n.left == null && n.right != null){
            return recursiveArray(n.right, 2*i+2, a);
        }
        else{
            a[i] = n;
            a = recursiveArray(n.left, 2*i+1, a);
            return recursiveArray(n.right, 2*i+2, a);
        }

    }

    @Override
    public String toString() {
        String s = "";
        int cal = 0;
        double var = 0;
    while (var<size){
       var = Math.pow(2,cal)-1;
    cal++;
    }

        var = Math.pow(2,cal)-1;
        Node[]ar = new Node[(int)var];
        ar = recursiveArray(root, 0, ar);
        for(int i = 0; i < var; i++){
        if (ar[i] !=null)     {    s += ar[i].toString();}
        }
        return s;
    }
    public String buildEncoding(){
              ArrayDictionary dict = new ArrayDictionary();
              recursiveEncode(root,dict,"");
              String encoding = "";

              for (int i =0; i<s.length();i++){
                  encoding+= dict.get(s.charAt(i));
              }
    String tree =  ""+this.toString().getBytes(Charset.defaultCharset());
        return tree + "\n" +encoding;
    }

    private void recursiveEncode(Node n, ArrayDictionary ard, String str){
      if (n.isLeaf()){ ard.put(n.c,str);return;}
      else {recursiveEncode(n.left, ard,str +0);
      recursiveEncode(n.right, ard, str+1);}

}}