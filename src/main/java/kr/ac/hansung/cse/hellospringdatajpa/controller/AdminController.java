package kr.ac.hansung.cse.hellospringdatajpa.controller; // 패키지 경로는 실제 프로젝트에 맞게 조정

import kr.ac.hansung.cse.hellospringdatajpa.entity.MyUser; // MyUser 엔티티 경로
import kr.ac.hansung.cse.hellospringdatajpa.repo.UserRepository; // UserService (사용자 목록 가져오는 서비스) 경로
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository; 

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<MyUser> userList = userRepository.findAll();
                model.addAttribute("userList", userList);
        return "user_list"; 
    }
}