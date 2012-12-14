package kr.mentalcare.project;

import java.sql.SQLException;
import java.util.List;

import kr.mentalcare.project.service.FieldNameService;
import kr.mentalcare.project.util.FileUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;

/*1분마다 스레드를 돌리면서 6개월 이상 보관된 파일을 삭제하는 기능 */
@Service
public class FileManager {
	@Autowired
	SqlMapClient sqlMapClient;
	@Autowired
	FieldNameService fieldNameService;
	public FileManager() throws InterruptedException{
		
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10000);

						List<String> oldFile=sqlMapClient.queryForList("Common.getOldFile");
						for(int i=0;i<oldFile.size();i++){
							if(FileUtil.deleteFile(oldFile.get(i))){
								fieldNameService.removeFile(oldFile.get(i));
								System.out.println(oldFile.get(i)+"가 만료되어 삭제되었습니다.");
							}
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
		
	}
}
