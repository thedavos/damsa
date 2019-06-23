package app;

import clases.Admin;
import models.AdminModel;

import clases.Cliente;
import models.ClientModel;

import clases.Empresa;
import models.EnterpriseModel;

import java.util.ArrayList;
import utils.RepositoryImage;
import java.util.Map;

public class App {
	public static void main(String[] args) throws Exception {
		RepositoryImage ri = new RepositoryImage();
		System.out.println(ri.authorize_account());

    }
}