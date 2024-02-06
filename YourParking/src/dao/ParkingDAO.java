package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Parking;

public class ParkingDAO extends DAO {

	public List<Parking> search(String municipalities) throws Exception {
	    List<Parking> parking = new ArrayList<>();

	    try (Connection con = getConnection();
	         PreparedStatement st = con.prepareStatement("SELECT * FROM PARKING WHERE MUNICIPALITIES = ?")) {
	        st.setString(1, municipalities); // プレースホルダに値を設定

	        try (ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	                Parking park = new Parking();
	                park.setParking_id(rs.getInt("parking_id"));
	                park.setParking_name(rs.getString("parking_name"));
	                park.setPrefectures(rs.getString("prefectures"));
	                park.setMunicipalities(rs.getString("municipalities"));
	                park.setStreet(rs.getString("street"));
	                parking.add(park);
	            }
	        }
	    }
	    return parking;
	}

	public Parking searchSingle(int parking_id) throws Exception {
	    Parking parking = new Parking();

	    try (Connection con = getConnection();
	        PreparedStatement st = con.prepareStatement("SELECT * FROM PARKING WHERE PARKING_ID = ?")) {
	        st.setInt(1, parking_id); // プレースホルダに値を設定

	        try (ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	                parking.setParking_id(rs.getInt("parking_id"));
	                parking.setPark_genre(rs.getString("park_genre"));
	                parking.setParking_name(rs.getString("parking_name"));
	                parking.setPrefectures(rs.getString("prefectures"));
	                parking.setMunicipalities(rs.getString("municipalities"));
	                parking.setStreet(rs.getString("street"));
	                parking.setPark_money(rs.getString("park_money"));
	                parking.setMax_money(rs.getString("max_money"));
	                parking.setPark_time(rs.getString("park_time"));
	                parking.setPark_space(rs.getString("park_space"));
	                parking.setRepark_card(rs.getString("repark_card"));
	                parking.setSs_card(rs.getString("ss_card"));
	                parking.setNbm_card(rs.getString("nbm_card"));
	                parking.setPark_weight(rs.getDouble("park_weight"));
	                parking.setPark_high(rs.getDouble("park_high"));
	                parking.setPark_width(rs.getDouble("park_width"));
	                parking.setPark_length(rs.getDouble("park_length"));
	                parking.setActual_height(rs.getDouble("actual_height"));
	                parking.setActual_length(rs.getDouble("actual_length"));
	                parking.setActual_width(rs.getDouble("actual_width"));
	                parking.setActual_weight(rs.getDouble("actual_weight"));
	                parking.setXcoord(rs.getDouble("xcoord"));
	                parking.setYcoord(rs.getDouble("ycoord"));
	            }
	        }
	    }
	    return parking;
	}



    public int insert(Parking parking) throws Exception {
        try (Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("INSERT INTO PARKING (cd_id, parking_name, prefectures, municipalities, street, park_high, park_width, park_length, park_weight, park_space, park_time, park_money, max_money, park_payment, park_genre, repark_card, ss_card, nbm_card, xcoord, ycoord) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

	        st.setInt(1, parking.getCd_id());
	        st.setString(2, parking.getParking_name());
	        st.setString(3, parking.getPrefectures());
	        st.setString(4, parking.getMunicipalities());
	        st.setString(5, parking.getStreet());
	        st.setDouble(6, parking.getPark_high());
	        st.setDouble(7, parking.getPark_width());
	        st.setDouble(8, parking.getPark_length());
	        st.setDouble(9, parking.getPark_weight());
	        st.setString(10, parking.getPark_space());
	        st.setString(11, parking.getPark_time());
	        st.setString(12, parking.getPark_money());
	        st.setString(13, parking.getMax_money());
	        st.setString(15, parking.getPark_genre());
	        st.setString(16, parking.getRepark_card());
	        st.setString(17, parking.getSs_card());
	        st.setString(18, parking.getNbm_card());
	        st.setDouble(19, parking.getXcoord());
	        st.setDouble(20, parking.getYcoord());

	        int line = st.executeUpdate();

	        st.close();
	        con.close();

	        return line;
        }
    }

    public List<Parking> certainty(String municipalities, int user_id)throws Exception {
		List<Parking> parking = new ArrayList<>();

		try (Connection con1 = getConnection();
		PreparedStatement st1 = con1.prepareStatement("SELECT * FROM CAR WHERE USER_ID = ? AND FLAG_USE = 1")) {
			st1.setInt(1, user_id);

			try (ResultSet rs1 = st1.executeQuery()) {
				if (rs1.next()) {
					double car_high = rs1.getDouble("car_high");
					double car_width = rs1.getDouble("car_width");
					double car_length = rs1.getDouble("car_length");
					double car_weight = rs1.getDouble("car_weight");

					try (Connection con2 = getConnection();
					PreparedStatement st2 = con2.prepareStatement("SELECT * FROM PARKING WHERE MUNICIPALITIES = ?")) {
						st2.setString(1, municipalities);

						try(ResultSet rs2 = st2.executeQuery()) {
							while (rs2.next()) {
								int parking_id = rs2.getInt("PARKING_ID");
								Double actual_height = rs2.getDouble("ACTUAL_HEIGHT");
								Double actual_width = rs2.getDouble("ACTUAL_WIDTH");
								Double actual_length = rs2.getDouble("ACTUAL_LENGTH");
								Double actual_weight = rs2.getDouble("ACTUAL_WEIGHT");

								if (actual_height == 0.0 || actual_width == 0.0 || actual_length == 0.0 || actual_weight == 0.0) {
									try (Connection con3 = getConnection();
									PreparedStatement st3 = con3.prepareStatement("SELECT * FROM PARKING WHERE PARKING_ID = ?"
									+ "AND PARK_HIGH >= ? AND PARK_WIDTH >= ? AND PARK_LENGTH >= ? AND PARK_WEIGHT >= ?")) {
										st3.setInt(1, parking_id);
										st3.setDouble(2, car_high);
										st3.setDouble(3, car_width);
										st3.setDouble(4, car_length);
										st3.setDouble(5, car_weight);

										try (ResultSet rs3 = st3.executeQuery()) {
											if (rs3.next()) {
												Parking park = new Parking();
												park.setParking_id(rs3.getInt("parking_id"));
												park.setParking_name(rs3.getString("parking_name"));
												park.setPrefectures(rs3.getString("prefectures"));
												park.setMunicipalities(rs3.getString("municipalities"));
												park.setStreet(rs3.getString("street"));
												parking.add(park);
												System.out.println(park.getParking_name());
											}
										}
									}
								} else {
									try (Connection con3 = getConnection();
									PreparedStatement st3 = con3.prepareStatement("SELECT * FROM PARKING WHERE PARKING_ID = ?"
									+ "AND ACTUAL_HEIGHT >= ? AND ACTUAL_WIDTH >= ? AND ACTUAL_LENGTH >= ? AND ACTUAL_WEIGHT >= ?")) {
										st3.setInt(1, parking_id);
										st3.setDouble(2, car_high);
										st3.setDouble(3, car_width);
										st3.setDouble(4, car_length);
										st3.setDouble(5, car_weight);

										try (ResultSet rs3 = st3.executeQuery()) {
											if (rs3.next()) {
												Parking park = new Parking();
												park.setParking_id(rs3.getInt("parking_id"));
												park.setParking_name(rs3.getString("parking_name"));
												park.setPrefectures(rs3.getString("prefectures"));
												park.setMunicipalities(rs3.getString("municipalities"));
												park.setStreet(rs3.getString("street"));
												parking.add(park);
											}
										}
									}
								}
							}
						}
					}
				}
			}
			return parking;
		}
	}

    public int update(Parking parking) throws Exception {
    	Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("UPDATE PARKING SET PARKING_NAME = ?, PREFECTURES = ?, MUNICIPALITIES = ?, STREET = ?, PARK_HIGH = ?, PARK_WIDTH = ?, PARK_LENGTH = ?, PARK_WEIGHT = ?, PARK_SPACE = ?, PARK_TIME = ?, PARK_MONEY = ?, MAX_MONEY = ?, REPARK_CARD = ?, SS_CARD = ?, NBM_CARD = ?, PARK_GENRE = ?, XCOORD = ?, YCOORD = ? WHERE PARKING_ID = ?");
        st.setString(1, parking.getParking_name());
        st.setString(2, parking.getPrefectures());
        st.setString(3, parking.getMunicipalities());
        st.setString(4, parking.getStreet());
        st.setDouble(5, parking.getPark_high());
        st.setDouble(6, parking.getPark_width());
        st.setDouble(7, parking.getPark_length());
        st.setDouble(8, parking.getPark_weight());
        st.setString(9, parking.getPark_space());
        st.setString(10, parking.getPark_time());
        st.setString(11, parking.getPark_money());
        st.setString(12, parking.getMax_money());
        st.setString(13, parking.getRepark_card());
        st.setString(14, parking.getSs_card());
        st.setString(15, parking.getNbm_card());
        st.setString(16, parking.getPark_genre());
        st.setDouble(17, parking.getXcoord());
        st.setDouble(18, parking.getYcoord());
        st.setInt(19, parking.getParking_id());

        int line = st.executeUpdate();

        st.close();
        con.close();

        return line;
    }

    public int delete(int parking_id) throws Exception {
    	Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("DELETE FROM parking WHERE parking_id = ?");

        st.setInt(1, parking_id);

        int line = st.executeUpdate();

        st.close();
        con.close();

		return line;
    }

    public int number(String search, int user_id)throws Exception {
    	int result = 0;

		try (Connection con1 = getConnection();
		PreparedStatement st1 = con1.prepareStatement("SELECT * FROM CAR WHERE USER_ID = ? AND FLAG = 1")) {
			st1.setInt(1, user_id);

			try (ResultSet rs1 = st1.executeQuery()) {
				while (rs1.next()) {
					double car_high = rs1.getDouble("car_high");
					double car_width = rs1.getDouble("car_width");
					double car_length = rs1.getDouble("car_length");
					double car_weight = rs1.getDouble("car_weight");

					try (Connection con2 = getConnection();
					PreparedStatement st2 = con2.prepareStatement("SELECT * FROM PARKING WHERE MUNICIPALITIES = ?")) {
						st2.setString(1, search);

						try (ResultSet rs2 = st2.executeQuery()) {
							while (rs2.next()) {
								int cd_id = rs2.getInt("CD_ID");
								try (Connection con3 = getConnection();
								PreparedStatement st3 = con3.prepareStatement("select count(＊) as record_count from PARKING where CD_ID = ?"
								+ "AND ACTUAL_HEIGHT >= ? AND ACTUAL_WIDTH >= ? AND ACTUAL_LENGTH >= ? AND ACTUAL_WEIGHT >= ?")) {
									st3.setInt(1, cd_id);
									st3.setDouble(2, car_high);
									st3.setDouble(3, car_width);
									st3.setDouble(4, car_length);
									st3.setDouble(5, car_weight);

									try (ResultSet rs3 = st3.executeQuery()) {
										if (rs3.next()) {
											result = rs3.getInt("record_count");
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
    }

    public int number(String municipalities) throws Exception {
	    int result = 0;

	    try (Connection con = getConnection();
	        PreparedStatement st = con.prepareStatement("SELECT  count(＊) as record_count FROM PARKING WHERE MUNICIPALITIES = ?")) {
	        st.setString(1, municipalities); // プレースホルダに値を設定

	        try (ResultSet rs = st.executeQuery()) {
	            if (rs.next()) {
	            	result = rs.getInt("record_count");
	            }
	        }
	    }
	    return result;
	}

    public int search_result(String municipalities) throws Exception {
	    int result = 0;

	    try (Connection con = getConnection();
	        PreparedStatement st = con.prepareStatement("SELECT COUNT(*) FROM parking WHERE municipalities = ? LIMIT 1")) {
	        st.setString(1, municipalities); // プレースホルダに値を設定

	        try (ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	            	result = rs.getInt(1);
	            }
	        }
	    }
	    return result;
	}

    public int search_result(String municipalities, int user_id) throws Exception {

    int result = 0;
    try (Connection con1 = getConnection();
    	PreparedStatement st1 = con1.prepareStatement("SELECT * FROM CAR WHERE USER_ID = ? AND FLAG_USE = 1")) {
   	    st1.setInt(1, user_id); // プレースホルダに値を設定

   	    try (ResultSet rs1 = st1.executeQuery()) {
   	        while (rs1.next()) {
   	            double car_high = rs1.getDouble("car_high");
				double car_width = rs1.getDouble("car_width");
				double car_length = rs1.getDouble("car_length");
				double car_weight = rs1.getDouble("car_weight");

				try (Connection con2 = getConnection();
					PreparedStatement st2 = con2.prepareStatement("SELECT * FROM PARKING WHERE MUNICIPALITIES = ?")) {
						st2.setString(1, municipalities);

						try(ResultSet rs2 = st2.executeQuery()) {
							while (rs2.next()) {
								int parking_id = rs2.getInt("PARKING_ID");
								Double actual_height = rs2.getDouble("ACTUAL_HEIGHT");
								Double actual_width = rs2.getDouble("ACTUAL_WIDTH");
								Double actual_length = rs2.getDouble("ACTUAL_LENGTH");
								Double actual_weight = rs2.getDouble("ACTUAL_WEIGHT");

								if (actual_height == 0.0 || actual_width == 0.0 || actual_length == 0.0 || actual_weight == 0.0) {
									try (Connection con3 = getConnection();
									PreparedStatement st3 = con3.prepareStatement("SELECT COUNT(*) FROM PARKING WHERE PARKING_ID = ? "
									+ "AND PARK_HIGH >= ? AND PARK_WIDTH >= ? AND PARK_LENGTH >= ? AND PARK_WEIGHT >= ? LIMIT 1")) {
										st3.setInt(1, parking_id);
										st3.setDouble(2, car_high);
										st3.setDouble(3, car_width);
										st3.setDouble(4, car_length);
										st3.setDouble(5, car_weight);

										try (ResultSet rs3 = st3.executeQuery()) {
											if (rs3.next()) {
												result = rs3.getInt(1);
											}
										}
									}
								} else {
									try (Connection con3 = getConnection();
									PreparedStatement st3 = con3.prepareStatement("SELECT COUNT(*) FROM PARKING WHERE PARKING_ID = ? "
									+ "AND ACTUAL_HEIGHT >= ? AND ACTUAL_WIDTH >= ? AND ACTUAL_LENGTH >= ? AND ACTUAL_WEIGHT >= ? LIMIT 1")) {
										st3.setInt(1, parking_id);
										st3.setDouble(2, car_high);
										st3.setDouble(3, car_width);
										st3.setDouble(4, car_length);
										st3.setDouble(5, car_weight);

										try (ResultSet rs3 = st3.executeQuery()) {
											if (rs3.next()) {
												result = rs3.getInt(1);
											}
										}
									}
								}
							}
						}
					}
				}
   	        }
   	    }
    	return result;
   	}

    public int fix_high(Double actual_high, int parking_id) throws Exception {
    	int result = 0;

    	Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("UPDATE PARKING SET ACTUAL_HEIGHT = ? WHERE PARKING_ID = ?");
        st.setDouble(1, actual_high);
        st.setInt(2, parking_id);
        result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }

    public int fix_length(Double actual_length, int parking_id) throws Exception {
    	int result = 0;

    	Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("UPDATE PARKING SET ACTUAL_LENGTH = ? WHERE PARKING_ID = ?");
        st.setDouble(1, actual_length);
        st.setInt(2, parking_id);
        result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }

    public int fix_width(Double actual_width, int parking_id) throws Exception {
    	int result = 0;

    	Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("UPDATE PARKING SET ACTUAL_WIDTH = ? WHERE PARKING_ID = ?");
        st.setDouble(1, actual_width);
        st.setInt(2, parking_id);
        result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }

    public int fix_weight(Double actual_weight, int parking_id) throws Exception {
    	int result = 0;

    	Connection con = getConnection();

        PreparedStatement st = con.prepareStatement("UPDATE PARKING SET ACTUAL_WEIGHT = ? WHERE PARKING_ID = ?");
        st.setDouble(1, actual_weight);
        st.setInt(2, parking_id);
        result = st.executeUpdate();

        st.close();
        con.close();

        return result;
    }
}
