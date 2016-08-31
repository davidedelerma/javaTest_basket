import java.util.*;

public class Basket{
  private Food food;
  private ArrayList<Food> items;

  public Basket(){
    this.items = new ArrayList<Food>();
  }

  public ArrayList<Food> getItems(){
    return items;
  }

  public void addItem(Food food){
    items.add(food);
  }

  public void emptyBasket(){
    items.clear();
  }

  public void removeItem(Food food){
    items.remove(food);
    // if (items.indexOf(food) != -1){
    //   removeItem(food);
    // }
  }

}