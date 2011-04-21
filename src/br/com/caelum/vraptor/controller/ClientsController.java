
package br.com.caelum.vraptor.controller;

import static br.com.caelum.vraptor.jasperreports.formats.Formats.*;

import java.io.IOException;
import java.util.List;

import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.Clients;
import br.com.caelum.vraptor.interceptor.download.Download;
import br.com.caelum.vraptor.jasperreports.ExportFormat;
import br.com.caelum.vraptor.jasperreports.Report;
import br.com.caelum.vraptor.jasperreports.ReportDownload;
import br.com.caelum.vraptor.jasperreports.ReportsDownload;
import br.com.caelum.vraptor.jasperreports.formats.Txt;
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
		return new ReportDownload(report, Csv());
	}
	
	@Path("/clients/xls") 
	public Download xlsReport() {
		Report<Client> report = generateReport();
		return new ReportDownload(report, Xls());
	}
	
	@Path("/clients/docx") 
	public Download docxReport() {
		Report<Client> report = generateReport();
		return new ReportDownload(report, Docx());
	}
	
	@Path("/clients/txt") 
	public Download txtReport() {
		Report<Client> report = generateReport();
		ExportFormat txt = new Txt();
		txt.configure(JRTextExporterParameter.OFFSET_X, 0)
		   .configure(JRTextExporterParameter.OFFSET_Y, 0);
		return new ReportDownload(report, txt, false);
	}
	
	@Path("/clients/odt") 
	public Download odtReport() {
		Report<Client> report = generateReport();
		return new ReportDownload(report, Odt());
	}
	
	@Path("/clients/rtf") 
	public Download rtfReport() {
		Report<Client> report = generateReport();
		return new ReportDownload(report, Rtf());
	}
	
	@Path("/clients/pdf") 
	public Download pdfReport() {
		Report<Client> report = generateReport();
		return new ReportDownload(report, Pdf());
	}
	
	@Path("/clients/zip") 
	public Download zipReport() throws IOException {
		ReportsDownload download = new ReportsDownload();
		Report<Client> report = generateReport();
		download.add(report, Pdf())
				.add(report, Csv())
				.add(report, Xls())
				.add(report, Rtf())
				.add(report, Docx())
				.add(report, Txt())
				.add(report, Odt());
		return download;
	}
	
	private Report<Client> generateReport(){
		List<Client> data = clients.listAll();
		return new ClientsReport(data);
	}
	
}
