package Controller;

import Service.ContactService;
import edu.till.Homestay.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String list(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "list";
    }
    @GetMapping("/contact/add")
    public String add(Model model) {
        model.addAttribute("contact", new Contact());
        return "form"; // Hien Thi form lien he 
    }
    @PostMapping("/contact/save")
    public String save(@Validated Contact contact, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        contactService.save(contact);
        redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
        return "redirect:/contact"; // Them phuong thuc lien he 
    }
    @GetMapping("/contact/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("contact", contactService.findOne(id)); // Sua lien he
        return "form";
    }
    @GetMapping("/contact/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        contactService.delete(id);
        redirect.addFlashAttribute("successMessage", "Deleted contact successfully!");
        return "redirect:/contact"; // Xoa lien he
        
    }
}