/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Ana
 * versión 1.1, 28/03/2018
 * Esta clase genera el PDF utilizando como objetos el evento y pago.
 */

package uhv1.Negocio;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControlImprimeComprobante {

    public static final String filename = "ComprobantePE.pdf";
    private final Evento evento;
    private final pagos pago;

    public ControlImprimeComprobante(Evento evento, pagos pago) {
        this.evento = evento;
        this.pago = pago;
    }
    
    public void generarPDF(){
        Rectangle pageSize = new Rectangle(300f, 170f); //ancho y alto
        Document documento = null;
        try{
            documento = new Document(pageSize,5,5,5,5);
            PdfWriter.getInstance(documento, new FileOutputStream(filename));
            documento.open();
        }catch(Exception e){            
        }
        try{
            Chunk espacio = new Chunk("\n");
            Chapter capitulo1 = new  Chapter(0);
            Section seccion1 = capitulo1;
            
            Image imagen = Image.getInstance("img/info.png");            
            imagen.setAlignment(Image.TEXTWRAP);
            imagen.scaleAbsolute(20, 20);
            
            Paragraph title = new Paragraph();
            title.add("COMPROBANTE PAGO DE EVENTO");
            title.setAlignment(Paragraph.ALIGN_CENTER);
            
            Paragraph subtitulo = new Paragraph();                                                                    
            subtitulo.add("Unidad Habitacional");
            subtitulo.setFont(FontFactory.getFont("Arial", 2, Font.BOLD, BaseColor.BLACK));
            
            seccion1.add(imagen);            
            seccion1.add(subtitulo);
            title.add(espacio);
            seccion1.add(title);
            seccion1.add(espacio);
            
            Section seccionDatos = seccion1;            
            Paragraph datosHabitante = new Paragraph();
            datosHabitante.setFont(FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK));
            datosHabitante.add("Nombre Habitante: " + evento.getHabitante().getNombre() +" "+ evento.getHabitante().getaPat() +" "+ evento.getHabitante().getaMat() + "\n");
            datosHabitante.add("Nombre Evento: " + evento.getNombre() + "\n");
            datosHabitante.add("Fecha: " + pago.getFechasql() +"\n");
            datosHabitante.add("Pago: " + pago.getSaldoActual());
            
            Paragraph firma = new Paragraph();
            firma.setAlignment(Paragraph.ALIGN_RIGHT);
            firma.setFont(FontFactory.getFont("Arial",5,BaseColor.BLACK));
            firma.add("_______________________   " + "\n" );
            firma.add("Firma Administrador         ");
            
            
            seccionDatos.add(datosHabitante);
            seccionDatos.add(firma);
            documento.add(seccion1);            
        } catch (Exception e) {
        }        
        documento.close();
        
        try{ 
            //definiendo la ruta en la propiedad file
            Runtime.getRuntime().exec("cmd /c start "+filename);
            System.out.println("uhv1.Negocio.ControlImprimir.imprimirHistorial()");
        }catch(IOException e){
            e.printStackTrace();
        } 
    }
}