package me.sergivb01.rhino.payloads;

public abstract class Payload{
	private String server;
	private long timestamp;

	public Payload(String server, long timestamp){
		this.server = server;
		this.timestamp = timestamp;
	}

	public long getTimestamp(){
		return timestamp;
	}

	public boolean isAfter(long compareTo){
		return timestamp < compareTo;
	}

	public boolean isBefore(long compareTo){
		return timestamp > compareTo;
	}

	@Override
	public boolean equals(Object obj){
		return super.equals(obj);
	}
}
