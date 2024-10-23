package pratice_ser;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(
		value = {	"createdBy",
					"projectName",
					"teamSize",
					"status"
		}
		)
@JsonIgnoreProperties(
		value = {	"teamSize"
		},allowSetters = true
		)

class Project {  //POJO class [Plain Old Java Class]
	private String projectName;
	@JsonProperty(value ="created By")
	private String createdBy;
	private int teamSize;
	private String status;
	
	private Project() {} 	//Empty Constructor for deSerialization
	
	public Project(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
		
}

public class Run3_Jackson_SerTest {

	public static void main(String[] args) throws Exception {
		Project pObj = new Project("DemoRS_JS", "Pranav", 0, "Created");
		
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File("./project.json"), pObj); // Converting into javaObject to Json
		System.out.println("====END====");
	}
}
