package com.example.xmltojson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import com.example.xmltojson.models.Attribute;
import com.example.xmltojson.models.Category;
import com.example.xmltojson.models.Combination;
import com.example.xmltojson.models.Manufacturer;
import com.example.xmltojson.models.Picture;
import com.example.xmltojson.models.Product;
import com.example.xmltojson.models.Specification;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    Product product;
    ArrayList<Product> products;
    FirebaseFirestore firebaseFirestore;
    int attributeCounter = 0;
    Combination combination = new Combination();
    Category category = new Category();
    Attribute attribute = new Attribute();
    Specification specification = new Specification();
    private String namedNodeMap;
    NodeList nodes;
    int k=0;
    ArrayList<String> mainCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        mainCategories = new ArrayList<>();
        firebaseFirestore = FirebaseFirestore.getInstance();
        product = new Product();
        products = new ArrayList<>();
        product.setCategories(new ArrayList<Category>());
        product.setManufacturer(new Manufacturer());
        product.setPictures(new ArrayList<Picture>());
        product.setCombinations(new ArrayList<Combination>());
        product.setSpecifications(new ArrayList<Specification>());
        InputStream inputStream = getResources().openRawResource(R.raw.ekrumoda_2);
        Document document = parseXML(new InputSource(inputStream));

        nodes = document.getElementsByTagName("Description");
            //Element element = (Element) nodes.item(0);

            //NodeList title = element.getElementsByTagName("CDATA");
            //Element line = (Element) title.item(0);
           //System.out.println("Title: " + getCharacterDataFromElement(line));
            // System.out.println("Title: " + getCharacterDataFromElement(element));


//        textView.setText(document.getDocumentElement().getNodeName());
//        firebaseFirestore.collection("products").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                System.out.println(queryDocumentSnapshots.getDocuments().size() + " products size 1");
//            }
//        });
        if (document.hasChildNodes()) {
            printNodeList(document.getChildNodes());
        }
        Gson gson = new Gson();
        String productsJson = gson.toJson(products);
        // Get the directory for the user's public pictures directory.
        final File path =
                Environment.getExternalStoragePublicDirectory
                        (
                                //Environment.DIRECTORY_PICTURES
                                Environment.DIRECTORY_DCIM
                        );

        // Make sure the path directory exists.
        if (!path.exists()) {
            // Make it, if it doesn't exit
            path.mkdirs();
        }

        final File file = new File(path, "products.json");

        // Save your stream, don't forget to flush() it before closing it.

        try {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(productsJson);

            myOutWriter.close();

            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }

        for (int i = 0; i < products.size(); i++){
            final int finalI = i;
            firebaseFirestore.collection("products").add(products.get(i)).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    System.out.println("document " + finalI +" uploaded successfully!");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    System.out.println("document "+ finalI + " upload failed!!");
                }
            });
//            firebaseFirestore.collection("products").whereEqualTo("id", products.get(i).getId()).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                @Override
//                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                    if (queryDocumentSnapshots.getDocuments().size() > 0) {
//                        String id = queryDocumentSnapshots.getDocuments().get(0).getId();
//                        firebaseFirestore.collection("products").document(id).set(products.get(finalI)).addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                System.out.println("existing product is updated successfully!!");
//                            }
//                        });
//                    }
//                    else {
//                        firebaseFirestore.collection("products").add(products.get(finalI)).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                            @Override
//                            public void onSuccess(DocumentReference documentReference) {
//                                System.out.println("new document uploaded successfully!");
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                System.out.println("document upload failed!!");
//                            }
//                        });
//                    }
//                }
//            });

//            firebaseFirestore.collection("products").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                @Override
//                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                    System.out.println(queryDocumentSnapshots.getDocuments().size() + " products size 2");
//                }
//            });
        }
    }

    public Document parseXML(InputSource source) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(false);
            dbf.setValidating(false);
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void printNodeList(NodeList nodeList) {

        for (int count = 0; count < nodeList.getLength(); count++) {

            Node elemNode = nodeList.item(count);
            if (elemNode.getNodeType() == Node.ELEMENT_NODE)
            {
// get node name and value
//                System.out.println("\nNode Name =" + elemNode.getNodeName()+ " [OPEN]");
//                System.out.println("Node Content =" + elemNode.getTextContent());
                if (elemNode.hasAttributes())
                {
                    NamedNodeMap nodeMap = elemNode.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++)
                    {
                        Node node = nodeMap.item(i);
                        if (elemNode.getNodeName().equals("Product")) {
                            switch (node.getNodeName()) {
                                case "Id":
                                    product.setId(node.getNodeValue());
                                    break;
                                case "ModelCode":
                                    product.setModelCode(node.getNodeValue());
                                    break;
                                case "Sku":
                                    product.setSku(node.getNodeValue());
                                    break;
                                case "Color":
                                    product.setColor(node.getNodeValue());
                                    break;
                                case "Gtin":
                                    product.setGtin(node.getNodeValue());
                                    break;
                                case "Name":
                                    product.setName(node.getNodeValue());
                                    break;
                                case "ShortDescription":
                                    product.setShortDescription(node.getNodeValue());
                                    break;
                                case "FullDescription":
                                    product.setFullDescription(node.getNodeValue());
                                    break;
                                case "Currency":
                                    product.setCurrency(node.getNodeValue());
                                    break;
                                case "StockQuantity":
                                    product.setStockQuantity(node.getNodeValue());
                                    break;
                                case "OldPrice":
                                    product.setOldPrice(node.getNodeValue());
                                    break;
                                case "Price":
                                    product.setPrice(node.getNodeValue());
                                    break;
                                case "Weight":
                                    product.setWeight(node.getNodeValue());
                                    break;
                                case "Tax":
                                    product.setTax(node.getNodeValue());
                                    break;
                                case "VAT":
                                    product.setVat(node.getNodeValue());
                                    break;
                                case "MainCategory":
//                                    String result = fetchMainCategory(node.getNodeValue());
//                                    if (result != null)
//                                        mainCategories.add(result);
                                    switch (node.getNodeValue()) {
                                        case "":
                                        case "Alt Giyim":
                                        case "Takım":
                                        case "Etek":
                                        case "Tulum":
                                        case "Takımlar":
                                        case "Üst Giyim":
                                        case "Büyük Beden":
                                        case "Giyim":
                                        case "Pantolon":
                                        case "Sweatshirt":
                                        case "Gömlek":
                                        case "Denim":
                                        case "Hırka":
                                        case "Hamile Giyim":
                                        case "Polyester":
                                        case "Tesettür Mayo":
                                        case "Eşofman Takım":
                                        case "Penye":
                                        case "Abiye":
                                        case "Pamuk Polyester":
                                        case "Tayt":
                                        case "Triko":
                                        case "Doğal ve Rahat":
                                        case "Bluz":
                                        case "Yelek":
                                        case "Eşofman":
                                        case "Mayo":
                                        case "Şalvar Pantolon":
                                            product.setMainCategory("Clothes");
                                            break;
                                        case "Tunik":
                                        case "Dış Giyim":
                                        case "Elbise":
                                        case "Ferace":
                                        case "Pardesü":
                                        case "Şal":
                                        case "Trenchoat":
                                        case "Kap - Trenchoat - Kaban":
                                        case "Kaban - Mont":
                                        case "Trençkot - Kap":
                                        case "Panço":
                                        case "Ceket":
                                            product.setMainCategory("Outside Clothes");
                                            break;
                                        case "Boyunluk - Kolluk - Eldiven":
                                        case "Gözlük":
                                        case "Çanta":
                                        case "Topuz Tokası":
                                        case "Aksesuar":
                                        case "Takı":
                                        case "Kolye":
                                        case "Babet":
                                        case "Şal-Eşarp Modelleri":
                                        case "Başörtüsü":
                                        case "Bone":
                                        case "Saat":
                                        case "Mıknatıs Çıt Çıt":
                                        case "Pratik Bone":
                                        case "Kemer":
                                        case "Ayakkabı":
                                        case "Bileklik":
                                        case "Yüzük":
                                        case "Anahtarlık":
                                            product.setMainCategory("Accessories");
                                            break;
                                        case " ":
                                        default:
                                            product.setMainCategory("Other");
                                            break;

                                    }
                                    break;
                                default:
                                    break;
                            }

                        } else if (elemNode.getNodeName().equals("Category")) {
                            switch (node.getNodeName()) {
                                case "Path":
                                    category.setPath(node.getNodeValue());
                                    break;
                                case "DisplayOrder":
                                    category.setDisplayOrder(node.getNodeValue());
                                    product.getCategories().add(category);
                                    category=new Category();
                                    break;
                                default:
                                    break;
                            }
                    } else if (elemNode.getNodeName().equals("Manufacturer")) {
                            switch (node.getNodeName()) {
                                case "Name":
                                    product.getManufacturer().setName(node.getNodeValue());
                                    break;
                                case "DisplayOrder":
                                    product.getManufacturer().setDisplayOrder(node.getNodeValue());
                                    break;
                                default:
                                    break;
                            }
                    } else if (elemNode.getNodeName().equals("Picture")) {
                            if (node.getNodeName().equals("Path")) {
                                product.getPictures().add(new Picture(node.getNodeValue()));
                            }
                    } else if (elemNode.getNodeName().equals("Combination")) {
                            switch (node.getNodeName()) {
                                case "Id":
                                    combination.setId(node.getNodeValue());
                                    break;
                                case "Sku":
                                    combination.setSku(node.getNodeValue());
                                    break;
                                case "Gtin":
                                    combination.setGtin(node.getNodeValue());
                                    break;
                                case "Barcode":
                                    combination.setBarcode(node.getNodeValue());
                                    break;
                                case "StockQuantity":
                                    combination.setStockQuantity(node.getNodeValue());
                                    product.getCombinations().add(combination);
                                    combination = new Combination();
                                    break;
                                default:
                                    break;
                            }
                    } else if (elemNode.getNodeName().equals("Attribute")) {
                            switch (node.getNodeName()) {
                                case "Name":
                                    attribute.setName(node.getNodeValue());
                                    break;
                                case "Value":
                                    attribute.setValue(node.getNodeValue());
                                    product.getCombinations().get(attributeCounter).setAttribute(attribute);
                                    attributeCounter++;
                                    attribute = new Attribute();
                                    break;
                                default:
                                    break;
                            }
                        }  else if (elemNode.getNodeName().equals("Specification")) {
                            switch (node.getNodeName()) {
                                case "Name":
                                    specification.setName(node.getNodeValue());
                                    break;
                                case "Value":
                                    specification.setValue(node.getNodeValue());
                                    break;
                                case "DisplayOrder":
                                    specification.setDisplayOrder(node.getNodeValue());
                                    product.getSpecifications().add(specification);
                                    specification = new Specification();
                                    break;
                            }
                        }

                    }
                }
                if (elemNode.hasChildNodes()) {
//recursive call if the node has child nodes
                    printNodeList(elemNode.getChildNodes());
                }
                if (elemNode.getNodeName().equals("Product")) {
                    product.setDescription(nodes.item(k).getTextContent());
                    products.add(product);
                    k++;
                    attributeCounter = 0;
                    product = new Product();
                    product.setCategories(new ArrayList<Category>());
                    product.setManufacturer(new Manufacturer());
                    product.setPictures(new ArrayList<Picture>());
                    product.setCombinations(new ArrayList<Combination>());
                    product.setSpecifications(new ArrayList<Specification>());
                }
            }
        }
    }

    public String fetchMainCategory(String mainCategory) {
        for (int i = 0; i < mainCategories.size(); i++) {
            if (mainCategory.equals(mainCategories.get(i))) {
                return null;
            }
        }
        System.out.println(mainCategory + "   " + mainCategories.size());
        return mainCategory;
    }


    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        //if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        //}
        //return "";
    }
}