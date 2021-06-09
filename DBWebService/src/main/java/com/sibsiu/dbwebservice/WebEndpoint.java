package com.sibsiu.dbwebservice;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import webservice.DataExchangeRequest;
import webservice.DataExchangeResponse;
import webservice.GetUsersResponse;
import webservice.Row;
import webservice.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.slf4j.Logger;



@Endpoint
public class WebEndpoint {
	private static final String NAMESPACE_URI = "http://webservice";
	private static final Logger LOG = LoggerFactory.getLogger("logger");
	
	private static final String DB_IP = "213.110.61.252";
	private static final String DB_NAME = "stb";
	private static final String DB_PORT = "5432";
	private static final String DB_URL = "jdbc:postgresql://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;

    @Autowired
    public WebEndpoint() {
    }
    
    //Главный метод обмена
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "dataExchangeRequest")
    @ResponsePayload
    public DataExchangeResponse dataExchange (@RequestPayload DataExchangeRequest request) {
    	LOG.info("Запрос на обмен данными");
    	
    	String username = request.getUsername();
    	String password = request.getPassword();
    	
    	Properties props = new Properties();
    	props.setProperty("user", username);
    	props.setProperty("password", password);
    	
    	try (Connection db = DriverManager.getConnection(DB_URL, props)) {
    		LOG.info("Запрос: dataExchangeRequest. Успешное подключение к БД. " + db.isValid(0));
    		
    		Statement statement = db.createStatement();
    		return getResponse(statement, username);	
    		
		} catch (SQLException e) {
			LOG.info("Запрос: dataExchangeRequest. Ошибка подключения к БД");
			e.printStackTrace();
		}
    	return null;
    }
    
  //Метод обработки запроса на получение списка пользователей
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsersRequest")
    @ResponsePayload
    public GetUsersResponse getUsers () {
    	LOG.info("Запрос: getUsersRequest");
    	
    	String username = "anonimsen";
    	String password = "stb3sen";
    	
    	Properties props = new Properties();
    	props.setProperty("user", username);
    	props.setProperty("password", password);
    	
    	try (Connection db = DriverManager.getConnection(DB_URL, props)) {
    		LOG.info("Запрос: getUsersRequest. Успешное подключение к БД. " + db.isValid(0));
    		
    		Statement statement = db.createStatement();
    		String SQL = "select id, usersen\r\n"
    				+ "from sen.u\r\n";
    		Table usersen = getTable(statement.executeQuery(SQL));		
    		GetUsersResponse response = new GetUsersResponse();
    		response.setUsersen(usersen);
    		return response;
    		
		} catch (SQLException e) {
			LOG.info("Запрос: getUsersRequest. Ошибка");
			e.printStackTrace();
		}
    	return null;
    }
    
  //Вспомогательный метод. Возвращает готовый ответ со всеми необходимыми таблицами
    public DataExchangeResponse getResponse(Statement statement, String username) throws SQLException {
    	
    	ResultSet set = statement.executeQuery("select id from sen.u where usersen = " + "'" + username + "'");
    	set.next();
    	String userId = set.getString(1);
    	
    	String SQL = "SELECT id, parent, nameorg FROM sen.org";
		Table org = getTable(statement.executeQuery(SQL));	
		
		SQL = "select sn.id, 1 as avtor, sn.namest\r\n"
				+ "from sen.usersen as u inner join sen.post as p on u.idp = p.id inner join sen.statuspost as sp on p.id=sp.idp inner join sen.statusname as sn on sn.id= sp.ids\r\n"
				+ "where u.id = " + userId + "\r\n"
				+ "union all\r\n"
				+ "select s0.id, null as avtor, s0.namest\r\n"
				+ "from sen.statusname as s0 left join \r\n"
				+ "(select sn.id, null as avtor, sn.namest\r\n"
				+ "from sen.usersen as u inner join sen.post as p on u.idp = p.id inner join sen.statuspost as sp on p.id=sp.idp inner join sen.statusname as sn on sn.id= sp.ids\r\n"
				+ "where u.id = " + userId + ") as s1 on s0.id = s1.id where s1.id is null";
		Table statusN = getTable(statement.executeQuery(SQL));
		
		SQL = "select 	u.id, \r\n"
				+ "	'sen'||u.id::text as idsen,\r\n"
				+ "        CASE WHEN u.id=" + userId + " THEN 1 ELSE 0 END as avtor,\r\n"
				+ "        ((((upper(u.fio1::text) || ' '::text) || upper(substring(u.fio2::text, 1, 1))) || '. '::text) || upper(substring(u.fio3::text, 1, 1))) || '.'::text AS fio,\r\n"
				+ "        u.phone,\r\n"
				+ "        u.passsen,\r\n"
				+ "        ps.namep as posts,\r\n"
				+ "        p.idorg as idORG,\r\n"
				+ "        p.severenessorg\r\n"
				+ "from sen.usersen as u inner join sen.post as p on u.id = p.id  inner join sen.posts as ps on p.idposts=ps.id";
		Table userS = getTable(statement.executeQuery(SQL));
		
		SQL = "select id, namem from sen.machine";
		Table machine = getTable(statement.executeQuery(SQL));
		
		SQL = "select id, idorg, idm, namemachine, sen.orgMachine.сost from sen.orgMachine";
		Table orgMachine = getTable(statement.executeQuery(SQL));
		
		SQL = "select 	id, idorg, nameloc, marsrut from sen.locats";
		Table locats = getTable(statement.executeQuery(SQL));
		
		SQL = "select id, name1, name2, name3, ball, stop from sen.texts";
		Table texts = getTable(statement.executeQuery(SQL));
		
		SQL = "select id, parent, idtext from sen.textScan";
		Table textScan = getTable(statement.executeQuery(SQL));
		
		SQL = "select id, idorg, idm, tm, idl, tl, idt, ts, 0 as mobiles from sen.STB";
		Table stb = getTable(statement.executeQuery(SQL));
		
		SQL = "select id, idstb, zapret, xi, begins, ends, idstatusname, commentstatus, us, null as foto, 0 as mobiles from sen.STATUS";
		Table status = getTable(statement.executeQuery(SQL));
		
		DataExchangeResponse response = new DataExchangeResponse();
		response.setLocats(locats);
		response.setMachine(machine);
		response.setOrg(org);
		response.setOrgMachine(orgMachine);
		response.setStatus(status);
		response.setStatusN(statusN);
		response.setStb(stb);
		response.setTexts(texts);
		response.setTextScan(textScan);
		response.setUserS(userS);
		
		LOG.info("Данные отправлены");
		return response;
	}
    
    //Вспомогательный метод. Возвращает таблицу из ResultSet
    public Table getTable(ResultSet rs) throws SQLException {
		Table table = new Table();
		while (rs.next()) {
			Row row = new Row();
			int columnCount = rs.getMetaData().getColumnCount();
			for(int i = 1; i <= columnCount; i++) {
				row.getDataList().add(rs.getString(i));
			}
			table.getRows().add(row);
		}
		rs.close();
		return table;
	}
}
