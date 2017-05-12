package Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import DBControl.DBConnection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sound  extends ManageMusic.Sound{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String url;
	private int idServer;
	
	
	public Sound(int id,String titre,String artiste, String album, String cover,String url,int idServer)
	{
		this.setId(id);
		this.titre = titre;
		this.artist = artiste;
		this.album = album;
		this.cover = cover;
		this.setUrl(url);
		this.idServer = idServer;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getArtiste() {
		return artist;
	}
	public void setArtiste(String artiste) {
		this.artist = artiste;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public int getIdServer() {
		return idServer;
	}
	public void setIdServer(int idServer) {
		this.idServer = idServer;
	}
	
	
	public static Sound getSoundById(int id) throws ClassNotFoundException, SQLException
	{
	     Connection c = DBConnection.getDBConnection().getConnection();
	     c.setAutoCommit(false);
	     Statement stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM sound WHERE id="+id+";" );
	      Sound s = null;
	      while ( rs.next() ) {

	         s = new Sound(rs.getInt("id"),rs.getString("titre"),rs.getString("artiste"),rs.getString("album"),rs.getString("cover"),rs.getString("url"),rs.getInt("idServer"));
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	      return s;
	}
	
	public static HashMap<Integer,Sound> getAllSounds() throws ClassNotFoundException, SQLException
	{
	     Connection c = DBConnection.getDBConnection().getConnection();
	     HashMap<Integer,Sound> sounds = new HashMap<Integer,Sound>();
	     Statement stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM sound ;" );
	      while ( rs.next() ) {
	    	  
	         sounds.put( rs.getInt("id"), new Sound(rs.getInt("id"),rs.getString("titre"),rs.getString("artiste"),rs.getString("album"),rs.getString("cover"),rs.getString("url"),rs.getInt("idServer")) );
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	      return sounds;
	}
	
	public static HashMap<Integer,Sound> getSoundsByServer(int id) throws ClassNotFoundException, SQLException
	{
	     Connection c = DBConnection.getDBConnection().getConnection();
	     HashMap<Integer,Sound> sounds = new HashMap<Integer,Sound>();
	     Statement stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM sound WHERE idServer="+id+" ;" );
	      while ( rs.next() ) {
	    	  
	         sounds.put( rs.getInt("id"), new Sound(rs.getInt("id"),rs.getString("titre"),rs.getString("artiste"),rs.getString("album"),rs.getString("cover"),rs.getString("url"),rs.getInt("idServer")) );
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	      return sounds;
	}
	
	public static HashMap<Integer,Sound> getSoundsByArtist(String artist) throws ClassNotFoundException, SQLException
	{
	     Connection c = DBConnection.getDBConnection().getConnection();
	     HashMap<Integer,Sound> sounds = new HashMap<Integer,Sound>();
	     Statement stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM sound WHERE artist='"+artist+"' ;" );
	      while ( rs.next() ) {
	    	  
	         sounds.put( rs.getInt("id"), new Sound(rs.getInt("id"),rs.getString("titre"),rs.getString("artiste"),rs.getString("album"),rs.getString("cover"),rs.getString("url"),rs.getInt("idServer")) );
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	      return sounds;
	}

	public static HashMap<Integer,Sound> getSoundsByTitre(String titre) throws ClassNotFoundException, SQLException
	{
		Connection c = DBConnection.getDBConnection().getConnection();
		HashMap<Integer,Sound> sounds = new HashMap<Integer,Sound>();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM sound WHERE titre='"+titre+"' ;" );
		while ( rs.next() ) {

			sounds.put( rs.getInt("id"), new Sound(rs.getInt("id"),rs.getString("titre"),rs.getString("artiste"),rs.getString("album"),rs.getString("cover"),rs.getString("url"),rs.getInt("idServer")) );
		}
		rs.close();
		stmt.close();
		c.close();
		return sounds;
	}
	public static HashMap<Integer,Sound> getSoundsByAlbum(String album) throws ClassNotFoundException, SQLException
	{
	     Connection c = DBConnection.getDBConnection().getConnection();
	     HashMap<Integer,Sound> sounds = new HashMap<Integer,Sound>();
	     Statement stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM sound WHERE album='"+album+"' ;" );
	      while ( rs.next() ) {
	    	  
	         sounds.put( rs.getInt("id"), new Sound(rs.getInt("id"),rs.getString("titre"),rs.getString("artiste"),rs.getString("album"),rs.getString("cover"),rs.getString("url"),rs.getInt("idServer")) );
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	      return sounds;
	}
	
	public static void addNewSound(Sound sound) throws SQLException, ClassNotFoundException
	{
		Connection c = DBConnection.getDBConnection().getConnection();
		 c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      Statement stmt = c.createStatement();
	      String sql = "INSERT INTO Sound (titre,artiste,album,cover,url,idServer) " +
	                   "VALUES ('"+sound.getTitre()+"','"+sound.getArtiste()+"','"+sound.getAlbum()+"','"+sound.getCover()+"','"+sound.getUrl()+"',"+sound.getIdServer()+" );"; 

	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.commit();
	      c.close();
	}
	
	public static void update(Sound sound) throws SQLException, ClassNotFoundException
	{
		Connection c = DBConnection.getDBConnection().getConnection();
		 c.setAutoCommit(false);

	      Statement stmt = c.createStatement();
	      String sql = "UPDATE sound set titre= '"+sound.getTitre()+"', artiste='"+sound.getArtiste()+"'," +
	    		  		" album='"+sound.getAlbum()+"', cover='"+sound.getCover()+"', url='"+sound.getUrl()+"'"+
	                   " where id="+sound.id+";";

	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.commit();
	      c.close();
	}
	
	public static void delete(String url, int serverId) throws SQLException, ClassNotFoundException
	{
		Connection c = DBConnection.getDBConnection().getConnection();
		 c.setAutoCommit(false);

	      Statement stmt = c.createStatement();
	      String sql = "DELETE FROM sound where url= '"+url+"' and idServer="+serverId+";"; 

	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.commit();
	      c.close();
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public  String toString()
	{
		return "{ \"id\" :"+ id+","+
				"\"titre\" : \""+titre+"\","+
				"\"artiste\" : \""+artist+"\","+
				"\"album\" : \""+album+"\","+
				"\"cover\" : \""+cover+"\","+
				"\"url\" : \""+url+"\""+
				"}";
	}
}