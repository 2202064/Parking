package admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cd;
import dao.CdDAO;
import tool.Action;

public class AddCdAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String csvFilePath = "../csv/CD.csv";


        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] columns = line.split(",");


                Cd cd = new Cd();
                cd.setCd_name(columns[1]);


                try {
                	int result = new CdDAO().insert(cd);

                	if (result > 0){

                	}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "index.jsp";
    }
}
