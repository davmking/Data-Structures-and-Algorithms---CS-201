public class LinkStrand implements IDnaStrand{

    private class Node{
        String info;
        Node next;

        Node(){}
        Node(String str){
            info = str;
        }
        Node(String str, Node nextNode){
            info = str;
            next = nextNode;
        }
    }

    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;
    private int myIndex;
    private Node myCurrent;
    private int myLocalIndex;

    public LinkStrand(){
        this("");
    }

    public LinkStrand(String s){
        initialize(s);
    }

    @Override
    public long size() {
        return mySize;
    }

    @Override
    public void initialize(String source) {
        Node init = new Node(source);
        myFirst = init;
        myIndex = 0;
        myCurrent = myFirst;
        myLast = init;
        myLocalIndex = 0;
        mySize = source.length();
        myAppends = 0;        
    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        Node dnaInfo = new Node(dna);
        myLast.next = dnaInfo;
        myLast = myLast.next;
        mySize += dna.length();
        myAppends++;
        return this;
    }

    @Override
    public String toString(){
        myCurrent = myFirst;
        StringBuilder allInfo = new StringBuilder();
        while(myCurrent != null){
            allInfo.append(myCurrent.info);
            myCurrent = myCurrent.next;
        }
        //myCurrent = myFirst;
        return allInfo.toString();
    }

    @Override
    public IDnaStrand reverse() {
        Node prev = null;
        Node temp = null;
        Node first = null;
        Node last = null;
        Node current = myFirst;
        while(current != null){
            if(first == null){
                first = new Node(current.info);
                last = first;
            }
            else{
                last.next = new Node();
                last = last.next;
                last.info = current.info;
                last.next = null;
            }
            current = current.next;
        }
        current = first;
        while(current != null){
            StringBuilder backwards = new StringBuilder();
            backwards.append(current.info);
            backwards.reverse();
            current.info = backwards.toString();
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        LinkStrand rev = new LinkStrand(prev.info);
        rev.myFirst.next = prev.next;
        rev.myCurrent = rev.myFirst;
        while(rev.myCurrent.next != null){
            rev.mySize += rev.myCurrent.next.info.length();
            rev.myCurrent = rev.myCurrent.next;
        }
        rev.myLast = rev.myCurrent;
        rev.myCurrent = rev.myFirst;
        rev.myAppends = 0;
        rev.myIndex = 0;
        rev.myLocalIndex = 0;
        return rev;
    }

    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
    public char charAt(int index){
        if(index < 0 || index >= mySize){
            throw new IndexOutOfBoundsException();
        }
        else if(index >= myIndex && myCurrent != null && myIndex > 0){
            myLocalIndex += (index - myIndex);
            myIndex = index;
        }
        else{
            myIndex = index;
            myLocalIndex = index;
            myCurrent = myFirst;
        }
        while(myCurrent != null && myCurrent.next != null && myLocalIndex >= myCurrent.info.length()){
            myLocalIndex -= myCurrent.info.length();
            myCurrent = myCurrent.next;
        }
        return myCurrent.info.charAt(myLocalIndex);
    }
    
}
