package casestudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TrainDAO {
		private String DRIVER_NAME = "oracle.jdbc.OracleDriver";
		private String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE"; 
		private String USERNAME = "hr";
		private String PASSWORD = "hr";
		
		Class.forName(DRIVER_NAME);
		
		Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

		Statement st = con.createStatement();
		
		public Train findTrain(int tno) throws SQLException {
			ResultSet rs = st.executeQuery("SELECT * FROM TRAIN WHERE TRAIN_NUMBER = '"+ tno +"'");
			Train t = new Train();
			while(rs.next()){
				t.setTrainNo(rs.getInt(1));
				t.setTrainName(rs.getString(2));
				t.setSource(rs.getString(3));
				t.setDest(rs.getString(4));
				t.setPrice(rs.getDouble(5));
			return t;
			}
	}
}
