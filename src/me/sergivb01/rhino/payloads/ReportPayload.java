package me.sergivb01.rhino.payloads;

import lombok.Getter;
import me.sergivb01.rhino.utils.ConfigUtils;
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

	public ReportPayload(String reporterName, UUID reporterUUID, String reportedName, UUID reportedUUID, String reason){
		super(ConfigUtils.SERVER_NAME, System.currentTimeMillis());
		this.uuid = UUID.randomUUID();
		this.reporterName = reporterName;
		this.reporterUUID = reporterUUID;
		this.reportedName = reportedName;
		this.reportedUUID = reportedUUID;
		this.reason = reason;
	}

	public void fromDocument(Document document){
		this.reporterName = document.getString("reporterName");
		this.reporterUUID = UUID.fromString(document.getString("reporterUUID"));
		this.reportedName = document.getString("reportedName");
		this.reportedUUID = UUID.fromString(document.getString("reportedUUID"));
		this.reason = document.getString("reason");
		this.uuid = UUID.fromString(document.getString("uuid"));
	}

	public Document toDocument(){
		return new Document("type", "report")
				.append("reporterName", reportedName)
				.append("reporterUUID", reportedUUID.toString())
				.append("reportedName", reportedName)
				.append("reportedUUID", reportedUUID.toString())
				.append("reason", reason)
				.append("uuid", uuid.toString());
	}


	public void send(){
		//TODO: Handle send
	}


}
