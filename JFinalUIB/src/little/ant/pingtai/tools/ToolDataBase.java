package little.ant.pingtai.tools;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import little.ant.pingtai.common.DictKeys;
import little.ant.pingtai.run.JfinalConfig;

/**
 * 数据库导入导出处理
 * @author 董华健
 */
public class ToolDataBase {
	
	/**
	 * 数据库导出
	 * @param exportPath
	 * @throws IOException
	 */
	public static void exportSql(String exportPath) throws IOException {
		String username = (String) JfinalConfig.getParamMapValue(DictKeys.db_connection_userName);
		String password = (String) JfinalConfig.getParamMapValue(DictKeys.db_connection_passWord);
		String ip = (String) JfinalConfig.getParamMapValue(DictKeys.db_connection_ip);
		String port = (String) JfinalConfig.getParamMapValue(DictKeys.db_connection_port);
		String database = (String) JfinalConfig.getParamMapValue(DictKeys.db_connection_dbName);
		
		String db_type = (String) JfinalConfig.getParamMapValue(DictKeys.db_type_key);
		if(db_type.equals(DictKeys.db_type_postgresql)){ // pg
			
			
			
		}else if(db_type.equals(DictKeys.db_type_mysql)){ // mysql
			StringBuffer command = new StringBuffer();
			command.append("cmd /c mysqldump -u").append(username).append(" -p").append(password)//密码是用的小p，而端口是用的大P。  
					.append(" -h").append(ip).append(" -P").append(port).append(" ").append(database).append(" -r \"").append(exportPath+"\"");
			try {
				Process process = Runtime.getRuntime().exec(command.toString(), null, new File(exportPath));
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 数据库导入
	 * @param filePath
	 * @throws IOException
	 */
	public static void importSql(String filePath) throws IOException {
		String username = (String) JfinalConfig.getParamMapValue(DictKeys.db_connection_userName);
		String password = (String) JfinalConfig.getParamMapValue(DictKeys.db_connection_passWord);
		String ip = (String) JfinalConfig.getParamMapValue(DictKeys.db_connection_ip);
		String port = (String) JfinalConfig.getParamMapValue(DictKeys.db_connection_port);
		String database = (String) JfinalConfig.getParamMapValue(DictKeys.db_connection_dbName);
		
		String db_type = (String) JfinalConfig.getParamMapValue(DictKeys.db_type_key);
		if(db_type.equals(DictKeys.db_type_postgresql)){ // pg
			
			
			
		}else if(db_type.equals(DictKeys.db_type_mysql)){ // mysql
			//第一步，获取登录命令语句  
			String loginCommand = new StringBuffer().append("mysql -u").append(username).append(" -p").append(password).append(" -h").append(ip).append(" -P").append(port).toString();
			//第二步，获取切换数据库到目标数据库的命令语句  
			String switchCommand = new StringBuffer("use ").append(database).toString();
			//第三步，获取导入的命令语句  
			String importCommand = new StringBuffer("source ").append(filePath).toString();
			//需要返回的命令语句数组  
			String[] commands = new String[] { loginCommand, switchCommand, importCommand };
			
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(commands[0]);
			//执行了第一条命令以后已经登录到mysql了，所以之后就是利用mysql的命令窗口  
			//进程执行后面的代码  
			OutputStream os = process.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(os);
			//命令1和命令2要放在一起执行  
			writer.write(commands[1] + "\r\n" + commands[2]);
			writer.flush();
			writer.close();
			os.close();
		}
	}
	
}