package jef;

public class Light implements Startable {

	private boolean alight;

	private String roomName;

	public Light(String roomName) {
		super();
		this.setRoomName(roomName);
	}

	public String getRoomName() {
		return roomName;
	}

	public boolean isAlight() {
		return alight;
	}

	private void setAlight(boolean alight) {
		this.alight = alight;
	}

	private void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public void start() {
		this.setAlight(true);
	}

	public void stop() {
		this.setAlight(false);
	}

}
