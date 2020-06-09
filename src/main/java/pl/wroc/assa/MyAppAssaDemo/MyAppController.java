package pl.wroc.assa.MyAppAssaDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyAppController {

    private final MyAppService myAppService;

    public MyAppController(MyAppService myAppService) {
        this.myAppService = myAppService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("myAppForm", new MyAppForm());
        return "index";
    }

    @PostMapping("/name")
    public String name(@ModelAttribute("myAppForm") MyAppForm myAppForm,
                       RedirectAttributes redirectAttributes ) {
        boolean isMale = myAppService.isMale(myAppForm.getName());
        if (isMale) {
            redirectAttributes.addFlashAttribute("gender", "man");
        } else {
            redirectAttributes.addFlashAttribute("gender", "woman");
        }

        return "redirect:/";
    }

}
