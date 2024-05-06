package art.aelaort.ffprobe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Format {
	@JsonProperty
	private String filename;
	@JsonProperty("nb_streams")
	private int nbStreams;
	@JsonProperty("nb_programs")
	private int nbPrograms;
	@JsonProperty("format_name")
	private String formatName;
	@JsonProperty("format_long_name")
	private String formatLongName;
	@JsonProperty("start_time")
	private double startTime;
	/* Duration in seconds */
	@JsonProperty
	private double duration;
	/* File size in bytes */
	@JsonProperty
	private long size;
	@JsonProperty("bit_rate")
	private long bitRate;
	@JsonProperty("probe_score")
	private int probeScore;
	@JsonProperty
	private Map<String, String> tags;
}
