/**
 * Created by Omar on 21/04/2017.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;


// The Java class will be hosted at the URI path "/helloworld"
@Path("/sounds")
public class Sound implements ContainerResponseFilter {
    // The Java method will process HTTP GET requests
    @GET

    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllSounds() {
        // Return some cliched textual content

        JSONArray array = new JSONArray();
        try {
            System.out.println(Entity.Sound.getAllSounds().size());
            for(HashMap.Entry<Integer,Entity.Sound> map :  Entity.Sound.getAllSounds().entrySet())
            {
                array.put(new JSONObject(map.getValue().toString()).toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  array.toString();
    }

    @GET

    @Path("/id/{id}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_JSON)
    public String getById(@PathParam("id") String id) {
        // Return some cliched textual content
        JSONObject object = null;
        try {
            object = new JSONObject("{}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int v = -1;
        try {
            v = Integer.parseInt(id);
        }catch (Exception e)
        {

        }
        try {
            Entity.Sound sound = Entity.Sound.getSoundById(v);
            if(sound != null)
            object = new JSONObject(sound.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return  object.toString();
    }

    @GET

    @Path("/album/{album}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_JSON)
    public String getByAlbum(@PathParam("album") String album) {
        // Return some cliched textual content
        JSONArray array = new JSONArray();
        try {
           for(HashMap.Entry<Integer,Entity.Sound> map :  Entity.Sound.getSoundsByAlbum(album).entrySet())
           {
                array.put(map.getValue().toString());
           }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  array.toString();
    }
    @GET
    @Path("/titre/{titre}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_JSON)
    public String getByTitre(@PathParam("titre") String titre) {
        // Return some cliched textual content
        JSONArray array = new JSONArray();
        try {
            for(HashMap.Entry<Integer,Entity.Sound> map :  Entity.Sound.getSoundsByTitre(titre).entrySet())
            {
                array.put(map.getValue().toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  array.toString();
    }
    @GET

    @Path("/artiste/{artiste}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_JSON)
    public String getByArtiste(@PathParam("artiste") String artiste) {
        // Return some cliched textual content
        JSONArray array = new JSONArray();
        try {
            for(HashMap.Entry<Integer,Entity.Sound> map :  Entity.Sound.getSoundsByArtist(artiste).entrySet())
            {
                array.put(map.getValue().toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  array.toString();
    }
    @GET

    @Path("/server/{id}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_JSON)
    public String getByServer(@PathParam("id") String id) {
        // Return some cliched textual content
        JSONArray array = new JSONArray();
        int v = -1;
        try {
            v = Integer.parseInt(id);
            System.out.println(v);
        }catch (Exception e)
        {

        }

        try {

            for(HashMap.Entry<Integer,Entity.Sound> map :  Entity.Sound.getSoundsByServer(v).entrySet())
            {
                array.put(new JSONObject(map.getValue().toString()).toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  array.toString();

    }


    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext cres) throws IOException {
        cres.getHeaders().add("Access-Control-Allow-Origin", "*");

    }
}