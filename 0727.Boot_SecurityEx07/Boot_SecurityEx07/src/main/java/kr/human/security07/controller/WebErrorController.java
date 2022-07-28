package kr.human.security07.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebErrorController implements ErrorController {
    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status != null){
            int statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
            	model.addAttribute("msg","존재하지 않는 페이지 입니다.");
                return "errors/404";
            } else {
            	model.addAttribute("msg","죄송합니다. 잠시 후 다시 시도해주세요!!!");
                return "errors/error";
            }
        }
        model.addAttribute("msg","죄송합니다. 잠시 후 다시 시도해주세요!!!");
        return "errors/error";
    }
}