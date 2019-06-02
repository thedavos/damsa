package app;

import clases.Admin;
import models.AdminModel;

import java.util.ArrayList;
import utils.RepositoryImage;

public class App {
	public static void main(String[] args) throws Exception {
		
		AdminModel am = new AdminModel();
		
		Admin admin = am.getAdmin(75454144);
		System.out.println(admin.getName());
    }
}