package com.example.xmltojson;

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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

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


public class MainActivity extends AppCompatActivity {
    TextView textView;
    Product product;
    ArrayList<Product> products;
    FirebaseFirestore firebaseFirestore;
    int attributeCounter = 0;
    Combination combination = new Combination();
    Attribute attribute = new Attribute();
    Specification specification = new Specification();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        firebaseFirestore = FirebaseFirestore.getInstance();
        product = new Product();
        products = new ArrayList<>();
        product.setCategory(new Category());
        product.setManufacturer(new Manufacturer());
        product.setPictures(new ArrayList<Picture>());
        product.setCombinations(new ArrayList<Combination>());
        product.setSpecifications(new ArrayList<Specification>());
        InputStream inputStream = getResources().openRawResource(R.raw.ekrumoda);
        Document document = parseXML(new InputSource(inputStream));
        textView.setText(document.getDocumentElement().getNodeName());
        firebaseFirestore.collection("products").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                System.out.println(queryDocumentSnapshots.getDocuments().size() + " products size 1");
            }
        });
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

//        for (int i = 0; i < products.size(); i++){
//            final int finalI = i;
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
//                    } else {
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
//
//            firebaseFirestore.collection("products").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                @Override
//                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                    System.out.println(queryDocumentSnapshots.getDocuments().size() + " products size 2");
//                }
//            });
//        }
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
                            if (product.getCategory().getPath() != null) {
                            }
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
                                    product.setMainCategory(node.getNodeValue());
                                    break;
                                default:
                                    break;
                            }

                        } else if (elemNode.getNodeName().equals("Category")) {
                            switch (node.getNodeName()) {
                                case "Path":
                                    product.getCategory().setPath(node.getNodeValue());
                                    break;
                                case "DisplayOrder":
                                    product.getCategory().setDisplayOrder(node.getNodeValue());
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
                    products.add(product);
                    attributeCounter = 0;
                    product = new Product();
                    product.setCategory(new Category());
                    product.setManufacturer(new Manufacturer());
                    product.setPictures(new ArrayList<Picture>());
                    product.setCombinations(new ArrayList<Combination>());
                    product.setSpecifications(new ArrayList<Specification>());
                }
            }
        }
    }
}