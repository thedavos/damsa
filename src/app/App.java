package app;

import clases.Admin;
import models.AdminModel;

import java.util.ArrayList;
import utils.RepositoryImage;

public class App {
	public static void main(String[] args) throws Exception {
		
		Admin admin = new Admin(
				74736630,
				"misael123",
				"Misael",
				"Cano Varas",
				'M',
				17,
				"misael@gmail.com",
				"",
				123456,
				997939992,
				""
				);
		
		AdminModel am = new AdminModel();
		
		am.createAdmin(admin);
		System.out.println(admin);
    }
}