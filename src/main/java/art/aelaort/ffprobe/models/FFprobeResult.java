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

	public List<Stream> getAudioStreams() {
		return streams.stream()
				.filter(s -> s.getType().equals(Stream.CodecType.audio))
				.toList();
	}

	public List<Stream> getSubtitlesStreams() {
		return streams.stream()
				.filter(s -> s.getType().equals(Stream.CodecType.subtitle))
				.toList();
	}

	public Stream getVideoStream() {
		return streams.stream()
				.filter(s -> s.getType().equals(Stream.CodecType.video))
				.findFirst()
				.orElseThrow();
	}

	public boolean hasError() {
		return error != null;
	}
}
