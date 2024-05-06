package art.aelaort.ffprobe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FFprobeResult {
	@JsonProperty
	private Error error;
	@JsonProperty
	private Format format;
	@JsonProperty
	private List<Stream> streams = new ArrayList<>();
	@JsonProperty
	private List<Chapter> chapters = new ArrayList<>();

	public boolean hasError() {
		return error != null;
	}
}
