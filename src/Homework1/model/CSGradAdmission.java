package Homework1.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class CSGradAdmission {

    Integer id;

    String name;

    Date date;

    Double GPA;

    String status;

    public CSGradAdmission( Integer id, String name, Date date, Double GPA,
        String status )
    {
        this.id = id;
        this.name = name;
        this.date = date;
        this.GPA = GPA;
        this.status = status;
    }

    public String getDateStr()
    {
        SimpleDateFormat formatter = new SimpleDateFormat( "MM/dd/yyyy" );
        try
        {
            return formatter.format( date );
        }
        catch( ParseException e )
        {
            return null;
        }

    }

    public void sort_desc( Date[] a )
    {
        for( int i = 0; i < a.length - 1; ++i )
        {
            for( int j = i + 1; j < a.length; ++j )
                if( a[i].before( a[j] ) )
                {
                    Date tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Double getGPA()
    {
        return GPA;
    }

    public void setGPA( Double gPA )
    {
        GPA = gPA;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate( Date date )
    {
        this.date = date;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus( String status )
    {
        this.status = status;
    }

}
