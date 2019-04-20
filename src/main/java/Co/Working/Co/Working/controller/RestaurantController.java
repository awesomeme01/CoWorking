package Co.Working.Co.Working.controller;

import Co.Working.Co.Working.model.Feedback;
import Co.Working.Co.Working.model.Menu;
import Co.Working.Co.Working.model.Restaurant;
import Co.Working.Co.Working.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
public class RestaurantController  {
    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping("api/restaurants")
    @GetMapping
    public List<Restaurant> getAllRestaurants(){
return this.restaurantService.getAllRestaurants();
    } @RequestMapping("api/feedbacks")
    @GetMapping
    public List<Feedback> getAllFeedbacks(){
return this.restaurantService.getAllFeedbacks();
    }
    @RequestMapping("api/addRestaurant")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRestaurant(@RequestBody Restaurant r , HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        restaurantService.saveRestaurant(r);
        out.println("Ресторан успешно добавлен!");
    }
    @RequestMapping("api/addFeedback")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveFeedback(@RequestBody Feedback f , HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        restaurantService.saveFeedback(f);
        out.println("Ваш отзыв успешно добавлен!");
    }
    @RequestMapping("api/addMenu")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMenu(@RequestBody Menu menu , HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        restaurantService.saveMenu(menu);
        out.println("Меню успешно добавлено!");
    }


}
