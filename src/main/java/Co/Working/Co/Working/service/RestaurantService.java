package Co.Working.Co.Working.service;

import Co.Working.Co.Working.model.Feedback;
import Co.Working.Co.Working.model.Menu;
import Co.Working.Co.Working.model.Restaurant;

import java.util.List;

public interface RestaurantService {
List<Restaurant> getAllRestaurants();
Restaurant getRestaurantById(Long id);
void saveRestaurant(Restaurant r);
void deleteRestaurantById(Long id);
void  deleteAllRestaurants();


List<Feedback> getAllFeedbacks();
void saveFeedback(Feedback f);
void saveMenu(Menu m);

}
