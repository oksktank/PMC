package kr.mentalcare.project.service;

import java.sql.SQLException;
import java.util.List;

import kr.mentalcare.project.model.Developer;
import kr.mentalcare.project.model.DeveloperTeam;
import kr.mentalcare.project.model.DeveloperWorkDeveloperTeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;

@Service
public class TeamService {
	@Autowired
	SqlMapClient sqlMapClient;
	
	@Autowired
	DeveloperService developerService;
	
	public List<DeveloperTeam> getTeamListInWork(Integer w_num) throws SQLException{
		List<DeveloperTeam> teamList=sqlMapClient.queryForList("Team.getTeamListInWork",w_num);
		for(int i=0;i<teamList.size();i++){
			DeveloperTeam team=teamList.get(i);
			List<Developer> devList=sqlMapClient.queryForList("Developer.getDeveloperListInTeam",team.getDt_number());
			team.setDevList(devList);
		}
		return teamList;
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
