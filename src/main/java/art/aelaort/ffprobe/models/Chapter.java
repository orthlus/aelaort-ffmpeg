package art.aelaort.ffprobe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Chapter {
	@JsonProperty
	private String id;
	@JsonProperty("time_base")
	private String timeBase;
	@JsonProperty
	private long start;
	@JsonProperty("start_time")
	private String startTime;
	@JsonProperty
	private long end;
	@JsonProperty("end_time")
	private String endTime;
	@JsonProperty
	private ChapterTag tags;
}
