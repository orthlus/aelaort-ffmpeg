package art.aelaort.ffprobe;

import art.aelaort.SystemResponse;

public class FFprobeException extends RuntimeException {
	private final boolean jsonError;
	private SystemResponse response;

	public FFprobeException(SystemResponse response) {
		this.response = response;
		this.jsonError = false;
	}

	public FFprobeException(SystemResponse response, boolean jsonError) {
		this.response = response;
		this.jsonError = jsonError;
	}

	public SystemResponse getResponse() {
		return response;
	}

	public boolean isJsonError() {
		return jsonError;
	}
}
