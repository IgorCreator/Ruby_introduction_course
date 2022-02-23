package cracking_the_code_book.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class BuildOrderNodesWithDependencies_withDFS {

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
//        String[][] dependencies = {{"a", "e"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        String[][] dependencies = {{"a", "e"}, {"c", "a"}, {"b", "a"}, {"f", "c"}, {"f", "b"}, {"d", "g"}};
        Stack<Project> projectsOrder = new BuildOrderNodesWithDependencies_withDFS().findBuildOrder(projects, dependencies);
        for (Project project : projectsOrder) {
            System.out.println(project.getName());
        }
    }

    Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    Stack<Project> orderProjects(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project : projects)
            if (project.getState() == Project.State.BLANK)
                if (!doDFS(project, stack))
                    return null;
        return stack;
    }

    boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL)	return false;	// cycle

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            ArrayList<Project> children = project.getChildren();
            for (Project child : children)
                if (!doDFS(child, stack))
                    return false;

            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }

        return true;
    }

    Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects)
            graph.getOrCreateNode(project);
        for (String[] dependency : dependencies)
            graph.addEdge(dependency[0], dependency[1]);
        return graph;
    }

    public class Graph {
        private ArrayList<Project> nodes = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();

        public Project getOrCreateNode(String name) {
            if(!map.containsKey(name)) {
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }
            return map.get(name);
        }

        public void addEdge(String startName, String endName) {
            Project start = getOrCreateNode(startName);
            Project end = getOrCreateNode(endName);
            start.addNeighbor(end);
        }

        public ArrayList<Project> getNodes() {	return nodes;	}
    }

    public static class Project {
        public enum State {COMPLETE, PARTIAL, BLANK};
        private State state = State.BLANK;
        public State getState() {	return state;	}
        public void setState(State st) {	state = st;		}


        private ArrayList<Project> children = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();
        private String name;
        private int dependencies = 0;

        public Project(String n) {	name = n;	}
        public void addNeighbor(Project node) {
            if(!map.containsKey(node.getName())) {
                children.add(node);
                node.incrementDependencies();
            }
        }
        public void incrementDependencies() {	++dependencies;	 }
        public void decrementDependencies() {	--dependencies;	 }
        public String getName() {	return name;	}
        public ArrayList<Project> getChildren() {	return children;	}
        public int getNumberDependencies() {	return dependencies;	}
    }
}
