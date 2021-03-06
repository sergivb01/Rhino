package me.sergivb01.rhino.payloads;

import lombok.Getter;
import me.sergivb01.rhino.payloads.utils.Payload;
import org.bson.Document;

import java.util.UUID;

@Getter
public class ReportPayload extends Payload{
	private UUID uuid;

	private String reporterName;
	private UUID reporterUUID;

	private String reportedName;
	private UUID reportedUUID;

	private String reason;

	public ReportPayload(){
		super("report");
	}

	public ReportPayload(String reporterName, UUID reporterUUID, String reportedName, UUID reportedUUID, String reason){
		super("report");
		this.uuid = UUID.randomUUID();
		this.reporterName = reporterName;
		this.reporterUUID = reporterUUID;
		this.reportedName = reportedName;
		this.reportedUUID = reportedUUID;
		this.reason = reason;
	}

	public void fromDocument(Document document){
		this.reporterName = document.getString("reporterName");
		this.reporterUUID = (UUID) document.get("reporterUUID");
		this.reportedName = document.getString("reportedName");
		this.reportedUUID = (UUID) document.get("reportedUUID");
		this.reason = document.getString("reason");
		this.uuid = (UUID) document.get("uuid");
	}

	public Document toDocument(){
		return new Document("reporterName", reportedName)
				.append("reporterUUID", reportedUUID)
				.append("reportedName", reportedName)
				.append("reportedUUID", reportedUUID)
				.append("reason", reason)
				.append("uuid", uuid);
	}

	public void broadcast(){
		//TODO: Broadcast
	}


}
