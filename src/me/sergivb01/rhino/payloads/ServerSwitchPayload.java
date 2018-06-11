package me.sergivb01.rhino.payloads;

import me.sergivb01.rhino.payloads.utils.Payload;
import org.bson.Document;

import java.util.UUID;

public class ServerSwitchPayload extends Payload{
	private UUID uuid;
	private String playerName;
	private UUID playerUUID;
	private boolean staff;
	private String status;

	public ServerSwitchPayload(String playerName, UUID playerUUID, String status, boolean staff){
		super("serverswitch");
		this.uuid = UUID.randomUUID();
		this.playerName = playerName;
		this.playerUUID = playerUUID;
		this.status = status;
		this.staff = staff;
	}

	@Override
	public void fromDocument(Document document){
		this.playerName = document.getString("playername");
		this.playerUUID = (UUID) document.get("playerUUID");
		this.status = document.getString("status");
		this.staff = document.getBoolean("staff");
	}

	@Override
	public Document toDocument(){
		return new Document("playerName", playerName)
				.append("playerUUID", playerUUID)
				.append("status", status)
				.append("staff", staff)
				.append("uuid", uuid);
	}
}
