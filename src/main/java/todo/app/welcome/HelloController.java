package todo.app.welcome;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory
            .getLogger(HelloController.class);
    
    @ModelAttribute
    public FileUploadWithValidationForm setFileUploadWithValidationForm() {
        return new FileUploadWithValidationForm();
    }

    @ModelAttribute
    public FileUploadWithoutValidationForm setFileUploadWithoutValidationForm() {
        return new FileUploadWithoutValidationForm();
    }
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        model.addAttribute("serverTime", getDate(locale));

        return "welcome/home";
    }
    
    @RequestMapping(value = "/article/upload/with/validation", method = RequestMethod.POST)
    public String uploadWithValidation(@Validated FileUploadWithValidationForm form,
            BindingResult result, RedirectAttributes redirectAttributes, Locale locale) {
        logger.info("Welcome upload with validation! The client locale is {}.", locale);
        
        if (result.hasErrors()) {
            return "welcome/home";
        }

        redirectAttributes.addFlashAttribute("serverTime", getDate(locale));

        return "redirect:/";
    }

    @RequestMapping(value = "/article/upload/without/validation", method = RequestMethod.POST)
    public String uploadWithoutValidation(@Validated FileUploadWithoutValidationForm form,
            BindingResult result, RedirectAttributes redirectAttributes, Locale locale) {
        logger.info("Welcome upload without validation! The client locale is {}.", locale);
        
        if (result.hasErrors()) {
            return "welcome/home";
        }

        redirectAttributes.addFlashAttribute("serverTime", getDate(locale));

        return "redirect:/";
    }
    
    private String getDate(Locale locale) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);

        return dateFormat.format(date);
    }
    
}
