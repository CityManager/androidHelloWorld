package ind.example.xuweiman.helloworld.utils;

import java.util.ArrayList;
import java.util.List;

import ind.example.xuweiman.helloworld.R;
import ind.example.xuweiman.helloworld.n03_customViews.customListView.Fruit;

public class FruitUtil {
    public static List<Fruit> initFruitList() {
        String[] data = {
                "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
                "Pineapple", "Strawberry", "Cherry", "Mango",
                "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
                "Pineapple", "Strawberry", "Cherry", "Mango"
        };
        List<Fruit> fruits = new ArrayList<>();
        for (String name : data) {
            Fruit fruit = new Fruit();
            fruit.setFruitImageId(R.drawable.ic_launcher_background);
            fruit.setFruitName(name);
            fruits.add(fruit);
        }
        return fruits;
    }
}
