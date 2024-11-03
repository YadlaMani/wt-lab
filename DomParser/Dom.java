import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.*;
class DOM{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of the XML file:");
        String filename=sc.nextLine();
        File f=new File(filename);
        if(f.exists()){
            try{
                DocumentBuilderFactory db=DocumentBuilderFactory.newInstance();
                DocumentBuilder builder=db.newDocumentBuilder();
                Document doc=builder.parse(f);
                NodeList nodeList=doc.getElementsByTagName("root_node");
                for(int i=0;i<nodeList.getLength();i++){
                    Element root=(Element)nodeList.item(i);
                    String childNode1 = root.getElementsByTagName("child_node1").item(0).getTextContent();
                    String childNode2 = root.getElementsByTagName("child_node2").item(0).getTextContent();
                    System.out.println(childNode1);
                    System.out.println(childNode2);
                }
                System.out.println(filename+"is well formated document");

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("File not found");
        }
    }
}