package org.example.main;


import org.example.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        String request;
        String response;

        /*request = "DELETE_FROM_DB\nid=17";
        response = controller.doAction(request);
        System.out.println(response);*/


       /* request = "ADD_PRODUCT_TO_BUCKET\nname=Молоко\ncountInBase=2";
        response = controller.doAction(request);
        System.out.println(response);


        request = "ADD_PRODUCT_TO_BUCKET\nname=Сыр\ncountInBase=4";
        response = controller.doAction(request);
        System.out.println(response);

        request = "TOTAL_AMOUNT_OF_BUCKET\n";
        response = controller.doAction(request);
        System.out.println(response);*/

        /*request= "FIND\nМолоко";
        response = controller.doAction(request);
        System.out.println(response);*/
    }
}


