package Co.Working.Co.Working.service;

import Co.Working.Co.Working.model.Feedback;
import Co.Working.Co.Working.model.Menu;
import Co.Working.Co.Working.model.Restaurant;
import Co.Working.Co.Working.repository.FeedbackRep;
import Co.Working.Co.Working.repository.MenuRep;
import Co.Working.Co.Working.repository.RestaurantRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl  implements  RestaurantService{
    private final RestaurantRep restaurantRep;
    private  final FeedbackRep feedbackRep;
    private final MenuRep menuRep;

    public RestaurantServiceImpl(RestaurantRep restaurantRep, FeedbackRep feedbackRep, MenuRep menuRep) {
        this.restaurantRep = restaurantRep;
        this.feedbackRep = feedbackRep;
        this.menuRep = menuRep;
    }


    @Override
    public List<Restaurant> getAllRestaurants(){
        return this.restaurantRep.findAll();
    }
    @Override
    public void deleteRestaurantById(Long id){
        restaurantRep.deleteById(id);
    }
    @Override
    public void deleteAllRestaurants(){
        restaurantRep.deleteAll();
    }
    @Override
    public  Restaurant getRestaurantById(Long id){
        return this.restaurantRep.findById(id).get();
    }
    @Override
    public void saveRestaurant(Restaurant r){
         this.restaurantRep.save(r);
    }

    @Override
    public  List<Feedback> getAllFeedbacks(){
        return this.feedbackRep.findAll();
    }
    @Override
    public void saveMenu(Menu menu){
        this.menuRep.save(menu);
    }
    @Override
    public void saveFeedback(Feedback feedback){
        this.feedbackRep.save(feedback);
    }
}
