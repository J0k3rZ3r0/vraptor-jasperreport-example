package br.com.caelum.vraptor.report;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.jasperreports.Report;
import br.com.caelum.vraptor.model.Client;

public class ClientsReport implements Report<Client> {
	
	private final List<Client> data;
	private Map<String, Object> parameters;
	
	public ClientsReport(List<Client> data) {
		this.data = data;
		this.parameters = new HashMap<String, Object>();
	}

	public Report<Client> addParameter(String key, Object value) {
		this.parameters.put(key, value);
		return this;
	}

	public Collection<Client> getData() {
		return data;
	}

	public String getFileName() {
		return "report" + System.currentTimeMillis();
	}

	public Map<String, Object> getParameters() {
		return this.parameters;
	}

	public String getTemplate() {
		return "/templates/report.jasper";
	}

}
