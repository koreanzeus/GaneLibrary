package org.wecancodeit.gamelibrary.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping({ "", "/", "/publisher" })
    public String getAllPublishers(Model model) {
        //model.addAttribute("publishers", repository.findAll());
        return "displayPublishersView";
    }
}
