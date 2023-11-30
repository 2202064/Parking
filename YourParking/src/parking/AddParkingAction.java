package parking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Parking;
import dao.ParkingDAO;
import tool.Action;

public class AddParkingAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Parking parking = new Parking();
            parking.setParking_name(request.getParameter("parking_name"));
            parking.setPrefectures(request.getParameter("prefectures_id"));
            parking.setMunicipalities(request.getParameter("cd_id"));
            parking.setStreet(request.getParameter("street"));
            parking.setPark_high(Double.parseDouble(request.getParameter("park_high")));
            parking.setPark_width(Double.parseDouble(request.getParameter("park_width")));
            parking.setPark_length(Double.parseDouble(request.getParameter("park_length")));
            parking.setPark_weight(Double.parseDouble(request.getParameter("park_weight")));
            parking.setPark_space(request.getParameter("park_space"));
            parking.setPark_time(request.getParameter("park_time"));
            parking.setPark_money(request.getParameter("park_money"));
            parking.setPark_payment(request.getParameter("park_payment"));
            parking.setPark_genre(request.getParameter("park_genre"));

            int result = new ParkingDAO().insert(parking);

            HttpSession session = request.getSession();
            session.setAttribute("parking", parking);

            if (result > 0) {
                request.setAttribute("suc_message", "追加しました");
                return "add_parking.jsp";
            } else {
                request.setAttribute("fai_message", "失敗しました");
                return "add_parking.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "../error/error.jsp";
        }
    }
}
