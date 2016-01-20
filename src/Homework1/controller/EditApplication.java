package Homework1.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Homework1.model.CSGradAdmission;

@WebServlet("/EditApplication")
public class EditApplication extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EditApplication()
    {
        super();
    }

    @SuppressWarnings("unchecked")
    private CSGradAdmission getEntry( Integer id )
    {
        List<CSGradAdmission> entries = (List<CSGradAdmission>) getServletContext()
            .getAttribute( "entries" );

        for( CSGradAdmission entry : entries )
            if( entry.getId().equals( id ) ) return entry;
        return null;
    }

    @SuppressWarnings({ "unchecked" })
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        response.setContentType( "text/html" );
        // get the entry to be edited
        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        CSGradAdmission entry = getEntry( id );
        // pass the entry to jsp using request scope
        request.setAttribute( "entry", entry );
        List<String> statusList = (List<String>) getServletContext()
            .getAttribute( "statusList" );
        // System.out.println(entry.getStatus());
        for( String a : statusList )
        {

            System.out.println( a );
        }

        request
            .getRequestDispatcher(
                "/WEB-INF/Homework1/view/EditApplication.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String status = request.getParameter( "isStatus" );
        String dateStr = request.getParameter( "date" );
        // get the entry to be edited
        SimpleDateFormat formatter = new SimpleDateFormat( "MM/dd/yyyy" );

        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        CSGradAdmission entry = getEntry( id );
        try
        {
            if( request.getParameter( "gpa" ).isEmpty() )
            {
                entry.setGPA( null );
            }
            else
            {
                entry.setGPA(
                    Double.parseDouble( request.getParameter( "gpa" ) ) );
            }
            // change the entry based on user input
            entry.setName( request.getParameter( "name" ) );
            entry.setDate( formatter.parse( dateStr ) );
            // entry.setGPA(Double.parseDouble(request.getParameter("gpa")));
            entry.setStatus( status );
        }
        catch( ParseException e )
        {
            e.printStackTrace();
        }
        // send the user back to the CS Grad Admissions list page
        response.sendRedirect( "CSGradApply" );
    }

}
