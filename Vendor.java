import java.util.*;

public class Vendor{
  
  private ArrayList<Food> items;
  private float totPrice;

  public Vendor(Basket basket){
    this.items = basket.getItems();
    this.totPrice = 0;
  }

  public float getBasketPrice(){
    return totPrice;
  }

  public void basketPrice(){
    totPrice = 0;
    for (Food food : items){
      totPrice += food.getPrice();
    }
  }

  public void twoForOne(Food discountedItem){
    int count = 0;

    for ( int i = 0 ; i < items.size(); i++){

      if (discountedItem == items.get(i)){
        count += 1;

        if (count % 2 == 0){
          items.remove(i);
        }
      } 

    }
  }

  public void discountOnTotalPrice(float percentage){
    basketPrice();
    if (totPrice > 20){
      totPrice -= totPrice * percentage;
    }
  }

  public void twoPercentDiscountForMembers(User user){
    basketPrice();
    if (user.getMembership()){
      totPrice -= totPrice * (float) 0.02;
    }
  }

}