package Homework1.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Homework1.model.CSGradAdmission;

@WebServlet(urlPatterns = "/CSGradApply", loadOnStartup = 1)
public class CSGradApply extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CSGradApply()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        SimpleDateFormat formatter = new SimpleDateFormat( "MM/dd/yyyy" );
        try
        {
            // create a static arraylist for status
            List<String> statusList = new ArrayList<String>();
            statusList.add( new String( "Application Incomplete" ) );
            statusList.add( new String( "Pending Review" ) );
            statusList.add( new String( "Rejected" ) );
            statusList.add( new String( "Accepted" ) );
            statusList.add( new String( "Admission Offer Sent" ) );
            statusList.add( new String( "Admission Offer Accepted" ) );
            getServletContext().setAttribute( "statusList", statusList );

            List<CSGradAdmission> entries = new ArrayList<CSGradAdmission>();
            entries.add( new CSGradAdmission( 100, "John Doe",
                formatter.parse( "10/21/2015" ), 3.1, "Pending Review" ) );
            entries.add( new CSGradAdmission( 101, "Jane Doe",
                formatter.parse( "3/20/2015" ), null,
                "Application Incomplete" ) );
            entries.add( new CSGradAdmission( 102, "Amy Smith",
                formatter.parse( "3/1/2015" ), 3.3, "Accepted" ) );
            getServletContext().setAttribute( "entries", entries );
            // Collections.sort(entries, new SortMechanic());

        }
        catch( ParseException e )
        {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        List<CSGradAdmission> entries = (List<CSGradAdmission>) getServletContext()
            .getAttribute( "entries" );

        String sort = request.getParameter( "sort" );
        if( sort != null )
        {
            if( sort.equals( "id" ) )
            {
                Collections.sort( entries, new sortID() );
            }
            else if( sort.equals( "name" ) )
            {
                Collections.sort( entries, new SortMechanic() );
            }
            else if( sort.equals( "date" ) )
            {
                Collections.sort( entries,
                    Collections.reverseOrder( new sortDate() ) );
            }
            else if( sort.equals( "gpa" ) )
            {
                Collections.sort( entries,
                    Collections.reverseOrder( new sortGPA() ) );
            }
            else if( sort.equals( "status" ) )
            {
                Collections.sort( entries, new sortStatus() );
            }
        }
        else
        {
            Collections.sort( entries,
                Collections.reverseOrder( new sortDate() ) );
        }
        request.setAttribute( "sort", sort );
        request.setAttribute( "entries", entries );
        request
            .getRequestDispatcher( "/WEB-INF/Homework1/view/CSGradApply.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}
