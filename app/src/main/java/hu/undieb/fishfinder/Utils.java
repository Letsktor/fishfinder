package hu.undieb.fishfinder;
import java.util.ArrayList;
public class Utils {
    private static Utils instance;
    private static ArrayList<Fish> allFish;
    private Utils(){
        if(null==allFish){
            allFish=new ArrayList<>();
            initData();
        }
    }
    private void initData(){
        ArrayList<Fish> fishes=new ArrayList<>();
        ArrayList<String> urls=new ArrayList<>();
        urls.add("https://t0.gstatic.com/licensed-image?q=tbn:ANd9GcRaz7PZmGVxPShJfAaCzCtoWD45eYkhA8ATd1zGUaVzV4FMl0sMl4DBOjGqJdv8QG9H");
        allFish.add(new Fish(1,"Betta","Betta splendens",urls,WaterType.FRESHWATER,"This is fookin betta bitch what do u want?"));
    }
    public static Utils getInstance() {
        if(null!=instance){
            return instance;
        }
        else{
            instance=new Utils();
            return instance;
        }

    }
    public static ArrayList<Fish> getAllFish() {
        return allFish;
    }
    public Fish getFishById(int id){
        for(Fish b: allFish){
            if(b.getId()==id){
                return b;
            }
        }

        return null;
    }
}
