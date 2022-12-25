package com.zerobase.festlms.main.controller;

// uri와 물리적인 파일을 맵핑하기 위해 MainPage 클래스를 만듬
// 맵핑이 가능한 것 3가지
// 클래스, 속성, 메소드
// 클래스 : 페이지가 늘어날 떄마다 클래스가 늘어나 비효율적임
//

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.zerobase.festlms.components.MailComponent;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MailComponent mailComponent;

    @GetMapping("/")
    public String index() {
        // mailComponent.sendMail(email, subject, text);
        return "index";
    }

    @GetMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();

        printWriter.write("helloWorld!!");
        printWriter.close();
    }

}
