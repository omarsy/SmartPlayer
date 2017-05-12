import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by Omar on 24/04/2017.
 */
@Path("/server")
public class Server  {
    @GET

    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllServer() {
        JSONArray array = new JSONArray();
        try {

            for(HashMap.Entry<Integer,Entity.Server> map :  Entity.Server.getServersDispo().entrySet())
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
}
