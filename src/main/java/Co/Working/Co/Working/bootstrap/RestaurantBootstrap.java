package Co.Working.Co.Working.bootstrap;

import Co.Working.Co.Working.model.Feedback;
import Co.Working.Co.Working.model.Menu;
import Co.Working.Co.Working.model.Restaurant;
import Co.Working.Co.Working.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RestaurantBootstrap implements CommandLineRunner {
    @Autowired
    RestaurantService restaurantService;

    @Override
    public void run(String ... args)throws  Exception{
        Menu menu= new Menu();
        menu.setDishes("asdasdas");
        menu.setPrice(122);
        restaurantService.saveMenu(menu);


        Feedback feedback=new Feedback();
        feedback.setMessage("Your restaurant is very good!");
        restaurantService.saveFeedback(feedback);

            Restaurant restaurant = new Restaurant();
            restaurant.setAddress("Донецкая");
            restaurant.setName("ШАШЛЫЧНАЯ");
            restaurant.setFeedback(feedback);
            restaurant.setMenu(menu);
            restaurantService.saveRestaurant(restaurant);




    }
}
