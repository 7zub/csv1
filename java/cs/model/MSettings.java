package cs.model;

import java.util.ArrayList;

public class MSettings {
    public ArrayList<Route> routes = new ArrayList<Route>();

    public static class Route {
        public String Name;
        public String path_from;
        public String path_to;
    }
}