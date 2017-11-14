package com.etlsolutions.examples.jerseyrestful;

import com.thoughtworks.xstream.XStream;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/xmlServices")
public class JerseyRestService {
    
    public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    
    @GET
    @Path("/print/{name}")
    @Produces(MediaType.APPLICATION_XML)
    public Student responseMsg(@PathParam("name") String name) {
        
        Student st = new Student(name, "Diaz", 22, 1);
        return st;
    }
    
    @POST
    @Path("/send")
    @Consumes(MediaType.APPLICATION_XML)
    public Response consumeXML(Student student) {
        
        String output = student.toString();
        
        XStream xStream = new XStream();
        xStream.alias("AKDK", Student.class);
        
        String xml = XML_HEADER + xStream.toXML(student);
        PrintWriter out; 
        try {
            out = new PrintWriter("C:\\Temp\\kyyy.xml");
            out.write(xml);
            out.flush();
        } catch (Exception ex) {
            Logger.getLogger(JerseyRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(xml);
        
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("C:\\Temp\\stu.xml")));
            encoder.writeObject(student);            
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("ERROR: While Creating or Opening the File dvd.xml");
        } finally {
            encoder.close();
        }
        return Response.status(200).entity(output).build();
    }
    
}
