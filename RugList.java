package com.example.assignment1;

import java.util.LinkedList;


public final class RugList extends LinkedList<Rug>
{

    private static RugList instance = null; // list does not exist initially.

    private RugList()
    {
        // Exists only to defeat additional instantiations.
    }

    public static RugList getInstance()
    {
        if(instance == null)
            instance = new RugList(); // create list here.

        return instance;
    }

} // end RugList
