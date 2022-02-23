package cracking_the_code_book.trees_and_graphs;

import java.util.*;

public class BuildOrderNodesWithDependencies {

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
//        String[][] dependencies = {{"a", "e"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        String[][] dependencies = {{"a", "e"}, {"c", "a"}, {"b", "a"}, {"f", "c"}, {"f", "b"}, {"d", "g"}};
        Project[] projectsOrder = buildOrder(projects, dependencies);

        for (Project project : projectsOrder) {
            System.out.println(project.getName());
        }
    }

    private static Project[] buildOrder(String[] projects, String[][] dependencies) {
        Graph graph = createProjectGraph(projects, dependencies);
        return calculateBuildOrder(graph);
    }

    private static Graph createProjectGraph(String[] projects, String[][] dependencies) {
        Graph res = new Graph();
        res.createProjects(projects);
        res.fillDependencies(dependencies);
        return res;
    }

    private static Project[] calculateBuildOrder(Graph graph) {
        int amountOfProj = graph.getAllProjects().size();
        Project[] projectsOrder = new Project[amountOfProj];

        int endOfList = addTopProjects(projectsOrder, graph.getAllProjects());

        int processCur = 0;
        while(processCur < amountOfProj){
            Project cur = projectsOrder[processCur];

            // circle dependency
            if(cur == null) throw new IllegalArgumentException("Circular dependency");

            ArrayList<Project> children = cur.getChildren();
            for (Project child : children) {
                child.decDependenciesQty();
            }

            endOfList = addNonDependentProjects(projectsOrder, children, endOfList);
            processCur++;
        }

        return projectsOrder;
    }

    private static int addTopProjects(Project[] projectOrder, ArrayList<Project> allProjects) {
        int nextOrderPosition = 0;
        for (Project project : allProjects) {
            if(project.getParents().size() == 0){
                projectOrder[nextOrderPosition] = project;
                nextOrderPosition++;
            }
        }
        return nextOrderPosition;
    }

    private static int addNonDependentProjects(Project[] projectOrder, ArrayList<Project> allProjects, int nextOrderPosition) {
        for (Project project : allProjects) {
            if(project.getDependenciesQty() == 0){
                projectOrder[nextOrderPosition] = project;
                nextOrderPosition++;
            }
        }
        return nextOrderPosition;
    }

    private static class Project {
        String name;
        ArrayList<Project> children = new ArrayList<>();
        ArrayList<Project> parents = new ArrayList<>();
        int dependenciesQty = 0;

        public Project(String name) {
            this.name = name;
        }

        void incDependenciesQty(){dependenciesQty++;}
        void decDependenciesQty(){dependenciesQty--;}

        public ArrayList<Project> getChildren() {
            return children;
        }

        public ArrayList<Project> getParents() {
            return parents;
        }

        public void addChild(Project child){
            children.add(child);
        }

        public void addParent(Project parent){
            incDependenciesQty();
            parents.add(parent);
        }

        public int getDependenciesQty() {
            return dependenciesQty;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Project project = (Project) o;
            return Objects.equals(name, project.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static class Graph {
        ArrayList<Project> allProjects = new ArrayList<>();
        Map<String, Project> projectsList = new HashMap<>();

        public void createProjects(String[] projectsName) {
            for (String projectName : projectsName) {
                if (!projectsList.containsKey(projectName)){
                    Project newProj = new Project(projectName);
                    allProjects.add(newProj);
                    projectsList.put(projectName, newProj);
                }
            }
        }

        public Project getOrCreateNode(String projectName) {
            if (!projectsList.containsKey(projectName)){
                Project newProj = new Project(projectName);
                allProjects.add(newProj);
                projectsList.put(projectName, newProj);
            }

            return projectsList.get(projectName);
        }

        public void fillDependencies(String[][] dependencies) {
            for (String[] dependency : dependencies) {
                String parent = dependency[0];
                String child = dependency[1];
                addEdge(parent, child);
            }
        }

        private void addEdge(String parentName, String childName) {
            if(projectsList.containsKey(childName) && projectsList.containsKey(parentName)){
                Project child = getOrCreateNode(childName);
                Project parent = getOrCreateNode(parentName);

                parent.addChild(child);
                child.addParent(parent);
            } else {
                System.out.println("Error: project non exists");
            }
        }

        public ArrayList<Project> getAllProjects() {
            return allProjects;
        }
    }
}
