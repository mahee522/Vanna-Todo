import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.PdfWriter;


public class BarCode128 {
public static void main(String[] args) throws FileNotFoundException, DocumentException {
	Document d=new Document(new Rectangle(PageSize.A4));
	PdfWriter writer=PdfWriter.getInstance(d, new FileOutputStream("C:/Users/MAHI/Desktop/vanna/Barcode.pdf"));
	d.open();
	d.add(new Paragraph("Code_128Format.com"));
	Barcode128 code128=new Barcode128();
	code128.setGenerateChecksum(true);
	code128.setCode("123456789");
	d.add(code128.createImageWithBarcode(writer.getDirectContent(), null,null));
	d.close();
	System.out.println("Document generated");
	
}
}
