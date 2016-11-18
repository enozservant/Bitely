package com.finalproject.game_logic;

import java.util.*;



//takes care of logic for discover weekly

public class DiscoverWeeklyLogic  {

    public List<Restaurant> generateDiscovery(User user){
        List<RankRestaurant> tempList = new ArrayList<RankRestaurant>();
        Set<Restaurant>  around =  user.getSurroundingRestaurants();

        UserProfileLogic upl = user.getProfile();

        for (Restaurant restaurant : around ){
            tempList.add(new RankRestaurant(restaurant, upl.getMatchingScore(restaurant)));
        }

        Comparator<RankRestaurant> comp = new Comparator<RankRestaurant>() {
            @Override
            public int compare(RankRestaurant lhs, RankRestaurant rhs) {
                if (lhs.getRanking() > rhs.getRanking()) return 1;
                else if (lhs.getRanking() < rhs.getRanking()) return -1;
                else return 0;
            }
        };

        PriorityQueue<RankRestaurant> pq = new PriorityQueue<>(10, comp);

        for (RankRestaurant r : tempList){
            pq.add(r);
        }

        List<Restaurant> retval = new ArrayList<Restaurant>(10);

        for (int i = retval.size() -1; i >= 0; i--){
            retval.set(i, pq.poll().getRestaurant());
        }

        return retval;
    }



    private void sort(List<RankRestaurant> toSort){
        int counter = toSort.size();
        while (counter > 0 ){
            for (int i = 1 ; i < counter; i++){
                if (toSort.get(i-1).comp(toSort.get(i))) {
                    RankRestaurant temp = toSort.get(i);
                    toSort.set(i, toSort.get(i - 1));
                    toSort.set(i - 1, temp);
                }
            }
            counter--;
        }
    }



    private class RankRestaurant extends Restaurant{
        Restaurant restaurant;
        int rankingNumber;

        RankRestaurant(Restaurant r, int rankNum){
            restaurant = r;
            rankingNumber = rankNum;
        }

        Restaurant getRestaurant(){
            return restaurant;
        }

        int getRanking(){
            return rankingNumber;
        }

        boolean comp(RankRestaurant rhs){
            //true if this restaurant has higher ranking than rhs
            return rankingNumber > rhs.getRanking();
        }
    }
}
