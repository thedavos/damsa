package App;

import Clases.Cliente;
import Models.ClientModel;

import java.util.ArrayList;
import Utils.RepositoryImage;

public class App {
	public static void main(String[] args) throws Exception {
//		Cliente client = new Cliente(
//				75454144,
//				"David",
//				"Vargas Domínguez",
//				'M',
//				23,
//				"davos@gmail.com",
//				"Los Robles 321",
//				994321035,
//				291543
//				);
//		
//		ClientModel model = new ClientModel();
//		model.createClient(client);
//		Cliente client = model.getClient(75454144);
//		Object obj = "hey";
		RepositoryImage repo = new RepositoryImage();
		repo.authorize_account();
//		System.out.println(obj);
    }
}