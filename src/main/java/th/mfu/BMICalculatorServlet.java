package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
        //TODO: get parameter from request: "weight" and "height"
        String weight_ = request.getParameter("weight");
        String height_ = request.getParameter("height");
        //TODO: calculate bmi
        double weight = Double.parseDouble(weight_);
        double height = Double.parseDouble(height_);
        double bmi = weight/(height * height);
        int roundbmi = (int) Math.round(bmi);
        //TODO: determine the built from BMI
        String bodyBuilt;
        if(roundbmi < 18.5){
            bodyBuilt = "underweight";
        }else if(roundbmi < 25 ){
            bodyBuilt = "normal";
        }else if(roundbmi < 30){
            bodyBuilt = "overweight";
        }else if(roundbmi < 35){
            bodyBuilt = "obese";
        }
        else{
            bodyBuilt = "extremely obese";
        }
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi",roundbmi);
        request.setAttribute("bodyBuilt",bodyBuilt);
        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request,response);
    }
    
}
