package art.aelaort.ffprobe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Disposition {
	@JsonProperty("_default")
	private boolean isDefault;
	@JsonProperty
	private boolean dub;
	@JsonProperty
	private boolean original;
	@JsonProperty
	private boolean comment;
	@JsonProperty
	private boolean lyrics;
	@JsonProperty
	private boolean karaoke;
	@JsonProperty
	private boolean forced;
	@JsonProperty("hearing_impaired")
	private boolean hearingImpaired;
	@JsonProperty("visual_impaired")
	private boolean visualImpaired;
	@JsonProperty("clean_effects")
	private boolean cleanEffects;
	@JsonProperty("attached_pic")
	private boolean attachedPic;
	@JsonProperty
	private boolean captions;
	@JsonProperty
	private boolean descriptions;
	@JsonProperty
	private boolean metadata;
}
