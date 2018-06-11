package me.sergivb01.rhino.payloads;

import me.sergivb01.rhino.utils.ConfigUtils;
import org.bson.Document;

import java.util.UUID;

public class RequestPayload extends Payload{
	private UUID uuid;
	private String playerName;
	private UUID playerUUID;
	private String reason;

	public RequestPayload(String playerName, UUID playerUUID, String reason){
		super(ConfigUtils.SERVER_NAME, System.currentTimeMillis());
		this.uuid = UUID.randomUUID();
		this.playerName = playerName;
		this.playerUUID = playerUUID;
		this.reason = reason;
	}

	public void fromDocument(Document document){
		this.playerName = document.getString("playername");
		this.playerUUID = UUID.fromString(document.getString("playerUUID"));
		this.reason = document.getString("reason");
		this.uuid = UUID.fromString(document.getString("uuid"));
	}

	public Document toDocument(){
		return new Document("type", "request")
				.append("playerName", playerName)
				.append("playerUUID", playerUUID)
				.append("reason", reason)
				.append("uuid", uuid.toString());
	}

	public void send(){
		//TODO: Handle send
	}


}
