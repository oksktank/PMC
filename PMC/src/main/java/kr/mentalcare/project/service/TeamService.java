package kr.mentalcare.project.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import kr.mentalcare.project.model.Developer;
import kr.mentalcare.project.model.DeveloperTeam;
import kr.mentalcare.project.model.DeveloperWorkDeveloperTeam;
import kr.mentalcare.project.model.FieldName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;

@Service
public class TeamService {
	@Autowired
	SqlMapClient sqlMapClient;
	
	@Autowired
	DeveloperService developerService;
	@Autowired
	FieldNameService fieldNameService;
	
	
	public List<DeveloperTeam> getTeamListInWork(Integer w_num) throws SQLException{
		List<DeveloperTeam> teamList=sqlMapClient.queryForList("Team.getTeamListInWork",w_num);
		for(int i=0;i<teamList.size();i++){
			DeveloperTeam team=teamList.get(i);
			List<Developer> devList=sqlMapClient.queryForList("Developer.getDeveloperListInTeam",team.getDt_number());
			team.setDevList(devList);
		}
		return teamList;
	}
	public DeveloperTeam getTeamById(Integer id) throws SQLException{
		DeveloperTeam team=(DeveloperTeam) sqlMapClient.queryForObject("Team.getTeamById",id);
		if(team!=null){
			List<Developer> devList=sqlMapClient.queryForList("Developer.getDeveloperListInTeam",team.getDt_number());

			HashMap<Integer,FieldName> fieldMap=fieldNameService.getFieldNameMap();
			for(int i=0;i<devList.size();i++){
				Developer dev=devList.get(i);
				dev.setExpert_part_name(fieldMap.get(dev.getExpert_part()).getName());
				dev.setDetail_part_name(fieldMap.get(dev.getDetail_part()).getName());
				dev.setGradeLevel(developerService.getGradeLevel(dev.getSn()));
			}
			team.setDevList(devList);
		}
		return team;
		
	}
	
	public DeveloperTeam getTeamBySnAndWnum(DeveloperWorkDeveloperTeam param) throws SQLException{
		DeveloperTeam myTeam=(DeveloperTeam) sqlMapClient.queryForObject("Team.getTeamBySn",param);
		if(myTeam!=null){
			List<Developer> devList=sqlMapClient.queryForList("Developer.getDeveloperListInTeam",myTeam.getDt_number());
			myTeam.setDevList(devList);
			
		}
		return myTeam;
	}
}
