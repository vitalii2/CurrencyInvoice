package org.example;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;


public class Currency{
private static double rate;
private static double buoghtAmount;
private static String date;
public Currency(String date, String rate){
    this.rate = Double.parseDouble(rate);
    this.date = date;
}

    public static double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public static String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Today - " + getDate() + ". Rate - " + getRate();
    }
    public void setBoughtAmount(double j){
    this.buoghtAmount = j;
    }

    public void getInvoice() throws FileNotFoundException {
        LocalDateTime time = LocalDateTime.now();

        int random = (int) (Math.random() * 100000000);
        float colWidth = 10000f;
        float twoCol = 200f;
        float twoColWidth[] = {colWidth,twoCol};
        String invoice = "invoice N "+ random +".pdf";
        PdfWriter pdfWriter = new PdfWriter(invoice);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A6);
        Document document = new Document(pdfDocument);
        Table table = new Table(twoColWidth);
        table.addCell(new Cell().add("Invoice").setFontSize(25f).setFontColor(com.itextpdf.kernel.color.Color.MAGENTA).setBorder(Border.NO_BORDER)).setTextAlignment(TextAlignment.CENTER);
        Table secTable = new Table(twoColWidth);
        secTable.addCell(new Cell().add("Invoice number: " + random).setFontSize(15f).setFontColor(com.itextpdf.kernel.color.Color.GRAY).setBorder(Border.NO_BORDER));
        document.add(table);
        document.add(secTable);
        document.add(new Paragraph("Company name: "));
        document.add(new Paragraph("Customer name: "));
        document.add(new Paragraph("Today - " + Currency.getDate() + " Time - " + time.getHour() + ":" + time.getMinute()));
        document.add(new Paragraph("Rate - " + Currency.getRate()));

        document.add(new Paragraph("Bought amount: " + buoghtAmount));
        document.add(new Paragraph("Total sum: "));

        Border border = new SolidBorder(com.itextpdf.kernel.color.Color.CYAN,1.5f);
        Table divider = new Table(twoColWidth);
        divider.setBorder(border);
        document.add(divider);
        document.add(new Paragraph("Exchange office address: " + Currency.getDate()).setItalic().setFontSize(9f));
        document.add(new Paragraph("Tel number: ").setItalic().setFontSize(9f));
        document.add(new Paragraph("fax: ").setItalic().setFontSize(9f).setFontColor(Color.MAGENTA));

        document.close();
    }

}
