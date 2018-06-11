package me.sergivb01.rhino.payloads.utils;

import me.sergivb01.rhino.Cache;
import me.sergivb01.rhino.RhinoPlugin;
import me.sergivb01.rhino.payloads.ReportPayload;
import me.sergivb01.rhino.payloads.RequestPayload;
import me.sergivb01.rhino.payloads.ServerSwitchPayload;
import me.sergivb01.rhino.utils.ConfigUtils;
import org.bson.Document;

public class PayloadParser{

	public static void parse(Document document){
		String server = document.getString("server");
		String type = document.getString("type");

		if(server.equalsIgnoreCase(ConfigUtils.SERVER_NAME)) return;

		Payload payload = getPayloadFromType(type);
		if(payload == null){
			RhinoPlugin.getInstance().getLogger().severe("Failed to parse payload - " + document.toJson());
			return;
		}

		payload.fromDocument(document);
		Cache.addPayload(payload);
	}

	public static Payload getPayloadFromType(String type){
		switch(type.toLowerCase()){
			case "report":
				return new ReportPayload();

			case "request":
				return new RequestPayload();

			case "serverswitch":
				return new ServerSwitchPayload();
		}
		return null;
	}

}
