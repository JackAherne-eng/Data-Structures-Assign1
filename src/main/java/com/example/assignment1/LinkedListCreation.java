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

    public int size() {
        LLNode<C> temp=head;
        int digit = 0;
        while(temp != null){
            temp = temp.next;
            digit++;
        }
        return digit;
    }

    public C get(int index) {
        LLNode<C> temp=head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp.getContents();
    }

    public void remove(int index){
        index=size()-index-1;

        if(index == 0){
            head = head.next;
        }
        else {
            LLNode<C> temp=head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    public void clear() {
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
