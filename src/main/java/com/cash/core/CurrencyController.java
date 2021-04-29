package com.cash.core;

import com.cash.util.TemplateCurrency;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

import java.net.*;
import java.util.ArrayList;
import java.util.List;


@Log4j
public class CurrencyController {

    private static final String URL_FILE = "http://www.cbr.ru/scripts/XML_daily.asp";

    public static List<TemplateCurrency> downloadCurrency() {
        List<TemplateCurrency> templateCurrencies = new ArrayList<>();
        try {

            String download = download();
            JSONObject xmlJSONObj = XML.toJSONObject(download);

            String jsonPrettyPrintString = xmlJSONObj.toString();

            JSONObject currentPerson = new JSONObject(jsonPrettyPrintString);

            String data = currentPerson.getJSONObject("ValCurs").getString("Date");
            JSONArray val = currentPerson.getJSONObject("ValCurs").getJSONArray("Valute");

            for (int i=0; i<val.length(); i++)
            {
                JSONObject node = val.getJSONObject(i);
                templateCurrencies.add(
                  new TemplateCurrency(
                          data,
                          node.getString("CharCode"),
                          node.getString("Value"),
                          node.getString("ID"),
                          node.getInt("Nominal"),
                          node.getInt("Nominal"),
                          node.getString("Name"),
                          false
                  ));
            }
            return templateCurrencies;
        } catch (Exception e) {
            log.error("Request error! " + e.getMessage());
            return templateCurrencies;
        }
    }

    @SneakyThrows
    private static String download() {
        URL url = new URL(URL_FILE);
        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");

        InputStream xml = connection.getInputStream();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(xml);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        String output = writer.getBuffer().toString().replaceAll("\n|\r", "");
        return output;
    }



}
