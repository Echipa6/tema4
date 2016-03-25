package Model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.List;


public class ReportCommand implements Command {

	private static ReportCommand instance= null;
	
	public static ReportCommand getInstance(){
		if(instance == null) {
	         instance = new ReportCommand();
	      }
	      return instance;
	}
	
	@Override
	public void execute(String parametres) {
		// TODO Auto-generated method stub
		System.out.println("Command report execute...");
		


		if (parametres.equals("html"))
		{
			System.out.println("incep sa fac raportul html");
			List<Song> songs = new ArrayList<Song>();
			songs = FavCommand.getInstance().getFavoriteSong();
			List<String> songsName=new ArrayList<String>();
			
			for(Song song:songs)
			{
				songsName.add(new String(song.getPath()));
			}
			

			Configuration cfg = new Configuration();
			cfg.setClassForTemplateLoading(ReportCommand.class, "templates"); // setez diferite setari de configurare
			cfg.setDefaultEncoding("UTF-8");
			cfg.setLocale(Locale.US);
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			Map<String, Object> input = new HashMap<String, Object>(); 
			input.put("title", "My favorite music"); //tot ce e cu dolar in template se va inlocul pe baza de $nume ,deci $title se inlocuieste cu my favourite music
			input.put("songs", songsName);

			try {
				Template template = cfg.getTemplate("favorites.ftl"); 
				Writer fileWriter = new FileWriter(new File("report.html"));

				try {
					template.process(input, fileWriter);
				} finally {
					fileWriter.close(); 
					System.out.println("Successfully created html report");
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());

			}

		} 
		else 
		{
			System.out.println("incep sa fac raportul pdf");
			Document document = new Document();
			try {
				PdfWriter.getInstance(document, new FileOutputStream(new File("report.pdf")));
			} catch (DocumentException | FileNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
			document.open();
			Paragraph title = new Paragraph();
			title.setAlignment(Element.ALIGN_CENTER);
			title.add("My favorite music");
			title.setFont(FontFactory.getFont(FontFactory.COURIER, 22));
			try {
				document.add(title);
			} catch (DocumentException ex) {
				System.out.println(ex.getMessage());
			}
			com.itextpdf.text.List lista = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED); // imi creez un obiect de tip lista din libraria pt pdf
			ListItem item;
			for (Song song : FavCommand.getInstance().favoriteSong) {
				item = new ListItem(new String(song.getPath()));
				lista.add(item); // pun in obiectul creeat mai sus toate melodiile favorite
			}
			try {
				document.add(lista); 
			} catch (DocumentException ex) {
				System.out.println(ex.getMessage());
			}
			document.addAuthor("Miron Dorin si Groza Vasile");
			document.close();
			System.out.println("Successfully created pdf report");
		}

	}


	
	
	private ReportCommand()
	{
		
	}

}
