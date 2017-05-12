package IServer;

import java.sql.SQLException;

import Entity.*;
import Ice.Current;
import ManageMusic._NetworkDisp;

public class Network extends _NetworkDisp {

	@Override
	public int inscription(String name, Current __current) {
		// TODO Auto-generated method stub
		try {
			Server.addNewServer(new Server(-1,name,"",false));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return - 1;
			// TODO Auto-generated catch block
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
			// TODO Auto-generated catch block
			
		}
		Server server = null;
		try {
			server = Server.getServerByName(name);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (server == null)? -1 : server.getId(); 
		
	}

	@Override
	public void changeIp(String ip, int id, Current __current) {
		// TODO Auto-generated method stub
		try {
			Server server = Server.getServerById(id);
			server.setIp(ip);
			Server.update(server);
			Server.updateServerIp(ip,id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deconnexion(int id, Current __current) {
		// TODO Auto-generated method stub
		try {
			Server server = Server.getServerById(id);
			server.setDispo(false);
			Server.update(server);
			System.out.println(id +" Deconnecte" );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void connexion(String ip, int id, Current __current) {
		// TODO Auto-generated method stub
		
		try {
			Server server = Server.getServerById(id);
			server.setIp(ip);
			server.setDispo(true);
			Server.update(server);
			Server.updateServerIp(ip,id);
			System.out.println(id +" Connecte" );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
}
