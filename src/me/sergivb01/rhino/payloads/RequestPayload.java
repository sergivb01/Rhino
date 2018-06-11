package me.sergivb01.rhino.payloads;

import me.sergivb01.rhino.payloads.utils.Payload;
import org.bson.Document;

import java.util.UUID;

public class RequestPayload extends Payload{
	private UUID uuid;
	private String playerName;
	private UUID playerUUID;
	private String reason;

	public RequestPayload(String playerName, UUID playerUUID, String reason){
		super("request");
		this.uuid = UUID.randomUUID();
		this.playerName = playerName;
		this.playerUUID = playerUUID;
		this.reason = reason;
	}

	public void fromDocument(Document document){
		this.playerName = document.getString("playerName");
		this.playerUUID = (UUID) document.get("playerUUID");
		this.reason = document.getString("reason");
		this.uuid = (UUID) document.get("uuid");
	}

	public Document toDocument(){
		return new Document("playerName", playerName)
				.append("playerUUID", playerUUID)
				.append("reason", reason)
				.append("uuid", uuid);
	}


}

