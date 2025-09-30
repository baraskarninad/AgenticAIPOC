// Example for CartPageController.java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

public class CartPageController {
    private static final Logger LOG = LoggerFactory.getLogger(CartPageController.class);

    @Autowired
    private ClientUserSessionFacade clientUserSessionFacade;
    @Autowired
    private ProjectFacade projectFacade;

    public ModelAndView showCartPage(HttpServletRequest request) {
        String projectCode = clientUserSessionFacade.getSelectedProjectCode();
        String projectName = projectFacade.getProjectName(projectCode);

        if (projectCode == null || projectCode.trim().isEmpty() ||
            projectName == null || projectName.trim().isEmpty()) {
            LOG.warn("selectprojectCode:: {} select Project Name ::{}", projectCode, projectName);
            ModelAndView mav = new ModelAndView("cartPage");
            mav.addObject("errorMessage", "No project selected or project data missing. Please select a valid project.");
            return mav;
        }
        // Continue normal processing...
        ModelAndView mav = new ModelAndView("cartPage");
        // Add additional logic
        return mav;
    }
}