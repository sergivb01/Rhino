package me.sergivb01.rhino.payloads.utils;

import me.sergivb01.rhino.Cache;
import me.sergivb01.rhino.RhinoPlugin;
import me.sergivb01.rhino.payloads.ReportPayload;
import me.sergivb01.rhino.payloads.RequestPayload;
import me.sergivb01.rhino.payloads.ServerSwitchPayload;
import me.sergivb01.rhino.utils.ConfigUtils;
import org.bson.Document;

import java.util.Objects;

public class PayloadParser{

	public static void parse(Document document){
		if(document.getString("server").equalsIgnoreCase(ConfigUtils.SERVER_NAME)) return;

		Payload payload = null;
		switch(document.getString("type").toLowerCase()){
			case "report":
				payload = new ReportPayload(null, null, null, null, null);
				break;
			case "request":
				payload = new RequestPayload(null, null, null);
				break;
			case "serverswitch":
				payload = new ServerSwitchPayload(null, null, null, false);
				break;
		}
		Objects.requireNonNull(payload).fromDocument(document);

		Cache.addPayload(payload);
		RhinoPlugin.instance.getLogger().info("Parsed payload " + payload.toDocument().toJson() + "!");
	}

}
