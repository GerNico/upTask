package Adapter;

import java.util.ArrayList;

interface  List {
    int count();                 //return the current number of elements in the list
    Object get(int index);       //return the object at the index in the list
    Object first();              //return the first object in the list
    Object last();               //return the last object in the list
    boolean include(Object obj); //return true is the object in the list
    void append(Object obj);     //append the object to the end of the list
    void prepend(Object obj);    //insert the object to the front of the list
    void delete(Object obj);     //remove the object from the list
    void deleteLast();           //remove the last element of the list
    void deleteFirst();          //remove the first element of the list
    void deleteAll();            //remove all elements of the list
}
public class Adapter extends ArrayList implements List {
    @Override
    public int count() {
        return this.size();
    }

    @Override
    public Object get(int index) {
        return super.get(index);
    }

    @Override
    public Object first() {
        return this.get(0);
    }

    @Override
    public Object last() {
        if (this.size()>=1)
        return this.get(this.size()-1);
        else return null;
    }

    @Override
    public boolean include(Object obj) {
        return this.contains(obj);
    }

    @Override
    public void append(Object obj) {
        this.add(0,obj);
    }

    @Override
    public void prepend(Object obj) {
        this.add(obj);
    }

    @Override
    public void delete(Object obj) {
        this.remove(obj);
    }

    @Override
    public void deleteLast() {
        if (this.size()>=1)this.remove(this.size()-1);
    }

    @Override
    public void deleteFirst() {
        if (this.size()>=1)this.remove(0);
    }

    @Override
    public void deleteAll() {
        this.removeAll(this);
    }
}
