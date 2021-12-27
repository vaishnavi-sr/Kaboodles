package lift.off.project.models;

import java.util.ArrayList;

public class HomeServiceData  {

        public static ArrayList<HomeService> findByColumnAndValue(String column, String value, Iterable<HomeService>allHomeServices) {

            ArrayList<HomeService> results = new ArrayList<>();

            if (value.toLowerCase().equals("all")){
                return (ArrayList<HomeService>) allHomeServices;
            }

            if (column.equals("all")){
                results = findByValue(value, allHomeServices);
                return results;
            }
            for (HomeService homeService : allHomeServices) {

                String aValue = getFieldValue(homeService, column);

                if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                    results.add(homeService);
                }
            }

            return results;
        }

        public static String getFieldValue(HomeService homeService, String fieldName){
            String theValue;
            if (fieldName.equals("name")){
                theValue = homeService.getName();
            } else if (fieldName.equals("customer")){
                theValue = homeService.getCustomer().toString();
            } else {
                theValue = homeService.getProSkills().toString();
            }

            return theValue;
        }


        public static ArrayList<HomeService> findByValue(String value, Iterable<HomeService> allHomeServices) {
            String lower_val = value.toLowerCase();

            ArrayList<HomeService> results = new ArrayList<>();

            for (HomeService homeService: allHomeServices) {

                if (homeService.getName().toLowerCase().contains(lower_val)) {
                    results.add(homeService);
                } else if (homeService.getCustomer().toString().toLowerCase().contains(lower_val)) {
                    results.add(homeService);
                } else if (homeService.getProSkills().toString().toLowerCase().contains(lower_val)) {
                    results.add(homeService);
                } else if (homeService.toString().toLowerCase().contains(lower_val)) {
                    results.add(homeService);
                }

            }

            return results;
        }


    }



