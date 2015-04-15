package com.insta.instaannuaire.resources;

import android.util.Base64;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.io.HttpResponseParser;
import org.json.JSONObject;


import java.io.InputStream;
import java.net.URLEncoder;

/**
 * Created by BNP on 14/04/2015.
 */
public  class Authentification {

    public static String authentificate(String login, String password) throws Exception {
String token = login + '|' + password;

        String encode = new String(Base64.encode(token.getBytes(), Base64.DEFAULT),"UTF-8");
encode = encode.replaceAll("\\n", "");

        final String url = "http://192.168.43.169:8080/annuaire/api/authentification?token="+encode ;

        URLEncoder.encode(url, "UTF-8");
        HttpClient hc = new DefaultHttpClient();
        try {
            HttpGet hg = new HttpGet(url);

            HttpResponse hr = hc.execute(hg);

            HttpEntity he = hr.getEntity();

            if (he != null) {
                InputStream input = he.getContent();
                String json = input.toString();
                JSONObject js = new JSONObject(json);

                if (js.getString("Error") != null || js.getString("Error").equals("Error")) {
// si une erreur se produit
                    return null;

                } else {
                    User u = new User();

                    u.setId(js.getInt("id"));
                    u.setNom(js.getString("nom"));
                    u.setPrenom(js.getString("Prenom"));
                    u.setMail(js.getString("mail"));
                    u.setImage(js.getString("image"));

                    return json;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }


}