package me.sergivb01.rhino.payloads.utils;

import me.sergivb01.rhino.Cache;
import me.sergivb01.rhino.redis.RedisManager;
import me.sergivb01.rhino.utils.ConfigUtils;
import org.bson.Document;

public abstract class Payload{
	private String type;

	public Payload(String type){
		this.type = type;
	}

	@Override
	public boolean equals(Object obj){
		return super.equals(obj);
	}

	public void send(){
		Cache.addPayload(this);
		RedisManager.publisher.write("payload;" +
				this.toDocument()
						.append("type", type)
						.append("server", ConfigUtils.SERVER_NAME)
						.append("timestamp", System.currentTimeMillis())
						.toJson()
		);
	}

	public abstract void fromDocument(Document document);

	public abstract Document toDocument();


}
