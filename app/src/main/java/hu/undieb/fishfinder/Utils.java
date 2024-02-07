package hu.undieb.fishfinder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private static Utils instance;
    private ArrayList<Fish> allFish;
    private Utils(){
        if(null==allFish){
            allFish= new ArrayList<>();
            initData();
        }

    }
    private void initData(){
        ArrayList<String> urls=new ArrayList<>();
        urls.add("https://t0.gstatic.com/licensed-image?q=tbn:ANd9GcRaz7PZmGVxPShJfAaCzCtoWD45eYkhA8ATd1zGUaVzV4FMl0sMl4DBOjGqJdv8QG9H");
        urls.add("https://greenaqua.hu/media/catalog/product/cache/a9f5b46441c9caeb48dbb3f5b899a840/8/8/888321.jpg");
        urls.add("https://www.thesprucepets.com/thmb/7YGQUU_FYAd2XCNmnW_9_jKcDZU=/5762x0/filters:no_upscale():strip_icc()/siamese-fighting-fish-bettas-1378308-hero-f459084da1414308accde7e21001906c.jpg");
        allFish.add(new Fish(1,"Betta","Betta splendens",urls,WaterType.FRESHWATER,"This is fookin betta bitch what do u want?"));
        urls=new ArrayList<>();
        urls.add("https://www.waikikiaquarium.org/wp-content/uploads/2013/11/reef-triggerfish_620.jpg");
        allFish.add(new Fish(2,"Reef triggerfish","Rhinecanthus rectangulus",urls,WaterType.SALTWATER,"This is my personal fav, it's called humuhumunukunukuapua'a in hawaiian language what't else?Nothing "));
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
    public ArrayList<Fish> getAllFish() {
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
