package br.com.caelum.vraptor.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.model.Client;

@Component
@ApplicationScoped
public class Clients {
	
	private List<Client> list = new ArrayList<Client>();

	public void add(Client client) {
		list.add(client);
	}

	public List<Client> listAll() {
		return list;
	}

	public void remove(Client client) {
		list.remove(client);
	}

}
