package Homework1.controller;

import java.util.Comparator;

import Homework1.model.CSGradAdmission;

public class SortMechanic implements Comparator<CSGradAdmission> {

    public int compare( CSGradAdmission o1, CSGradAdmission o2 )
    {
        // TODO Auto-generated method stub
        return o1.getName().compareToIgnoreCase( o2.getName() );
    }
}

class sortID implements Comparator<CSGradAdmission> {

    @Override
    public int compare( CSGradAdmission o1, CSGradAdmission o2 )
    {
        return o1.getId() < o2.getId() ? -1 : o1.getId() == o2.getId() ? 0 : 1;
    }
}

class sortDate implements Comparator<CSGradAdmission> {

    @Override
    public int compare( CSGradAdmission o1, CSGradAdmission o2 )
    {
        if( o1.getDate().before( o2.getDate() ) )
        {
            return -1;
        }
        else if( o1.getDate().after( o2.getDate() ) )
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}

class sortGPA implements Comparator<CSGradAdmission> {

    @Override
    public int compare( CSGradAdmission o1, CSGradAdmission o2 )
    {
        if( o1.getGPA() == null && o2.getGPA() == null ){ return 0; }
        if( o1.getGPA() == null ){ return -1; }
        if( o2.getGPA() == null ){ return 1; }
        // return NULL_COMPARATOR.compare(o1.getGPA(), o2.getGPA());
        return o1.getGPA() < o2.getGPA() ? -1
            : o1.getGPA() == o2.getGPA() ? 0 : 1;
    }
}

class sortStatus implements Comparator<CSGradAdmission> {

    @Override
    public int compare( CSGradAdmission o1, CSGradAdmission o2 )
    {
        // TODO Auto-generated method stub
        return o1.getStatus().compareToIgnoreCase( o2.getStatus() );
    }
}
