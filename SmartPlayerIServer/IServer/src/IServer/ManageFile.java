package IServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;

import Ice.Current;
import ManageMusic.Sound;
import ManageMusic._ManageFileDisp;
import  java.net.HttpURLConnection;



public class ManageFile extends _ManageFileDisp {

	@Override
	public void delete(String path, int id, Current __current) {
		// TODO Auto-generated method stub
		try {
			Entity.Sound.delete(path, id);
			System.out.println("Suppression :"+ id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void newMusic(Sound sound, String url, int id, Current __current) {
		// TODO Auto-generated metheod stub
	System.out.println(url);
		try {
		Entity.Sound.addNewSound(new Entity.Sound(-1, sound.titre, sound.artist, sound.album, sound.cover, url, id));
		sendPost(sound.artist,sound.album,sound.titre);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// HTTP POST request
	private void sendPost(String artiste,String album, String titre) throws Exception {

		String ur="http://10.122.3.250:5000/music";
		String post="artiste="+artiste+"&album="+album+"&titre="+titre;
		URL url = new URL(ur);
		URLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(60 * 1000);
		conn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
		writer.write(post);
		writer.flush();
//recuperation du code html
		String reponse=null,ligne = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((ligne = reader.readLine()) != null) {
			reponse+= ligne.trim()+"\n";
		}
		System.out.print(reponse);
	}
}
