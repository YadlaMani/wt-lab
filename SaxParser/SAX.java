import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.util.*;
import java.io.*;
class SAX{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of the xml file:");
        String filename=sc.nextLine();
        File f=new File(filename);
        if(f.exists()){
            try{
                SAXParserFactory factory=SAXParserFactory.newInstance();
                SAXParser parser=factory.newSAXParser();
                InputSource is=new InputSource(filename);
                DefaultHandler handler=new DefaultHandler(){
                    public void startElement(String uri,String localName,String qName,Attributes attributes) throws SAXException{
                        System.out.println(qName);
                    }


                };
                parser.parse(is,handler);
                System.out.println(filename + " is a well formed document");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("File not found");
        }

    }
}