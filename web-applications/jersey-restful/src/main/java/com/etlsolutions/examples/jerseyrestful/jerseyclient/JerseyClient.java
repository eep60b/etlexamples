package com.etlsolutions.examples.jerseyrestful.jerseyclient;

import com.etlsolutions.examples.jerseyrestful.Student;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import java.io.File;
import static javafx.scene.AccessibleAttribute.HEADER;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

public class JerseyClient {

    public static void main(String[] args) {
        try {

  //          Student st = new Student("Adriana", "Barrer", 12, 9);

            Client client = Client.create();

            WebResource webResource = client
                    .resource("http://localhost:9548/jersey-restful/rest/xmlServices/send");

            Builder builder = webResource.type(MediaType.APPLICATION_XML);
            builder = builder.accept(MediaType.TEXT_PLAIN);
            builder = builder.header(HttpHeaders.AUTHORIZATION, HEADER);
            File file = new File("C:\\Temp\\student.xml");
            builder = builder.entity(file);
            ClientResponse response = builder.post(ClientResponse.class);
//            ClientResponse response = webResource.accept("application/xml")
//                    .post(ClientResponse.class, st);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Server response .... \n");
            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
