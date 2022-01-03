package lift.off.project.models;

import java.util.ArrayList;

public class ProData {



    public static ArrayList<Pro> findByColumnAndValue(String column, String value, Iterable<Pro> allPros) {

        ArrayList<Pro> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Pro>) allPros;
        }

        if (column.equals("all")){
            results = findByValue(value, allPros);
            return results;
        }
        for (Pro pro: allPros) {

            String aValue = getFieldValue(pro, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(pro);
            }
        }

        return results;
    }

    public static String getFieldValue(Pro pro, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = pro.getName();
        } else if (fieldName.equals("customer")){
            theValue = pro.getCustomer().toString();
        } else {
            theValue = pro.getProSkills().toString();
        }

        return theValue;
    }


    public static ArrayList<Pro> findByValue(String value, Iterable<Pro> allPros) {
        String lower_val = value.toLowerCase();

        ArrayList<Pro> results = new ArrayList<>();

        for (Pro pro : allPros) {

            if (pro.getName().toLowerCase().contains(lower_val)) {
                results.add(pro);
            } else if (pro.getCustomer().toString().toLowerCase().contains(lower_val)) {
                results.add(pro);
            } else if (pro.getProSkills().toString().toLowerCase().contains(lower_val)) {
                results.add(pro);
            } else if (pro.toString().toLowerCase().contains(lower_val)) {
                results.add(pro);
            }

        }

        return results;
    }


}

