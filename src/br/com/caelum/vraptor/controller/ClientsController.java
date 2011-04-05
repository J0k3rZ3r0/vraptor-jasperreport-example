
package br.com.caelum.vraptor.controller;

import static br.com.caelum.vraptor.jasperreports.formats.Formats.*;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.Clients;
import br.com.caelum.vraptor.interceptor.download.Download;
import br.com.caelum.vraptor.jasperreports.JasperReportDownload;
import br.com.caelum.vraptor.jasperreports.Report;
import br.com.caelum.vraptor.model.Client;
import br.com.caelum.vraptor.report.ClientsReport;

@Resource
public class ClientsController {

	private final Result result;
	private final Clients clients;

	public ClientsController(Result result, Clients clients) {
		this.result = result;
		this.clients = clients;
	}

	@Path("/")
	public void index() {
		result.include("clients", clients.listAll());
	}

	@Post("/clients") 
	public void add(Client client) {
		clients.add(client);
		result.redirectTo(this).index();
	}
	
	@Path("/clients/csv") 
	public Download csvReport() {
		Report<Client> report = generateReport();
		return new JasperReportDownload(report, CSV());
	}
	
	@Path("/clients/docx") 
	public Download docxReport() {
		Report<Client> report = generateReport();
		return new JasperReportDownload(report, DOCX());
	}
	
	@Path("/clients/txt") 
	public Download txtReport() {
		Report<Client> report = generateReport();
		return new JasperReportDownload(report, TXT());
	}
	
	@Path("/clients/odt") 
	public Download odtReport() {
		Report<Client> report = generateReport();
		return new JasperReportDownload(report, ODT());
	}
	
	@Path("/clients/rtf") 
	public Download rtfReport() {
		Report<Client> report = generateReport();
		return new JasperReportDownload(report, RTF());
	}
	
	@Path("/clients/pdf") 
	public Download pdfReport() {
		Report<Client> report = generateReport();
		return new JasperReportDownload(report, PDF());
	}
	
	private Report<Client> generateReport(){
		List<Client> data = clients.listAll();
		return new ClientsReport(data);
	}
	
}
