package net.awesomepowered.namehistory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by John on 2/4/2015.
 *
 * THIS SHIT IS PROVIDED FOR FREE BY LAXWASHERE, DO NOT FUCKING SELL AT SPIGOT.
 * I SWEAR TO MY MUM, I WILL END U
 *
 */
public class NameHistory extends Plugin {

    String daUrl = "https://api.mojang.com/user/profiles/UUID/names";
    private JsonParser fuckingShit = new JsonParser();

    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new NameHistoryCommand(this));
    }

    public void doRequest(String uuid, ProxiedPlayer dumbShit) {
        URL url = null;
        try {
            url = new URL(daUrl.replace("UUID", uuid.replace("-", "")));
            System.out.println("Requesting: " + url.toString());
            HttpsURLConnection urMum = (HttpsURLConnection) url.openConnection();
            parseAndSendData("name", urMum.getInputStream(), dumbShit);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  void parseAndSendData(String just, InputStream theTip, ProxiedPlayer dumbShit) throws Exception {
        final Reader fuckYou = new InputStreamReader(theTip);
        final BufferedReader fuckThis = new BufferedReader(fuckYou);
        JsonArray fuckMojang = (JsonArray) fuckingShit.parse(fuckThis.readLine());
        dumbShit.sendMessage(ChatColor.AQUA + "<-- Printing History -->");
        for (Object fuckingShit : fuckMojang) {
            JsonObject notAFuckingJasonObject = (JsonObject) fuckingShit;
            dumbShit.sendMessage(ChatColor.RED + "> " +ChatColor.GREEN + notAFuckingJasonObject.get(just).toString());
        }
        dumbShit.sendMessage(ChatColor.AQUA + "<-- Done Printing -->");
    }

    public static void main(String[] args) throws Exception {
        //doRequest("fb08985e-d4c9-452e-8cfd-9d1f3f6143fe");
    }

}
