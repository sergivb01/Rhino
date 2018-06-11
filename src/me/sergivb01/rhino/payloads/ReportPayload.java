package me.sergivb01.rhino.payloads;

import lombok.Getter;
import org.bson.Document;

import java.util.UUID;

@Getter
public class ReportPayload extends Payload{
	private String reporterName;
	private UUID reporterUUID;

	private String reportedName;
	private UUID reportedUUID;

	public ReportPayload(String server, long timestamp, String reporterName, UUID reporterUUID, String reportedName, UUID reportedUUID){
		super(server, timestamp);
		this.reporterName = reporterName;
		this.reporterUUID = reporterUUID;
		this.reportedName = reportedName;
		this.reportedUUID = reportedUUID;
	}

	public void fromDocument(Document document){
		this.reporterName = document.getString("reporterName");
		this.reporterUUID = UUID.fromString(document.getString("reporterUUID"));
		this.reportedName = document.getString("reportedName");
		this.reportedUUID = UUID.fromString(document.getString("reportedUUID"));
	}

	public Document toDocument(){
		return new Document("type", "report")
				.append("reporterName", reportedName)
				.append("reporterUUID", reportedUUID.toString())
				.append("reportedName", reportedName)
				.append("reportedUUID", reportedUUID.toString());
	}


}
