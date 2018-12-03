
public class Node implements Comparable <Node>{
    public char c;
    public int freq;
    public Node left;
    public Node right;

    public Node(){};
    public Node(char c, int freq){
        this.c = c;
        this.freq = freq;
    };

    @Override
    public int compareTo(Node n) {
        return   this.freq - n.freq;

    }

    public boolean isLeaf(){
        if (getLeft() ==null && getRight() ==null){return true;}
    else return false;}
    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }



    public String toString(){
        return "[" + c + freq + "]";

    }
}
