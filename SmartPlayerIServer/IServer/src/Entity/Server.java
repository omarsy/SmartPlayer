package Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import DBControl.DBConnection;

public class Server extends ManageMusic.Server {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ip;
	private boolean dispo;
	private HashMap<Integer,Sound> sounds = new HashMap<Integer,Sound>() ;
	/**
	 * 
	 * @param id
	 * @param nom
	 * @param ip
	 * @param dispo
	 */
	public Server(int id, String nom, String ip,boolean dispo)
	{
		this.id = id;
		this.ip = ip;
		this.nom = nom;
		this.dispo = dispo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void addSound(int id , Sound sound)
	{
		sounds.put(id, sound);
	}
	
	public void deleteSound(int id)
	{
		sounds.remove(id);
	}
	
	public static void addNewServer(Server server) throws SQLException, ClassNotFoundException
	{
		Connection c = DBConnection.getDBConnection().getConnection();
		 c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      Statement stmt = c.createStatement();
	      String sql = "INSERT INTO server (ip,dispo,nom) " +
	                   "VALUES ( '"+server.getIp()+"',"+((server.isDispo())? 1 : 0)+",'"+server.getNom()+"' );"; 
	      System.out.println(sql);
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.commit();
	      c.close();
	}
	
	public static void update(Server server) throws SQLException, ClassNotFoundException
	{
		Connection c = DBConnection.getDBConnection().getConnection();
		 c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      Statement stmt = c.createStatement();
	      String sql = "UPDATE server set ip= '"+server.getIp()+"', nom='"+server.getNom()+"', dispo="+((server.isDispo())? 1 : 0)+" where id="+server.id+" ;"; 

	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.commit();
	      c.close();
	}
	public static void updateServerIp(String ip,int id) throws SQLException, ClassNotFoundException
	{
		HashMap<Integer,Sound> maps = Sound.getSoundsByServer(id);
		for(Map.Entry<Integer,Sound> sound : maps.entrySet())
		{
			String url = sound.getValue().getUrl().replaceAll("http://","");
			String path = url.split(":")[1];
			sound.getValue().setUrl("http://"+ip+":"+path);
			String coverurl = sound.getValue().getCover().replaceAll("http://","");
			String coverpath = coverurl.split(":")[1];
			sound.getValue().setCover("http://"+ip+":"+coverpath);
			Sound.update(sound.getValue());

		}

	}
	public static Server getServerById(int id) throws ClassNotFoundException, SQLException
	{
	     Connection c = DBConnection.getDBConnection().getConnection();
	     c.setAutoCommit(false);
	     Statement stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM server WHERE id="+id+";" );
	      Server s = null;
	      while ( rs.next() ) {

	         s = new Server(rs.getInt("id"),rs.getString("nom"),rs.getString("ip"),rs.getBoolean("dispo"));
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	      return s;
	}
	
	public HashMap<Integer,Server> getServers() throws ClassNotFoundException, SQLException
	{
	     Connection c = DBConnection.getDBConnection().getConnection();
	     HashMap<Integer,Server> servers = new HashMap<Integer,Server>();
	     Statement stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM server ;" );
	      while ( rs.next() ) {
	    	  
	         servers.put( rs.getInt("id"), new Server(rs.getInt("id"),rs.getString("nom"),rs.getString("ip"),rs.getBoolean("dispo")) );
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	      return servers;
	}
	
	public static HashMap<Integer,Server> getServersDispo() throws ClassNotFoundException, SQLException
	{
	     Connection c = DBConnection.getDBConnection().getConnection();
	     HashMap<Integer,Server> servers = new HashMap<Integer,Server>();
	     Statement stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM server where dispo=1 ;" );
	      while ( rs.next() ) {
	    	  
	         servers.put( rs.getInt("id"), new Server(rs.getInt("id"),rs.getString("nom"),rs.getString("ip"),rs.getBoolean("dispo")) );
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	      
	      return servers;
	}
	
	public static Server getServerByName(String name) throws ClassNotFoundException, SQLException
	{
	     Connection c = DBConnection.getDBConnection().getConnection();
	     Server server = null ;
	     Statement stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM server where nom ='"+ name+"';" );
	      while ( rs.next() ) {
	    	  
	         server =  new Server(rs.getInt("id"),rs.getString("nom"),rs.getString("ip"),rs.getBoolean("dispo")) ;
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	      return server;
	}
	public boolean isDispo() {
		return dispo;
	}
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	@Override
	public  String toString()
	{
		return "{ \"id\" :"+ id+","+
				"\"nom\" : \""+nom+"\""+
				"}";
	}
	
	
}
