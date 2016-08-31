import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

public class BasketTest{
  Food banana, apple, meat;
  Basket basket;
  ArrayList<Food> items;
  User user1;

  @Before
  public void before(){
    banana = new Food("Banana", (float) 3.2);
    apple = new Food("Apple",  (float) 1.2);
    meat = new Food("meat", (float) 30.1 );
    basket = new Basket();
    user1 = new User ("Davide", "de Lerma", false);
  }

  @Test
  public void basketStartsEmpty(){
    items = basket.getItems();
    assertEquals(0,items.size());
  }

  @Test
  public void canAddItemsToBasket(){
    basket.addItem(banana);
    basket.addItem(banana);
    basket.addItem(apple);
    items = basket.getItems();
    assertEquals(3,items.size());
  }

  @Test
  public void canEmptyTheBasket(){
    basket.addItem(banana);
    basket.addItem(banana);
    basket.addItem(apple);
    basket.emptyBasket();
    items = basket.getItems();
    assertEquals(0,items.size());
  }

  @Test
  public void canRemoveItemsFromBasket(){
    basket.addItem(banana);
    basket.addItem(banana);
    basket.addItem(apple);
    basket.removeItem(banana);
    items = basket.getItems();
    assertEquals(2,items.size());
  }

  @Test
  public void canGetTotPriceOfTheBasket(){
    basket.addItem(banana);
    basket.addItem(banana);
    basket.addItem(apple);
    Vendor vendor = new Vendor (basket);
    vendor.basketPrice();

    assertEquals(7.6,vendor.getBasketPrice(),0.01);
  }

  @Test
  public void canHaveTwoForOneDiscount(){
    basket.addItem(banana);
    basket.addItem(banana);
    basket.addItem(apple);
    basket.addItem(meat);
    Vendor vendor = new Vendor (basket);
    vendor.twoForOne(banana);
    vendor.basketPrice();
    assertEquals(34.5,vendor.getBasketPrice(),0.01);
  }

  @Test
  public void canHaveTenPercentOffIfTotPriceMoreThanTwenty(){
    basket.addItem(banana);
    basket.addItem(banana);
    basket.addItem(apple);
    basket.addItem(meat);
    Vendor vendor = new Vendor (basket);
    vendor.twoForOne(banana);
    vendor.discountOnTotalPrice((float) 0.1);
    assertEquals(31.05,vendor.getBasketPrice(),0.01);
  }

  @Test
  public void canGetMembershipFromUser(){
    assertEquals(false, user1.getMembership());
  }

  @Test 
  public void canSetUserMembership(){
    user1.setMembership(true);
    assertEquals(true, user1.getMembership() );
  }

  @Test 
  public void canHaveTwoPercentDiscountIfUserIsMember(){
    basket.addItem(banana);
    basket.addItem(banana);
    basket.addItem(apple);
    basket.addItem(meat);
    user1.setMembership(true);
    Vendor vendor = new Vendor (basket);
    vendor.twoPercentDiscountForMembers(user1);
    //tot price before discount 37.7 
    assertEquals(36.946,vendor.getBasketPrice(),0.01);
  }

  @Test
  public void canHaveTwoForOnePlusTenPercentOffIfBasketMoreThanTwentyPlusTwoPercentIfUserIsMember(){
    basket.addItem(banana);
    basket.addItem(banana);
    basket.addItem(apple);
    basket.addItem(meat);
    user1.setMembership(true);
    Vendor vendor = new Vendor (basket);
    vendor.twoForOne(banana);
    vendor.discountOnTotalPrice((float) 0.1);
    vendor.twoPercentDiscountForMembers(user1);
    assertEquals(33.81,vendor.getBasketPrice(),0.01);
  }

}