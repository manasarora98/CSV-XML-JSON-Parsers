package com.com.miniproject;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class XMLHandler implements MyFileHandler {

    public void read() throws Exception{
        try {
            File file = new File("/Users/manasarora/Downloads/employee.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("employee");
            for (int i = 0;i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    String s1= eElement.getElementsByTagName("firstName").item(0).getTextContent();
                    String s3= eElement.getElementsByTagName("lastName").item(0).getTextContent();
                    String s4= eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent();
                    String s5= eElement.getElementsByTagName("experience").item(0).getTextContent();
                   // System.out.println("XML"+s1 + s3 + s4 + s5);
                    Employee emp=new Employee();
                    emp.setFirstName(s1);
                    emp.setLastName(s3);
                    Date date = new SimpleDateFormat("dd/MM/yy").parse(s4);
                    Long exp = Long.parseLong(s5);
                    emp.setDateOfBirth(date);
                    emp.setExperience(exp);
                    MyCollection.add(emp);
                }

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void write(){
        ArrayList<Employee> employees = new ArrayList<>();
        for(int i = 0; i < 100; i++)
            employees.add(MyCollection.get());
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement =
                    doc.createElementNS("", "Employees");
            doc.appendChild(rootElement);

           for(int i=0;i<100;i++) {
               String ex = Double.toString(employees.get(i).getExperience());
               String strDate = (new SimpleDateFormat("dd-mm-yy")).format(Calendar.getInstance().getTime());

               rootElement.appendChild(getEmployee(doc, employees.get(i).getFirstName(), employees.get(i).getLastName()
                       , strDate, ex));

           }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("/Users/manasarora/Downloads/outemployee.xml"));

            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Node getEmployee(Document doc, String fName, String lName, String DOB, String exprience) {
        Element employee = doc.createElement("Employee");
        employee.appendChild(getEmployeeElements(doc, employee, "firstName", fName));
        employee.appendChild(getEmployeeElements(doc, employee, "lastName", lName));
        employee.appendChild(getEmployeeElements(doc, employee, "dateOfBirth", DOB));
        employee.appendChild(getEmployeeElements(doc, employee, "experience", exprience));
        return employee;
    }
    private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}

