package com.example.xmltojson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xmltojson.models.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    /*    AssetManager assetManager = getAssets();
        InputStream inputStream = getResources().openRawResource(R.raw.ekrumoda);
       parseXML();
           XmlToJson xmlToJson = new XmlToJson.Builder(inputStream,null).build();
            inputStream.close();
            JSONObject jsonObject = xmlToJson.toJson();
            String jsonString = xmlToJson.toString();
            String formatted = xmlToJson.toFormattedString();
            ObjectMapper mapper=new ObjectMapper();

            List<Product> products = Arrays.asList(mapper.readValue(jsonString,Product[].class));
            Toast.makeText(this, products.get(0).getName(), Toast.LENGTH_SHORT).show();

            textView.setText(products.get(0).getName());
            System.out.print("saed");
            // Get the directory for the user's public pictures directory.
            final File path =
                    Environment.getExternalStoragePublicDirectory
                            (
                                    //Environment.DIRECTORY_PICTURES
                                    Environment.DIRECTORY_DCIM
                            );

            // Make sure the path directory exists.
            if(!path.exists())
            {
                // Make it, if it doesn't exit
                path.mkdirs();
            }

            final File file = new File(path, "test2.txt");

            // Save your stream, don't forget to flush() it before closing it.

            try
            {
                file.createNewFile();
                FileOutputStream fOut = new FileOutputStream(file);
                OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                myOutWriter.append(formatted);

                myOutWriter.close();

                fOut.flush();
                fOut.close();
            }
            catch (IOException e)
            {
                Log.e("Exception", "File write failed: " + e.toString());
            }*/
    parseXML();
    }
    void parseXML(){
        XmlPullParserFactory parserFactory;
        try {
            parserFactory=XmlPullParserFactory.newInstance();
            XmlPullParser parser= parserFactory.newPullParser();
            //AssetManager assetManager = getAssets();//read our XML file.
            InputStream inputStream = getAssets().open("data.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parser.setInput(inputStream, null);
            processParsing(parser);

        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

    }
    void processParsing(XmlPullParser parser) throws XmlPullParserException, IOException {
        ArrayList<Product> products= new ArrayList<>();
        int eventType=parser.getEventType();
        Product currentProduct=null;
        while(eventType != XmlPullParser.END_DOCUMENT){
            String eltName =null;
            switch (eventType){
                case XmlPullParser.END_TAG:
                    eltName=parser.getName();
                    if("Product".equals(eltName)){
                        currentProduct=new Product();
                        products.add(currentProduct);
                    }
                    else if (currentProduct!=null){
                        if("Id".equals(eltName)){
                            currentProduct.Id=parser.nextText();
                        }
                        else if("ModelCode".equals(eltName)){
                            currentProduct.ModelCode=parser.nextText();
                        }
                        else if ("Sku".equals(eltName)){
                            currentProduct.Sku=parser.nextText();
                        }
                    }
                    break;
            }
           eventType=parser.next();
        }
        printProducts(products);
    }
    void printProducts(ArrayList<Product> products){
        StringBuilder builder = new StringBuilder();
        builder.append(products.get(0).Id).append("\n").append(products.get(0).ModelCode).append("\n").append(products.get(0).Sku);
        textView.setText(builder.toString());
    }
}