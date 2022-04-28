package fantasy.dataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Trie<Value> {

    private static final int alphabetSize = 36; // alphabet
    private Trie.Node root; // root of trie

    private static class Node<Value> {
        protected Set<Value> values = new HashSet<Value>();
        protected Trie.Node[] links = new Node[Trie.alphabetSize];
    }

    public void put(String key, Value val) {}

    public void getAllSorted(String key, Comparator<Value> comparator) {};

    public void getAllWithPrefixSorted(String prefix, Comparator<Value> comparator){};

    public void deleteAllWithPrefix(String prefix){};

    private void deleteSubtrie(Node node, Set<Value> delValues){}

    private void getAllDescendants(Node node, Set<Value> descendants){};

    public void deleteAll(String key){};

    public void delete(String key, Value val){};

    private int indexConverter(char element){
        if(Character.isLetter(element)){
            return (int) element - 97;
        }else if (Character.isDigit(element)){
            return (int) element - 22; // position numerics after letters
        }
        else{
            return -1;
        }
    }
}
