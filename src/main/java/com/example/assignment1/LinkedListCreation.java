package com.example.assignment1;
import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListCreation<C>  {
    public LLNode<C> head=null;

    public void addElement(C e) { //Add element to head of list
        LLNode<C> lln=new LLNode<>();
        lln.setContents(e);
        lln.next=head;
        head=lln;
    }
    public void clear() { //Empty list
        head=null;
    }

    public void deleteToLinkedList() {

    }

    public void getLinkedList() {

    }
    //Add other insertion, deletion, access, search, etc. methods too
//Inner class approach.
    class LLNode<C> {
        public LLNode<C> next=null;
        private C contents; //ADT reference!
        public C getContents() { return contents; }
        public void setContents(C c) { contents=c; }
    }
}
