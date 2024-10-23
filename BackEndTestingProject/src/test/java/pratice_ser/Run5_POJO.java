package pratice_ser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

		   class ProjectPojo {

		   String projectName;
		   String projectstatus;
		   int teamSize;
		   List<String> teamMember;
		   ProjectManager projectManager;

		   public ProjectPojo(String projectName, String projectstatus, int teamSize, List<String> teamMember,
				ProjectManager projectManager) {
			super();
			this.projectName = projectName;
			this.projectstatus = projectstatus;
			this.teamSize = teamSize;
			this.teamMember = teamMember;
			this.projectManager = projectManager;
		}
		    
			public void setProjectName(String projectName) {
		        this.projectName = projectName;
		    }
		    public String getProjectName() {
		        return projectName;
		    }
		    
		    public void setProjectstatus(String projectstatus) {
		        this.projectstatus = projectstatus;
		    }
		    public String getProjectstatus() {
		        return projectstatus;
		    }
		    
		    public void setTeamSize(int teamSize) {
		        this.teamSize = teamSize;
		    }
		    public int getTeamSize() {
		        return teamSize;
		    }
		    
		    public void setTeamMember(List<String> teamMember) {
		        this.teamMember = teamMember;
		    }
		    public List<String> getTeamMember() {
		        return teamMember;
		    }
		    
		    public void setProjectManager(ProjectManager projectManager) {
		        this.projectManager = projectManager;
		    }
		    public ProjectManager getProjectManager() {
		        return projectManager;
		    }
		    
		}
	
		class ProjectManager {

		   String name;
		   String empID;
		   
		    public ProjectManager(String name, String empID) {
			super();
			this.name = name;
			this.empID = empID;
		}
			public void setName(String name) {
		        this.name = name;
		    }
		    public String getName() {
		        return name;
		    }
		    
		    public void setEmpID(String empID) {
		        this.empID = empID;
		    }
		    public String getEmpID() {
		        return empID;
		    }
		    
		}
	
	
	public class Run5_POJO {
		
		public static void main(String[] args) throws Exception{
			
			List<String> lst = new ArrayList<String>();
			lst.add("Jhon");
			lst.add("David");
			lst.add("Stev");
	
			ProjectManager Pm = new ProjectManager("appu", "tp04");
			ProjectPojo prObj = new ProjectPojo("Pranav", "Created", 0, lst , Pm);
			
			ObjectMapper onjM = new ObjectMapper();
			onjM.writeValue(new File("./project1.json"), prObj);
		}
}
